package br.biblioteca.livros.configurator;

import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap implements CommandLineRunner {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public Bootstrap(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /* DADOS LIVRO */
//        List<Livro> listaLivros = new ArrayList<Livro>();
//        listaLivros.add(new Livro(1L, "Livro de PHP", 100));
//        listaLivros.add(new Livro(2L, "Livro de Java", 500));
//        listaLivros.add(new Livro(3L, "Livro de FIB", 150));
//        Iterable<Livro> livros = listaLivros;
        //livroRepository.saveAll(livros);

        /* DADOS DO AUTOR */
//        List<Autor> listaAutor = new ArrayList<Autor>();
//        listaAutor.add(new Autor(1L, "Felipe Sá Freire"));
//        listaAutor.add(new Autor(2L, "João Tosca"));
//        listaAutor.add(new Autor(3L, "José da  Silva"));
//        Iterable<Autor> autores = listaAutor;
        //autorRepository.saveAll(autores);

    }
}
