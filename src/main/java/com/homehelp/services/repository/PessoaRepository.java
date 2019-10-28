package com.homehelp.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByNome(String pessoa); 

}
