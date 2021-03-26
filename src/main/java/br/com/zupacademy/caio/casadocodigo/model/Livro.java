package br.com.zupacademy.caio.casadocodigo.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String isbn;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String resumo;
    private String sumario;
    @Column(columnDefinition = "decimal(6,2) not null check(preco >=20)")
    private BigDecimal preco;
    @Column(columnDefinition = "smallint not null check (numero_paginas>=100)")
    private Integer numeroPaginas;
    @Column(columnDefinition = "date not null check (data_publicacao >= current_date())")
    private LocalDate dataPublicacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String isbn, String titulo, String resumo, String sumario,
                 BigDecimal preco, Integer numeroPaginas,
                 LocalDate dataPublicacao, Categoria categoria, Autor autor) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
