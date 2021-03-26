package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class DetalhesLivroDtoResponse {

    private String isbn;
    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private Integer numeroPaginas;
    private String autorNome;
    private String autorDescricao;

    public DetalhesLivroDtoResponse(Livro livro) {
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.autorNome = livro.getAutor().getNome();
        this.autorDescricao = livro.getAutor().getDescricao();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
    }
}
