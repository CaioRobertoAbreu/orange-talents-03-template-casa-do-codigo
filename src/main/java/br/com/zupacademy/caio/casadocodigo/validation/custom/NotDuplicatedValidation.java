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

public class NotDuplicatedValidation implements ConstraintValidator<NotDuplicatedField, Object> {


    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> classDomainName;
    private String fieldName;


    public NotDuplicatedValidation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(NotDuplicatedField constraintAnnotation) {
        classDomainName = constraintAnnotation.domain();
        fieldName = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("SELECT 1 FROM " + classDomainName.getSimpleName() +
                " WHERE " + fieldName + " = :value").setParameter("value", value);

        List<?> lista = query.getResultList();

        Assert.state(lista.size() <= 1, "Há mais de um campo " + fieldName + "com valor " +
        value + " na classe " + classDomainName.getSimpleName());

        return lista.isEmpty();

    }
}
