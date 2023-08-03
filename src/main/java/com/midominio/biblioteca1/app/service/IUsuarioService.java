package com.midominio.biblioteca1.app.service;

import java.util.List;

import com.midominio.biblioteca1.app.entity.Usuario;

public interface IUsuarioService {
	
	Iterable<Usuario> findAll();
	void save(Usuario usuario);
	Usuario find(Long id);
	void delete(Long id);
	
	void insert(Usuario usuario);
	void update(Usuario usuario);	
	
	Usuario dameUsuarioEmail(String email);
}
