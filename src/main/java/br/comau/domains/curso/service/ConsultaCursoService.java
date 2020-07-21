package br.comau.domains.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.curso.model.Curso;
import br.comau.domains.curso.repository.CursoRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class ConsultaCursoService {

	@Autowired
    private CursoRepository cursoRepository;
	
	public List<Curso> getAll() {
		return this.cursoRepository.findAll();
	}
	
	public Curso getById(long id) throws ResourceNotFoundException {
		return this.cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DO CURSO" + id));
	}
	
}
