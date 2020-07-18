package br.comau.domains.cliente.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */
@Document(collection = "tipocliente")
public enum TipoCliente {

        PESSOAFISICA(1, "Pessoa Física"),
        PESSOAJURIDICA(2, "Pessoa Jurídica");

        private int cod;
        private String descricao;

        TipoCliente(int cod, String descricao) {
            this.cod = cod;
            this.descricao = descricao;
        }

        public int getCod() {
            return cod;
        }

        public String getDescricao () {
            return descricao;
        }

        public static TipoCliente toEnum(Integer cod) {

            if (cod == null) {
                return null;
            }

            for (TipoCliente x : TipoCliente.values()) {
                if (cod.equals(x.getCod())) {
                    return x;
                }
            }

            throw new IllegalArgumentException("Id inválido: " + cod);
        }

    @Override
    public String toString() {
        return descricao;
    }
}