package com.homehelp.services.controller.form;

import com.homehelp.services.model.Solicitacao;
import com.homehelp.services.repository.SolicitacaoRepository;

public class AtualizacaoSolicitacaoForm {

	private String horario;
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Solicitacao atualizar(Long id, SolicitacaoRepository solicitacaoRepository) {
		Solicitacao solicitacao = solicitacaoRepository.getOne(id);
		solicitacao.setHorario(this.horario);
		return solicitacao;
	}
}
