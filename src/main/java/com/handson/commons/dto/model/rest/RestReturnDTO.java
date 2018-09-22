package com.handson.commons.dto.model.rest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Representa um retorno de uma API REST, seguindo a padronização para a
 * estrutura do response body.
 */
public class RestReturnDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object data;

	private List<RestErrorDTO> error;

	public RestReturnDTO() {
	}

	public RestReturnDTO(Object data) {
		this.data = data;
	}

	/**
	 * Constrói um {@code RestReturnDTO} contendo uma lista de erros.
	 *
	 */
	public static RestReturnDTO withErrors(List<RestErrorDTO> errors) {
		RestReturnDTO restReturn = new RestReturnDTO();
		restReturn.setError(errors);
		return restReturn;
	}

	/**
	 * Constrói um {@code RestReturnDTO} contendo um único erro.
	 */
	public static RestReturnDTO withError(RestErrorDTO error) {
		return withErrors(Arrays.asList(error));
	}

	/**
	 * O conteúdo de fato da response, no caso de não ter havido erro no
	 * processamento da requisição.
	 */
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * A lista de erros ocorridos no processamento da requisição.
	 */
	public List<RestErrorDTO> getError() {
		return error;
	}

	public void setError(List<RestErrorDTO> error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RestReturnDTO [data=" + data + ", error=" + error + "]";
	}

}