package com.tcdNetflix.filmeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcdNetflix.filmeservice.service.GeneroService;

@RestController
@RequestMapping(value = "/v1/generoservice")

public class GeneroController {
	@Autowired
	private GeneroService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> List() {
		return ResponseEntity.ok(service.getGeneros());
	}
}
