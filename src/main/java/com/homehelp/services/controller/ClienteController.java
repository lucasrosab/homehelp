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

import com.homehelp.services.controller.dto.ClienteDto;
import com.homehelp.services.controller.form.AtualizacaoClienteDesativarForm;
import com.homehelp.services.controller.form.AtualizacaoClienteForm;
import com.homehelp.services.controller.form.AtualizacaoClientePorDadosForm;
import com.homehelp.services.controller.form.AtualizacaoClientePorLoginForm;
import com.homehelp.services.controller.form.ClienteForm;
import com.homehelp.services.model.Cliente;
import com.homehelp.services.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	//Listar todos os clientes
	@GetMapping
	public List<ClienteDto> listar() {
		List<Cliente> cliente = clienteRepository.findAll();
		return ClienteDto.converter(cliente);
	}

	
	//Detalhar um cliente pela ID Dinamica 
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	//Cadastrar um cliente
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(clienteRepository);
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	//Atualizar todos os dados do cliente pela ID
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}

	//Atualizar todos os dados pessoais do cliente pela ID
	@PutMapping("/cli/dados/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarDadosPessoais(@PathVariable Long id, @RequestBody @Valid AtualizacaoClientePorDadosForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Atualizar todos os dados de login do cliente pela ID
	@PutMapping("/cli/login/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarDadosLogin(@PathVariable Long id, @RequestBody @Valid AtualizacaoClientePorLoginForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Desativar o cliente
	@PutMapping("/cli/desativar/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> desativar(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteDesativarForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Deletar todos os dados do cliente pela ID
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
