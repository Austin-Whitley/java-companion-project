'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
			console.log("calling fetch all games");
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(gameToDelete){
				return MGL_Task1_Service.deleteGame(gameToDelete.id).then( function() {
					self.fetchAllGames();
				});
			}
			
			self.selectGame = function(gameToUpdate) {
				self.game = angular.copy(gameToUpdate);
			}

			self.fetchAllGames();
		} ]);
