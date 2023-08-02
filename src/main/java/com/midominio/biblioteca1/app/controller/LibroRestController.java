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
import com.midominio.biblioteca1.app.service.ILibroService;


@RequestMapping("/libro/rest")
@RestController
public class LibroRestController {

		@Autowired
		private ILibroService libroService;
		
		@GetMapping("/listar2")
		public Iterable<Libro> listarAllRest2()  {
			return libroService.findAll();
		}
		
		@GetMapping("/{id}")
		public Libro listarLibroRest(@PathVariable Long id) {
			return libroService.find(id);
		}
		
		@DeleteMapping("/{id}")
		public void borrarLibroRest(@PathVariable Long id) {
			libroService.delete(id);
		}
	
		@PostMapping("/libro")
		public void crearLibroRest(@RequestBody Libro libro) {
		    libroService.save(libro);
		}
		
		@PutMapping("/libro")
		public void actualizarLibroRest(@RequestBody Libro libro) {
		    libroService.save(libro);
		}
}