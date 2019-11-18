app.controller("LoginController", function($scope, $http){
	
	$scope.userCliente = {}
	$scope.userPrestador = {}
	$scope.userAdministrador = {}
	
	$scope.autenticarCliente = function(){
		console.log($scope.userCliente)
		$http.post("/autenticar", $scope.userCliente)
		.then(function(response){
			console.log("Sucesso: " + response)
		}, function(response){
			console.log("Erro: " + response)
		});
		
		/*
		$http({method: 'POST',url: 'http://localhost:8080/login',data:$scope.usuario})
	    .then(function successCallback(response) {
	    }, function errorCallback(response) {
	    	console.log("Erro")
	    });
	    */
	}
	
})