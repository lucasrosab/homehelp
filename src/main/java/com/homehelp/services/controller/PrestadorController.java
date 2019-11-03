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
import com.homehelp.services.controller.form.AtualizacaoPrestadorForm;
import com.homehelp.services.controller.form.PrestadorForm;
import com.homehelp.services.model.Prestador;
import com.homehelp.services.repository.PrestadorRepository;

@RestController
@RequestMapping("/prestador")
public class PrestadorController {

	@Autowired
	private PrestadorRepository prestadorRepository;
	
	@GetMapping
	public List<PrestadorDto> listar(){
		List<Prestador> prestador = prestadorRepository.findAll();
		return PrestadorDto.converter(prestador);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PrestadorDto> cadastrar(@RequestBody @Valid PrestadorForm form, UriComponentsBuilder uriBuilder) {
		Prestador prestador = form.converter(prestadorRepository);
		prestadorRepository.save(prestador);

		URI uri = uriBuilder.path("/prestador/{id}").buildAndExpand(prestador.getId()).toUri();
		return ResponseEntity.created(uri).body(new PrestadorDto(prestador));
	}
	
	//Detalhar um prestador pela id dele
	@GetMapping("/{id}")
	public ResponseEntity <PrestadorDto> detalhar(@PathVariable Long id) {
		Optional<Prestador> prestador = prestadorRepository.findById(id);
		if (prestador.isPresent()) {
			return ResponseEntity.ok(new PrestadorDto(prestador.get()));
		}	
		return ResponseEntity.notFound().build();		
	}

	//Listar os prestadores pelo status ativo
	@GetMapping("/ativo")
	public List <PrestadorAtivoDto> prestadorAtivo() {
		List<Prestador> prestador = prestadorRepository.findAll();
		return PrestadorAtivoDto.converter(prestador);		
	}
	
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
