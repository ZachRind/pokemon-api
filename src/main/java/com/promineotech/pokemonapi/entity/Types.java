package com.promineotech.pokemonapi.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Types {
	
	private Long id;
	private Set<Pokemon> pokemonId;
	private String typeOne;
	private String typeTwo;
	private String strengths;
	private String weaknesses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}
	
	public String getTypeTwo() {
		return typeTwo;
	}
	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}
	
	public String getStrengths() {
		return strengths;
	}
	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}
	
	public String getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}
	
	@ManyToMany(mappedBy = "typesId")
	public Set<Pokemon> getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(Set<Pokemon> pokemonId) {
		this.pokemonId = pokemonId;
	}
	
	
	
	

}
