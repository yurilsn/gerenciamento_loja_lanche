package com.gerenciamento.loja.gerenciamento_loja.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Estabelecimento {
    LOJA("LOJA"),
    LANCHE("LANCHE");

    private String codigo;

    private Estabelecimento(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    @JsonCreator
    public static Estabelecimento doValor(String codigo){
        for(Estabelecimento estabelecimento : Estabelecimento.values()){
            if(estabelecimento.getCodigo().equals(codigo.toUpperCase())){
                return estabelecimento;
            }
        }
        throw new IllegalArgumentException("Ta errado o enum paizão");
    }
}
