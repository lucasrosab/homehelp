package com.homehelp.services.controller.form;

import com.homehelp.services.model.Cliente;
import com.homehelp.services.repository.ClienteRepository;

public class AtualizacaoClientePorLoginForm {

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
	
	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setEmail(this.email);
		cliente.setSenha(this.senha);
		return cliente;
	}
	
}
