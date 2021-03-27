package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.EstadoRequestDto;
import br.com.zupacademy.caio.casadocodigo.model.Estado;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.caio.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {

        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequestDto estadoRequestDto) {

        Pais pais = paisRepository.findById(estadoRequestDto.getPais()).get();

        Estado estado = EstadoRequestDto.toModel(estadoRequestDto, pais);

        estadoRepository.save(estado);


        return ResponseEntity.ok().build();
    }
}
