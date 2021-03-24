package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.LivroDto;
import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.model.Livro;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.caio.casadocodigo.validation.custom.ObjectExists;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;


    public LivroController(AutorRepository autorRepository,
                           CategoriaRepository categoriaRepository,
                           LivroRepository livroRepository) {

        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDto livroDto,
                                       UriComponentsBuilder uriBuilder) {

        Autor autor =  autorRepository.findById(livroDto.getAutor()).get();
        Categoria categoria = categoriaRepository.findById(livroDto.getCategoria()).get();

        Livro livro = livroDto.toModel(livroDto, autor, categoria);

        Livro livroSalvo = livroRepository.save(livro);

        URI uri = uriBuilder.path("/livros/{isbn}").build(livroSalvo.getIsbn());

        return ResponseEntity.created(uri).build();
    }
}
