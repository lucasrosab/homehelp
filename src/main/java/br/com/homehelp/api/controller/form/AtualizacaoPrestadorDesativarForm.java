package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Prestador;
import br.com.homehelp.api.repository.PrestadorRepository;

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
