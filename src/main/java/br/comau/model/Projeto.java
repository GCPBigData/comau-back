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
@Document(collection = "projeto")
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "projeto_sequence";

    @Id
    private long id;
    public  String nomeProjeto;
    public  String descricao;
    public  String obs;
    public  String clienteFisica;
    public  String clienteJuridica;
    public  String Status;

    public Projeto() {
    }

    public Projeto(long id, String nomeProjeto, String descricao, String obs, String clienteFisica, String clienteJuridica, String status) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.obs = obs;
        this.clienteFisica = clienteFisica;
        this.clienteJuridica = clienteJuridica;
        Status = status;
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

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getClienteFisica() {
        return clienteFisica;
    }

    public void setClienteFisica(String clienteFisica) {
        this.clienteFisica = clienteFisica;
    }

    public String getClienteJuridica() {
        return clienteJuridica;
    }

    public void setClienteJuridica(String clienteJuridica) {
        this.clienteJuridica = clienteJuridica;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
