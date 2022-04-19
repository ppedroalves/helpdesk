package br.ppedro.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ppedro.helpdesk.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
