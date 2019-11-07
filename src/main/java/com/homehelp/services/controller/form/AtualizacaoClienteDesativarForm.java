package com.homehelp.services.controller.form;

import com.homehelp.services.model.Cliente;
import com.homehelp.services.repository.ClienteRepository;

public class AtualizacaoClienteDesativarForm {

	public boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setAtivo(this.ativo);
		return cliente;
	}
}
