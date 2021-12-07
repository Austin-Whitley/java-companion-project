package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.service.GameService;

@Controller
public class RestController {
	
	@Autowired
	private GameService gameService;
	
	//read
	@RequestMapping(value = "/game/get", method = RequestMethod.GET)
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	//create
	@RequestMapping(value = "/game/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//update
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody Game game){
		gameService.updateGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping(value = "game/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id){
		
		return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
		
	}

}
