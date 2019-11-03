package com.homehelp.services.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 250 ,nullable = false)
	private String endereco;

	@Column(length = 100)
	private String complemento;

	private int numero;

	@OneToOne(cascade = CascadeType.ALL)
	private Cidade cidade;
	
	@OneToMany(mappedBy = "endereco")
	private List<Favorito> favorito;
	
	public Endereco() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Favorito> getFavorito() {
		return favorito;
	} 
}