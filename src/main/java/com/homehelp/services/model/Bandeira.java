package com.homehelp.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bandeira {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 60 ,nullable = false)
	private String nome;

	public Bandeira() {

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
}
