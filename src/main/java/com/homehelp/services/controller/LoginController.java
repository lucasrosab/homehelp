package com.homehelp.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelp.services.controller.dto.ClienteDto;
import com.homehelp.services.model.Cliente;
import com.homehelp.services.repository.ClienteRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ClienteRepository clienteRepository;

	//Retorna os dados do usuario logado 
	@GetMapping
	public List<ClienteDto> lista(String email, String senha) {
		List<Cliente> cliente = clienteRepository.findByEmailAndSenha(email, senha); 
		return ClienteDto.converter(cliente);  
	}
}
