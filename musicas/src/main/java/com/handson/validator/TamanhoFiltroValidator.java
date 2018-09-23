package com.handson.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.handson.commons.exceptions.BusinessException;
import com.handson.commons.exceptions.ConstantsCodError;

@Component
public class TamanhoFiltroValidator {
	
	public static final int TAMANHO_MINIMO_DO_FILTRO_DEFAULT = 3;

	public void validate(String filtro, int tamanhoMinimo) throws BusinessException {
		if (StringUtils.length(filtro) < TAMANHO_MINIMO_DO_FILTRO_DEFAULT) {
			throw new BusinessException(ConstantsCodError.TAMANHO_INVALIDO, TAMANHO_MINIMO_DO_FILTRO_DEFAULT);
		}
	}
}
