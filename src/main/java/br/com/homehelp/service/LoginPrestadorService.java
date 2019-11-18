package br.com.homehelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Prestador;
import br.com.homehelp.repository.PrestadorRepository;

@Service
public class LoginPrestadorService {

	@Autowired
	private PrestadorRepository prestadorRepository;
	
	public Prestador buscarPorEmail(String email){
		return prestadorRepository.buscarPorEmail(email);
	}
}
