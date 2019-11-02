package com.homehelp.services.controller.form;

import com.homehelp.services.model.Cliente;
import com.homehelp.services.model.Prestador;
import com.homehelp.services.model.Solicitacao;
import com.homehelp.services.repository.ClienteRepository;
import com.homehelp.services.repository.PrestadorRepository;

public class SolicitacaoForm {

	private String horario;
	private String codCliente;
	private String codPrestador;
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodPrestador() {
		return codPrestador;
	}

	public void setCodPrestador(String codPrestador) {
		this.codPrestador = codPrestador;
	}

	public Solicitacao converter(ClienteRepository clienteRepository, PrestadorRepository prestadorRepository) {
		Cliente cliente = clienteRepository.findByNome(codCliente);
		Prestador prestador = prestadorRepository.findByNome(codPrestador);
		return new Solicitacao(prestador, cliente, horario);
	}
}
