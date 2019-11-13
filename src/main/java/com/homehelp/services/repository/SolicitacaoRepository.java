package com.homehelp.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homehelp.services.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

	@Query("SELECT h FROM Solicitacao h where h.cliente.id = :teste")
	List<Solicitacao> solicitacaoClienteHistorico(@Param("teste") Long id);

	List<Solicitacao> findByCliente_Id(Long idUser);

}
