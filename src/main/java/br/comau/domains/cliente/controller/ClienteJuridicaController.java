package br.comau.domains.cliente.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.exception.ResourceNotFoundException;
import br.comau.service.SequenceGeneratorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/clientejuridica")
public class ClienteJuridicaController {

    @Autowired
    private ClienteJuridicaRepository clienteJuridicaRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<ClienteJuridica> getAllClienteJuridica() {
        return clienteJuridicaRepository.findAll();
    }

    @GetMapping("/clientejuridica/{id}")
    public ResponseEntity<ClienteJuridica> getClienteJuridicaById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ClienteJuridica clienteJuridica = clienteJuridicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DA CLIENTE JURIDIDCA" + id));
        return ResponseEntity.ok().body(clienteJuridica);
    }

    @PostMapping("/clientejuridica/post")
    public ClienteJuridica createCleinteJuridica(@RequestBody ClienteJuridica clienteJuridica) {
        clienteJuridica.setId(sequenceGeneratorService.generateSequence(ClienteJuridica.SEQUENCE_NAME));
        return clienteJuridicaRepository.save(clienteJuridica);
    }

    @PutMapping("/clientejuridica/{id}")
    public ResponseEntity<ClienteJuridica> updateClienteJuridica(
            @PathVariable(value = "id") Long id,
            @RequestBody ClienteJuridica clienteJuridica) throws ResourceNotFoundException {

        ClienteJuridica clienteJuridicaObj = clienteJuridicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O ClienteJuridica :: " + id));

        clienteJuridica.setId(clienteJuridica.getId());
        clienteJuridica.setRazaoSocial(clienteJuridica.getRazaoSocial());
        clienteJuridica.setNomeFantasia(clienteJuridica.getNomeFantasia());
        clienteJuridica.setTipo(clienteJuridica.getTipo());
        clienteJuridica.setCnpj(clienteJuridica.getCnpj());
        clienteJuridica.setEndereco(clienteJuridica.getEndereco());
        clienteJuridica.setTelefone(clienteJuridica.getTelefone());
        clienteJuridica.setObs(clienteJuridica.getObs());
        clienteJuridica.setStatus(clienteJuridica.getStatus());
        clienteJuridica.setLogo(clienteJuridica.getLogo());

        final ClienteJuridica updatedClienteJuridica = clienteJuridicaRepository.save(clienteJuridica);
        return ResponseEntity.ok(clienteJuridica);
    }

    @DeleteMapping("/clientejuridica/{id}")
    public Map<String, Boolean> deleteClienteJuridica(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        ClienteJuridica clienteJuridica = clienteJuridicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID clientejuridica " + id));

        clienteJuridicaRepository.delete(clienteJuridica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("clientejuridica", Boolean.TRUE);
        return response;
    }
}