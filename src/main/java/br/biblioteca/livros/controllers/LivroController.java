package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/list")
    public ModelAndView list(){
        List<Livro> livros = livroService.listarLivro();
        return new ModelAndView("livros/list", "listarLivro", livros);
    }

    @GetMapping("/novo")
    public ModelAndView newBook(@ModelAttribute Livro livro) {
        List<Autor> autores = autorService.listarAutores();
        return new ModelAndView("livros/livro", "listarAutores", autores);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update(@ModelAttribute Livro livro, @PathVariable("id") Long id) {
        List<Autor> autores = autorService.listarAutores();
        Livro l = livroService.getLivro(id);
        ModelAndView model = new ModelAndView("livros/edit");
        model.addObject("listarAutores", autores);
        model.addObject("livro", l);
        return model;
    }

    @PutMapping("/editar")
    public ModelAndView editar(@Valid Livro livro, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("livros/edit");
        }
        livroService.salvarLivro(livro);
        return new ModelAndView("redirect:/livros/list");
    }

    @DeleteMapping(value = "/excluir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        livroService.excluirLivro(id);
    }

    @PostMapping("/gravar")
    public ModelAndView createLivro(@Valid Livro livro, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("livros/livro");
        }
        livroService.salvarLivro(livro);
        return new ModelAndView("redirect:/livros/list");
    }


}
