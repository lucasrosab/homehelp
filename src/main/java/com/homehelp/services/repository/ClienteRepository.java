package com.homehelp.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
