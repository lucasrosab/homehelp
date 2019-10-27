package com.homehelp.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Administrado extends Pessoa {
	
	@Column(nullable = false)
	private int matricula;

	@ManyToOne 
	private Acesso acesso;

	public Administrado() {
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Acesso getPerfilAcesso() {
		return acesso;
	}

	public void setPerfilAcesso(Acesso acesso) {
		this.acesso = acesso;
	}
}
