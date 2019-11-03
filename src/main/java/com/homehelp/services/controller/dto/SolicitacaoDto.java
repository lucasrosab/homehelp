package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Solicitacao;

public class SolicitacaoDto {

	private Long id;
	private String horario;
	private String cliente;
	private String prestador;
	private String status;
	
	public SolicitacaoDto(Solicitacao solicitacao) {
		this.id = solicitacao.getId();
		this.horario = solicitacao.getHorario();
		this.cliente = solicitacao.getCliente().getNome();
		this.prestador = solicitacao.getPrestador().getNome();
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

	public static List<SolicitacaoDto> converter(List<Solicitacao> solicitacao) {
		return solicitacao.stream().map(SolicitacaoDto::new).collect(Collectors.toList());
	}

}
