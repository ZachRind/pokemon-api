package com.promineotech.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GymLeaders {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String typeSpecialization;
	private String gym;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTypeSpecialization() {
		return typeSpecialization;
	}
	public void setTypeSpecialization(String typeSpecialization) {
		this.typeSpecialization = typeSpecialization;
	}
	
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}

}
