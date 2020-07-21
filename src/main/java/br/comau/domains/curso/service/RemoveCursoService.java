package br.comau.domains.curso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.curso.model.Curso;
import br.comau.domains.curso.repository.CursoRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class RemoveCursoService {

	@Autowired
    private CursoRepository cursoRepository;
	
	public Map<String, Boolean> deleteCurso(long id) throws ResourceNotFoundException {
		Curso curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID curso " + id));

        this.cursoRepository.delete(curso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("curso", Boolean.TRUE);
        return response;
	}
	
}
