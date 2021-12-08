'use strict';

angular.module('MGL_Task1_app').controller('gameController',
		[ 'gameService', function(gameService) {
			var self = this;
			self.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
			console.log("calling fetch all games");
				gameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return gameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(gameToDelete){
				return gameService.deleteGame(gameToDelete.id).then( function() {
					self.fetchAllGames();
				});
			}
			
			self.selectGame = function(gameToUpdate) {
				self.game = angular.copy(gameToUpdate);
			}

			self.fetchAllGames();
		} ]);
