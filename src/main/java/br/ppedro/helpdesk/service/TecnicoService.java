package br.ppedro.helpdesk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.repository.TecnicoRepository;
import br.ppedro.helpdesk.service.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	
	public Tecnico findById (Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado com id:" + id));
	}
	
	
	public List<Tecnico> findAll(){
		return tecnicoRepository.findAll();
		
	}
}
