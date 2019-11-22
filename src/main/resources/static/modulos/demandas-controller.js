app.controller("DemandaController", function($http, $scope, $rootScope){
		
	$scope.demandasDisponiveis = []
	$rootScope.solicitacoes
	
	function demandas() {
    	$http({
  		  method: 'GET',
  		  url: '/solicitar/todas',
  		}).then(function successCallback(response) {
  			$scope.demandasDisponiveis = response.data
  		  }, function errorCallback(response) {
  			  
  		  });
	}

	demandas();

	$scope.status = function(){
		$scope.prestador = $rootScope.presLogado.pres
		if($rootScope.presLogado.pres.status_prestador){
			$scope.prestador.status_prestador = false
		} else {
			$scope.prestador.status_prestador = true
		}
		
		$http({
            method: "PUT",  
            url: "/pres/alterar",  
            datatype: "json",  
            data: $scope.prestador
    	  }).then(function mySuccess(response) {
    		  
    	  }, function myError(response) {

    	  });
	}

})