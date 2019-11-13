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

import com.homehelp.services.controller.dto.SolicitacaoDto;
import com.homehelp.services.controller.form.AtualizacaoSolicitacaoForm;
import com.homehelp.services.controller.form.SolicitacaoForm;
import com.homehelp.services.model.Solicitacao;
import com.homehelp.services.repository.ClienteRepository;
import com.homehelp.services.repository.PrestadorRepository;
import com.homehelp.services.repository.SolicitacaoRepository;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Autowired
	private PrestadorRepository prestadorRepository;
	
	@Autowired ClienteRepository clienteRepository;
	
	
	@GetMapping
	public List<SolicitacaoDto> lista() {
		List<Solicitacao> solicitacao = solicitacaoRepository.findAll();
		return SolicitacaoDto.converter(solicitacao);
	}

	@PostMapping //Verificar por conta do Relacionamento 
	@Transactional
	public ResponseEntity<SolicitacaoDto> cadastrar(@RequestBody @Valid SolicitacaoForm form, UriComponentsBuilder uriBuilder) {
		Solicitacao solicitacao = form.converter(clienteRepository, prestadorRepository);
		solicitacaoRepository.save(solicitacao);

		URI uri = uriBuilder.path("/solicitacao/{id}").buildAndExpand(solicitacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SolicitacaoDto(solicitacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <SolicitacaoDto> detalhar(@PathVariable Long id) {
		Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(id);
		if (solicitacao.isPresent()) {
			return ResponseEntity.ok(new SolicitacaoDto(solicitacao.get()));
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SolicitacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoSolicitacaoForm form) {
		Optional<Solicitacao> optional = solicitacaoRepository.findById(id);
		if (optional.isPresent()) {
			Solicitacao solicitacao = form.atualizar(id, solicitacaoRepository);
			return ResponseEntity.ok(new SolicitacaoDto(solicitacao));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Solicitacao> optional = solicitacaoRepository.findById(id);
		if (optional.isPresent()) {
			solicitacaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Listar todas as solicitacoes ativas
	@GetMapping("/ativa")
	public List <SolicitacaoDto> solicitacaoAtivo() {
		List<Solicitacao> solicitacao = solicitacaoRepository.findAll();
		return SolicitacaoDto.converter(solicitacao);		
	}
}
