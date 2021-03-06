package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.commons.dto.model.rest.RestReturnDTO;
import com.handson.controller.validator.ParameterValidator;
import com.handson.model.entities.Musica;
import com.handson.model.entities.Playlist;
import com.handson.service.PlaylistService;

@RestController
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@Autowired
	private ParameterValidator parameterValidator;
	
	@GetMapping(value = "/playlists")
	public RestReturnDTO listar(@RequestParam(value = "user", required = false) String filtroUsuario) {
		List<Playlist> playlists = playlistService.listarPlaylists(filtroUsuario);
		
		return new RestReturnDTO(playlists);
	}
	
	@PutMapping(value = "/playlists/{playlistId}/musicas")
	public ResponseEntity<Musica> incluir(@PathVariable String playlistId, @RequestBody List<Musica> musicas) throws Exception {
		parameterValidator.validate(playlistId, musicas);
		playlistService.adicionar(playlistId, musicas);
		
		return new ResponseEntity<Musica>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/playlists/{playlistId}/musicas/{musicaId}")
	public ResponseEntity<Musica> deletar(@PathVariable String playlistId, @PathVariable String musicaId) throws Exception {
		parameterValidator.validate(playlistId, musicaId);
		playlistService.removerMusica(playlistId, musicaId);
		
		return new ResponseEntity<Musica>(HttpStatus.OK);
	}
}
