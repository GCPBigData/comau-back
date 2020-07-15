package br.comau.model;

import lombok.*;
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
@Document(collection = "projeto")
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "projeto_sequence";

    @Id
    private long id;
    String nomeProjeto;
    String descricao;
    String obs;
    String clienteFisica;
    String clienteJuridica;
    String Status;
}
