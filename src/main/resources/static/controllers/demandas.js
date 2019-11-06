app.controller("DemandasCtrl", function($scope, $http) {
	
	$scope.demandasDisponiveis = []
	$scope.isAtivo = []
	$scope.prestador = {}
	
	//Exibe todas as demandas disponíveis
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
	
	//Responsável pela alteração do status do prestador
	$scope.status = function(){
		if($scope.isAtivo.status) {
			$scope.prestador = { status : false}
		} else {
			$scope.prestador = { status : true}
		}
		$http({
            method: "PUT",  
            url: "/prestador/status/" + 1,  
            datatype: "json",  
            data: JSON.stringify($scope.prestador)
    	  }).then(function mySuccess(response) {
    		  statusPrestador();
    	  }, function myError(response) {
    	    
    	  });
	}
	
	//Carrega o status do prestador
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