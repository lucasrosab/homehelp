package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.model.Prestador;
import br.com.homehelp.api.model.Solicitacao;
import br.com.homehelp.api.repository.ClienteRepository;
import br.com.homehelp.api.repository.PrestadorRepository;

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
