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
@Document(collection = "clientejuridica")
public class ClienteJuridica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "cliente_juridica_sequence";

    @Id
    private long id;
    public  String razaoSocial;
    public  String nomeFantasia;
    public  String cnpj;
    public  String tipo;
    public  String endereco;
    public  String telefone;
    public  String email;
    public  String obs;
    public  String status;
    public  String logo;

    public ClienteJuridica() {
    }

    public ClienteJuridica(long id, String razaoSocial,
                           String nomeFantasia, String cnpj, String tipo,
                           String telefone, String email, String obs, String status,
                           String endereco
    ) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.obs = obs;
        this.status = status;
        this.logo = logo;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
