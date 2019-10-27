package com.homehelp.services.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

	private int id;

	public Cliente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
