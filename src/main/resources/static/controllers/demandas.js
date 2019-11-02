app.controller("DemandasCtrl", function($scope, $http) {
	
	$scope.demandasDisponiveis = []
	
	function demandas() {
    	$http({
  		  method: 'GET',
  		  url: '/solicitacao',
  		}).then(function successCallback(response) {
  			$scope.demandasDisponiveis = response.data
  		  }, function errorCallback(response) {
  			  
  		  });
	}
	
	demandas();
});