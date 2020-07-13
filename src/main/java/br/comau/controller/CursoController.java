package br.comau.controller;

import br.comau.exception.ResourceNotFoundException;
import br.comau.model.Curso;
import br.comau.repository.CursoRepository;
import br.comau.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DO CURSO" + id));
        return ResponseEntity.ok().body(curso);
    }

    @PostMapping("/curso/post")
    public Curso createCurso(@RequestBody Curso curso) {
        curso.setId(sequenceGeneratorService.generateSequence(Curso.SEQUENCE_NAME));
        return cursoRepository.save(curso);
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> updateCurso(
            @PathVariable(value = "id") Long id,
            @RequestBody Curso curso) throws ResourceNotFoundException {

        Curso cursoObj = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O CURSO :: " + id));

        curso.setId(curso.getId());
        curso.setNomeCurso(curso.getNomeCurso());
        curso.setDataInicio(curso.getDataInicio());
        curso.setDataFim(curso.getDataFim());
        curso.setDescricao(curso.getDescricao());
        curso.setFornecedor(curso.getFornecedor());
        curso.setStatus(curso.getStatus());

        final Curso updatedCurso = cursoRepository.save(curso);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/curso/{id}")
    public Map<String, Boolean> deleteCurso(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID curso " + id));

        cursoRepository.delete(curso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("curso", Boolean.TRUE);
        return response;
    }

}
