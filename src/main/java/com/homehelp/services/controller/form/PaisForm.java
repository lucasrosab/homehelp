package com.homehelp.services.controller.form;

import com.homehelp.services.model.Pais;
import com.homehelp.services.repository.PaisRepository;

public class PaisForm {

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
	public Pais converter(PaisRepository paisRepository) {
		return new Pais(nome,abreviacao);
	}

}
