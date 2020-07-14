package br.comau.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@Document(collection = "clientefisica")
public class ClienteFisica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "cliente_fisica_sequence";

    @Id
    private long id;
    public  String nome;
    public  String cpf;
    public  TipoCliente tipo;
    public  String endereco;
    public  String telefone;
    public  String email;
    public  String status;
    public  String empresa;
    public  Perfil perfil;

    /*
@JsonFormat(pattern="dd/MM/yyyy HH:mm")
@Temporal(TemporalType.TIMESTAMP)
@Temporal(TemporalType.DATE)
@JsonFormat(shape = JsonFormat.Shape.STRING,
       pattern = "dd/MM/yyyy HH:mm:ss",
       locale = "pt-BR",
       timezone = "Brazil/East")
@JsonDeserialize(using = JsonDateDeserializer.class)
@JsonSerialize(using = JsonDateSerializer.class)
@JsonFormat(pattern="dd/MM/yyyy")*/
    public  String vistoDataVencimento;

    public ClienteFisica() {
    }

    /*public ClienteFisica() {
        addPerfil(Perfil.CLIENTE);
    }*/

    public ClienteFisica(long id, String nome, String cpf,
                         TipoCliente tipo, String endereco, String telefone,
                         String email, String status, String empresa,
                         String vistoDataVencimento, Perfil perfil
                         ) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.empresa = empresa;
        this.vistoDataVencimento = vistoDataVencimento;
        this.perfil = perfil;

    }

    /*public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /*public Date getVistoDataVencimento() {
        return vistoDataVencimento;
    }

    public void setVistoDataVencimento(Date vistoDataVencimento) {
        this.vistoDataVencimento = vistoDataVencimento;
    }*/

    public String getVistoDataVencimento() {
        return vistoDataVencimento;
    }

    public void setVistoDataVencimento(String vistoDataVencimento) {
        this.vistoDataVencimento = vistoDataVencimento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /* @PrePersist
    public void prePersist() {
        final Date atual = new Date();
    }*/

    @Override
    public String toString() {

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return "Código: " +
                getId() +

                //builder.append(", Data: ");
                //builder.append(sdf.format(getVistoDataVencimento()));

                ", Cliente: " +
                getNome();
}
}