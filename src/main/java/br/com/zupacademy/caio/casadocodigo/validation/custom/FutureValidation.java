package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureValidation implements ConstraintValidator<Future, LocalDate> {


    @Override
    public void initialize(Future constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate data, ConstraintValidatorContext context) {
        LocalDate hoje = LocalDate.now();

        return data.isAfter(hoje);
    }
}
