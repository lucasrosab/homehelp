package com.homehelp.services.controller.form;

import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

public class AtualizacaoPrestadorPorDadosForm {

	private String nome;
	private String sobrenome;
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
	
	public Prestador atualizar(Long id, PrestadorRepository prestadorRepository) {
		Prestador prestador = prestadorRepository.getOne(id);
		prestador.setNome(this.nome);
		prestador.setSobrenome(this.sobrenome);
		prestador.setDataNascimento(this.dataNascimento);
		prestador.setTelefone(this.telefone);
		prestador.setSexo(this.sexo);
		return prestador;
	}
}
