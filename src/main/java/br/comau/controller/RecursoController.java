package br.comau.controller;

import br.comau.exception.ResourceNotFoundException;
import br.comau.model.Recurso;
import br.comau.repository.RecursoRepository;
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
@RequestMapping(value = "/api/v1/recurso")
public class RecursoController {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<Recurso> getAllRecursos() {
        return recursoRepository.findAll();
    }

    @GetMapping("/recursos/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DO RECURSO" + id));
        return ResponseEntity.ok().body(recurso);
    }

    @PostMapping("/recurso/post")
    public Recurso createRecurso(@RequestBody Recurso recurso) {
        recurso.setId(sequenceGeneratorService.generateSequence(Recurso.SEQUENCE_NAME));
        return recursoRepository.save(recurso);
    }

    @PutMapping("/recurso/{id}")
    public ResponseEntity<Recurso> updateRecurso(
            @PathVariable(value = "id") Long id,
            @RequestBody Recurso recurso) throws ResourceNotFoundException {

        Recurso recursoObj = recursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O RECURSO :: " + id));

        recurso.setId(recurso.getId());
        recurso.setNomeRecurso(recurso.getNomeRecurso());
        recurso.setCurso(recurso.getCurso());
        recurso.setFuncao(recurso.getFuncao());
        recurso.setProjeto(recurso.getProjeto());
        recurso.setStatus(recurso.getStatus());
        recurso.setPessoaJuridica(recurso.getPessoaJuridica());
        recurso.setPessoFisicaEstrangeiro(recurso.getPessoFisicaEstrangeiro());
        recurso.setPessoFisicaResponsavel(recurso.getPessoFisicaResponsavel());

        final Recurso updatedRecurso = recursoRepository.save(recurso);
        return ResponseEntity.ok(recurso);
    }

    @DeleteMapping("/recurso/{id}")
    public Map<String, Boolean> deleteRecurso(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID Recurso " + id));

        recursoRepository.delete(recurso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("recurso", Boolean.TRUE);
        return response;
    }
}
