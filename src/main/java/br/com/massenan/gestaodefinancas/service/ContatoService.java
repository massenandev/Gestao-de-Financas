package br.com.massenan.gestaodefinancas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.gestaodefinancas.domain.Contato;
import br.com.massenan.gestaodefinancas.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll() {
		return repository.findAll();
	}

	public void create(Contato contato) {
		repository.save(contato);
	}
	
	public Contato findById(Long id, boolean active) {
		return repository.findById(id, active);
	}
	
	public Optional<Contato> findById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Contato contato) {
		repository.saveAndFlush(contato);
	}
}
