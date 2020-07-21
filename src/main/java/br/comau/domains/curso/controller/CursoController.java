package br.comau.domains.curso.controller;

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

import br.comau.domains.curso.model.Curso;
import br.comau.domains.curso.service.AlteraCursoService;
import br.comau.domains.curso.service.ConsultaCursoService;
import br.comau.domains.curso.service.RemoveCursoService;
import br.comau.domains.curso.service.SalvaCursoService;
import br.comau.exception.ResourceNotFoundException;

/**
 * @author Herick N Marques
 * herick.marques@gmail.com
 * Pocos de Caldas - Brazil 12/07/2020
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "curso")
public class CursoController {

    @Autowired
    private ConsultaCursoService consultaCursoService;
    
    @Autowired
    private SalvaCursoService salvaCursoService;
    
    @Autowired
    private AlteraCursoService alteraCursoService;
    
    @Autowired
    private RemoveCursoService removeCursoService;

    

    @GetMapping()
    public List<Curso> getAllCursos() {
        return this.consultaCursoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
       return ResponseEntity.ok().body(this.consultaCursoService.getById(id));
    }

    @PostMapping()
    public Curso createCurso(@RequestBody Curso curso) {
        return this.salvaCursoService.saveCurso(curso);
    }

    @PutMapping()
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.alteraCursoService.updateCurso(curso));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCurso(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return this.removeCursoService.deleteCurso(id);
    }

}
