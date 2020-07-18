package br.comau.domains.cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.comau.domains.cliente.model.ClienteFisica;

@Repository
public interface ClienteFisicaRepository extends MongoRepository<ClienteFisica, Long> {

   ClienteFisica findByNome(String nome);

}
