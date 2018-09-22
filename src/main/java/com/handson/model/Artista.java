package com.handson.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.handson.model.serializer.MusicasListSerializer;

@Entity
@Table(name = "artistas")
public class Artista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artista", fetch = FetchType.EAGER, targetEntity = Musicas.class)
	@JsonSerialize(using = MusicasListSerializer.class)
	private List<Musicas> musicas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Musicas> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musicas> musicas) {
		this.musicas = musicas;
	}
}
