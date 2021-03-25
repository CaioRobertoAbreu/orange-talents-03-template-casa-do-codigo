package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.LivroDtoRequest;
import br.com.zupacademy.caio.casadocodigo.dtos.LivroDtoResponse;
import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.model.Livro;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<LivroDtoResponse>> buscarTodos() {
        List<Livro> todosLivros = livroRepository.findAll();

        return ResponseEntity.ok(LivroDtoResponse.listaLivroDtoResponse(todosLivros));
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDtoRequest livroDtoRequest,
                                       UriComponentsBuilder uriBuilder) {

        Autor autor =  autorRepository.findById(livroDtoRequest.getAutor()).get();
        Categoria categoria = categoriaRepository.findById(livroDtoRequest.getCategoria()).get();

        Livro livro = livroDtoRequest.toModel(livroDtoRequest, autor, categoria);

        Livro livroSalvo = livroRepository.save(livro);

        URI uri = uriBuilder.path("/livros/{id}").build(livroSalvo.getId());

        return ResponseEntity.created(uri).build();
    }
}
