package com.midominio.biblioteca1.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.biblioteca1.app.entity.Libro;

public interface ILibroService {
	
	Iterable<Libro> findAll();
	void save(Libro articulo);
	Libro find(Long id);
	void delete(Long id);
	
	void insert(Libro libro);
	void update(Libro libro);
	
	List<Libro> dameLibrosAutor(String s);
	List<Libro> dameLibrosGenero(String s);
	
	// Ojo importar de Spring Data Domain
	Page<Libro> listar(Pageable pageable);

}
