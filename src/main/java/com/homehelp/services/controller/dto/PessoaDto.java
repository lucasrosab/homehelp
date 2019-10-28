package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Pessoa;

public class PessoaDto {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	
	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.cpf = pessoa.getCpf();
		this.sexo = pessoa.getSexo();
		this.telefone = pessoa.getTelefone();
		this.email = pessoa.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<PessoaDto> converter(List<Pessoa> pessoa) {
		// TODO Auto-generated method stub
		return pessoa.stream().map(PessoaDto::new).collect(Collectors.toList());
	}
}
