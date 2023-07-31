package com.midominio.biblioteca1.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.midominio.biblioteca1.app.model.entity.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long>{}
