package br.comau.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;

}
