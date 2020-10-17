package com.tcdNetflix.usuarioservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcdNetflix.usuarioservice.entity.Usuario;
import com.tcdNetflix.usuarioservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario getUsuario(int idUsuario) {
		return repository.findById(idUsuario).get();
	}
}
