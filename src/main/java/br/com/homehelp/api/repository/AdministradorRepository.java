package br.com.homehelp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homehelp.api.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
