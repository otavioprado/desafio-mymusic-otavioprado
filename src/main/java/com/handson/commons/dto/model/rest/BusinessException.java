package com.handson.commons.dto.model.rest;
import org.apache.commons.lang3.StringUtils;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 35604564252035658L;

    private final String codigo;

    public BusinessException(String mensagem) {
        super(mensagem);
        codigo = StringUtils.EMPTY;
    }

    public BusinessException(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}