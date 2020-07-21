package br.comau.domains.cliente.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class RemoveClienteJuridicaService {
	
	@Autowired
	private ClienteJuridicaRepository clienteJuridicaRepository;
	
	public Map<String, Boolean> deleteClienteJuridica(long id) throws ResourceNotFoundException {
		ClienteJuridica clienteJuridica = this.clienteJuridicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID clientejuridica " + id));

        this.clienteJuridicaRepository.delete(clienteJuridica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("clientejuridica", Boolean.TRUE);
        return response;
	}

}
