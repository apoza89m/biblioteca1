package com.midominio.biblioteca1.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.midominio.biblioteca1.app.entity.Libro;

public interface ILibroRepository extends CrudRepository<Libro, Long>{}
