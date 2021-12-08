'use strict';

angular.module('MGL_Task1_app').factory('gameService', ['$http','$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'get').then(function(response) {
					return response.data;
				}
			);
		}
		

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'create', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(gameId){
			return $http.delete(REST_SERVICE_URI + gameId).then(function( response){
				if(response.data){
					$log.info("Successfully deleted game with id: " + gameId);
				}else{
					$log.debug("No Game Deleted with id: " + gameId);
				}
				return response.data;
			});
		}

}]);
