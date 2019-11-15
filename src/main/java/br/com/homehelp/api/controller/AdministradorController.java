package br.com.homehelp.api.controller;

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

import br.com.homehelp.api.controller.dto.AdministradorDto;
import br.com.homehelp.api.controller.form.AdministradorForm;
import br.com.homehelp.api.controller.form.AtualizacaoAdministradorForm;
import br.com.homehelp.api.model.Administrador;
import br.com.homehelp.api.repository.AdministradorRepository;

@RestController
@RequestMapping("/admin")
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@GetMapping
	public List<AdministradorDto> listar(){
		List<Administrador> admin = administradorRepository.findAll();
		return AdministradorDto.converter(admin);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AdministradorDto> cadastrar(@RequestBody @Valid AdministradorForm form, UriComponentsBuilder uriBuilder) {
		Administrador admin = form.converter(administradorRepository);
		administradorRepository.save(admin);

		URI uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
		return ResponseEntity.created(uri).body(new AdministradorDto(admin));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdministradorDto> detalhar(@PathVariable Long id) {
		Optional<Administrador> admin = administradorRepository.findById(id);
		if (admin.isPresent()) {
			return ResponseEntity.ok(new AdministradorDto(admin.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AdministradorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAdministradorForm form) {
		Optional<Administrador> optional = administradorRepository.findById(id);
		if (optional.isPresent()) {
			Administrador admin = form.atualizar(id, administradorRepository);
			return ResponseEntity.ok(new AdministradorDto(admin));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Administrador> optional = administradorRepository.findById(id);
		if (optional.isPresent()) {
			administradorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
