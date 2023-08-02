package com.midominio.biblioteca1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.biblioteca1.app.entity.Libro;
import com.midominio.biblioteca1.app.entity.Usuario;
import com.midominio.biblioteca1.app.service.ILibroService;
import com.midominio.biblioteca1.app.service.IUsuarioService;


@RequestMapping("/usuario/rest")
@RestController
public class UsuarioRestController {

		@Autowired
		private IUsuarioService usuarioService;
		
		@GetMapping("/listar")
		public Iterable<Usuario> listarAllRest()  {
			return usuarioService.findAll();
		}
		
		@GetMapping("/{id}")
		public Usuario listarUsuarioRest(@PathVariable Long id) {
			return usuarioService.find(id);
		}
		
		@DeleteMapping("/{id}")
		public void borrarUsuarioRest(@PathVariable Long id) {
			usuarioService.delete(id);
		}
	
		@PostMapping("/usuario")
		public void crearUsuarioRest(@RequestBody Usuario usuario) {
		    usuarioService.save(usuario);
		}
		
		@PutMapping("/usuario")
		public void actualizarUsuarioRest(@RequestBody Usuario usuario) {
		    usuarioService.save(usuario);
		}
}