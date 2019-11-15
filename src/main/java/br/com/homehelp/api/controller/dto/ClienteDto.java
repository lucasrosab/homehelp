package br.com.homehelp.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.homehelp.api.model.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String cidade;
	private String endereco;
	private String celular;
	private String email;
	private String senha;
	private boolean status_conta;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.dataNascimento = cliente.getDataNascimento();
		this.sexo = cliente.getSexo();
		this.cpf = cliente.getCpf();
		this.cidade = cliente.getCidade();
		this.endereco = cliente.getEndereco();	
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.status_conta = cliente.isStatus_conta();
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

	public static List<ClienteDto> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
