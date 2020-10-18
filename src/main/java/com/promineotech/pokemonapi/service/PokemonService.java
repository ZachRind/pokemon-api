package com.promineotech.pokemonapi.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonapi.entity.GymLeaders;
import com.promineotech.pokemonapi.entity.Pokemon;
import com.promineotech.pokemonapi.entity.Trainers;
import com.promineotech.pokemonapi.entity.Types;
import com.promineotech.pokemonapi.repository.GymLeadersRepository;
import com.promineotech.pokemonapi.repository.PokemonRepository;
import com.promineotech.pokemonapi.repository.TrainersRepository;
import com.promineotech.pokemonapi.repository.TypesRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repo;
	
	@Autowired
	private TrainersRepository trainersRepo;
	
	@Autowired 
	private TypesRepository typesRepo;
	
	@Autowired
	private GymLeadersRepository gymLeaderRepo;
	
	public Pokemon createTrainerPokemon(Pokemon pokemon, Long trainerId, Long typesId) throws Exception {
		Trainers trainer = trainersRepo.findOne(trainerId);
		Types pType = typesRepo.findOne(typesId);
		if (trainer == null || pType == null ) {
			throw new Exception("Trainer or Type does not exist.");
		}
		Set<Types> pSetTypes = new HashSet<Types>();
		pSetTypes.add(pType);
		pokemon.setTrainerId(trainer);
		pokemon.setTypesId(pSetTypes);
		return repo.save(pokemon);	
	}
	
	public Pokemon createGymLeaderPokemon(Pokemon pokemon, Long gymLeaderId, Long typesId) throws Exception {
		GymLeaders gymLeader = gymLeaderRepo.findOne(gymLeaderId);
		Types pType = typesRepo.findOne(typesId);
		if (gymLeader == null || pType == null) {
			throw new Exception("Gym Leader or Type does not exist.");
		}
		Set<Types> pSetTypes = new HashSet<Types>();
		pSetTypes.add(pType);
		pokemon.setGymLeaderId(gymLeader);
		pokemon.setTypesId(pSetTypes);
		return repo.save(pokemon);	
	}
	
	
	public Pokemon getPokemon(Long id) {
		return repo.findOne(id);
	}
	
	public Pokemon updatePokemon(Pokemon pokemon, Long id) throws Exception {
		Pokemon foundPokemon = repo.findOne(id);
		if (foundPokemon == null ) {
			throw new Exception("Pokemon not found."); // add else for evolution
		}
		foundPokemon.setBreed(pokemon.getBreed());
		return repo.save(foundPokemon);
	}
	
	public void deletePokemon(Long id) { // annotation for releasing
		repo.delete(id);
		
	}
	
	
}
