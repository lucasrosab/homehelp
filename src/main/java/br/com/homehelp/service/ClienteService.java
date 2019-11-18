package br.com.homehelp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homehelp.model.Cliente;
import br.com.homehelp.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository; 


	// Negocios
	public Cliente cadastrar(Cliente cliente) {

		return clienteRepository.save(cliente);

	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	public void excluir (Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
	public Cliente buscarPorId(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public Cliente alterar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
}
