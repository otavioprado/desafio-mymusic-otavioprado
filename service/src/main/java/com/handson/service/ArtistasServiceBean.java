package com.handson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.model.entities.Artista;
import com.handson.repository.ArtistasRepository;

@Service
public class ArtistasServiceBean implements ArtistasService {

	@Autowired
	private ArtistasRepository artistasRepository;

	public List<Artista> listarArtistas() {
		return artistasRepository.findAll();
	}

}
