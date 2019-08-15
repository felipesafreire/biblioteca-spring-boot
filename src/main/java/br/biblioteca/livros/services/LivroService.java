package br.biblioteca.livros.services;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> listarLivro() {
        return repository.findAll();
    }

    public void salvarLivro(Livro livro){
        repository.save(livro);
    }

    public void excluirLivro(Long id){
        repository.deleteById(id);
    }

    public Livro getLivro(Long id){

        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()){
            return  livro.get();
        }
        return null;

    }

}
