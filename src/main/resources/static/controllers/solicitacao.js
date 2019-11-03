app.controller("SolicitacaoCtrl", function($scope,$http) {
	
	$scope.solicitacao = {}
	$scope.solicitacoesCliente = []
	$scope.profissionalDisponivel = []
	
	$scope.solicitarHidraulica = function(){
		$scope.solicitacao.codCliente = "Lucas Rosa Barbosa"
		$scope.solicitacao.codPrestador = "Lucas Rosa"

		$http({
            method: "POST",  
            url: "/solicitacao",  
            datatype: "json",  
            data: JSON.stringify($scope.solicitacao)
    	  }).then(function mySuccess(response) {
    	    $scope.solicitacoesCliente = response.data;
    	    console.log("Salvou")
    	    $scope.solicitacao = {}
    	    window.location.href='../../partes/prestador/index.html'
    	  }, function myError(response) {
    	    $scope.prestadores = response.statusText;
    	  });
	}
	
	function minhasSolicitacoes() {
    	$http({
  		  method: 'GET',
  		  url: '/solicitacao/cliente/' + 1,
  		}).then(function successCallback(response) {
  			$scope.solicitacoesCliente = response.data
  		  }, function errorCallback(response) {
  		    // called asynchronously if an error occurs
  		    // or server returns response with an error status.
  		  });
	}
	
	function profissionalDisponivel(){
    	$http({
    		  method: 'GET',
    		  url: '/prestador/ativo',
    		}).then(function successCallback(response) {
    			$scope.profissionalDisponivel = response.data
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
	}
	
	profissionalDisponivel(); 	
	
});