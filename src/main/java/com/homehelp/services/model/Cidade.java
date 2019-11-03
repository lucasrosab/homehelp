package com.homehelp.services.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 100 ,nullable = false)
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Estado estado;
	
	@OneToOne(mappedBy = "cidade") 
	private Endereco endereco;

	public Cidade() {
		
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}