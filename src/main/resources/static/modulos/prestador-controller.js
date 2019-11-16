app.controller("PrestadorController", function($scope, $http, $location){
	
	$scope.prestador = {};
	$scope.prestadores = [];
	//-----------------------------------------------------------------------------------------------//
	//Carregar todos os prestadores
	carregarPrestadores = function(){
		 $http({method: 'GET',url: 'http://localhost:8080/prestador'})
		 .then(function successCallback(response) {
		     $scope.prestadores = response.data
		 }, function errorCallback(response) {
	    	 console.log(response.data)
	    	 console.log(response.status)
		 });
	};
	
	carregarPrestadores();
	
	//Salvar Prestador 
	$scope.salvarPrestador = function(){
		if($scope.formCadastroPrestador.$valid){
			$http({method: 'POST',url: 'http://localhost:8080/prestador',data:$scope.prestador})
		    .then(function successCallback(response) {
		    	carregarPrestadores();
		    	$scope.formCadastroPrestador.$setPristine(true)
		    	$('#InfoCadPrestadorModal').modal('show');
		    }, function errorCallback(response) {
		    	mensagem("Preencha todos os campos", "Erro")
		    	console.log(response.data)
		    	console.log(response.status)
		    });
		} else {
			console.log("Erro")
		}
	}	 
	
	//Alterar Prestador
	$scope.alterarPrestador = function(prestador){
		$scope.prestador = angular.copy(prestador)
	}
	
	$scope.cancelarAlteracaoPrestador = function(){
		$scope.prestador = {}
	}
	
	 
	//Excluir Prestador
	//Ao chamar essa funcao, passar o valor como parametro para a exclusao 
	$scope.excluirPrestador= function(prestador){
	 $http({method: 'DELETE',url: 'http://localhost:8080/prestador' + prestador.id})
	    .then(function successCallback(response) {
	   	 pos = $scope.prestadores.indexOf(cliente)
	   	 $scope.prestadores.splice(pos, 1);
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
    
    $scope.InfoPrestador = function() {
		$('#InfoCadPrestadorModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		$location.path('/')
    }

})