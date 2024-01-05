package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paciente {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	String nome;
	String email;
	LocalDate dataNasc;
	@Transient
	Long idade;
	LocalDateTime dataCadastro;
	
	@PrePersist
	public void prePersist() {
		dataCadastro = LocalDateTime.now();
	}
	
	public Long getIdade() {
		return ChronoUnit.YEARS.between(this.dataNasc, LocalDate.now());
	}
}