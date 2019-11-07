package com.homehelp.services.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	private String dataNascimento;
	private boolean ativo;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.cpf = cliente.getCpf();
		this.sexo = cliente.getSexo();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.dataNascimento = cliente.getDataNascimento();
		this.ativo = cliente.isAtivo();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNascimento() { 
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) { 
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) { 
		this.ativo = ativo;
	}
	
	public static List<ClienteDto> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
