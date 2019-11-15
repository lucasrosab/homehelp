package br.com.homehelp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 10, nullable = false)
	private String dataNascimento;

	@Column(length = 20, nullable = false)
	private String sexo;
	
	@Column(length = 20, nullable = false)
	private String cpf;

	@Column(length = 20, nullable = false)
	private String cidade;
	
	@Column(length = 150, nullable = false)
	private String endereco;

	@Column(length = 20, nullable = false)
	private String celular;

	@Column(length = 250, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String senha;

	@Column(columnDefinition = "TINYINT") 
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean status_conta = true;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String dataNascimento, String sexo, String cpf, String cidade, String endereco, String celular, String email, String senha) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.cidade = cidade;
		this.endereco = endereco;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true; 
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public boolean isStatus_conta() {
		return status_conta;
	}

	public void setStatus_conta(boolean status_conta) {
		this.status_conta = status_conta;
	}

}
