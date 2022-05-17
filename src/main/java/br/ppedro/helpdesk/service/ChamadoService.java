package br.ppedro.helpdesk.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ppedro.helpdesk.model.Chamado;
import br.ppedro.helpdesk.model.Cliente;
import br.ppedro.helpdesk.model.Prioridade;
import br.ppedro.helpdesk.model.Status;
import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.model.dtos.ChamadoDTO;
import br.ppedro.helpdesk.repository.ChamadoRepository;
import br.ppedro.helpdesk.service.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    
    @Autowired
    private TecnicoService tecnicoService;
    
    
    @Autowired
    private ClienteService clienteService;
    
    public Chamado findById(Integer id) {
    	Optional<Chamado> obj = chamadoRepository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! ID: " + id));
    }
    
    
    public List<Chamado> findAll(){
    	return chamadoRepository.findAll();
    }


	public Chamado create(@Valid ChamadoDTO objDTO) {
		return chamadoRepository.save(newChamado(objDTO));
	}
	
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)){
			chamado.setDataFechamento(LocalDate.now());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
		
	}


	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return chamadoRepository.save(oldObj);
	}
}
