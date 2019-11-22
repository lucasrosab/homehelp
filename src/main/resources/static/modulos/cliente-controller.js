app.controller("ClienteController", function($scope, $http, $location, $rootScope){
	
	$scope.cliente = {};
	$scope.clientes = [];
	$scope.clientedetalhe = [];
	$rootScope.cliLogado;
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todos os clientes
	carregarClientes = function(){
		 $http({method: 'GET',url: 'http://localhost:8080/cli/todos'})
		 .then(function successCallback(response) {
		     $scope.clientes = response.data
		 }, function errorCallback(response) {
	    	 console.log(response.data)
	    	 console.log(response.status)
		 });
	};
	
	carregarClientes();

	//Salvar Cliente 
	$scope.salvarCliente= function(){
		if($scope.formCadastroCliente.$valid){
			$http({method: 'POST',url: 'http://localhost:8080/cli/novo',data:$scope.cliente})
		    .then(function successCallback(response) {
		    	carregarClientes();
	            mensagem("Cadastrado com Sucesso", "Sucesso")
	            $location.path('/login')
		    }, function errorCallback(response) {
		    	console.log(response.data)
		    	console.log(response.status)
		    });
		} else {
			mensagem("Preencha todos os campo", "Erro")
		}
	}	 
	
	//Alterar Cliente
	$scope.alterarCliente = function(cliente){
		$scope.cliente = angular.copy(cliente)
	}
	
	$scope.cancelarAlteracaoCliente = function(){
		$scope.cliente = {}
	}
	
	 
	//Excluir Cliente
	//Ao chamar essa funcao, passar o valor como parametro para a exclusao 
	$scope.excluirCliente= function(cliente){
	 $http({method: 'DELETE',url: 'http://localhost:8080/cli/excluir/' + $rootScope.cliLogado.cliente.id})
	    .then(function successCallback(response) {
	   	 pos = $scope.clientes.indexOf(cliente)
	   	 $scope.clientes.splice(pos, 1);
	    }, function errorCallback(response) {
	   	 console.log(response.data)
	   	 console.log(response.status)
	    });
	}
	//-----------------------------------------------------------------------------------------------//
	// Funções e Validações
	
    //Função para carregar o tipo de mensagem ao cadastrar
    function mensagem(mensagem, status) {
        $scope.mensagem = mensagem
        $scope.status = status
        $('.toast').toast({ delay: 3000 });
        $('.toast').toast('show');
    }
	
	
	
	
	
})