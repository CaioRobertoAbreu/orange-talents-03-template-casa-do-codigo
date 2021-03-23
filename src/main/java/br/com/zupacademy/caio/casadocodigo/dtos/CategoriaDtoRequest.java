package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedCategoria;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotEmpty;

public class CategoriaDtoRequest {

    @NotEmpty
    @NotDuplicatedCategoria
    private String nome;

    @JsonCreator
    public CategoriaDtoRequest(String nome) {
        this.nome = nome;
    }

    public Categoria toModel(CategoriaDtoRequest categoriaDto) {

        return new Categoria(categoriaDto.nome);
    }

    public String getNome() {
        return nome;
    }
}
