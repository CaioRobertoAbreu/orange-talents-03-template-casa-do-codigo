package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = CPF_CNPJValidator.class)
@Documented
public @interface CPF_CNPJ {

    String message() default "{Documento inválido}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };
}
