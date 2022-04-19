package br.ppedro.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ppedro.helpdesk.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
