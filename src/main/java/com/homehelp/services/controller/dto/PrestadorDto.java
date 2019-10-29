package com.homehelp.services.controller.dto;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.homehelp.services.model.Prestador;

public class PrestadorDto {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	private String usuario;
	private Calendar dataNascimento;
	private boolean ativo;
	
	public PrestadorDto(Prestador prestador) {
		this.nome = prestador.getNome();
		this.sobrenome = prestador.getSobrenome();
		this.cpf = prestador.getCpf();
		this.sexo = prestador.getSexo();
		this.telefone = prestador.getTelefone();
		this.email = prestador.getEmail();
		this.senha = prestador.getSenha();
		this.usuario = prestador.getUsuario();
		this.dataNascimento = prestador.getDataNascimento();
		this.ativo = prestador.isAtivo();
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public static List<PrestadorDto> converter(List<Prestador> prestador) {
		return prestador.stream().map(PrestadorDto::new).collect(Collectors.toList());
	}
}
