package br.comau.domains.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comau.domains.curso.model.Curso;
import br.comau.domains.curso.model.CursoBuilder;
import br.comau.domains.curso.repository.CursoRepository;
import br.comau.exception.ResourceNotFoundException;

@Service
public class AlteraCursoService {
	
	@Autowired
    private CursoRepository cursoRepository;
	
	public Curso updateCurso(Curso curso) throws ResourceNotFoundException {
		this.cursoRepository.findById(curso.getId())
	                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O CURSO :: " + curso.getId()));
			
		Curso cursoUpdate = new CursoBuilder()
	        .setId(curso.getId())
	        .setNomeCurso(curso.getNomeCurso())
	        .setDataInicio(curso.getDataInicio())
	        .setDataFim(curso.getDataFim())
	        .setDescricao(curso.getDescricao())
	        .setFornecedor(curso.getFornecedor())
	        .setStatus(curso.getStatus())
	        .constroi();
		
		return this.cursoRepository.save(cursoUpdate);
	}

}
