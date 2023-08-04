package com.midominio.biblioteca1.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.midominio.biblioteca1.app.entity.Libro;

public interface ILibroRepository extends PagingAndSortingRepository<Libro, Long>,
CrudRepository<Libro, Long>,
JpaRepository<Libro, Long>{
	
	    List<Libro> findByGenero(@Param("genero") String genero);
	    
	    /*@Query(value = "SELECT * FROM libros WHERE genero = :genero", 
	    		  nativeQuery = true)
	    Page<Libro> findByGeneroPage(String genero, Pageable pageable);*/
	    Page<Libro> findByGenero(String genero, Pageable pageable);
	
}
