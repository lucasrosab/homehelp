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

import com.homehelp.services.controller.dto.BancoDto;
import com.homehelp.services.controller.form.AtualizacaoBancoForm;
import com.homehelp.services.controller.form.BancoForm;
import com.homehelp.services.model.Banco;
import com.homehelp.services.repository.BancoRepository;


@RestController
@RequestMapping("/banco")
public class BancoController {

	@Autowired
	private BancoRepository bBancoRepository;
	
	@GetMapping
	public List<BancoDto> exibirBancos(String sNomeBanco){
		if (sNomeBanco == null) {
			List<Banco> banco = bBancoRepository.findAll();
			return BancoDto.converter(banco);
		} else {
			List<Banco> banco = bBancoRepository.findByNome(sNomeBanco);
			return BancoDto.converter(banco);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<BancoDto> cadastrar(@RequestBody @Valid BancoForm form, UriComponentsBuilder uriBuilder) {
		Banco banco = form.converter(bBancoRepository);
		bBancoRepository.save(banco);
		
		URI uri = uriBuilder.path("/banco/{id}").buildAndExpand(banco.getId()).toUri();
		return ResponseEntity.created(uri).body(new BancoDto(banco));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BancoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoBancoForm form) {
		Optional<Banco> optional = bBancoRepository.findById(id);
		if (optional.isPresent()) {
			Banco banco = form.atualizar(id, bBancoRepository);
			return ResponseEntity.ok(new BancoDto(banco));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Banco> optional = bBancoRepository.findById(id);
		if (optional.isPresent()) {
			bBancoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build(); 
	}

	
	
	
	
}
