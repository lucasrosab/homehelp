package com.homehelp.services.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.homehelp.services.controller.dto.BandeiraDto;
import com.homehelp.services.controller.dto.ClienteDto;
import com.homehelp.services.controller.form.AtualizacaoClienteForm;
import com.homehelp.services.controller.form.ClienteForm;
import com.homehelp.services.model.Bandeira;
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
