package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.RetornoDTO;
import com.example.entity.Paciente;
import com.example.service.PacienteService;

@Controller
public class RelatorioController {
	@Autowired
	PacienteService pacienteService;

	@GetMapping ("/relatorio")
	public String relatorio (Model model) {
		List<Paciente> pacientes = pacienteService.findAll();
		model.addAttribute("pacientes",pacientes);
		return "relatorio";
	}
}
