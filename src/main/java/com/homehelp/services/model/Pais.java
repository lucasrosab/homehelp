package com.homehelp.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 150 ,nullable = false)
	private String nome;

	@Column(length = 5 ,nullable = false)
	private String abreviacao;

	public Pais() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
}
