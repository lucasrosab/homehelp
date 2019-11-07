package com.homehelp.services.controller.form;

import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

public class AtualizacaoPrestadorDesativarForm {
	
	public boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Prestador atualizar(Long id, PrestadorRepository prestadorRepository) {
		Prestador prestador = prestadorRepository.getOne(id);
		prestador.setAtivo(this.ativo);
		return prestador;
	}
}
