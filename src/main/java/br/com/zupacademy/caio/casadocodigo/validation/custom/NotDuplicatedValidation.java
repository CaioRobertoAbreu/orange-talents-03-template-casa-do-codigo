package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.model.Livro;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class NotDuplicatedValidation implements ConstraintValidator<NotDuplicatedField, Object> {


    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;
    private String classeDominioNome;

    public NotDuplicatedValidation(CategoriaRepository categoriaRepository, AutorRepository autorRepository,
                                   LivroRepository livroRepository) {

        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
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

       if(classeDominioNome.equalsIgnoreCase("livro")) {
           Optional<Livro> livroEncontradoTitulo = livroRepository.findByTitulo(value);
           Optional<Livro> livroEncontradoIsbn = livroRepository.findByIsbn(value);

           return livroEncontradoTitulo.isEmpty() && livroEncontradoIsbn.isEmpty();
       }

       return false;
    }
}
