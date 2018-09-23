package com.handson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.model.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, String> {

	@Query(value = "SELECT m FROM Musica m JOIN m.artista a WHERE lower(a.nome) LIKE lower(concat('%', :nomeArtista,'%')) ORDER BY a.nome, m.nome") 
    public List<Musica> findAllByArtistName(@Param("nomeArtista") String filterName);
	
}
