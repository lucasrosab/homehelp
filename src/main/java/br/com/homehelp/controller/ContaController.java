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

import br.com.homehelp.model.Conta;

import br.com.homehelp.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/nova", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta) {

		Conta contaCadastrado = contaService.cadastrar(conta);
		return new ResponseEntity<>(contaCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Conta>> buscarTodasContas() {

		Collection<Conta> contasBuscadas = contaService.buscarTodos();

		return new ResponseEntity<>(contasBuscadas, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conta> buscarContaPorId(@PathVariable Integer id) {

		Conta conta = contaService.buscarPorId(id);

		return new ResponseEntity<>(conta, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}" )
	public ResponseEntity<Conta> excluirConta(@PathVariable Integer id) {
		
		Conta contaEncontrado = contaService.buscarPorId(id);
		if (contaEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		contaService.excluir(contaEncontrado);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conta> alterarCliente(@RequestBody Conta conta) {

		Conta contaAlterada = contaService.alterar(conta);
		return new ResponseEntity<>(contaAlterada, HttpStatus.OK);
	}
}
