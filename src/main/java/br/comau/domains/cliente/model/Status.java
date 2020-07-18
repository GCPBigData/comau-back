package br.comau.domains.cliente.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Herick N Marques
 * herick.marques@gmail.com
 * Pocos de Caldas - Brazil 15/07/2020
 */

@Document(collection = "status")
public enum Status {

    ATIVO(1, "ATIVO"),
    INATIVO(2, "INATIVO");

    private int cod;
    private String descricao;

    Status(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao () {
        return descricao;
    }

    public static Status toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

    @Override
    public String toString() {
        return  descricao;
    }
}

