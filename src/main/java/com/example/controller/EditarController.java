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
public class EditarController {
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping ("/editar/{id}")
	public String editar (Model model, @PathVariable Long id) {
		Paciente paciente = pacienteService.getById(id);
		model.addAttribute("paciente", paciente);
		return "editar";
	}
	
	@PostMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody Paciente paciente) {
		Paciente pacienteAtual = pacienteService.getById(paciente.getId());
		paciente.setDataCadastro(pacienteAtual.getDataCadastro());
				
		System.out.println("salvando paciente");
		RetornoDTO retorno = pacienteService.save(paciente);
		if (retorno.isSucesso()) {
			return ResponseEntity.ok("Salvo com sucesso!");
		}
		return ResponseEntity.badRequest().body("Erro: " + retorno.getMensagem());
	}
}
