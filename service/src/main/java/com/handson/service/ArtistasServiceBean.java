package com.handson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.model.entities.Artista;
import com.handson.repository.ArtistaRepository;

@Service
public class ArtistasServiceBean implements ArtistaService {

	@Autowired
	private ArtistaRepository artistasRepository;

	public List<Artista> listarArtistas() {
		return artistasRepository.findAll();
	}

}
