package com.handson.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.handson.model.entities.Artista;

@Validated
public interface ArtistaService {

    List<Artista> listarArtistas();

}
