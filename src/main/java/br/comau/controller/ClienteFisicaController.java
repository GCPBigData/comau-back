package br.comau.controller;

import java.util.*;
import java.util.stream.Collectors;

import br.comau.dto.ClienteFisicaDTO;
import br.comau.model.ClienteFisica;
import br.comau.repository.ClienteFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.comau.exception.ResourceNotFoundException;
import br.comau.service.SequenceGeneratorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listaFiltro", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteFisicaDTO>> findAll(){
        List<ClienteFisica> list = clienteFisicaRepository.findAll();
        List<ClienteFisicaDTO> listDto = list.parallelStream()
                .sorted(Comparator.comparing(ClienteFisica::getId).reversed())
                .filter(p -> p.getStatus().equals("Ativo"))
                .map(ClienteFisicaDTO::new)
                .limit(10)
                .collect(Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listaFiltroAtivo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteFisicaDTO>> findAllAtivo(){
        List<ClienteFisica> list = clienteFisicaRepository.findAll();
        List<ClienteFisicaDTO> listDto = list.parallelStream()
                .sorted(Comparator.comparing(ClienteFisica::getId).reversed())
                .filter(p -> p.getStatus().equals("Ativo"))
                .map(ClienteFisicaDTO::new)
                .limit(10)
                .collect(Collectors.toList());
        HttpStatus status = list != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.ok().body(listDto);
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

        clienteFisicaRepository.save(clienteFisica);
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
    /*
     *    https://www.baeldung.com/queries-in-spring-data-mongodb
     *    https://www.journaldev.com/18156/spring-boot-mongodb
     */
    @GetMapping("/listaFiltroFull/{criteria}")
    public List<ClienteFisica> getAllClienteCriteria(@PathVariable(value = "criteria") String crit)
    {
        Query query = new Query();
        query.addCriteria(
                new Criteria().orOperator(
                        Criteria.where("nome").regex(crit),
                        Criteria.where("cpf").regex(crit),
                        Criteria.where("email").regex(crit),
                        Criteria.where("telefone").regex(crit),
                        Criteria.where("empresa").regex(crit),
                        Criteria.where("status").regex(crit)
                )
        );
        return mongoTemplate.find(query, ClienteFisica.class);
    }

}