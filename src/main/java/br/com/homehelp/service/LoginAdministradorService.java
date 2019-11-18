package br.com.homehelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Administrador;	
import br.com.homehelp.repository.AdministradorRespository;

@Service
public class LoginAdministradorService {

	@Autowired
	private AdministradorRespository administradorRepository;
	
	public Administrador buscarPorEmail(String email){
		return administradorRepository.buscarPorEmail(email);
	}
	
}
