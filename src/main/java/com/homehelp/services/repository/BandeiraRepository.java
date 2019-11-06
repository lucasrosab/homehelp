package com.homehelp.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Bandeira;

public interface BandeiraRepository extends JpaRepository<Bandeira, Long>{

	List<Bandeira> findByNome(String pessoa);

}
