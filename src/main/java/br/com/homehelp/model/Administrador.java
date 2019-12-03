package br.com.homehelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Administrador { 
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 15, nullable = false, unique = true)
	private String cpf;

	@Column(length = 10)
	private String sexo;

	@Column(length = 20, nullable = false)
	private String celular;

	@Column(length = 250, nullable = false, unique = true)
	private String email;

	@Column(length = 20, nullable = false)
	private String senha;
	
	@Column(nullable = false, unique = true)
	private String matricula;
	
	@Column(length = 10, nullable = false)
	private String dataNascimento;
	
	@Column(columnDefinition = "TINYINT") 
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean status_conta = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	} 

	public boolean isStatus_conta() {
		return status_conta;
	}

	public void setStatus_conta(boolean status_conta) { 
		this.status_conta = status_conta;
	}
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	} 
		
}
