package br.com.homehelp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homehelp.api.model.Prestador;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

	Prestador findByNome(String codPrestador);

}
