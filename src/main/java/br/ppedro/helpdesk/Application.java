package br.ppedro.helpdesk;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ppedro.helpdesk.model.Chamado;
import br.ppedro.helpdesk.model.Cliente;
import br.ppedro.helpdesk.model.Perfil;
import br.ppedro.helpdesk.model.Prioridade;
import br.ppedro.helpdesk.model.Status;
import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.repository.ChamadoRepository;
import br.ppedro.helpdesk.repository.ClienteRepository;
import br.ppedro.helpdesk.repository.TecnicoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info(">>>> Iniciando a execucao da aplicacao");
		SpringApplication.run(Application.class, args);
		logger.info(">>>> Aplicacao inicializada");
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Pedro", "07144179632", "pedro@email.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Rogerio", "06233345693", "nanci@email.com", "123456");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado01", "Primeiro Chamado", cli1, tec1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
	
	

}
