package com.midominio.biblioteca1.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca1.app.entity.Libro;
import com.midominio.biblioteca1.app.service.ILibroService;
import com.midominio.biblioteca1.app.utils.PageRender;

import jakarta.validation.Valid;

@RequestMapping("/libro")
@Controller
public class LibroController {

	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page,
			Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libro/listar", libros); 
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libro/listar";
	}
	
	@GetMapping("/listar/{genero}")
	public String listarFiltrado(@RequestParam(defaultValue = "0") int page,
			@PathVariable String genero,
			Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.pageFiltro(genero, pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libro/listar/"+genero, libros);		
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libro/listar";
	}

	@ResponseBody
	@GetMapping("/rest/listar")
	public Iterable<Libro> listarAllRest()	{
		return libroService.findAll();
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		model.put("title", "Formulario de libro");
		model.put("libro", new Libro());
		return "libro/form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, RedirectAttributes flash, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Formulario de libro");
			return "libro/form";
		}
		libroService.save(libro);
		flash.addFlashAttribute("success", "Libro guardado con éxito");
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
	public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
		
		if (id > 0)
			libroService.delete(id);
		flash.addFlashAttribute("warningDelete", "Libro borrado con éxito");
		return "redirect:/libro/listar";
	}

}
