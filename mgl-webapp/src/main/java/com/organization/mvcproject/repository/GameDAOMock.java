package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class GameDAOMock {
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	
	public List<Game> retrieveAllGames() {
		return games;
	}
	
	public List<Game> findGamesByGenre(String genre){
		List<Game> genreList = new ArrayList<>();
		for(Game game: games) {
			if(game.getGenre().equalsIgnoreCase(genre)) {
				genreList.add(game);
			}
		}
		return (genreList.isEmpty()) ? null : genreList;
	}
	
//	public List<Game> findGamesByGenre(String genre) {
//		return games.stream()
//				  .filter(game -> genre.equals(game.getGenre()))
//				  .collect(Collectors.toList());
//	}

	
	public Game saveGame(Game game) {
		
		//update if the id already exists
		if(game.getId() != null) {
			Game foundGame = findGameById(game.getId());
			if(foundGame != null) {
				//update the game found in the list
				for(int i = 0; i < games.size(); i++) {
					if(game.getId().equals(games.get(i).getId())) {
						games.set(i, game);
						//if the database made changes
						return findGameById(game.getId());
					}
				}
			}
		}
		//create new game
		game.setId(++gameId);
		games.add(game);
		return game;
	}



	public boolean deleteGameById(Long gameId) {
		for(Game game : games) {
			if(game.getId() == gameId) {
				games.remove(game);
				return true;
			}
		}
		return false;
	}
	
	
	public Game findGameById(Long gameId) {
		for(Game g: games) {
			if(g.getId() == gameId) {
				return g;
			}
		}
		return null;
	}

}
