package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Estado;
import br.com.zupacademy.caio.casadocodigo.model.Pais;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedField;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedStateToSameCountry;
import br.com.zupacademy.caio.casadocodigo.validation.custom.ObjectExists;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotDuplicatedStateToSameCountry(domain = Estado.class, fieldCountry = "pais", fieldState = "nome")
public class EstadoRequestDto {

    @NotBlank
    private String nome;
    @NotNull
    @ObjectExists(domain = Pais.class, fieldName = "id")
    private Long pais;

    @JsonCreator
    public EstadoRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    public static Estado toModel(EstadoRequestDto estadoRequestDto, Pais pais) {

        return new Estado(estadoRequestDto.getNome(), pais);
    }
}
