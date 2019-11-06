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
import com.homehelp.services.controller.form.AtualizacaoBandeiraForm;
import com.homehelp.services.controller.form.BandeiraForm;
import com.homehelp.services.model.Bandeira;
import com.homehelp.services.repository.BandeiraRepository;


@RestController
@RequestMapping("/bandeira")
public class BandeiraController {

	@Autowired
	private BandeiraRepository bandeiraRepository;
 
	@GetMapping
	public List<BandeiraDto> lista(String pessoa) {
		if (pessoa == null) {
			List<Bandeira> bandeira = bandeiraRepository.findAll();
			return BandeiraDto.converter(bandeira);
		} else {
			List<Bandeira> bandeira = bandeiraRepository.findByNome(pessoa); 
			return BandeiraDto.converter(bandeira); 
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<BandeiraDto> cadastrar(@RequestBody @Valid BandeiraForm form, UriComponentsBuilder uriBuilder) {
		Bandeira bandeira = form.converter(bandeiraRepository);
		bandeiraRepository.save(bandeira);

		URI uri = uriBuilder.path("/bandeira/{id}").buildAndExpand(bandeira.getId()).toUri();
		return ResponseEntity.created(uri).body(new BandeiraDto(bandeira));
	}

	@GetMapping("/{id}")
	public ResponseEntity <BandeiraDto> detalhar(@PathVariable Long id) {
		Optional<Bandeira> bandeira = bandeiraRepository.findById(id);
		if (bandeira.isPresent()) {
			return ResponseEntity.ok(new BandeiraDto(bandeira.get()));
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BandeiraDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoBandeiraForm form) {
		Optional<Bandeira> bandeira = bandeiraRepository.findById(id);
		if (bandeira.isPresent()) {
			Bandeira bandeiras = form.atualizar(id, bandeiraRepository);
			return ResponseEntity.ok(new BandeiraDto(bandeiras));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Bandeira> optional = bandeiraRepository.findById(id);
		if (optional.isPresent()) {
			bandeiraRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
