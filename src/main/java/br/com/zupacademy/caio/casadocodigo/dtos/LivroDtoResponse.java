package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDtoResponse {

    private Long id;
    private String titulo;

    public LivroDtoResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDtoResponse> listaLivroDtoResponse(List<Livro> livros) {

        return livros.stream().map(l -> new LivroDtoResponse(l.getId(), l.getTitulo()))
                .collect(Collectors.toList());
    }
}
