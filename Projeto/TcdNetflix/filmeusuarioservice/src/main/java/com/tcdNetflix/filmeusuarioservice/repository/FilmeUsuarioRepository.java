package com.tcdNetflix.filmeusuarioservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcdNetflix.filmeusuarioservice.entity.FilmeUsuario;

public interface FilmeUsuarioRepository extends JpaRepository<FilmeUsuario, Integer> {


	FilmeUsuario findByIdUsuarioAndIdFilme(int idUsuario, int idFilme);

	List<FilmeUsuario> findAllByIdUsuarioAndFavoritoTrue(int IdUsuario);

	List<FilmeUsuario> findAllByIdUsuarioAndJaVistoTrue(int idUsuario);

	List<FilmeUsuario> findAllByIdUsuarioAndVerDepoisTrue(int idUsuario);
}
