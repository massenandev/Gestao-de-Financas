package br.com.massenan.gestaodefinancas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.massenan.gestaodefinancas.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	@Query("SELECT c FROM Contato c WHERE c.id = ?1 AND c.ativo = ?2")
	Contato findById(Long id, boolean active);

}
