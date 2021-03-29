package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.dtos.ClienteRequestDto;
import br.com.zupacademy.caio.casadocodigo.model.Cliente;
import br.com.zupacademy.caio.casadocodigo.model.Estado;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository,
                             EstadoRepository estadoRepository) {

        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Long> cadastrar(@RequestBody @Valid ClienteRequestDto clienteRequestDto) {
        Pais pais = paisRepository.findById(clienteRequestDto.getPais()).get();
        Estado estado;

        Cliente cliente = ClienteRequestDto.toModel(clienteRequestDto, pais);

        if(clienteRequestDto.getEstado() != null) {
            estado = estadoRepository.findById(clienteRequestDto.getEstado()).get();
            cliente.setEstado(estado);
        }

        clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente.getId());
    }
}
