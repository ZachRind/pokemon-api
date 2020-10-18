package com.promineotech.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonapi.entity.GymLeaders;
import com.promineotech.pokemonapi.service.GymLeadersService;

@RestController
@RequestMapping("/gymLeaders")
public class GymLeadersController {

	@Autowired
	private GymLeadersService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGymLeader(@RequestBody GymLeaders gymLeader) {
		return new ResponseEntity<Object>(service.createGymLeader(gymLeader), HttpStatus.CREATED);
	}
}
