package com.midominio.biblioteca1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca1.app.entity.Libro;
import com.midominio.biblioteca1.app.entity.Usuario;
import com.midominio.biblioteca1.app.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Transactional
	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario find(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void insert(Usuario usuario) {
		
		if (usuario.getId() != null) return;
		usuarioRepository.save(usuario);
	}

	@Transactional
	@Override
	public void update(Usuario usuario) {
		
		if (usuario.getId() == null) return;
		usuarioRepository.save(usuario);
	}

}