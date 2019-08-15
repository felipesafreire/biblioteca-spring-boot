package br.biblioteca.livros.services;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public List<Autor> listarAutores(){
        return repository.findAll();
    }

    public void salvarAutor(Autor autor){
        repository.save(autor);
    }

    public void apagarAutor(Long id){
        repository.deleteById(id);
    }

    public Autor getAutor(Long id){

        Optional<Autor> autor = repository.findById(id);
        if(autor.isPresent()){
            return  autor.get();
        }
        return null;

    }


}
