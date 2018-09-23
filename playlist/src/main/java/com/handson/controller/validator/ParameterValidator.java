package com.handson.controller.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.handson.commons.exceptions.ConstantsCodError;
import com.handson.commons.exceptions.RecordNotFoundException;
import com.handson.model.entities.Musica;
import com.handson.repository.MusicaRepository;
import com.handson.repository.PlaylistRepository;

@Component
public class ParameterValidator {

	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private MusicaRepository musicaRepository;
	
	public void validate(String playlistId, String musicaId) throws RecordNotFoundException {
		if(musicaId == null || musicaRepository.findOne(musicaId) == null) {
			throw new RecordNotFoundException(ConstantsCodError.REGISTRO_NAO_ENCONTRADO, "música", musicaId);
		} 
		
		if(playlistId == null || playlistRepository.findOne(playlistId) == null) {
			throw new RecordNotFoundException(ConstantsCodError.REGISTRO_NAO_ENCONTRADO, "playlist", playlistId);
		}
	}
	
	public void validate(String playlistId, List<Musica> musicas) throws RecordNotFoundException {
		if(musicas != null) {
			for(Musica m : musicas) {
				validate(playlistId, m.getId());
			}
		} else {
			throw new RecordNotFoundException(ConstantsCodError.REGISTRO_NAO_ENCONTRADO, "música", null);
		}
	}
}
