package com.tcdNetflix.filmeservice.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeVO {

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("visto")
	private int visto;

	public FilmeVO() {
	
	}

	public FilmeVO(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getVisto() {
		return visto;
	}

	public void setVisto(int visto) {
		this.visto = visto;
	}
}
