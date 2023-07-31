package com.midominio.biblioteca1.app.service;

import com.midominio.biblioteca1.app.model.entity.Usuario;

public interface IUsuarioService {
	Iterable<Usuario> findAll();
	void save(Usuario tienda);
	Usuario find(Long id);
	void delete(Long id);

}
