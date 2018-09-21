package com.handson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.model.Artistas;

@Repository
public interface ArtistasRepository extends JpaRepository<Artistas, String> {

}
