package com.homehelp.services.controller.form;

import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

public class AtualizacaoPrestadorPorLoginForm {

	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Prestador atualizar(Long id, PrestadorRepository prestadorRepository) {
		Prestador prestador = prestadorRepository.getOne(id);
		prestador.setEmail(this.email);
		prestador.setSenha(this.senha);
		return prestador;
	}
}
