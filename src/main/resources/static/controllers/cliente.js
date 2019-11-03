app.controller("CadastroClienteCtrl", function ($scope, $http) {
     
	$scope.cliente = {}
	$scope.clientes = []
	$scope.clienteDetalhado = []
	
    $scope.cadastrar = function (){
		$http({
            method: "POST",  
            url: "/cliente",  
            datatype: "json",  
            data: JSON.stringify($scope.cliente)
    	  }).then(function mySuccess(response) {
    	    $scope.clientes = response.data;
    	    window.location.href='../../partes/cliente/index.html'
    	  }, function myError(response) {
    	    $scope.cliente = response.statusText;
    	    $('.alert').alert()
    	  });
    };
    
    function exibirPessoa (){
    	$http({
    		  method: 'GET',
    		  url: '/cliente',
    		}).then(function successCallback(response) {
    			$scope.clientes = response.data
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
    }
    
    exibirPessoa();
    
    function detalhar(){
    	$http({
    		  method: 'GET',
    		  url: '/cliente/' + 1,
    		}).then(function successCallback(response) {
    			$scope.clienteDetalhado = response.data
    			console.log($scope.clienteDetalhado)
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
    }
    
    detalhar()
    
});
