package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.PaisRequestDto;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    @PostMapping
    private ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequestDto paisRequestDto) {


        Pais pais = PaisRequestDto.toModel(paisRequestDto);

        paisRepository.save(pais);

        return ResponseEntity.ok().build();
    }

}
