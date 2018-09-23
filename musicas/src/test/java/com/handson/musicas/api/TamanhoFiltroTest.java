package com.handson.musicas.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.handson.Application;
import com.handson.commons.exceptions.BusinessException;
import com.handson.validator.TamanhoFiltroValidator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TamanhoFiltroTest {
	
	@Autowired
	private TamanhoFiltroValidator tamanhoFiltroValidator;
	
	@Test(expected = BusinessException.class)
    public void tamanhoInformadoMenorQueTamanhoMinimo() throws BusinessException{
        int tamanho = 3;
        String parametro = "Br";

        tamanhoFiltroValidator.validate(parametro, tamanho);
    }
	
	@Test
    public void tamanhoInformadoValido() throws BusinessException{
        int tamanho = 3;
        String parametro = "24K Magic";

        tamanhoFiltroValidator.validate(parametro, tamanho);
    }
}
