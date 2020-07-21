package br.comau.domains.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.service.SequenceGeneratorService;

@Service
public class SalvaClienteJuridicaService {
	
	@Autowired
    private ClienteJuridicaRepository clienteJuridicaRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

	public ClienteJuridica saveClienteJuridica(ClienteJuridica clienteJuridica) {
		clienteJuridica.setId(this.sequenceGeneratorService.generateSequence(ClienteJuridica.SEQUENCE_NAME));
        return this.clienteJuridicaRepository.save(clienteJuridica);
	}
	
}
