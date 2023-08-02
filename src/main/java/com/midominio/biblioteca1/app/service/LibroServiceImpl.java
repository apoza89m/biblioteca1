package com.midominio.biblioteca1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}