package com.handson.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist_musicas")
public class PlaylistMusicas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "playlist_musicas_id")
	private Playlist playList;
	
	@ManyToOne
    @JoinColumn(name = "musica_id")
	private Musica musica;

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Playlist getPlayList() {
		return playList;
	}

	public void setPlayList(Playlist playList) {
		this.playList = playList;
	}
}
