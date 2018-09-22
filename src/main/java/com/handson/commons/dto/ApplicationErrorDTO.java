package com.handson.commons.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Estrutura que representa um erro da aplicação
 */
public class ApplicationErrorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;

	private String description;

	@JsonInclude(Include.NON_NULL)
	private String field;

	@JsonInclude(Include.NON_NULL)
	private Object rejectedValue;

	public ApplicationErrorDTO() {
		// do nothing
	}

	public ApplicationErrorDTO(String code) {
		this.code = code;
	}

	public ApplicationErrorDTO(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public ApplicationErrorDTO(String code, String defaultMessage, String field, Object rejectedValue) {
		this.code = code;
		description = defaultMessage;
		this.field = field;
		this.rejectedValue = rejectedValue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

}