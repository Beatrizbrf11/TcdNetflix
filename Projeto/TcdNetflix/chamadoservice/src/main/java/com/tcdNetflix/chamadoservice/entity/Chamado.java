package com.tcdNetflix.chamadoservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "chamado")
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("id_usuario")
	private int idUsuario;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("status_chamado")
	private int statusChamado;
	
	public Chamado() {}
	
	public Chamado(int idUsuario, String titulo, String descricao, int statusChamado) {
		super();
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.statusChamado = statusChamado;
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

	public int getStatus() {
		return statusChamado;
	}

	public void setStatus(int statusChamado) {
		this.statusChamado = statusChamado;
	}
}
