package com.tcdNetflix.usuarioservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcdNetflix.usuarioservice.entity.Usuario;
import com.tcdNetflix.usuarioservice.service.UsuarioService;

@RestController
@RequestMapping(value = "/v1/usuarioservice")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable(name = "id") int id) {
		Usuario retorno = service.getUsuario(id);
		return ResponseEntity.ok(retorno);
	}
}
