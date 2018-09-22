package com.handson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.handson.model.Musicas;

@Repository
public interface MusicasRepository extends JpaRepository<Musicas, String> {

	@Query(value = "SELECT m FROM Musicas m JOIN m.artista") 
    public List<Musicas> findAll2();
	
}
