package com.homehelp.services.controller.form;

import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

public class AtualizacaoStatusPrestadorForm {

	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Prestador atualizar(Long id, PrestadorRepository prestadorRepository) {
		Prestador prestador = prestadorRepository.getOne(id);
		prestador.setStatus(this.status);
		return prestador;
	}
}
