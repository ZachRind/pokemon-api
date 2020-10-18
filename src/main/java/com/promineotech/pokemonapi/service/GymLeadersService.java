package com.promineotech.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonapi.entity.GymLeaders;
import com.promineotech.pokemonapi.repository.GymLeadersRepository;

@Service
public class GymLeadersService {

	@Autowired
	private GymLeadersRepository repo;
	
	public GymLeaders createGymLeader(GymLeaders gymLeader) {
		return repo.save(gymLeader);
	}
	
}
