package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Paciente;
import com.example.service.PacienteService;

@Controller
public class PacienteController {
	@Autowired
	PacienteService service;
	
	@GetMapping ("/")
	public String index (Model model) {
		return "index";
	}
	@PostMapping ("/salvar")
	public String salvar (Model model) {
		model.addAttribute("serviceVar",service);
		return "salvar";
	}
	@GetMapping ("/relatorio")
	public String relatorio (Model model) {
		List<Paciente> pacientes = service.findAll();
		model.addAttribute("pacientes",pacientes);
		return "relatorio";
	}
}
