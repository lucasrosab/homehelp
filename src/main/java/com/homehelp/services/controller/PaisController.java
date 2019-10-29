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

import com.homehelp.services.controller.dto.PaisDto;
import com.homehelp.services.controller.form.AtualizacaoPaisForm;
import com.homehelp.services.controller.form.PaisForm;
import com.homehelp.services.model.Pais;
import com.homehelp.services.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public List<PaisDto> listar() {
		List<Pais> pais = paisRepository.findAll();
		return PaisDto.converter(pais);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form, UriComponentsBuilder uriBuilder) {
		Pais pais = form.converter(paisRepository);
		paisRepository.save(pais);

		URI uri = uriBuilder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).body(new PaisDto(pais));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaisDto> detalhar(@PathVariable Long id) {
		Optional<Pais> pais = paisRepository.findById(id);
		if (pais.isPresent()) {
			return ResponseEntity.ok(new PaisDto(pais.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PaisDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoPaisForm form) {
		Optional<Pais> optional = paisRepository.findById(id);
		if (optional.isPresent()) {
			Pais pais = form.atualizar(id, paisRepository);
			return ResponseEntity.ok(new PaisDto(pais));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pais> optional = paisRepository.findById(id);
		if (optional.isPresent()) {
			paisRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
