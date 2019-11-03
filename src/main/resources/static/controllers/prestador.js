app.controller("CadastroPrestadorCtrl", function ($scope, $http) {
     
	$scope.prestador = {}
	$scope.prestadores = []
	$scope.prestadorDetalhado = []
	
    $scope.cadastrar = function (){
		$http({
            method: "POST",  
            url: "/prestador",  
            datatype: "json",  
            data: JSON.stringify($scope.prestador)
    	  }).then(function mySuccess(response) {
    	    $scope.prestadores = response.data;
    	    $scope.prestador = {}
    	    window.location.href='../../partes/prestador/index.html'
    	  }, function myError(response) {
    	    $scope.prestadores = response.statusText;
    	  });
    };
    
    function exibir(){
    	$http({
    		  method: 'GET',
    		  url: '/prestador',
    		}).then(function successCallback(response) {
    			$scope.prestadores = response.data
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
    }
    
    exibir();
    
    function detalhar(){
    	$http({
    		  method: 'GET',
    		  url: '/prestador/' + 1,
    		}).then(function successCallback(response) {
    			$scope.prestadorDetalhado = response.data
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    		  });
    }
    
    detalhar()
    
});
