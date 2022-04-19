package br.ppedro.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ppedro.helpdesk.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
