package com.midominio.biblioteca1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.midominio.biblioteca1.app.entity.Libro;
import com.midominio.biblioteca1.app.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>,
JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(@Param("email") String email);
	//https://hellokoding.com/jpa-one-to-many-relationship-mapping-example-with-spring-boot-maven-and-mysql/
}
