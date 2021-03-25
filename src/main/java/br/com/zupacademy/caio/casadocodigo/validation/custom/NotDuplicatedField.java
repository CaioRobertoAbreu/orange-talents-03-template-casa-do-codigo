package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = NotDuplicatedValidation.class)
@Documented
public @interface NotDuplicatedField {

    String message() default "{valor informado já cadastrado em nossa base de dados}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

    Class domain();
}
