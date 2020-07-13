package br.comau.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@Document(collection = "recurso")
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "recurso_sequence";

    @Id
    private long id;
    private String nomeRecurso;
    private String funcao;
    private String curso;
    private String pessoFisicaResponsavel; // reponsavel
    private String pessoFisicaEstrangeiro; // pode ser um estrangeiro com visto
    private String pessoaJuridica;
    private String projeto;
    private String status;

    public Recurso() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPessoFisicaResponsavel() {
        return pessoFisicaResponsavel;
    }

    public void setPessoFisicaResponsavel(String pessoFisicaResponsavel) {
        this.pessoFisicaResponsavel = pessoFisicaResponsavel;
    }

    public String getPessoFisicaEstrangeiro() {
        return pessoFisicaEstrangeiro;
    }

    public void setPessoFisicaEstrangeiro(String pessoFisicaEstrangeiro) {
        this.pessoFisicaEstrangeiro = pessoFisicaEstrangeiro;
    }

    public String getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(String pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
