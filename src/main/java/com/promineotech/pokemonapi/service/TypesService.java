package com.promineotech.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pokemonapi.entity.Types;
import com.promineotech.pokemonapi.repository.TypesRepository;

@Service
public class TypesService {

	@Autowired
	private TypesRepository repo;
	
	public Types createType(Types type) {
		return repo.save(type);
	}
	
}
