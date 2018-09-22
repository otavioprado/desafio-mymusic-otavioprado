package com.handson.exceptions;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    protected final String code;
    protected final Object[] params;

    public BusinessException(ConstantsCodError code, String... params) {
        this.code = code.getCode();
        this.params = params;
    }

    public BusinessException(ConstantsCodError code, Integer param) {
        this.code = code.getCode();
        this.params = Arrays.asList(param).toArray();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        params = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }

    public String getCode() {
        return code;
    }

    public Object[] getParams() {
        return params;
    }
}