package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.validation.custom.EmailDuplicado;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorDtoRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @EmailDuplicado
    private String email;
    @NotBlank
    private String descricao;

    public AutorDtoRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(AutorDtoRequest autorDto) {

        return new Autor(autorDto.getNome(), autorDto.getEmail(), autorDto.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
