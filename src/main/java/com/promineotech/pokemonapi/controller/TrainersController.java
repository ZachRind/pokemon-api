package com.promineotech.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonapi.entity.Trainers;
import com.promineotech.pokemonapi.service.TrainersService;

@RestController
@RequestMapping("/trainers")
public class TrainersController {
	
	@Autowired
	private TrainersService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createTrainer(@RequestBody Trainers trainer) {
		return new ResponseEntity<Object>(service.createTrainer(trainer), HttpStatus.CREATED);
	}
	
	
	
	
}