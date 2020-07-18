package br.comau.domains.cliente.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.repository.ClienteFisicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class RemoveClienteFisicaService {

	@Autowired
	private ClienteFisicaRepository clienteFisicaRepository;

	public Map<String, Boolean> deleteClienteFisica(long id) throws ResourceNotFoundException {
		ClienteFisica clienteFisica = this.clienteFisicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID clientefisica " + id));

		clienteFisicaRepository.delete(clienteFisica);
		Map<String, Boolean> response = new HashMap<>();
		response.put("clientefisica", Boolean.TRUE);
		return response;
	}

}
