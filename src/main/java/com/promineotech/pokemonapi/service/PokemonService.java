package com.promineotech.pokemonapi.service;

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
	
	public Pokemon createPokemon(Pokemon pokemon, Long trainerId, Long typeId, Long gymLeaderId) throws Exception {
		Trainers trainer = trainersRepo.findOne(trainerId);
		Set<Types> type = (Set<Types>) typesRepo.findOne(typeId);
		GymLeaders gymLeader = gymLeaderRepo.findOne(gymLeaderId);
		if (trainer == null || gymLeader == null || type == null ) {
			throw new Exception("Trainer, Gym Leader, or Type does not exist.");
		}
		pokemon.setTrainerId(trainer);
		pokemon.setTypesId(type);
		pokemon.setGymLeaderId(gymLeader);
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
