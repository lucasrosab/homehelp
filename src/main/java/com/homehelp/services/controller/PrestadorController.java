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

import com.homehelp.services.controller.dto.PrestadorAtivoDto;
import com.homehelp.services.controller.dto.PrestadorDto;
import com.homehelp.services.controller.dto.PrestadorStatusDto;
import com.homehelp.services.controller.form.AtualizacaoPrestadorDesativarForm;
import com.homehelp.services.controller.form.AtualizacaoPrestadorForm;
import com.homehelp.services.controller.form.AtualizacaoPrestadorPorDadosForm;
import com.homehelp.services.controller.form.AtualizacaoPrestadorPorLoginForm;
import com.homehelp.services.controller.form.AtualizacaoPrestadorStatusForm;
import com.homehelp.services.controller.form.PrestadorForm;
import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

@RestController
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorRepository prestadorRepository;
	
	//Listar todos os prestadores
	@GetMapping
	public List<PrestadorDto> listar(){
		List<Prestador> prestador = prestadorRepository.findAll();
		return PrestadorDto.converter(prestador);
	}
	
	//Detalhar um prestador pela ID Dinamica 
	@GetMapping("/{id}")
	public ResponseEntity <PrestadorDto> detalhar(@PathVariable Long id) {
		Optional<Prestador> prestador = prestadorRepository.findById(id);
		if (prestador.isPresent()) {
			return ResponseEntity.ok(new PrestadorDto(prestador.get()));
		}	
		return ResponseEntity.notFound().build();		
	}
	
	//Recupera o status do Prestador
	@GetMapping("/status/{id}")
	public ResponseEntity <PrestadorStatusDto> recuperarStatus(@PathVariable Long id) {
		Optional<Prestador> prestador = prestadorRepository.findById(id);
		if (prestador.isPresent()) {
			return ResponseEntity.ok(new PrestadorStatusDto(prestador.get()));
		}	
		return ResponseEntity.notFound().build();		
	}
	
	//Listar todos os prestadores pelo status ativo
	@GetMapping("/ativo")
	public List <PrestadorAtivoDto> prestadorAtivo() {
		List<Prestador> prestador = prestadorRepository.findAll();
		return PrestadorAtivoDto.converter(prestador);		
	}
	
	//Cadastrar um prestador
	@PostMapping
	@Transactional
	public ResponseEntity<PrestadorDto> cadastrar(@RequestBody @Valid PrestadorForm form, UriComponentsBuilder uriBuilder) {
		Prestador prestador = form.converter(prestadorRepository);
		prestadorRepository.save(prestador);

		URI uri = uriBuilder.path("/prestador/{id}").buildAndExpand(prestador.getId()).toUri();
		return ResponseEntity.created(uri).body(new PrestadorDto(prestador));
	}
	
	//Atualizar um prestador
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PrestadorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorForm form) {
		Optional<Prestador> prestador = prestadorRepository.findById(id);
		if (prestador.isPresent()) {
			Prestador prestadores = form.atualizar(id, prestadorRepository);
			return ResponseEntity.ok(new PrestadorDto(prestadores));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Atualizar todos os dados pessoais do prestador pela ID
	@PutMapping("/pres/dados/{id}")
	@Transactional
	public ResponseEntity<PrestadorDto> atualizarDadosPessoais(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorPorDadosForm form) {
		Optional<Prestador> optional = prestadorRepository.findById(id);
		if (optional.isPresent()) {
			Prestador prestador = form.atualizar(id, prestadorRepository);
			return ResponseEntity.ok(new PrestadorDto(prestador));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Atualizar todos os dados de login do prestador pela ID
	@PutMapping("/pres/login/{id}")
	@Transactional
	public ResponseEntity<PrestadorDto> atualizarDadosLogin(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorPorLoginForm form) {
		Optional<Prestador> optional = prestadorRepository.findById(id);
		if (optional.isPresent()) {
			Prestador prestador = form.atualizar(id, prestadorRepository);
			return ResponseEntity.ok(new PrestadorDto(prestador));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Desativar o prestador
	@PutMapping("/pres/desativar/{id}")
	@Transactional
	public ResponseEntity<PrestadorDto> desativar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorDesativarForm form) {
		Optional<Prestador> optional = prestadorRepository.findById(id);
		if (optional.isPresent()) {
			Prestador prestador = form.atualizar(id, prestadorRepository);
			return ResponseEntity.ok(new PrestadorDto(prestador));
		}
		return ResponseEntity.notFound().build();
	}
	
	//Atualiza o status de um prestador
	@PutMapping("/pres/status/{id}")
	@Transactional
	public ResponseEntity<PrestadorStatusDto> atualizarStatus(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorStatusForm form) {
		Optional<Prestador> prestador = prestadorRepository.findById(id);
		if (prestador.isPresent()) {
			Prestador prestadores = form.atualizar(id, prestadorRepository);
			return ResponseEntity.ok(new PrestadorStatusDto(prestadores));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Deletar todos os dados do prestador pela ID
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Prestador> optional = prestadorRepository.findById(id);
		if (optional.isPresent()) {
			prestadorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
