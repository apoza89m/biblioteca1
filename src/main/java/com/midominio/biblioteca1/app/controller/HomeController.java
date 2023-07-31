package com.midominio.biblioteca1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/","/home"})

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String m(Model model) {
		model.addAttribute("titulo", "Home"); 
		return "home/home";
	}

}
