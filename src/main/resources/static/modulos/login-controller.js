app.controller("LoginController", function($scope, $http, $location, $rootScope){
	
	$scope.userCliente = {}
	$scope.userPrestador = {}
	$scope.userAdministrador = {}
	
	$scope.tokenCliente = "";
	$scope.tokenPrestador = "";
	$scope.tokenAdministrador = "";
	
	$rootScope.cliLogado = [];
	
	$scope.autenticarCliente = function(){
		$http.post("/auth-cli", $scope.userCliente).then(function(response){
			$rootScope.cliLogado = response.data;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/cliente/inicio')
		} , function(response){
			console.log("Falha " + response);
		});
	}
	
	$scope.autenticarPrestador = function(){
		$http.post("/auth-pres", $scope.userPrestador).then(function(response){
			console.log("Sucesso " + response);
			$scope.tokenPrestador= response.data.token;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/prestador/inicio')
		} , function(response){
			console.log("Falha " + response);
		});
	}
	
	$scope.autenticarAdministrador = function(){
		$http.post("/auth-adm", $scope.userAdministrador).then(function(response){
			console.log("Sucesso " + response);
			$scope.tokenAdministrador= response.data.token;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/administrador/inicio')
		} , function(response){
			console.log("Falha " + response);
		});
	}
	
})