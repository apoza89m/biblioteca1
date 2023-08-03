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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca1.app.entity.Usuario;
import com.midominio.biblioteca1.app.service.IUsuarioService;

import jakarta.validation.Valid;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", "Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());

		return "usuario/listar.html";
	}

	@GetMapping("/ver/{id}")
	public String verUsusario(@PathVariable("id") Long id,
			RedirectAttributes flash,
			Model model) { 
		Usuario user = usuarioService.find(id);
		if (user==null) {
			flash.addFlashAttribute("error", "Email no registrado");	
		}
		model.addAttribute("titulo", "Usuario");
		model.addAttribute("usuario", user);
		model.addAttribute("volverALista",true);

		return "usuario/ver.html";
	}
		
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		model.put("titulo", "Formulario de usuario");
		model.put("usuario", new Usuario());
		return "usuario/form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Usuario usuario, BindingResult result, RedirectAttributes flash, Model model) { 
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de usuario");
			return "usuario/form";
		}
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String actualizar(@PathVariable("id") Long id, Map<String, Object> model) {

		Usuario usuario = null;
		if (id > 0) {
			usuario = usuarioService.find(id);
		} else {
			return "redirect:/usuario/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar usuario:");
		return "usuario/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
		if (id > 0)
			usuarioService.delete(id);
		flash.addFlashAttribute("warningDelete", "Usuario borrado con éxito");
		return "redirect:/usuario/listar";
	}

}
