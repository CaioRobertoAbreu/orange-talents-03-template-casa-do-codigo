package br.com.zupacademy.caio.casadocodigo.validation.custom;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Neste ponto para cada novo campo que necessitava desta validação
 * tinha que ser injetado uma dependência de um repositório diferente,
 * isso estava cheirando mal, então decidi refatorar o código.
 */
public class ObjectExistsValidation implements ConstraintValidator<ObjectExists, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class domain;
    private String fieldName;

    public ObjectExistsValidation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ObjectExists constraintAnnotation) {
        domain = constraintAnnotation.domain();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("SELECT 1 FROM " + domain.getSimpleName() + " WHERE " +
                fieldName + " = :value").setParameter("value", value);

        List<?> lista = query.getResultList();

        Assert.state(lista.size() <= 1, "Há mais de um campo " + fieldName + "com valor " +
                value + " na classe " + domain.getSimpleName());

        return !lista.isEmpty();
    }
}
