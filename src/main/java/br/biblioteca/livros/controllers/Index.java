package br.biblioteca.livros.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Index {

    @GetMapping("/")
    public ModelAndView home() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals("anonymousUser")) {
            return new ModelAndView("redirect:/login");
        } else {
            return new ModelAndView("index");
        }

    }

}

