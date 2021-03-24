package br.com.zupacademy.caio.casadocodigo.dtos;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.model.Categoria;
import br.com.zupacademy.caio.casadocodigo.model.Livro;
import br.com.zupacademy.caio.casadocodigo.validation.custom.NotDuplicatedField;
import br.com.zupacademy.caio.casadocodigo.validation.custom.Future;
import br.com.zupacademy.caio.casadocodigo.validation.custom.ObjectExists;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class LivroDto {

    @NotEmpty @NotDuplicatedField(domain = "livro")
    private String isbn;
    @NotEmpty @NotDuplicatedField(domain = "livro")
    private String titulo;
    @NotEmpty @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min(20) @Digits(integer = 6, fraction = 2)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ObjectExists(campo = "categoria")
    private Long categoria;
    @NotNull
    @ObjectExists(campo = "autor")
    private Long autor;



    public Livro toModel(LivroDto livroDto, Autor autor, Categoria categoria) {

        return new Livro(livroDto.isbn, livroDto.titulo, livroDto.resumo,
                livroDto.sumario, livroDto.preco, livroDto.numeroPaginas,
               livroDto.dataPublicacao, categoria, autor);

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
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

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }
}
