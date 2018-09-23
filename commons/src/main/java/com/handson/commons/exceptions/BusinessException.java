package com.handson.commons.exceptions;

public class BusinessException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(ConstantsCodError code, Integer param) {
		super(code, param);
	}
	
	public BusinessException(ConstantsCodError code, String... params) {
		super(code, params);
	}

	public BusinessException(String code, String message) {
		super(code, message);
	}
}