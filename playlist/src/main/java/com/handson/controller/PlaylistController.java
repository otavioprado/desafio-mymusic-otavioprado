package com.handson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.commons.dto.model.rest.RestReturnDTO;
import com.handson.model.entities.Playlist;
import com.handson.service.PlaylistService;

@RestController
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	@GetMapping(value = "/playlists")
	public RestReturnDTO listArtistas() {
		List<Playlist> playlists = playlistService.listarPlaylists();
		
		return new RestReturnDTO(playlists);
	}
}
