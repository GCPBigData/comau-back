package br.comau.repository;

import br.comau.model.ClienteFisica;
import br.comau.model.ClienteJuridica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJuridicaRepository extends MongoRepository<ClienteJuridica, Long> {

   ClienteFisica findByNomeFantasia(String nomeFantasia);

}
