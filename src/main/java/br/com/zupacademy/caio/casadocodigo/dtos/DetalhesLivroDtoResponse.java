package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroDtoResponse {

    private String isbn;
    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private Integer numeroPaginas;
    private String autorNome;
    private String autorDescricao;
    private String dataPublicacao;

    public DetalhesLivroDtoResponse(Livro livro) {
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.autorNome = livro.getAutor().getNome();
        this.autorDescricao = livro.getAutor().getDescricao();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
