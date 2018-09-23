package com.handson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.model.entities.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {

}
