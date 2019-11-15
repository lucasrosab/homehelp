package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Solicitacao;

public class SolicitacaoDto {

	private Long id;
	private String horario;
	private String cliente;
	private Long idcliente;
	private String prestador;
	private String status;
	private String endereco;
	
	public SolicitacaoDto(Solicitacao solicitacao) {
		this.id = solicitacao.getId();
		this.horario = solicitacao.getHorario();
		this.idcliente = solicitacao.getCliente().getId();
		this.cliente = solicitacao.getCliente().getNome();
		this.prestador = solicitacao.getPrestador().getNome();
		this.endereco = solicitacao.getEndereco();
		this.status = solicitacao.getStatus();
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static List<SolicitacaoDto> converter(List<Solicitacao> solicitacao) {
		return solicitacao.stream().map(SolicitacaoDto::new).collect(Collectors.toList());
	}
}
