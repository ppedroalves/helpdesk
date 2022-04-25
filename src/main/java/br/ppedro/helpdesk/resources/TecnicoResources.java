package br.ppedro.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ppedro.helpdesk.model.Tecnico;
import br.ppedro.helpdesk.service.TecnicoService;

@RestController
@RequestMapping( value = "/tecnicos")
public class TecnicoResources {
	
	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
		Tecnico obj = tecnicoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
