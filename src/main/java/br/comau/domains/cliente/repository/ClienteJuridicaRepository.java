package br.comau.domains.cliente.repository;

import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.model.ClienteJuridica;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJuridicaRepository extends MongoRepository<ClienteJuridica, Long> {

   ClienteJuridica findByNomeFantasia(String nomeFantasia);

}
