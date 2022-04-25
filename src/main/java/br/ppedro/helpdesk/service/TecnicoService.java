package br.ppedro.helpdesk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.repository.TecnicoRepository;

@Service
public class TecnicoService {
	
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	
	public Tecnico findById (Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElse(null);
	}
}
