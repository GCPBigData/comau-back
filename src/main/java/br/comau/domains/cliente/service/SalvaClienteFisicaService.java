package br.comau.domains.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.repository.ClienteFisicaRepository;
import br.comau.service.SequenceGeneratorService;

@Service
public class SalvaClienteFisicaService {
	
	@Autowired
	private ClienteFisicaRepository clienteFisicaRepository;
	
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
	
	public ClienteFisica saveClienteFisica(ClienteFisica clienteFisica) {
		clienteFisica.setId(this.sequenceGeneratorService.generateSequence(ClienteFisica.SEQUENCE_NAME));
        return clienteFisicaRepository.save(clienteFisica);
	}

}
