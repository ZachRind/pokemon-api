package com.promineotech.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Badges {
	
	private Long id;
	private GymLeaders gymLeaderId;
	private Trainers trainerId;
	private String description;
	private String gym;
	private String type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "gymLeaderId")
	public GymLeaders getGymLeaderId() {
		return gymLeaderId;
	}
	public void setGymLeaderId(GymLeaders gymLeaderId) {
		this.gymLeaderId = gymLeaderId;
	}
	
	@ManyToOne
	@JoinColumn(name="trainerId")
	public Trainers getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Trainers trainer) {
		this.trainerId = trainer;
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
