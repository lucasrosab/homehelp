package br.com.homehelp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homehelp.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByNome(String codCliente);

	List<Cliente> findByEmailAndSenha(String email, String senha);
}
