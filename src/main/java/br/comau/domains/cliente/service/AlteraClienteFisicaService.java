package br.comau.domains.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.model.ClienteFisicaBuilder;
import br.comau.domains.cliente.repository.ClienteFisicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class AlteraClienteFisicaService {

	@Autowired
    private ClienteFisicaRepository clienteFisicaRepository;

	public ClienteFisica updateClienteFisica(ClienteFisica clienteFisica) throws ResourceNotFoundException {

		this.clienteFisicaRepository.findById(clienteFisica.getId())
				.orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O ClienteFisica :: " + clienteFisica.getId()));

		ClienteFisica clienteFisicaUpdate = new ClienteFisicaBuilder()
				.setId(clienteFisica.getId())
				.setNome(clienteFisica.getNome())
				.setCpf(clienteFisica.getCpf())
				.setTipoClienteFisica(clienteFisica.getTipoClienteFisica())
				.setEndereco(clienteFisica.getEndereco())
				.setTelefone(clienteFisica.getTelefone())
				.setEmail(clienteFisica.getEmail())
				.setStatus(clienteFisica.getStatus())
				.setEmpresa(clienteFisica.getEmpresa())
				.setVistoDataVencimento(clienteFisica.getVistoDataVencimento())
				.constroi();
		
		return this.clienteFisicaRepository.save(clienteFisicaUpdate);
	}
}
