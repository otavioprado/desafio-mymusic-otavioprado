package com.handson.commons.dto.model.rest;

import com.handson.commons.exceptions.BusinessException;

public class InvalidFilterSizeException extends BusinessException {
	
	private static final String HANDSON_ERROR_002 = "HO-002";

	public InvalidFilterSizeException(String mensagem) {
		super(HANDSON_ERROR_002, mensagem);
	}

	private static final long serialVersionUID = 1L;

}
