package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Prestador;
import br.com.homehelp.api.repository.PrestadorRepository;

public class PrestadorForm {

	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String habilidade;
	private String celular;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public Prestador converter(PrestadorRepository prestadorRepository) {
		return new Prestador(nome, dataNascimento, sexo, cpf, habilidade, celular, email, senha);
	}
}
