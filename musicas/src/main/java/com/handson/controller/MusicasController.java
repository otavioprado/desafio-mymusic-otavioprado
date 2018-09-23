package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.commons.exceptions.BusinessException;
import com.handson.commons.rest.ResponseBuilder;
import com.handson.commons.rest.ResponseObject;
import com.handson.model.entities.Musica;
import com.handson.service.MusicaService;
import com.handson.validator.TamanhoFiltroValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class MusicasController {

	@Autowired
	private MusicaService musicaService;
	
	@Autowired
	private TamanhoFiltroValidator tamanhoFiltroValidator;

	@GetMapping(value = "/musicas")
	@ApiOperation(value = "Consulta as informações das músicas cadastradas, filtrando por nome do artista.", httpMethod = "GET", response = ResponseObject.class)
	public ResponseObject<List<Musica>> listMusicas(
			@ApiParam(value = "Nome da música ou do artista (requer mais de 3 caracteres)") @RequestParam(value = "filtro", required = false) String filtro)
			throws BusinessException {

		tamanhoFiltroValidator.validate(filtro, TamanhoFiltroValidator.TAMANHO_MINIMO_DO_FILTRO_DEFAULT);

		List<Musica> musicas = musicaService.listarMusicas(filtro);

		return new ResponseBuilder<List<Musica>>().withData(musicas).build();
	}
}
