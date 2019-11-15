package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Prestador;

public class PrestadorDto {
	
	private Long id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String habilidade;
	private String celular;
	private String email;
	private String senha; 
	private boolean status_prestador;
	private boolean status_conta;
	
	public PrestadorDto(Prestador prestador) {
		this.id = prestador.getId();
		this.nome = prestador.getNome();
		this.dataNascimento = prestador.getDataNascimento();
		this.sexo = prestador.getSexo();
		this.cpf = prestador.getCpf();
		this.habilidade = prestador.getHabilidade();
		this.celular = prestador.getCelular();
		this.email = prestador.getEmail();
		this.senha = prestador.getSenha();
		this.status_prestador = prestador.isStatus_prestador();
		this.status_conta = prestador.isStatus_conta();
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

	public boolean isStatus_prestador() {
		return status_prestador;
	}

	public void setStatus_prestador(boolean status_prestador) {
		this.status_prestador = status_prestador;
	}

	public boolean isStatus_conta() {
		return status_conta;
	}

	public void setStatus_conta(boolean status_conta) {
		this.status_conta = status_conta;
	}

	public static List<PrestadorDto> converter(List<Prestador> prestador) {
		return prestador.stream().map(PrestadorDto::new).collect(Collectors.toList());
	}
}
