package br.comau.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.comau.domains.cliente.model.TipoCliente;

public interface TipoClienteRepository extends MongoRepository<TipoCliente, Long> {
}
