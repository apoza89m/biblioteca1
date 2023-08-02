package com.midominio.biblioteca1.app.service;

import com.midominio.biblioteca1.app.entity.Libro;

public interface ILibroService {
	
	Iterable<Libro> findAll();
	void save(Libro articulo);
	Libro find(Long id);
	void delete(Long id);
	
	void insert(Libro libro);
	void update(Libro libro);
}
