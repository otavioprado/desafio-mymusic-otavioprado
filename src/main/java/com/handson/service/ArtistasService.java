package com.handson.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.handson.model.Artista;

@Validated
public interface ArtistasService {

    List<Artista> listarArtistas();

}
