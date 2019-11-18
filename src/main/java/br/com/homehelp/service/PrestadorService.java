package br.com.homehelp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Prestador;
import br.com.homehelp.repository.PrestadorRepository;

@Service
public class PrestadorService {

	@Autowired
	PrestadorRepository prestadorRepository;
	
	// Negocios
	public Prestador cadastrar(Prestador prestador) {
		return prestadorRepository.save(prestador);
	}

	public Collection<Prestador> buscarTodos() {
		return prestadorRepository.findAll();
	}
	
	public void excluir (Prestador prestador){
		prestadorRepository.delete(prestador);
	}
	
	public Prestador buscarPorId(Integer id) {
		return prestadorRepository.findOne(id);
	}
	
	public Prestador alterar(Prestador prestador){
		return prestadorRepository.save(prestador);
	}
}
