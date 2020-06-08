package br.com.massenan.gestaodefinancas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.massenan.gestaodefinancas.dto.ContatoDto;
import br.com.massenan.gestaodefinancas.service.ContatoService;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	private static final Logger logger = LoggerFactory.getLogger(ContatoController.class);

	@GetMapping("/cadastros")	
	public String cadastros() {
		return "/contatos/cadastro";
	}
	
	@Autowired
	private ContatoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok().body(ContatoDto.parse(service.findAll()));
		} catch (Exception ex) {
//			pq tem esse logger de error só aqui
			logger.error("[CARREGANDO TODOS OS CONTATOS]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(ContatoDto.parse(service.findById(id).get()));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> create(@RequestBody ContatoDto contatoDto) {

		try {
			service.create(ContatoDto.parse(contatoDto));
			return new ResponseEntity<>(ContatoDto.parse(service.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ContatoDto contatoDto) {

		try {
			return ResponseEntity.ok().body(ContatoDto.parse(service.findAll()));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
