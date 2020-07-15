package br.comau.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "clientejuridica")
public class ClienteJuridica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "cliente_juridica_sequence";

    @Id
    long id;
    String razaoSocial;
    String nomeFantasia;
    @CNPJ String cnpj;
    TipoCliente tipo;
    String endereco;
    String telefone;
    String email;
    String obs;
    String status;
    String logo;

}
