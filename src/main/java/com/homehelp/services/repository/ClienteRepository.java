package com.homehelp.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByNome(String codCliente);

	List<Cliente> findByEmailAndSenha(String email, String senha);
}
