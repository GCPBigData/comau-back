package br.comau.dto;
import br.comau.model.ClienteFisica;

import java.io.Serializable;

public class ClienteFisicaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public ClienteFisicaDTO(){

    }

    public ClienteFisicaDTO(ClienteFisica objClienteFisica){
        id = objClienteFisica.getId();
        nome = objClienteFisica.getNome();
        cpf = objClienteFisica.getCpf();
        telefone = objClienteFisica.getTelefone();
        email = objClienteFisica.getEmail();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
