package com.gerenciamento.loja.gerenciamento_loja.domain.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoMovimentacao {
    SAIDA("SAIDA"),
    ENTRADA("ENTRADA");

    private String codigo;

    private TipoMovimentacao(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonCreator
    public static TipoMovimentacao doValor(String codigo){
        for(TipoMovimentacao tipoMovimentacao : TipoMovimentacao.values()){
            if(tipoMovimentacao.getCodigo().equals(codigo.toUpperCase())){
                return tipoMovimentacao;
            }
        }
        throw new IllegalArgumentException("Ta errado o enum paizão");
    }
}
