package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Administrador;
import br.com.homehelp.api.repository.AdministradorRepository;

public class AtualizacaoAdministradorForm {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	private int matricula;
	
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
		
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public Administrador atualizar(Long id, AdministradorRepository administradorRepository) {
		Administrador admin = administradorRepository.getOne(id);
		admin.setNome(this.nome);
		admin.setSobrenome(this.sobrenome);
		admin.setCpf(this.cpf);
		admin.setSexo(this.sexo);
		admin.setTelefone(this.telefone);
		admin.setEmail(this.email);
		admin.setSenha(this.senha);
		admin.setMatricula(this.matricula);
		return admin;
	}

}
