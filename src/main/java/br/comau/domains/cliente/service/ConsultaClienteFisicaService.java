package br.comau.domains.cliente.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.dto.ClienteFisicaDTO;
import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.repository.ClienteFisicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class ConsultaClienteFisicaService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private ClienteFisicaRepository clienteFisicaRepository;

	public List<ClienteFisica> getAll() {
		return this.clienteFisicaRepository.findAll();
	}

	public ClienteFisica getById(long id) throws ResourceNotFoundException {
		return this.clienteFisicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DA CLIENTE FISICA" + id));

	}

	public List<ClienteFisicaDTO> getAllFilter() {
		List<ClienteFisica> list = this.clienteFisicaRepository.findAll();
		return list.parallelStream().sorted(Comparator.comparing(ClienteFisica::getId).reversed())
				.map(ClienteFisicaDTO::new).limit(10).collect(Collectors.toList());

	}

	public List<ClienteFisicaDTO> getAllFilterAtivo() {
		List<ClienteFisica> list = this.clienteFisicaRepository.findAll();
		return list.parallelStream().sorted(Comparator.comparing(ClienteFisica::getId).reversed())
				.filter(p -> p.getStatus().equals("Ativo")).map(ClienteFisicaDTO::new).limit(10)
				.collect(Collectors.toList());

	}

	public List<ClienteFisica> getAllClienteCriteria(String crit) {
		Query query = new Query();
		query.addCriteria(
				new Criteria().orOperator(Criteria.where("nome").regex(crit), Criteria.where("cpf").regex(crit),
						Criteria.where("email").regex(crit), Criteria.where("telefone").regex(crit),
						Criteria.where("empresa").regex(crit), Criteria.where("status").regex(crit)));
		return mongoTemplate.find(query, ClienteFisica.class);

	}

}
