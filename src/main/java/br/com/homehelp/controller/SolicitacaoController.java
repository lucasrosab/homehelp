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

import br.com.homehelp.model.Solicitacao;
import br.com.homehelp.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitar")
public class SolicitacaoController {


	@Autowired
	SolicitacaoService solicitacaoService;
	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/nova", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Solicitacao> cadastrarSolicitacao(@RequestBody Solicitacao solicitacao) {

		Solicitacao solicitacaoCadastrado = solicitacaoService.cadastrar(solicitacao);
		return new ResponseEntity<>(solicitacaoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Solicitacao>> buscarTodasSolicitacoes() {

		Collection<Solicitacao> solicitacoesBuscadas = solicitacaoService.buscarTodos();

		return new ResponseEntity<>(solicitacoesBuscadas, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Solicitacao> buscarSolicitacaoPorId(@PathVariable Integer id) {

		Solicitacao solicitacao = solicitacaoService.buscarPorId(id);

		return new ResponseEntity<>(solicitacao, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}" )
	public ResponseEntity<Solicitacao> excluirSolicitacao(@PathVariable Integer id) {
		
		Solicitacao solicitacaoEncontrado = solicitacaoService.buscarPorId(id);
		if (solicitacaoEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		solicitacaoService.excluir(solicitacaoEncontrado);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Solicitacao> alterarSolicitacao(@RequestBody Solicitacao solicitacao) {

		Solicitacao solicitacaoAlterado = solicitacaoService.alterar(solicitacao);
		return new ResponseEntity<>(solicitacaoAlterado, HttpStatus.OK);
	}

}
