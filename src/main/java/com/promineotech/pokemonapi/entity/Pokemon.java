package com.promineotech.pokemonapi.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pokemon {

	private Long id;
	private Trainers trainerId;
	private Set<Types> typesId;
	private GymLeaders gymLeaderId;
	private String name;
	private String breed;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "trainerId")
	public Trainers getTrainerId() {
		return trainerId;
	}
	public void setTrainerId (Trainers trainerId) {
		this.trainerId = trainerId;
	}
	
	@JsonIgnore
	@ManyToMany //add annotation to type entity
	@JoinTable(
		name = "pokemon_types",
		joinColumns = @JoinColumn(name = "pokemonId"),
		inverseJoinColumns = @JoinColumn(name = "typesId"))
	public Set<Types> getTypesId() {
		return typesId;
	}
	public void setTypesId(Set<Types> typesId) {
		this.typesId = typesId;
	}
	
	@ManyToOne
	@JoinColumn(name = "gymLeaderId")
	public GymLeaders getGymLeaderId() {
		return gymLeaderId;
	}
	public void setGymLeaderId(GymLeaders gymLeaderId) {
		this.gymLeaderId = gymLeaderId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	
	
	
	
	
	
}
