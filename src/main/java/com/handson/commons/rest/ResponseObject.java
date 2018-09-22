package com.handson.commons.rest;

public class ResponseObject<T> {

	public static class ResponseError {

		private String code;
		private String description;

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

	}

	private T data;
	private ResponseError error;

	public T getData() {
		return data;
	}

	public ResponseError getError() {
		return error;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}
}