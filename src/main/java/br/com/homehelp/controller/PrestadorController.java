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

import br.com.homehelp.model.Prestador;
import br.com.homehelp.service.PrestadorService;

@RestController
@RequestMapping("/pres")
public class PrestadorController {
	
	@Autowired
	PrestadorService prestadorService;
	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/novo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prestador> cadastrarPrestador(@RequestBody Prestador prestador) {

		Prestador prestadorCadastrado = prestadorService.cadastrar(prestador);
		return new ResponseEntity<>(prestadorCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Prestador>> buscarTodosPrestadores() {

		Collection<Prestador> prestadoresBuscados = prestadorService.buscarTodos();

		return new ResponseEntity<>(prestadoresBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prestador> buscarPrestadorPorId(@PathVariable Integer id) {

		Prestador prestador = prestadorService.buscarPorId(id);

		return new ResponseEntity<>(prestador, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}" )
	public ResponseEntity<Prestador> excluirPrestador(@PathVariable Integer id) {
		
		Prestador prestadorEncontrado = prestadorService.buscarPorId(id);
		if (prestadorEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		prestadorService.excluir(prestadorEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prestador> alterarPrestador(@RequestBody Prestador prestador) {

		Prestador prestadorAlterado = prestadorService.alterar(prestador);
		return new ResponseEntity<>(prestadorAlterado, HttpStatus.OK);
	}

}
