package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedField;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class PaisRequestDto {

    @NotBlank
    @NotDuplicatedField(domain = Pais.class, field = "nome")
    private String nome;


    @JsonCreator
    public PaisRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Pais toModel(PaisRequestDto paisRequestDto) {

        return new Pais(paisRequestDto.getNome());
    }
}
