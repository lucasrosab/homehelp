package com.homehelp.services.controller.form;

import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

public class PrestadorForm {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	private String dataNascimento;
	
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
	
	public Prestador converter(PrestadorRepository prestadorRepository) {
		return new Prestador(nome,sobrenome,cpf,sexo,telefone,email,senha,dataNascimento);
	}
}