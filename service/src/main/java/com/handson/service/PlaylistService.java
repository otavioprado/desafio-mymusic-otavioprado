package com.handson.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.handson.model.entities.Playlist;

@Validated
public interface PlaylistService {

    List<Playlist> listarPlaylists();

}
