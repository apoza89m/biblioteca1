package com.midominio.biblioteca1.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca1.app.entity.Libro;
import com.midominio.biblioteca1.app.repository.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	ILibroRepository libroRepository;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Libro> findAll() {
		return libroRepository.findAll();
	}

	@Transactional
	@Override
	public void save(Libro libro) {
		libroRepository.save(libro);
	}

	@Transactional(readOnly = true)
	@Override
	public Libro find(Long id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		libroRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void insert(Libro libro) {
		
		if (libro.getId() != null) return;
		libroRepository.save(libro);
	}

	@Transactional
	@Override
	public void update(Libro libro) {
		
		if (libro.getId() == null) return;
		libroRepository.save(libro);
	}

	@Override
	public List<Libro> dameLibrosGenero(String genero) {
		return libroRepository.findByGenero(genero);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> listar(Pageable pageable) {
		return libroRepository.findAll(pageable);
	}

	@Override
	public Page<Libro> pageFiltro(String genero, Pageable page) {
		return libroRepository.findByGenero(genero, page);
	}

}