package br.com.zupacademy.caio.casadocodigo.validation.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotDuplicatedEmailValidation.class)
@Documented
@Repeatable(NotDuplicatedEmail.List.class)
public @interface NotDuplicatedEmail {

    String message() default "{email já cadastrado em nossa base de dados}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        NotDuplicatedEmail[] value();
    }
}
