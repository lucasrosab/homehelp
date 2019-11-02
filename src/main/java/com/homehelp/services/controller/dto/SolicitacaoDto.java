package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Solicitacao;

public class SolicitacaoDto {

	private Long id;
	private String horario;
	private String nomeCliente;
	private String nomePrestador;
	private String status;
	
	public SolicitacaoDto(Solicitacao solicitacao) {
		this.id = solicitacao.getId();
		this.horario = solicitacao.getHorario();
		this.nomeCliente = solicitacao.getCliente().getNome();
		this.nomePrestador = solicitacao.getPrestador().getNome();
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomePrestador() {
		return nomePrestador;
	}

	public void setNomePrestador(String nomePrestador) {
		this.nomePrestador = nomePrestador;
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
