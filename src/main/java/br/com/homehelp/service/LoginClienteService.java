package br.com.homehelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Cliente;
import br.com.homehelp.repository.ClienteRepository;

@Service
public class LoginClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorEmail(String email){
		return clienteRepository.buscarPorEmail(email);
	}
}
