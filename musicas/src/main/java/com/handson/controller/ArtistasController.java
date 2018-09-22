package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.commons.dto.model.rest.RestReturnDTO;
import com.handson.model.Artista;
import com.handson.service.ArtistasService;

@RestController
@RequestMapping("/api")
public class ArtistasController {

	@Autowired
	private ArtistasService artistasService;

	@GetMapping(value = "/artistas")
	public RestReturnDTO listArtistas() {
		List<Artista> artistas = artistasService.listarArtistas();
		
		return new RestReturnDTO(artistas);
	}
}
