package br.ppedro.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ppedro.helpdesk.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
