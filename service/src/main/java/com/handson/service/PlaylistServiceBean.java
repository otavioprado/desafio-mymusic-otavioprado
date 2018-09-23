package com.handson.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.handson.commons.exceptions.BusinessException;
import com.handson.commons.exceptions.ConstantsCodError;
import com.handson.model.entities.Musica;
import com.handson.model.entities.Playlist;
import com.handson.repository.PlaylistRepository;

@Service
public class PlaylistServiceBean implements PlaylistService {

	@Autowired
	private PlaylistRepository playlistRepository;

	@Override
	public List<Playlist> listarPlaylists(String filtroUsuario) {

		if (StringUtils.isBlank(filtroUsuario)) {
			return playlistRepository.findAll();
		}

		return playlistRepository.findAllByUsername(filtroUsuario);
	}

	@Override
	public void adicionarNovaMusica(String playlistId, Musica musica) throws Exception {
		Playlist playlist = playlistRepository.findOne(playlistId);

		List<Musica> musicas = playlist.getMusicas();

		if (musicas != null && musicas.contains(musica)) {
			throw new BusinessException(ConstantsCodError.PLAYLIST_JA_TEM_ESSA_MUSICA, musica.getNome(),
					playlist.getUsuario().getNome());
		}

		musicas.add(musica);

		try {
			playlistRepository.save(playlist);
		} catch (EntityNotFoundException | JpaObjectRetrievalFailureException ex) {
			throw new BusinessException(ConstantsCodError.MUSICA_NAO_ENCONTRADA);
		}
	}

}
