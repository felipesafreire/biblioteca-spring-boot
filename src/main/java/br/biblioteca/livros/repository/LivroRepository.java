package br.biblioteca.livros.repository;

import br.biblioteca.livros.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository  extends JpaRepository <Livro, Long> {

}
