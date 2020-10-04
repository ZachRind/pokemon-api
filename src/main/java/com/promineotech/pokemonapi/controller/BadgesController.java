package com.promineotech.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pokemonapi.entity.Badges;
import com.promineotech.pokemonapi.service.BadgesService;

@RestController
@RequestMapping("/gymLeaders/{gymLeaderId}/trainers/{trainerId}/badges") //?? /gymLeaders/{id}/etc ??
public class BadgesController {

	@Autowired
	private BadgesService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createBadge(@RequestBody Badges badges, @PathVariable Long gymLeaderId, @PathVariable Long trainerId) {
		try {
			return new ResponseEntity<Object>(service.createBadge(badges, gymLeaderId, trainerId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{badgeId})", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteBadge(@PathVariable long badgeId) {
		service.deleteBadge(badgeId);
		return new ResponseEntity<Object>("Badge with id" + badgeId + "has been revoked from trainer.", HttpStatus.OK);
	}
	
}
