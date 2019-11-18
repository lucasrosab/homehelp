package br.com.homehelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.homehelp.model.Administrador;

@Repository
public interface AdministradorRespository extends JpaRepository<Administrador, Integer>{

	@Query(value="Select u from Administrador u where u.email=:pemail and u.status_conta = true")
	public Administrador buscarPorEmail(@Param("pemail") String email); 
}
