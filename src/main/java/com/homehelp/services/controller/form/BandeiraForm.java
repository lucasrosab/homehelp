package com.homehelp.services.controller.form;

import com.homehelp.services.model.Bandeira;
import com.homehelp.services.repository.BandeiraRepository;

public class BandeiraForm {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Bandeira converter(BandeiraRepository bandeiraRepository) {
		return new Bandeira(nome);
	}

}
