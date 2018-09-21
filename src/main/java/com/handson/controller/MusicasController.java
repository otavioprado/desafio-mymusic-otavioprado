package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.model.Musicas;
import com.handson.service.MusicaService;

@RestController
@RequestMapping("/api")
public class MusicasController {

	@Autowired
	private MusicaService musicaService;

	@GetMapping(value = "/musicas")
	public List<Musicas> listMusicas(@RequestParam(value = "filtro", required = false) String filtro) {
		return musicaService.listarMusicas(filtro);
	}
}
