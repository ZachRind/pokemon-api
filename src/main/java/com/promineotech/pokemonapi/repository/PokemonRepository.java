package com.promineotech.pokemonapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.pokemonapi.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}


