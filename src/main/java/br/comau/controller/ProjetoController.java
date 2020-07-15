package br.comau.controller;

import br.comau.exception.ResourceNotFoundException;
import br.comau.model.Projeto;
import br.comau.repository.ProjetoRepository;
import br.comau.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Herick N Marques
 * herick.marques@gmail.com
 * Pocos de Caldas - Brazil 12/07/2020
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/projeto")
public class ProjetoController {

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

    @GetMapping("/projetos/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DO PROJETO" + id));
        return ResponseEntity.ok().body(projeto);
    }

    @PostMapping("/projeto/post")
    public Projeto createProjeto(@RequestBody Projeto projeto) {
        projeto.setId(sequenceGeneratorService.generateSequence(Projeto.SEQUENCE_NAME));
        return projetoRepository.save(projeto);
    }

    @PutMapping("/projeto/{id}")
    public ResponseEntity<Projeto> updateProjeto(
            @PathVariable(value = "id") Long id,
            @RequestBody Projeto projeto) throws ResourceNotFoundException {

        Projeto projetoObj = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O PROJETO :: " + id));

        projeto.setId(projeto.getId());
        projeto.setNomeProjeto(projeto.getNomeProjeto());
        projeto.setDescricao(projeto.getDescricao());
        projeto.setObs(projeto.getObs());
        projeto.setClienteFisica(projeto.getClienteFisica());
        projeto.setClienteJuridica(projeto.getClienteJuridica());
        projeto.setStatus(projeto.getStatus());

        final Projeto updatedProjeto = projetoRepository.save(projeto);
        return ResponseEntity.ok(projeto);
    }

    @DeleteMapping("/projeto/{id}")
    public Map<String, Boolean> deleteProjeto(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID Projeto " + id));

        projetoRepository.delete(projeto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("projeto", Boolean.TRUE);
        return response;
    }
}
