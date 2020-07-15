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
@Document(collection = "curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String SEQUENCE_NAME = "curso_sequence";

    @Id
    long id;
    String nomeCurso;
    String descricao;
    String fornecedor;
    String dataInicio;
    String dataFim;
    String status;

}
