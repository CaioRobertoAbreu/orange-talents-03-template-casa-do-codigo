package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = VerifyIfMandatoryValidator.class)
@Documented
public @interface VerifyIfMandatory {

    String message() default "{Campo inválido}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

    Class<?> domain();

    String fieldName();
}
