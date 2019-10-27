package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Banco;

public class BancoDto {
	
	private String nome;
	private int prefixo;
	
	public BancoDto(Banco banco) {
		this.nome = banco.getNome();
		this.prefixo = banco.getPrefixo();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}

	public static List<BancoDto> converter(List<Banco> banco) {
		return banco.stream().map(BancoDto::new).collect(Collectors.toList());
	}

}
