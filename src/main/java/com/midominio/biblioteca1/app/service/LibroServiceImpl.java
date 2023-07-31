package com.midominio.biblioteca1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca1.app.model.dao.ILibroDao;
import com.midominio.biblioteca1.app.model.entity.Libro;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	ILibroDao libroDao;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Libro> findAll() {
		return libroDao.findAll();
	}

	@Transactional
	@Override
	public void save(Libro libro) {
		libroDao.save(libro);
	}

	@Transactional(readOnly = true)
	@Override
	public Libro find(Long id) {
		return libroDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		libroDao.deleteById(id);
	}

}