package com.homehelp.services.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.homehelp.services.model.Cliente;
import com.homehelp.services.repository.ClienteAutenticacaoRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private ClienteAutenticacaoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Cliente> clienteLogin = repository.findByEmail(username);
		if(clienteLogin.isPresent()){
			return clienteLogin.get();
		}
		throw new UsernameNotFoundException("Dados inválidos!");		
	}

}
