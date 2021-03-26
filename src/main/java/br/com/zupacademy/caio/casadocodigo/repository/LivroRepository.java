package br.com.zupacademy.caio.casadocodigo.repository;

import br.com.zupacademy.caio.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    Optional<Livro> findByTitulo(String value);

    Optional<Livro> findByIsbn(String value);

    @Override
    List<Livro> findAll();

}
