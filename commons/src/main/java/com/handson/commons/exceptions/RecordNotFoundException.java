package com.handson.commons.exceptions;

public class RecordNotFoundException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(ConstantsCodError code, Integer param) {
		super(code, param);
	}
	
	public RecordNotFoundException(ConstantsCodError code, String... params) {
		super(code, params);
	}

	public RecordNotFoundException(String code, String message) {
		super(code, message);
	}
}