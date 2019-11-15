package br.com.homehelp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.api.controller.dto.ClienteDto;
import br.com.homehelp.api.model.Cliente;
import br.com.homehelp.api.repository.ClienteRepository;

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
