package br.com.homehelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.homehelp.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	@Query(value="Select u from Cliente u where u.email=:pemail and u.status_conta = true")
	public Cliente buscarPorEmail(@Param("pemail") String email);
}
