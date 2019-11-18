package br.com.homehelp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Administrador;
import br.com.homehelp.repository.AdministradorRespository;


@Service
public class AdministradorService {

	@Autowired
	AdministradorRespository administradorRepository; 
	
	// Negocios
	public Administrador cadastrar(Administrador administrador) {

		return administradorRepository.save(administrador);

	}

	public Collection<Administrador> buscarTodos() {
		return administradorRepository.findAll();
	}
	
	public void excluir (Administrador administrador){
		administradorRepository.delete(administrador);
	}
	
	public Administrador buscarPorId(Integer id) {
		return administradorRepository.findOne(id);
	}
	
	public Administrador alterar(Administrador administrador){
		return administradorRepository.save(administrador);
	}
}
