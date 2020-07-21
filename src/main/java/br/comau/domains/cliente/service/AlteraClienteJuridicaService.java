package br.comau.domains.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.model.ClienteJuridicaBuilder;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class AlteraClienteJuridicaService {

	@Autowired
	private ClienteJuridicaRepository clienteJuridicaRepository;
	
	public ClienteJuridica updateClienteJuridica(ClienteJuridica clienteJuridica) throws ResourceNotFoundException {
	
		this.clienteJuridicaRepository.findById(clienteJuridica.getId())
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O ClienteJuridica :: " + clienteJuridica.getId()));
		
		ClienteJuridica clienteJuridicaUpdate = new ClienteJuridicaBuilder()
			.setId(clienteJuridica.getId())
	        .setRazaoSocial(clienteJuridica.getRazaoSocial())
	        .setNomeFantasia(clienteJuridica.getNomeFantasia())
	        .setTipo(clienteJuridica.getTipo())
	        .setCnpj(clienteJuridica.getCnpj())
	        .setEndereco(clienteJuridica.getEndereco())
	        .setTelefone(clienteJuridica.getTelefone())
	        .setObs(clienteJuridica.getObs())
	        .setStatus(clienteJuridica.getStatus())
	        .setLogo(clienteJuridica.getLogo())
	        .constroi();
		
		return this.clienteJuridicaRepository.save(clienteJuridicaUpdate);
	}
}
