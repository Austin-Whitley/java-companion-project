package com.organization.mvcproject.service;

import java.util.List;

import com.organization.mvcproject.model.Game;


public interface GameService{

	List<Game> retrieveAllGames();
	
	List<Game> findGamesByGenre(String genre);

	Game saveGame(Game game);
	
	boolean deleteGame(Long gameId);
	
	Game updateGame(Game game);

}
