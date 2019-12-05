package br.com.homehelp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.model.Administrador;
import br.com.homehelp.model.Cliente;
import br.com.homehelp.service.AdministradorService;

@RestController
@RequestMapping("/admin") 
public class AdministradorController {

	@Autowired
	AdministradorService administradorService;
	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/novo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Administrador> cadastrarAdministrador(@RequestBody Administrador administrador) {

		Administrador administradorCadastrado = administradorService.cadastrar(administrador);
		return new ResponseEntity<>(administradorCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Administrador>> buscarTodosAdministradores() {

		Collection<Administrador> administradorBuscados = administradorService.buscarTodos();

		return new ResponseEntity<>(administradorBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Administrador> buscarAdministradorPorId(@PathVariable Integer id) {

		Administrador administrador = administradorService.buscarPorId(id);

		return new ResponseEntity<>(administrador, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}" )
	public ResponseEntity<Cliente> excluirAdministrador(@PathVariable Integer id) {
		
		Administrador administradorEncontrado = administradorService.buscarPorId(id);
		if (administradorEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		administradorService.excluir(administradorEncontrado);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Administrador> alterarAdministrador(@RequestBody Administrador administrador) {

		Administrador administradorAlterado = administradorService.alterar(administrador);
		return new ResponseEntity<>(administradorAlterado, HttpStatus.OK);
	}
}
