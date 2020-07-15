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
@Document(collection = "recurso")
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "recurso_sequence";

    @Id
    long id;
    String nomeRecurso;
    String funcao;
    String curso;
    String pessoFisicaResponsavel; // reponsavel
    String pessoFisicaEstrangeiro; // pode ser um estrangeiro com visto / Não seria então TIPO?
    String pessoaJuridica;
    String projeto;
    String status;

}
