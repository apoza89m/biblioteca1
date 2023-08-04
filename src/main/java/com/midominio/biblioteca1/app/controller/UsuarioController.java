package com.midominio.biblioteca1.app.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
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
	@PostMapping("/listar")
	public String listarK(@RequestParam("email") String email,
			RedirectAttributes flash,
			Model model) {
		
		Usuario user = usuarioService.dameUsuarioEmail(email);
		model.addAttribute("titulo", "Usuarios");
		model.addAttribute("usuarios", user);
		String s ="";
		if(user==null) {
			s = "redirect:/usuario/listar";
			flash.addFlashAttribute("error", "Usuario no registrado");
		}
			else   s = "redirect:/usuario/ver/"+user.getId();		
		return s;
	}

	@GetMapping("/ver/{id}")
	public String verUsusario(@PathVariable("id") Long id,
			RedirectAttributes flash,
			Model model) { 
		Usuario user = usuarioService.find(id);		
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
	public String guardar(@Valid Usuario usuario,
			BindingResult result,
			@RequestParam("file") MultipartFile foto,
			RedirectAttributes flash,
			Model model) { 
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de usuario");
			return "usuario/form";
		}
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src/main/resources/static/upload");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			//String rootPath = "/opt/uploads";
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Subido correctamente " + foto.getOriginalFilename());
				usuario.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {

			}
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
