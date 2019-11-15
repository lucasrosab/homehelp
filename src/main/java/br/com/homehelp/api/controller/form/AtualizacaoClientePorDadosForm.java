package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.repository.ClienteRepository;

public class AtualizacaoClientePorDadosForm {

	private String nome;
	private String dataNascimento;
	private String telefone;
	private String sexo;
	
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNome(this.nome);
		cliente.setSobrenome(this.sobrenome);
		cliente.setDataNascimento(this.dataNascimento);
		cliente.setTelefone(this.telefone);
		cliente.setSexo(this.sexo);
		return cliente;
	}
	
}
