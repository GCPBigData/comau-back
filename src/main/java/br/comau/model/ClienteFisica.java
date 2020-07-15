package br.comau.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "clientefisica")
public class ClienteFisica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "cliente_fisica_sequence";

    @Id
    long id;
    String nome;
    @CPF String cpf;
    String endereco;
    String telefone;
    @Email String email;
    String status;
    String empresa;
    List<Perfil> perfils;
    List<TipoCliente> tipoClientes;
    String dataCadastro;
    String vistoDataVencimento;

    //LocalDateTime dataCadastro = LocalDateTime.now();
    //LocalDateTime vistoDataVencimento = LocalDateTime.now().plusMonths(3); //adiciona mais 3 meses


}