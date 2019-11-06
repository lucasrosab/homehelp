package com.homehelp.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Cliente;

public interface ClienteAutenticacaoRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByEmail(String email);
}
