package com.promineotech.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonapi.entity.Badges;
import com.promineotech.pokemonapi.entity.GymLeaders;
import com.promineotech.pokemonapi.entity.Trainers;
import com.promineotech.pokemonapi.repository.BadgesRepository;
import com.promineotech.pokemonapi.repository.GymLeadersRepository;
import com.promineotech.pokemonapi.repository.TrainersRepository;

@Service
public class BadgesService {
	
	@Autowired
	private BadgesRepository repo;
	
	@Autowired
	private GymLeadersRepository gymLeaderRepo;
	
	@Autowired
	private TrainersRepository trainersRepo;

	public Badges createBadge(Badges badges, Long gymLeaderId, Long trainerId) throws Exception {
		GymLeaders gymLeader = gymLeaderRepo.findOne(gymLeaderId);
		Trainers trainer = trainersRepo.findOne(trainerId);
		if (gymLeader == null || trainer == null) {
			throw new Exception("Trainer or Gym Leader does not exist.");
		}
		badges.setGymLeaderId(gymLeader);
		badges.setTrainerId(trainer);
		return repo.save(badges);
	}

	public void deleteBadge(Long badgeId) {
		repo.delete(badgeId);
		
	}

}
