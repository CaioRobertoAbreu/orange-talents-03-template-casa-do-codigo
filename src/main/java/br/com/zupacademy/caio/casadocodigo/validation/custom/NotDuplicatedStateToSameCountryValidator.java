package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.dtos.EstadoRequestDto;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.List;

public class NotDuplicatedStateToSameCountryValidator implements ConstraintValidator<NotDuplicatedStateToSameCountry, EstadoRequestDto> {

    private Class<?> domain;
    private String fieldCountry;
    private String fieldState;
    @PersistenceContext
    private EntityManager entityManager;

    public NotDuplicatedStateToSameCountryValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(NotDuplicatedStateToSameCountry constraintAnnotation) {
        this.domain = constraintAnnotation.domain();
        this.fieldCountry = constraintAnnotation.fieldCountry();
        this.fieldState = constraintAnnotation.fieldState();

    }

    @Override
    public boolean isValid(EstadoRequestDto value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("SELECT 1 FROM " + domain.getSimpleName() + " WHERE " +
                fieldState + " = :valueState AND " + fieldCountry + " = " + value.getPais())
                .setParameter("valueState", value.getNome());


        List<?> lista = query.getResultList();

        Assert.state(lista.size() <= 1, "Há mais de um estado com o mesmo nome para o mesmo país");

        return lista.isEmpty();
    }
}
