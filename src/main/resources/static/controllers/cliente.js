app.controller("CadastroClienteCtrl", function ($scope, $http) {
     
	$scope.cliente = {}
	$scope.clientes = []
	
    $scope.cadastrar = function (){
		
		$scope.clientes.push($scope.cliente)
		$http({
    	    method : "POST",
    	      url : "http://localhost:8080/pessoa/",
    	      data: $scope.cliente
    	  }).then(function mySuccess(response) {
    	    $scope.cliente = response.data;
    	  }, function myError(response) {
    	    $scope.cliente = response.statusText;
    	  });
    };
    
    function exibirPessoa (){
    	$http({
    		  method: 'GET',
    		  url: '/pessoa/',
    		}).then(function successCallback(response) {
    			$scope.clientes = response.data
    			console.log($scope.clientes);
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
    }
    
    exibirPessoa();
    
    
});

