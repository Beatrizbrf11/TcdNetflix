package com.tcdNetflix.filmeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tcdNetflix.filmeservice.entity.Filme;
import com.tcdNetflix.filmeservice.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	public Filme getFilmePorId(int id) {
		try {
			return repository.findById(id).get();
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao buscar um filme: " + ex.getMessage());
		}
	}

	public List<Filme> getFilmeByNome(String nome) {
		List<Filme> filmes = repository.findAllByNomeContaining(nome);
		return filmes;
	}

	@HystrixCommand(fallbackMethod = "buildFallbackFilmeGeneroByIdGenero", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "12") })
	public List<Filme> getFilmeGeneroByIdGenero(int idGenero) {
		List<Filme> filmes = repository.findAllFilmeQuery(idGenero);
		return filmes;
	}
	
	public List<Filme> buildFallbackFilmeGeneroByIdGenero(int idGenero) {
		List<Filme> filmes = new ArrayList<Filme>();
		Filme filme = new Filme();
		
		switch(idGenero) {
		  case 2:
		  case 4:
		  case 10:
				filme.setNome("Inimigos Públicos");
				filme.setDescricao("2009 ");
				filmes.add(filme);
		    break;
		  case 13:
				filme.setNome("O Mágico de Oz");
				filme.setDescricao("1939 ");
				filmes.add(filme);
		    break;
		  default:
				filme.setNome("Cidadão Kane");
				filme.setDescricao("1941");
				filmes.add(filme);
		}
		
		return filmes;
	}
	
	public List<Filme> getFilmes(List<Integer> ids) {
		List<Filme> filmes = repository.findByIdIn(ids);
		return filmes;
	}

	public void getAtualizarFilmeVisto(int idFilme) {
		try {
			Filme filme = getFilmePorId(idFilme);
			filme.setVisto(filme.getVisto() + 1);
			repository.save(filme);
		} catch (Exception ex) {
			throw new RuntimeException("Erro ao marcar filme como visto: " + ex.getMessage());
		}
	}

	public List<Filme> getFilmeGeneroMaisVistosByIdGenero(int idGenero) {
		List<Filme> filmes = repository.findAllFilmeOrderByDescQuery(idGenero);
		return filmes;
	}
}
