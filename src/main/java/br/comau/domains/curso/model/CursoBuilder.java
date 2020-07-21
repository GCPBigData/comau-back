package br.comau.domains.curso.model;

import java.time.LocalDateTime;

public class CursoBuilder {

	private long id;
	private String nomeCurso;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private String descricao;
	private String fornecedor;
	private String status;
	

	public CursoBuilder() {}

	public CursoBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public CursoBuilder setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
		return this;
	}

	public CursoBuilder setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
		return this;
	}

	
	public CursoBuilder setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
		return this;
	}

	public CursoBuilder setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public CursoBuilder setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
		return this;
	}

	public CursoBuilder setStatus(String status) {
		this.status = status;
		return this;
	}

	public Curso constroi() {
		Curso curso = new Curso();
		curso.setId(id);
		curso.setNomeCurso(nomeCurso);
		curso.setDataInicio(dataInicio);
		curso.setDataFim(dataFim);
		curso.setDescricao(descricao);
		curso.setFornecedor(fornecedor);
		curso.setStatus(status);
		
		return curso;
	}

}
