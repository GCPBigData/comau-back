package br.comau.domains.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.comau.domains.curso.model.Curso;

public interface CursoRepository extends MongoRepository<Curso, Long> {
}
