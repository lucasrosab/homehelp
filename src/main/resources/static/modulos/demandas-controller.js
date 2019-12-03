app.controller("DemandaController", function($http, $scope, $rootScope, $location){
		
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

	$scope.aceitar = function(demanda){
		$scope.dados = demanda
		$scope.dados.prestador = {id: $rootScope.presLogado.pres.id}
		$scope.dados.status = "Em Andamento"
			
		$http({
            method: "PUT",  
            url: "/solicitar/alterar",  
            datatype: "json",  
            data: $scope.dados
    	  }).then(function mySuccess(response) {
		    	$('#solicitacaoAceitaModal').modal('show')
    	  }, function myError(response) {

    	  });
    	 
	}
	
	$scope.cancelar = function(reparos){
		$scope.cancelar = reparos
		$scope.cancelar.status = "Disponivel"
		$scope.cancelar.prestador = null	
		
		$http({
            method: "PUT",  
            url: "/solicitar/alterar",  
            datatype: "json",  
            data: $scope.cancelar
    	  }).then(function mySuccess(response) {
    		  
    	  }, function myError(response) {

    	  });
	}
	
	$scope.finalizar = function(reparos){
		$scope.finalizar = reparos
		$scope.finalizar.status = "Encerrada"
		
		$http({
            method: "PUT",  
            url: "/solicitar/alterar",  
            datatype: "json",  
            data: $scope.finalizar
    	  }).then(function mySuccess(response) {
    		  
    	  }, function myError(response) {

    	  });
	}
	
	$scope.ir = function(){
		$('#solicitacaoAceitaModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		$location.path('/prestador/reparos')
	}
})