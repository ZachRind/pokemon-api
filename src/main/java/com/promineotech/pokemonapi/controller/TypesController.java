package com.promineotech.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonapi.entity.Types;
import com.promineotech.pokemonapi.service.TypesService;

@RestController
@RequestMapping("/types")
public class TypesController {

	@Autowired
	private TypesService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createType(@RequestBody Types type) {
		return new ResponseEntity<Object>(service.createType(type), HttpStatus.CREATED);
	}

}
