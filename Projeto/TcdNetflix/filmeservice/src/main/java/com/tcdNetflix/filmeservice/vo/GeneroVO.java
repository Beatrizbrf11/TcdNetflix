package com.tcdNetflix.filmeservice.vo;

import java.util.List;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcdNetflix.filmeservice.entity.Filme;

public class GeneroVO {
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;
	
	@OneToMany
	private List<Filme> filmes;
	
	public GeneroVO() {
	}

	public GeneroVO( String nome, String descricao) {
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
}
