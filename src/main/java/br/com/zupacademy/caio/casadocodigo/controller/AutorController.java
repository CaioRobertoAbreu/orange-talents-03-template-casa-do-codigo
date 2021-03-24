package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.AutorDtoRequest;
import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorDtoRequest autorDto) {
        Autor autor = autorDto.toModel(autorDto);

        autorRepository.save(autor);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autor.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
