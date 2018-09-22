package com.handson.commons.dto;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Representa o objeto que deve ser retornado por todos os servicos REST
 */
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Object data;

    private List<ApplicationErrorDTO> error;

    public ResponseDTO() {
        // do nothing
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }

    public ResponseDTO(ApplicationErrorDTO error) {
        this.error = Arrays.asList(error);
    }

    public ResponseDTO(List<ApplicationErrorDTO> error) {
        this.error = error;
    }

    public ResponseDTO(Object data, ApplicationErrorDTO error) {
        this.data = data;
        this.error = Arrays.asList(error);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ApplicationErrorDTO> getError() {
        return error;
    }

    public void setError(List<ApplicationErrorDTO> error) {
        this.error = error;
    }

}