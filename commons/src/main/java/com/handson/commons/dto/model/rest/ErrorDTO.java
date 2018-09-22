package com.handson.commons.dto.model.rest;

public class ErrorDTO {

	private String code;

	private String message;

	private String field;

	private String action;

	public ErrorDTO() {
	}

	public ErrorDTO(String code, String message, String field, String action) {
		this.code = code;
		this.message = message;
		this.field = field;
		this.action = action;
	}

	public ErrorDTO(String code, String message, String field) {
		this.code = code;
		this.message = message;
		this.field = field;
	}

	public ErrorDTO(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "ErrorDTO [code=" + code + ", message=" + message + ", field=" + field + ", action=" + action + "]";
	}

}