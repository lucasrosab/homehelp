package com.homehelp.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Solicitacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Prestador prestador;
	
	@ManyToOne
	private Cliente cliente; 
	
	private String horario;
	
	private String endereco;
	
	private String status = "Disponivel";
	
	public Solicitacao() {
		super();
	}

	public Solicitacao(Prestador prestador, Cliente cliente, String horario) {
		super();
		this.prestador = prestador;
		this.cliente = cliente;
		this.horario = horario;
	}

	public Solicitacao(Prestador prestador, Cliente cliente, String horario, String status) {
		super();
		this.prestador = prestador;
		this.cliente = cliente;
		this.horario = horario;
		this.status = status;
	}

	public Solicitacao(Long id, Prestador prestador, Cliente cliente, String horario, String status) {
		super();
		this.id = id;
		this.prestador = prestador;
		this.cliente = cliente;
		this.horario = horario;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
