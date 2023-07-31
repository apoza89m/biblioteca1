package com.midominio.biblioteca1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca1.app.model.dao.IUsuarioDao;
import com.midominio.biblioteca1.app.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDao usuarioDao;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Transactional
	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario find(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

}