package com.promineotech.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonapi.entity.Trainers;
import com.promineotech.pokemonapi.repository.TrainersRepository;

@Service
public class TrainersService {
	
	@Autowired
	private TrainersRepository repo;
	
	public Trainers createTrainer(Trainers trainer) {
		return repo.save(trainer);
		
	}
	

}
