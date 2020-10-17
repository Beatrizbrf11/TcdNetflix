package com.tcdNetflix.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcdNetflix.usuarioservice.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
