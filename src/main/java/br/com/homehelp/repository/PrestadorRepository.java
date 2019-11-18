package br.com.homehelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.homehelp.model.Prestador;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Integer>{

	@Query(value="Select u from Prestador u where u.email=:pemail and u.status_conta = true")
	public Prestador buscarPorEmail(@Param("pemail") String email);
}
