package com.homehelp.services.controller.form;

import com.homehelp.services.model.Bandeira;
import com.homehelp.services.repository.BandeiraRepository;

public class AtualizacaoBandeiraForm {

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Bandeira atualizar(Long id, BandeiraRepository bandeiraRepository) {
		Bandeira bandeira = bandeiraRepository.getOne(id);
		bandeira.setNome(this.nome);
		return bandeira;
	}

}
