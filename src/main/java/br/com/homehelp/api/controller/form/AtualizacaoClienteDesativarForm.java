package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.repository.ClienteRepository;

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
