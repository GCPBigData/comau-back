package br.comau.repository;


import br.comau.model.TipoCliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoClienteRepository extends MongoRepository<TipoCliente, Long> {
}
