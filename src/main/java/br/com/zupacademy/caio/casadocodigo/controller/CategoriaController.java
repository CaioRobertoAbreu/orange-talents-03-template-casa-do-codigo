package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.CategoriaDtoRequest;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaDtoRequest categoriaDto,
                                       UriComponentsBuilder uriBuilder) {

        Categoria categoria = categoriaDto.toModel(categoriaDto);

        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categorias/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }
}
