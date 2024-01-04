package com.example.dto;

import java.time.LocalDate;

import com.example.entity.Paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetornoDTO {
	String mensagem;
	boolean sucesso;
}
