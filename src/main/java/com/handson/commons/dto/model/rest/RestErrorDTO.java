package com.handson.commons.dto.model.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um erro ocorrido em uma API REST.
 */
public class RestErrorDTO extends ErrorDTO {

	public RestErrorDTO() {
		super();
	}

	public RestErrorDTO(String code, String message, String field, String action) {
		super(code, message, field, action);
	}

	public RestErrorDTO(String code, String message, String field) {
		super(code, message, field);
	}

	public RestErrorDTO(String code, String message) {
		super(code, message);
	}
	
	public static RestErrorDTO fromErrorDTO(ErrorDTO ErrorDTO) {
		return new RestErrorDTO(ErrorDTO.getCode(), ErrorDTO.getMessage(), ErrorDTO.getField(),
				ErrorDTO.getAction());
	}

	public static List<RestErrorDTO> fromListErrorDTO(List<ErrorDTO> ErrorDTOs) {
		List<RestErrorDTO> restErrors = new ArrayList<>(ErrorDTOs.size());
		for (ErrorDTO errorDTO : ErrorDTOs) {
			restErrors.add(fromErrorDTO(errorDTO));
		}
		return restErrors;
	}
	
}