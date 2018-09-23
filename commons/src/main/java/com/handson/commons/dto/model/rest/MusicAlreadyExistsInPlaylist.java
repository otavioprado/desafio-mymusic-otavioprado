package com.handson.commons.dto.model.rest;

import com.handson.commons.exceptions.BusinessException;

public class MusicAlreadyExistsInPlaylist extends BusinessException {
	
	private static final String HANDSON_ERROR_003 = "HO-003";

	public MusicAlreadyExistsInPlaylist(String mensagem) {
		super(HANDSON_ERROR_003, mensagem);
	}

	private static final long serialVersionUID = 1L;

}
