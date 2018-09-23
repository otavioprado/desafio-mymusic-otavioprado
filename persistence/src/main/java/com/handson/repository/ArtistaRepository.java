package com.handson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.model.entities.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, String> {

}
