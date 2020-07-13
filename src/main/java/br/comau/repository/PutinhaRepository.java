package br.comau.repository;

import br.comau.model.Putinhas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PutinhaRepository extends MongoRepository<Putinhas, Long>{

}
