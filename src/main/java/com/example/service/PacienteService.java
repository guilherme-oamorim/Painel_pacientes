package com.example.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.RetornoDTO;
import com.example.entity.Paciente;
import com.example.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository repository;
	

	public RetornoDTO save(Paciente paciente) {
		RetornoDTO retorno = new RetornoDTO();
		
		if (paciente.getIdade() < 18) {
			retorno.setSucesso(false);
			retorno.setMensagem("Menor que 18 anos!");
			return retorno;
		}
		
		boolean exist = repository.existsByEmail(paciente.getEmail());
		if (exist && paciente.getId() == null) {
			retorno.setSucesso(false);
			retorno.setMensagem("E-mail já existente!");
			return retorno;
		}

		Paciente pacienteSalvo = repository.save(paciente);
		retorno.setSucesso(true);
		retorno.setMensagem("Cadastro salvo com sucesso");
		
		return retorno;
	}

	public List<Paciente> findAll() {
		return repository.findAll();
	}
	
	public Paciente getById(Long id) {
		return repository.getById(id);
	}
}