app.controller("LoginClienteController", function($scope, $http){
	
	$scope.usuario = {}
	
	$scope.autenticar = function(){
		console.log($scope.usuario)
		$http({method: 'POST',url: 'http://localhost:8080/login',data:$scope.usuario})
	    .then(function successCallback(response) {
	    }, function errorCallback(response) {
	    	console.log("Erro")
	    });
	}
	
})