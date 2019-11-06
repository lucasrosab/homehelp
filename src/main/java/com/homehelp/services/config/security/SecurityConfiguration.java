package com.homehelp.services.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
    //Método de configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService);		
	}
	
	//Método de configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/servicos").permitAll() //Permite qualquer requisição get pra esse endereço
		.antMatchers(HttpMethod.GET,"/servicos/*").permitAll()//Permite qualquer requisição get pra esse endereço
		.antMatchers("/cliente").permitAll()//Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/services").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/solicitacao").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/banco").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/cliente").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/bandeira").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		.antMatchers("/estado").permitAll() //Permite qualquer requisição, de qualquer verbo pra esse endereço
		/*.antMatchers("/*").permitAll()*/ // Essa parte tá comentada pq tá dando erro, por padrão não pode permitir acesso à tudo
		.anyRequest().authenticated() //Qualquer requisição para uma rota nao citada acima, deverá se logar
		.and().formLogin(); // Formulário de login		
	}
	
	//Método de configurações de rescursos estáticos, ex: css, js e imgs, etc
	@Override
	public void configure(WebSecurity web) {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
