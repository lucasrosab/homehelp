package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Prestador;

public class PrestadorStatusDto {

	private Long id;
	private String nome;
	private boolean status;
	
	public PrestadorStatusDto(Prestador prestador) {
		this.id = prestador.getId();
		this.nome = prestador.getNome();
		this.status = prestador.isStatus();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public static List<PrestadorStatusDto> converter(List<Prestador> prestador) {
		return prestador.stream().map(PrestadorStatusDto::new).collect(Collectors.toList());
	}
}
