package br.com.homehelp.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.model.Administrador;
import br.com.homehelp.model.Prestador;
import br.com.homehelp.service.LoginAdministradorService;
import br.com.homehelp.service.LoginPrestadorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginAdminController {

	@Autowired
	private LoginAdministradorService loginAdministradorService;
	
	@RequestMapping(value="/auth-adm", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Administrador administrador) throws ServletException{
		
		if (administrador.getEmail() == null || administrador.getSenha() == null){
			throw new ServletException("Email e senha obrigatório.");
		}
		
		//Consulta no banco
		Administrador admAutenticado = loginAdministradorService.buscarPorEmail(administrador.getEmail());
		
		if (admAutenticado==null){
			throw new ServletException("Cliente não encontrado.");
		}
		
		if (!admAutenticado.getSenha().equals(administrador.getSenha())){
			throw new ServletException("Usuário ou senha inválido.");
		}
		
		String token=  Jwts.builder()
				.setSubject(admAutenticado.getEmail())
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
