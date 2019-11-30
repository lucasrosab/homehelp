package br.com.homehelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.homehelp.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
