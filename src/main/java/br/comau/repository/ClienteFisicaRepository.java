package br.comau.repository;

import br.comau.model.ClienteFisica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteFisicaRepository extends MongoRepository<ClienteFisica, Long> {

   ClienteFisica findByNome(String nome);

}
