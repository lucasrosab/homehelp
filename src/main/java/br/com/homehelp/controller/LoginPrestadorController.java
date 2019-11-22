package br.com.homehelp.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.model.Prestador;
import br.com.homehelp.service.LoginPrestadorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginPrestadorController {
	
	@Autowired
	private LoginPrestadorService loginPrestadorService;
	
	@RequestMapping(value="/auth-pres", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Prestador prestador) throws ServletException{
		
		if (prestador.getEmail() == null || prestador.getSenha() == null){
			throw new ServletException("Email e senha obrigatório.");
		}
		
		//Consulta no banco
		Prestador presAutenticado = loginPrestadorService.buscarPorEmail(prestador.getEmail());
		
		if (presAutenticado==null){
			throw new ServletException("Cliente não encontrado.");
		}
		
		if (!presAutenticado.getSenha().equals(prestador.getSenha())){
			throw new ServletException("Usuário ou senha inválido.");
		}
		
		String token=  Jwts.builder()
				.setSubject(presAutenticado.getEmail())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();
		
		
		return	new LoginResponse(token, presAutenticado);
	}		
	
	private class LoginResponse{
		public String token;
		public Prestador pres;
		 
		public LoginResponse(String token, Prestador pres){
			this.token = token; 
			this.pres = pres;
		 }
		
	}
}
