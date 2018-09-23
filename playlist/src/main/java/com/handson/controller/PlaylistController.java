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
import com.handson.model.entities.Musica;
import com.handson.model.entities.Playlist;
import com.handson.service.PlaylistService;

@RestController
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping(value = "/playlists")
	public RestReturnDTO listArtistas(@RequestParam(value = "user", required = false) String filtroUsuario) {
		List<Playlist> playlists = playlistService.listarPlaylists(filtroUsuario);
		
		return new RestReturnDTO(playlists);
	}
	
	@PutMapping(value = "/playlists/{playlistId}/musicas")
	public ResponseEntity<Musica> listArtistas(@PathVariable String playlistId, @RequestBody Musica musica) throws Exception {
		
		playlistService.adicionarNovaMusica(playlistId, musica);
		
		return new ResponseEntity<Musica>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/playlists/{playlistId}/musicas/{musicaId}")
	public ResponseEntity<Musica> listArtistas(@PathVariable String playlistId, @PathVariable String musicaId) throws Exception {
		
		playlistService.removerMusica(playlistId, musicaId);
		
		return new ResponseEntity<Musica>(HttpStatus.OK);
	}
}
