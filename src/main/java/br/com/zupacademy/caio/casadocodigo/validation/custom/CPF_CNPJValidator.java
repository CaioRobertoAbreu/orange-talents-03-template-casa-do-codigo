package br.com.zupacademy.caio.casadocodigo.validation.custom;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPF_CNPJValidator implements ConstraintValidator<CPF_CNPJ, String> {

    @Override
    public void initialize(CPF_CNPJ constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        CPFValidator cpf = new CPFValidator();
        cpf.initialize(null);

        CNPJValidator cnpj = new CNPJValidator();
        cnpj.initialize(null);

        return cpf.isValid(value, null) || cnpj.isValid(value, null);
    }

}
