package br.com.homehelp.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.model.Cliente;
import br.com.homehelp.service.LoginClienteService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginClienteController {
	
	@Autowired 
	private LoginClienteService loginClienteService;
	
	@RequestMapping(value="/auth-cli", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Cliente cliente) throws ServletException{
		
		if (cliente.getEmail() == null || cliente.getSenha() == null){
			throw new ServletException("Email e senha obrigatório.");
		}
		
		//Consulta no banco
		Cliente cliAutenticado = loginClienteService.buscarPorEmail(cliente.getEmail());
		
		if (cliAutenticado==null){
			throw new ServletException("Cliente não encontrado.");
		}
		
		if (!cliAutenticado.getSenha().equals(cliente.getSenha())){
			throw new ServletException("Usuário ou senha inválido.");
		}
		
		String token=  Jwts.builder()
				.setSubject(cliAutenticado.getEmail())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();
		
		
		return	new LoginResponse(token);
	}		
	
	private class LoginResponse{
		public String token;
		 
		public LoginResponse(String token ){
			this.token=token; 
		 }
		
	}
}
