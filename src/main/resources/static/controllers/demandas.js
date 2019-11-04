app.controller("DemandasCtrl", function($scope, $http) {
	
	$scope.demandasDisponiveis = []
	$scope.isAtivo = []
	
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
	
	$scope.status = function(){
		$scope.status = 'true'
		
		$http({
            method: "PUT",  
            url: "/prestador/status/" + 1,  
            datatype: "json",  
            data: JSON.stringify($scope.status)
    	  }).then(function mySuccess(response) {
    		  console.log("Sucesso: " + response.data)
    	  }, function myError(response) {
    	    console.log("Erro: " + response.statusText)
    	  });
	}

	function statusPrestador() {
    	$http({
    		  method: 'GET',
    		  url: '/prestador/status/'+1,
		}).then(function successCallback(response) {
			$scope.isAtivo = response.data
			
			//Recupera o valor do botao
			if($scope.isAtivo.status){
				$scope.valor = "Disponível"
			} else {
				$scope.valor = "Indisponível"
			}
		  }, function errorCallback(response) {
			  
		  });
	}
	
	statusPrestador();
});