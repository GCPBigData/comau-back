package br.comau.repository;

import br.comau.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, Long> {
}
