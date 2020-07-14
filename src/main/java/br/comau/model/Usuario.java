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
@Document(collection = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "usario_sequence";

    @Id
    private long id;
    private String login;
    private String senha;
    private Perfil perfil;
    private ClienteFisica pessoaFisica;
    private ClienteJuridica pessoaJuridica;
    private String Status;

    public Usuario() {
    }

    public Usuario(long id, String login, String senha, Perfil perfil, ClienteFisica pessoaFisica, ClienteJuridica pessoaJuridica, String status) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = pessoaJuridica;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ClienteFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(ClienteFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public ClienteJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(ClienteJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}