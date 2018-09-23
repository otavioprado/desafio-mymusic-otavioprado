package com.handson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.model.entities.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {
	
	@Query(value = "SELECT p FROM Playlist p JOIN p.usuario u WHERE lower(p.usuario.nome) LIKE lower(concat('%', :username,'%'))")
    public List<Playlist> findAllByUsername(@Param("username") String username);
}
