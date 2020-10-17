package com.tcdNetflix.chamadoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcdNetflix.chamadoservice.entity.Chamado;
import com.tcdNetflix.chamadoservice.service.ChamadoService;
import com.tcdNetflix.chamadosservice.vo.ChamadoVO;

@RestController
@RequestMapping(value = "/v1/chamadoservice")
public class ChamadoController {

	@Autowired
	private ChamadoService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> Listar() {
		List<Chamado> retorno = service.ListarChamados();
		return ResponseEntity.ok(retorno);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> Criar(@RequestBody ChamadoVO chamado) {
		Chamado retorno = service.CriarChamado(chamado);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
}
