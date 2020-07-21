package br.comau.domains.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class ConsultaClienteJuridicaService {

	@Autowired
	private ClienteJuridicaRepository clienteJuridicaRepository;

	public List<ClienteJuridica> getAll() {
		return this.clienteJuridicaRepository.findAll();
	}

	public ClienteJuridica getById(long id) throws ResourceNotFoundException {
		return this.clienteJuridicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DA CLIENTE JURIDIDCA" + id));
	}
}
