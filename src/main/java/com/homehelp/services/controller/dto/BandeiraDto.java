package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Bandeira;

public class BandeiraDto {
	
	private String nome;
	
	public BandeiraDto(Bandeira bandeira) {
		this.nome = bandeira.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<BandeiraDto> converter(List<Bandeira> bandeira) {
		return bandeira.stream().map(BandeiraDto::new).collect(Collectors.toList());
	}

}
