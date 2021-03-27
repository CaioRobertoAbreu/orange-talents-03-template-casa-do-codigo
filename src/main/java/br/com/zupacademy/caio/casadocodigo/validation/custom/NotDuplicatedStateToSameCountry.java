package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotDuplicatedStateToSameCountryValidator.class)
@Documented
public @interface NotDuplicatedStateToSameCountry {

    String message() default "{Estado já cadastrado para este país}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

    Class domain();

    String fieldCountry();

    String fieldState();

}
