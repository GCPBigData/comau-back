package br.comau.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.comau.model.ClienteFisica;
import br.comau.repository.ClienteFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

import br.comau.exception.ResourceNotFoundException;
import br.comau.service.SequenceGeneratorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/clientefisica")
public class ClienteFisicaController {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private ClienteFisicaRepository clienteFisicaRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<ClienteFisica> getAllClienteFisica() {
        return clienteFisicaRepository.findAll();
    }

    @GetMapping("/clientefisica/{id}")
    public ResponseEntity<ClienteFisica> getClienteFisicaById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ClienteFisica clienteFisica = clienteFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DA CLIENTE FISICA" + id));
        return ResponseEntity.ok().body(clienteFisica);
    }

    @PostMapping("/clientefisica/post")
    public ClienteFisica createClienteFisica(@RequestBody ClienteFisica clienteFisica) {
        clienteFisica.setId(sequenceGeneratorService.generateSequence(ClienteFisica.SEQUENCE_NAME));
        return clienteFisicaRepository.save(clienteFisica);
    }

    @PutMapping("/clientefisica/{id}")
    public ResponseEntity<ClienteFisica> updateClienteFisica(
            @PathVariable(value = "id") Long id,
            @RequestBody ClienteFisica clienteFisica) throws ResourceNotFoundException {

        ClienteFisica clienteFisicaObj = clienteFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O ClienteFisica :: " + id));

        clienteFisica.setId(clienteFisica.getId());
        clienteFisica.setNome(clienteFisica.getNome());
        clienteFisica.setCpf(clienteFisica.getCpf());
        clienteFisica.setTipo(clienteFisica.getTipo());
        clienteFisica.setEndereco(clienteFisica.getEndereco());
        clienteFisica.setTelefone(clienteFisica.getTelefone());
        clienteFisica.setEmail(clienteFisica.getEmail());
        clienteFisica.setStatus(clienteFisica.getStatus());
        clienteFisica.setEmpresa(clienteFisica.getEmpresa());
        clienteFisica.setVistoDataVencimento(clienteFisica.getVistoDataVencimento());

        final ClienteFisica updatedClienteFisica = clienteFisicaRepository.save(clienteFisica);
        return ResponseEntity.ok(clienteFisica);
    }

    @DeleteMapping("/clientefisica/{id}")
    public Map<String, Boolean> deleteClienteFisica(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        ClienteFisica clienteFisica = clienteFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID clientefisica " + id));

        clienteFisicaRepository.delete(clienteFisica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("clientefisica", Boolean.TRUE);
        return response;
    }

    @GetMapping("/teste/{criteria}")
    public List<ClienteFisica> getAllClienteCriteria(@PathVariable(value = "criteria") String crit)
    {
        Query query = new Query();
        query.addCriteria(
                new Criteria().orOperator(
                        Criteria.where("nome").regex(crit),
                        Criteria.where("cpf").regex(crit)
                )
        );
        return mongoTemplate.find(query, ClienteFisica.class);
    }

}