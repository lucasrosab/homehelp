package com.homehelp.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long>{

	List<Banco> findByNome(String sNomeBanco);	
}
