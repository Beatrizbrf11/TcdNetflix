package com.tcdNetflix.filmeusuarioservice.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeUsuarioVO {

	@JsonProperty("idUsuario")
	private int idUsuario;

	@JsonProperty("idFilme")
	private int idFilme;
		
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
		this.idFilme= idFilme;
	}
}
