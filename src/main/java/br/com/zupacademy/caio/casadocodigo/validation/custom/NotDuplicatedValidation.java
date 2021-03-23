package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Optional;

public class NotDuplicatedValidation implements ConstraintValidator<NotDuplicatedField, Object> {


    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;
    private String classeDominioNome;

    public NotDuplicatedValidation(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(NotDuplicatedField constraintAnnotation) {
        classeDominioNome = constraintAnnotation.domain();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String value = obj.toString();

       if (classeDominioNome.equalsIgnoreCase("categoria")) {

           Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(value);

           return categoriaOptional.isEmpty();
       }

       if(classeDominioNome.equalsIgnoreCase("autor")) {
           Optional<Autor> emailOptional = autorRepository.findByEmail(value);

           return emailOptional.isEmpty();
       }

       return false;
    }
}
