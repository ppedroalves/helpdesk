package br.ppedro.helpdesk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ppedro.helpdesk.model.Chamado;
import br.ppedro.helpdesk.repository.ChamadoRepository;
import br.ppedro.helpdesk.service.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    
    public Chamado findById(Integer id) {
    	Optional<Chamado> obj = chamadoRepository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! ID: " + id));
    }
    
    
    public List<Chamado> findAll(){
    	return chamadoRepository.findAll();
    }
}
