package br.comau.repository;


import br.comau.model.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerfilRepository extends MongoRepository<Perfil, Long> {
}
