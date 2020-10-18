package com.promineotech.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonapi.entity.Pokemon;
import com.promineotech.pokemonapi.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService service;
	
	@RequestMapping(value="/trainer/{trainerId}/{typesId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createTrainerPokemon(@RequestBody Pokemon pokemon, @PathVariable Long trainerId, @PathVariable Long typesId) {
		try {
			return new ResponseEntity<Object>(service.createTrainerPokemon(pokemon, trainerId, typesId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/gymLeader/{gymLeaderId}/{typesId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createGymLeaderPokemon(@RequestBody Pokemon pokemon, @PathVariable Long gymLeaderId, @PathVariable Long typesId) {
		try {
			return new ResponseEntity<Object>(service.createGymLeaderPokemon(pokemon, gymLeaderId, typesId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/{pokemonId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getPokemon(@PathVariable Long pokemonId) {
		return new ResponseEntity<Object>(service.getPokemon(pokemonId), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{pokemonId}", method=RequestMethod.PUT) //evolves Pokemon by updating breed
	public ResponseEntity<Object> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable Long pokemonId) {
		try {
			return new ResponseEntity<Object>(service.updatePokemon(pokemon, pokemonId), HttpStatus.OK);
			//return new ResponseEntity<Object>("Your " +  + )
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/{pokemonId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePokemon(@PathVariable long pokemonId) {
		service.deletePokemon(pokemonId);
		return new ResponseEntity<Object>("Pokemon with id number " + pokemonId + " has been released back into the wild.", HttpStatus.OK);
	}
	
}
