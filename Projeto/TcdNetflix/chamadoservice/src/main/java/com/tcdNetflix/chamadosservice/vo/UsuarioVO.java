package com.tcdNetflix.chamadosservice.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioVO {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("sobrenome")
	private String sobrenome;

	public UsuarioVO(int id, String nome, String sobrenome) {
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
