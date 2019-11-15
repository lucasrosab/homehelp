package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Administrador;

public class AdministradorDto {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	private String senha;
	private int matricula;
	
	public AdministradorDto(Administrador admin) {
		this.nome = admin.getNome();
		this.sobrenome = admin.getSobrenome();
		this.cpf = admin.getCpf();
		this.sexo = admin.getSexo();
		this.telefone = admin.getTelefone();
		this.email = admin.getEmail();
		this.senha = admin.getSenha();
		this.matricula = admin.getMatricula();
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
		
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static List<AdministradorDto> converter(List<Administrador> admin) {
		return admin.stream().map(AdministradorDto::new).collect(Collectors.toList());
	}

}
