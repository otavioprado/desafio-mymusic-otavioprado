package com.handson.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.handson.commons.exceptions.BaseException;
import com.handson.commons.exceptions.BusinessException;
import com.handson.commons.exceptions.ConstantsCodError;
import com.handson.commons.exceptions.RecordNotFoundException;
import com.handson.model.entities.Musica;
import com.handson.model.entities.Playlist;
import com.handson.repository.MusicaRepository;
import com.handson.repository.PlaylistRepository;

@Service
public class PlaylistServiceBean implements PlaylistService {

	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private MusicaRepository musicaRepository;

	@Override
	public List<Playlist> listarPlaylists(String filtroUsuario) {

		if (StringUtils.isBlank(filtroUsuario)) {
			return playlistRepository.findAll();
		}

		return playlistRepository.findAllByUsername(filtroUsuario);
	}

	@Override
	public void adicionar(String playlistId, List<Musica> musicas) throws BaseException {
		Playlist playlist = playlistRepository.findOne(playlistId);

		List<Musica> playlistMusicas = playlist.getMusicas();

		if (playlistMusicas != null && !Collections.disjoint(playlistMusicas, musicas)) {
			Musica musicaNaPlaylist = CollectionUtils.findFirstMatch(musicas, playlistMusicas);
			throw new BusinessException(ConstantsCodError.PLAYLIST_JA_TEM_ESSA_MUSICA, playlistId, musicaNaPlaylist.getId());
		}
		
		playlistMusicas.addAll(musicas);
		
		try {
			playlistRepository.save(playlist);
		} catch (EntityNotFoundException | JpaObjectRetrievalFailureException ex) {
			throw new BusinessException(ConstantsCodError.MUSICA_NAO_ENCONTRADA);
		}
	}

	@Override
	public void removerMusica(String playlistId, String musicaId) throws BaseException {
		Playlist playlist = playlistRepository.findOne(playlistId);
		Musica musicaToBeRemoved = musicaRepository.findOne(musicaId);
		
		if(playlist == null) {
			throw new RecordNotFoundException(ConstantsCodError.REGISTRO_NAO_ENCONTRADO, "playlist", playlistId);
		} else if(musicaToBeRemoved == null) {
			throw new RecordNotFoundException(ConstantsCodError.REGISTRO_NAO_ENCONTRADO, "música", musicaId);
		}
		
		List<Musica> musicas = playlist.getMusicas();
		musicas.remove(musicaToBeRemoved);
		
		playlistRepository.save(playlist);
	}

}
