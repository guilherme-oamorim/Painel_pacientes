package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.PacienteService;

@Controller
public class IndexController {
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping ("/")
	public String index (Model model) {
		return "index";
	}
	
	@PostMapping ("/salvar")
	public String salvar (Model model) {
		model.addAttribute("serviceVar", pacienteService);
		return "salvar";
	}
}
