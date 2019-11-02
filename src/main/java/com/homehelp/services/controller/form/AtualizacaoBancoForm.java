package com.homehelp.services.controller.form;

import com.homehelp.services.model.Banco;
import com.homehelp.services.repository.BancoRepository;

public class AtualizacaoBancoForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Banco atualizar(Long id, BancoRepository bancoRepository) {
		Banco banco = bancoRepository.getOne(id);
		banco.setNome(this.nome);
		return banco;
	}
}
