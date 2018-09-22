package com.handson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.model.Artista;

@Repository
public interface ArtistasRepository extends JpaRepository<Artista, String> {

}