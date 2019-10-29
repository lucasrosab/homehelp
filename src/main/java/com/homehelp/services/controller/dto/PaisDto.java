package com.homehelp.services.controller.dto;

import javax.persistence.Column;

public class PaisDto {

	private String nome;
	private String abreviacao;


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
}
