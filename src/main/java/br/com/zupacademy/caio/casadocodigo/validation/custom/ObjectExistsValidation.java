package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ObjectExistsValidation implements ConstraintValidator<ObjectExists, Long> {

    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private String campo;

    public ObjectExistsValidation(AutorRepository autorRepository,
                                  CategoriaRepository categoriaRepository) {

        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void initialize(ObjectExists constraintAnnotation) {
        campo = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if(campo.equalsIgnoreCase("autor")) {

            return autorRepository.findById(value).isPresent();
        }

        if (campo.equalsIgnoreCase("categoria")) {

            return categoriaRepository.findById(value).isPresent();
        }

        return false;
    }
}
