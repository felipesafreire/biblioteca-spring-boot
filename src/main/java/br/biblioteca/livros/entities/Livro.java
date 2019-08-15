package br.biblioteca.livros.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Min(2)
    @Column(name = "quantidadePaginas")
    private int quantidadePaginas;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro(){

    }

    public Livro(Long id, String nome, int quantidadePaginas, Autor autor) {
        this.id = id;
        this.nome = nome;
        this.quantidadePaginas = quantidadePaginas;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }


}
