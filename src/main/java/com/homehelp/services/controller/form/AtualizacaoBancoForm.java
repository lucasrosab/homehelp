package com.homehelp.services.controller.form;

import com.homehelp.services.model.Banco;
import com.homehelp.services.repository.BancoRepository;

public class AtualizacaoBancoForm {

	private String nome;

	private int prefixo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}

	public Banco atualizar(Long id, BancoRepository bancoRepository) {
		Banco banco = bancoRepository.getOne(id);
		banco.setNome(this.nome);
		banco.setPrefixo(this.prefixo);
		return banco;
	}
}
