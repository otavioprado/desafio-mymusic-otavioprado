package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.model.Artistas;
import com.handson.service.ArtistasService;

@RestController
@RequestMapping("/api")
public class ArtistasController {

	@Autowired
	private ArtistasService artistasService;

	@GetMapping(value = "/artistas")
	public List<Artistas> listArtistas() {
		return artistasService.listarArtistas();
	}
}
