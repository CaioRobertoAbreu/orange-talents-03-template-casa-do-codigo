package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotDuplicatedCategoriaValidation implements ConstraintValidator<NotDuplicatedCategoria, String> {

    private final CategoriaRepository categoriaRepository;

    public NotDuplicatedCategoriaValidation(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String categoria, ConstraintValidatorContext context) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findByNome(categoria);

        if (categoriaEncontrada.isPresent()) {
            return false;
        }

        return true;
    }
}
