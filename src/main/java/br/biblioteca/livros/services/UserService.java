package br.biblioteca.livros.services;

import java.util.List;

import br.biblioteca.livros.entities.Login;

public interface UserService {
	
	void save (Login user);

	Login findByUsername (String username);

	List<Login> findAll ();
	
}