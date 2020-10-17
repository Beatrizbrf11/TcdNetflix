package com.tcdNetflix.usuarioservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("sobrenome")
	private String sobrenome;

	public Usuario() {
	}

	public Usuario(int id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
