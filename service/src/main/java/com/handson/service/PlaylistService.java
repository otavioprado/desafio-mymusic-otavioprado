package com.handson.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.handson.commons.exceptions.BaseException;
import com.handson.model.entities.Musica;
import com.handson.model.entities.Playlist;

@Validated
public interface PlaylistService {

    List<Playlist> listarPlaylists(String filtroUsuario);
    
    void adicionarNovaMusica(String playlistId, Musica musica) throws BaseException;
    
    void removerMusica(String playlistId, String musicaId) throws BaseException;

}
