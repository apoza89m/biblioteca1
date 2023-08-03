package com.midominio.biblioteca1.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.midominio.biblioteca1.app.entity.Prestamo;

public interface IPrestamoRepository extends CrudRepository<Prestamo, Long>{}
