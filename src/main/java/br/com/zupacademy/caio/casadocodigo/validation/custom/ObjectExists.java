package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ObjectExistsValidation.class)
@Documented
public @interface ObjectExists {

    String message() default "{objeto não encontrado}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

    String campo ();
}
