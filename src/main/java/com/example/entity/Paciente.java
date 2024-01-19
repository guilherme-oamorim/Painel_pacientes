package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNasc;
	@Transient
	private Long idade;
	private LocalDateTime dataCadastro;
	private LocalDateTime ultimaAtt;
	private String queixa;
	
	
	@PrePersist
	public void prePersist() {
		dataCadastro = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		ultimaAtt = LocalDateTime.now();
	}
	
	public Long getIdade() {
		return ChronoUnit.YEARS.between(this.dataNasc, LocalDate.now());
	}
}