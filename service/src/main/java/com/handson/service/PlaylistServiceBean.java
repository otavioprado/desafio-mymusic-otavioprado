package com.handson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.model.entities.Playlist;
import com.handson.repository.PlaylistRepository;

@Service
public class PlaylistServiceBean implements PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	@Override
	public List<Playlist> listarPlaylists() {
		return playlistRepository.findAll();
	}
	
}
