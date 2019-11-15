package br.com.homehelp.api.controller.form;

import br.com.homehelp.api.model.Prestador;
import br.com.homehelp.api.repository.PrestadorRepository;

public class AtualizacaoPrestadorStatusForm {

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
