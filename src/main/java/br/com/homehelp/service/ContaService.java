package br.com.homehelp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Conta;
import br.com.homehelp.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;
	
	// Negocios
	public Conta cadastrar(Conta conta) {
		return contaRepository.save(conta);
	}

	public Collection<Conta> buscarTodos() {
		return contaRepository.findAll();
	}
	
	public void excluir (Conta conta){
		contaRepository.delete(conta);
	}
	
	public Conta buscarPorId(Integer id) {
		return contaRepository.findOne(id);
	}
	
	public Conta alterar(Conta conta){
		return contaRepository.save(conta);
	}
}
