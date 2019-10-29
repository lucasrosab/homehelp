package com.homehelp.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelp.services.model.Prestador;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

}
