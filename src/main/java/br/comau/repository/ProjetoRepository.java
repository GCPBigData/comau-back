package br.comau.repository;

import br.comau.model.Projeto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjetoRepository extends MongoRepository<Projeto, Long> {
}
