package com.midominio.biblioteca1.app.service;

import com.midominio.biblioteca1.app.model.entity.Libro;

public interface ILibroService {
	Iterable<Libro> findAll();
	void save(Libro articulo);
	Libro find(Long id);
	void delete(Long id);
}
