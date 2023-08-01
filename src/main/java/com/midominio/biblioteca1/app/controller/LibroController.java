package com.midominio.biblioteca1.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.biblioteca1.app.model.entity.Libro;
import com.midominio.biblioteca1.app.service.ILibroService;

import jakarta.validation.Valid;

@RequestMapping("/libro")
@Controller
public class LibroController {

	@Autowired
	private ILibroService libroService;

	@GetMapping("/listar")
	public String m1(Model model) {

		model.addAttribute("title", "Libros");
		model.addAttribute("libros", libroService.findAll());

		return "libro/listar.html";
	}

	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		model.put("title", "Formulario de libro");
		model.put("libro", new Libro());
		return "libro/form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Formulario de libro");
			return "libro/form";
		}
		libroService.save(libro);
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String actualizar(@PathVariable("id") Long id, Map<String, Object> model) {

		Libro libro = null;
		if (id > 0) {
			libro = libroService.find(id);
		} else {
			return "redirect:/libro/listar";
		}
		model.put("title", "Editar libro:");
		model.put("libro", libro);
		return "libro/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		
		if (id > 0)
			libroService.delete(id);
		return "redirect:/libro/listar";
	}

}
