package br.comau.repository;

import br.comau.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoRepository extends MongoRepository<Recurso, Long> {
}
