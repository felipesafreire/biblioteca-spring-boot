package br.biblioteca.livros.controllers;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/list")
    public ModelAndView list() {
        Iterable<Autor> autores = autorService.listarAutores();
        return new ModelAndView("autores/list", "listaAutores", autores);
    }

    @GetMapping("/novo")
    public ModelAndView newAutor(@ModelAttribute Autor autor) {
        return new ModelAndView("/autores/autor");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update(@ModelAttribute Autor autor, @PathVariable("id") Long id) {
        Autor aut = autorService.getAutor(id);
        return new ModelAndView("autores/edit", "autor", aut);
    }

    @PutMapping("/editar")
    public ModelAndView editar(@Valid Autor autor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("autores/edit");
        }
        autorService.salvarAutor(autor);
        return new ModelAndView("redirect:/autores/list");
    }

    @DeleteMapping(value = "/excluir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        autorService.apagarAutor(id);
    }

    @PostMapping("/gravar")
    public ModelAndView createAutor(@Valid Autor autor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("/autores/autor");
        }
        autorService.salvarAutor(autor);
        return new ModelAndView("redirect:/autores/list");
    }


}
