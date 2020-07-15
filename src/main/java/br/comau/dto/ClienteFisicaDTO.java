package br.comau.dto;
import br.comau.model.ClienteFisica;

import java.io.Serializable;

public class ClienteFisicaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cnpj;

    public ClienteFisicaDTO(){

    }

    public ClienteFisicaDTO(ClienteFisica objClienteFisica){
        id = objClienteFisica.getId();
        nome = objClienteFisica.getNome();
        cnpj = objClienteFisica.getCnpj();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
