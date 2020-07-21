package br.comau.domains.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.curso.model.Curso;
import br.comau.domains.curso.repository.CursoRepository;
import br.comau.service.SequenceGeneratorService;

@Service
public class SalvaCursoService {
	
	@Autowired
    private CursoRepository cursoRepository;
	
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
	
	public Curso saveCurso(Curso curso) {
		curso.setId(this.sequenceGeneratorService.generateSequence(Curso.SEQUENCE_NAME));
		return this.cursoRepository.save(curso);
	}

}
