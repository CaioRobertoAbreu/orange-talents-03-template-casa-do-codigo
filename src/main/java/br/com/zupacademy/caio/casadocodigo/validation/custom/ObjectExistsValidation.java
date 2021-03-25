package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ObjectExistsValidation implements ConstraintValidator<ObjectExists, Long> {

    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private Class campo;

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
        if(campo.equals(Autor.class)) {

            return autorRepository.existsById(value);
        }

        if (campo.equals(Categoria.class)) {

            return categoriaRepository.existsById(value);
        }

        return false;
    }
}
