package com.tcdNetflix.filmeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcdNetflix.filmeservice.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	List<Filme> findAllByNomeContaining(String nome);
		
	@Query(value = "SELECT f FROM Filme f JOIN FilmeGenero d ON f.id = d.idFilme where d.idGenero = :id")
	List<Filme> findAllFilmeQuery(int id);

	List<Filme> findByIdIn(List<Integer> ids);

	@Query(value = "SELECT f.* FROM filme f JOIN filme_genero d ON f.id = d.id_filme where d.id_genero = :id ORDER BY f.visto DESC LIMIT 5", nativeQuery = true)
	List<Filme> findAllFilmeOrderByDescQuery(int id);
}
