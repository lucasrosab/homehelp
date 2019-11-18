package br.com.homehelp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Solicitacao;
import br.com.homehelp.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

	@Autowired
	SolicitacaoRepository solicitacaoRepository;
	
	// Negocios
	public Solicitacao cadastrar(Solicitacao solicitacao) {
		return solicitacaoRepository.save(solicitacao);
	}

	public Collection<Solicitacao> buscarTodos() {
		return solicitacaoRepository.findAll();
	}
	
	public void excluir (Solicitacao solicitacao){
		solicitacaoRepository.delete(solicitacao);
	}
	
	public Solicitacao buscarPorId(Integer id) {
		return solicitacaoRepository.findOne(id);
	}
	
	public Solicitacao alterar(Solicitacao solicitacao){
		return solicitacaoRepository.save(solicitacao);
	}
}
