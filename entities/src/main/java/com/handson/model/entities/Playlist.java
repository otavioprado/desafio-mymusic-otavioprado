package com.handson.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlists")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "playlist_musicas_id")
	private List<PlaylistMusicas> playlistMusicas;
	
	@OneToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PlaylistMusicas> getPlaylistMusicas() {
		return playlistMusicas;
	}

	public void setPlaylistMusicas(List<PlaylistMusicas> playlistMusicas) {
		this.playlistMusicas = playlistMusicas;
	}
}
