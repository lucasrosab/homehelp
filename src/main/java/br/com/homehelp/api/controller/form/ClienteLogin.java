package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.repository.ClienteRepository;

public class ClienteLogin {

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

	public Cliente converter(ClienteRepository clienteRepository) {
		return new Cliente(email,senha);
	}
}
