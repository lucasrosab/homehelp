app.controller("LoginController", function($scope, $http, $location, $rootScope){
	
	$scope.userCliente = {}
	$scope.userPrestador = {}
	$scope.userAdministrador = {}
	
	$rootScope.cliLogado = [];
	$rootScope.presLogado = [];
	$rootScope.adminLogado = [];
	
	$scope.autenticarCliente = function(){
		$http.post("/auth-cli", $scope.userCliente).then(function(response){
			$rootScope.cliLogado = response.data;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/cliente/inicio')
		} , function(response){
			mensagem("Usuário/Senha inválidos", "Erro")
			 
		});
	}
	
	$scope.autenticarPrestador = function(){
		$http.post("/auth-pres", $scope.userPrestador).then(function(response){
			$rootScope.presLogado = response.data;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/prestador/inicio')
		} , function(response){
			mensagem("Usuário/Senha inválidos", "Erro")
		});
	}
	
	$scope.autenticarAdministrador = function(){
		$http.post("/auth-adm", $scope.userAdministrador).then(function(response){
			$rootScope.adminLogado = response.data;
			localStorage.setItem("userToken", response.data.token);
			$location.path('/administrador/inicio')
		} , function(response){
			mensagem("Usuário/Senha inválidos", "Erro")
		});
	}
	
    //Função para carregar o tipo de mensagem ao cadastrar
    function mensagem(mensagem, status) {
        $scope.mensagem = mensagem
        $scope.status = status
        $('.toast').toast({ delay: 3000 });
        $('.toast').toast('show');
    }
	
})