package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Prestador;

public class PrestadorAtivoDto {

	private Long id;
	private String prestador;
	private boolean status;
	
	public PrestadorAtivoDto(Prestador prestador) {
		this.id = prestador.getId();
		this.prestador = prestador.getNome();
		this.status = prestador.isStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static List<PrestadorAtivoDto> converter(List<Prestador> prestador) {
		return prestador.stream().map(PrestadorAtivoDto::new).collect(Collectors.toList());
	}
}
