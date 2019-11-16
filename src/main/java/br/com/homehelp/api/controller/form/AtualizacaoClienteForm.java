package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.repository.ClienteRepository;

public class AtualizacaoClienteForm {

	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String cidade;
	private String endereco;
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
	
	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNome(this.nome);
		cliente.setDataNascimento(this.dataNascimento);
		cliente.setSexo(this.sexo);
		cliente.setCpf(this.cpf);
		cliente.setCidade(this.cidade);
		cliente.setEndereco(this.endereco);
		cliente.setCelular(this.celular);
		cliente.setEmail(this.email);
		cliente.setSenha(this.senha);
		cliente.setDataNascimento(this.dataNascimento);
		return cliente;
	}

}