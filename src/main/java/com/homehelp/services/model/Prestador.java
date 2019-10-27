package com.homehelp.services.model;

import javax.persistence.Entity;

import javax.persistence.OneToOne;

@Entity
public class Prestador extends Usuario {

	@OneToOne
	private Conta conta;

	public Prestador() {
		super();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
