package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Pais;

public class PaisDto {

	private String nome;
	private String abreviacao;

	public PaisDto(Pais pais) {
		this.nome = pais.getNome();
		this.abreviacao = pais.getAbreviacao();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public static List<PaisDto> converter(List<Pais> pais) {
		return pais.stream().map(PaisDto::new).collect(Collectors.toList());
	}
}
