package br.comau.domains.cliente.dto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import br.comau.domains.cliente.model.ClienteFisica;

import java.io.Serializable;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Getter
@Setter
@Document(collection = "clientefisicaDTO")
public class ClienteFisicaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    Long id;
    String nome;
    String cpf;
    String telefone;
    String email;

    public ClienteFisicaDTO(){

    }

    public ClienteFisicaDTO(ClienteFisica objClienteFisica){
        id = objClienteFisica.getId();
        nome = objClienteFisica.getNome();
        cpf = objClienteFisica.getCpf();
        telefone = objClienteFisica.getTelefone();
        email = objClienteFisica.getEmail();
    }

}
