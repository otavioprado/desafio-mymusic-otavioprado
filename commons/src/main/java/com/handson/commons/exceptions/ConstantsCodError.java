package com.handson.commons.exceptions;

public enum ConstantsCodError {
    ERRO_GENERICO("HANDSON-001"),
    TAMANHO_INVALIDO("HANDSON-002"),
    PLAYLIST_JA_TEM_ESSA_MUSICA("HANDSON-003"),
    MUSICA_NAO_ENCONTRADA("HANDSON-004");

    private String code;

    ConstantsCodError(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
