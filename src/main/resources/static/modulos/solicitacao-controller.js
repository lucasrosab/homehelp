app.controller("SolicitacaoController", function($scope, $http, $location){
	
	$scope.hidraulica = {};
	$scope.reparo = {};
	$scope.acabamento = {};
	$scope.eletricista = {};
	
	$scope.solicitacoes = [];
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todas as solicitacões no geral
	carregarTodasSolicitacoes = function(){
		
		 $http({method: 'GET', url: 'http://localhost:8080/solicitacoes'})
		 .then(function successCallback(response) {
			 $scope.solicitacoes = response.data
		 }, function errorCallback(response) {
	    	 console.log(response.data)
	    	 console.log(response.status)
		 });
	};
	
	carregarTodasSolicitacoes();
	
	//Solicitar Hidráulica 
	$scope.solicitarHidraulica = function(){
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.hidraulica})
	    .then(function successCallback(response) {
	    	mensagem("Sua solicitação foi criada com sucesso", "Sucesso")
	    }, function errorCallback(response) {
	    	
	    	console.log(response.data)
	    	console.log(response.status)
	    });
	}	 
	
	//Solicitar Reparos 
	$scope.solicitarReparos = function(){
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.reparo})
	    .then(function successCallback(response) {
	    	mensagem("Sua solicitação foi criada com sucesso", "Sucesso")
	    }, function errorCallback(response) {
	    	
	    	console.log(response.data)
	    	console.log(response.status)
	    });
	}	
	
	//Solicitar Acabamento 
	$scope.solicitarAcabamento = function(){
			$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.acabamento})
		    .then(function successCallback(response) {
		    	mensagem("Sua solicitação foi criada com sucesso", "Sucesso")
		    }, function errorCallback(response) {
		    	
		    	console.log(response.data)
		    	console.log(response.status)
		    });
	}
	
	//Solicitar Eletricista 
	$scope.solicitarEletricista = function(){

		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.eletricista})
	    .then(function successCallback(response) {
	    	mensagem("Sua solicitação foi criada com sucesso", "Sucesso")
	    }, function errorCallback(response) {
	    	
	    	console.log(response.data)
	    	console.log(response.status)
	    });

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
    
    $scope.mudarEmail = function() {
		$('#HidraulicaModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		$location.path('/cliente/dados-pessoais')
    }

})