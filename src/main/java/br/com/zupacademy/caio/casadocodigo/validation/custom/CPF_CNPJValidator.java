package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.validation.custom.utils.ValidaCpfCnpj;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPF_CNPJValidator implements ConstraintValidator<CPF_CNPJ, String> {

    @Override
    public void initialize(CPF_CNPJ constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return ValidaCpfCnpj.isValidCPF(value) || ValidaCpfCnpj.isValidCNPJ(value);
    }

}
