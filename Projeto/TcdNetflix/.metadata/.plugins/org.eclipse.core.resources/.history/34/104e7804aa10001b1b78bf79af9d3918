package com.tcdNetflix.chamadosservice.vo;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChamadoVO {
	@Id
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("idUsuario")
	private int idUsuario;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("descricao")
	private String descricao;
	
	public ChamadoVO() {}
	
	public ChamadoVO(int id, int idUsuario, String titulo, String descricao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.descricao = descricao;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
