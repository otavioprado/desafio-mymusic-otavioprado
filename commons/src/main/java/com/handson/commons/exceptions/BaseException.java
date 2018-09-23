package com.handson.commons.exceptions;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	protected final String code;
	protected final Object[] params;

	public BaseException(ConstantsCodError code, String... params) {
		this.code = code.getCode();
		this.params = params;
	}

	public BaseException(ConstantsCodError code, Integer param) {
		this.code = code.getCode();
		this.params = Arrays.asList(param).toArray();
	}

	public BaseException(String code, String message) {
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
