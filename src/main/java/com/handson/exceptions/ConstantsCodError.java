package com.handson.exceptions;

public enum ConstantsCodError {
    ERRO_GENERICO("HANDSON-001"),
    TAMANHO_INVALIDO("HANDSON-002");

    private String code;

    ConstantsCodError(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
