package br.ppedro.helpdesk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ppedro.helpdesk.model.Chamado;
import br.ppedro.helpdesk.model.Cliente;
import br.ppedro.helpdesk.model.Perfil;
import br.ppedro.helpdesk.model.Prioridade;
import br.ppedro.helpdesk.model.Status;
import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.repository.ChamadoRepository;
import br.ppedro.helpdesk.repository.ClienteRepository;
import br.ppedro.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Pedro", "07144179632", "pedro@email.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Rogerio", "06233345693", "nanci@email.com", "123456");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado01", "Primeiro Chamado", cli1, tec1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
