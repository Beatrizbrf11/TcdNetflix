package com.tcdNetflix.filmeusuarioservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "filme_usuario")
public class FilmeUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id;

	@JsonProperty("id_usuario")
	private int idUsuario;

	@JsonProperty("id_filme")
	private int idFilme;

	@JsonProperty("favorito")
	private boolean favorito;

	@JsonProperty("ja_visto")
	private boolean jaVisto;

	@JsonProperty("ver_depois")
	private boolean verDepois;

	public FilmeUsuario() { }
	
	public FilmeUsuario(int idUsuario, int idFilme, boolean favorito, boolean jaVisto, boolean verDepois) {
		super();
		this.idUsuario = idUsuario;
		this.idFilme = idFilme;
		this.favorito = favorito;
		this.jaVisto = jaVisto;
		this.verDepois = verDepois;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public boolean getJaVisto() {
		return jaVisto;
	}

	public void setJaVisto(boolean jaVisto) {
		this.jaVisto = jaVisto;
	}

	public boolean getVerDepois() {
		return verDepois;
	}

	public void setVerDepois(boolean verDepois) {
		this.verDepois = verDepois;
	}
}