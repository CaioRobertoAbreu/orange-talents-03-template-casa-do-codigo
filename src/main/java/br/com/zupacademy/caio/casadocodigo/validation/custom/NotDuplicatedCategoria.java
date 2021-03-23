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
@Constraint(validatedBy = NotDuplicatedCategoriaValidation.class)
@Documented
@Repeatable(NotDuplicatedCategoria.List.class)
public @interface NotDuplicatedCategoria {

    String message() default "{categoria já cadastrada em nossa base de dados}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        NotDuplicatedCategoria[] value();
    }
}
