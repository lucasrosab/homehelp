package com.homehelp.services.controller.form;

import com.homehelp.services.model.Banco;
import com.homehelp.services.model.Pessoa;
import com.homehelp.services.repository.PessoaRepository;

public class AtualizacaoPessoaForm {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		pessoa.setNome(this.nome);
		pessoa.setSobrenome(this.sobrenome);
		pessoa.setCpf(this.cpf);
		pessoa.setSexo(this.sexo);
		pessoa.setTelefone(this.telefone);
		pessoa.setEmail(this.email);
		pessoa.setSenha(this.senha);
		return pessoa;
	}

}
