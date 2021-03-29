package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.dtos.ClienteRequestDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.MessageInterpolator;
import java.util.List;

public class VerifyIfMandatoryValidator implements ConstraintValidator<VerifyIfMandatory, ClienteRequestDto> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> domain;
    private String fieldName;

    @Override
    public void initialize(VerifyIfMandatory constraintAnnotation) {
        domain = constraintAnnotation.domain();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(ClienteRequestDto value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + domain.getSimpleName() + " WHERE " +
                fieldName + " = :value").setParameter("value", value.getPais());


        List<?> lista = query.getResultList();

        if(lista.isEmpty() && value.getEstado() != null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Não existe um estado para este país")
                    .addConstraintViolation();
            return false;
        }

        if(!lista.isEmpty() && value.getEstado() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Estado precisa ser preenchido")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }

}
