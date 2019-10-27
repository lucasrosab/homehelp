package com.homehelp.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Administrado extends Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int matricula;

	@ManyToOne 
	private Acesso perfilAcesso;

	public Administrado() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Acesso getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(Acesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
}
