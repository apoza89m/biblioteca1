package com.midominio.biblioteca1.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.tienda1.app.model.dao.ITiendaDao;
import com.midominio.tienda1.app.model.entity.Tienda;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	ITiendaDao tiendaDao;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Tienda> findAll() {
		return tiendaDao.findAll();
	}

	@Transactional
	@Override
	public void save(Tienda tienda) {
		tiendaDao.save(tienda);
	}

	@Transactional(readOnly = true)
	@Override
	public Tienda findOne(Long id) {
		return tiendaDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		tiendaDao.deleteById(id);
	}

}