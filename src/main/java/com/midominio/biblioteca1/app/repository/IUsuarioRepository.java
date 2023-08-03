package com.midominio.biblioteca1.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.midominio.biblioteca1.app.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(@Param("email") String email);
	
}
