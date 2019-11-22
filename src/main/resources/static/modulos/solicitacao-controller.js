app.controller("SolicitacaoController", function($scope, $http, $location, $rootScope){
	
	$scope.hidraulica = {};
	$scope.reparo = {};
	$scope.acabamento = {};
	$scope.eletricista = {};
	$rootScope.solicitacoes = [];
	$rootScope.cliLogado;
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todas as solicitacões no geral
	carregarTodasSolicitacoes = function(){
		
		 $http({method: 'GET', url: 'http://localhost:8080/solicitar/todas'})
		 .then(function successCallback(response) {
			 $rootScope.solicitacoes = response.data
		 }, function errorCallback(response) {

		 });
	};
	
	carregarTodasSolicitacoes();
	
	//Solicitar Hidráulica 
	$scope.solicitarHidraulica = function(){
		$scope.hidraulica.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.hidraulica.categoria = "Hidraulica"
		$scope.hidraulica.dia = RetornaDataAtual();
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.hidraulica})
	    .then(function successCallback(response) {
	    	
	    }, function errorCallback(response) {
	    	
	    });
	}	 
	
	//Solicitar Reparos 
	$scope.solicitarReparos = function(){
		$scope.reparo.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.reparo.categoria = "Reparo"
		$scope.reparo.dia = RetornaDataAtual();
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.reparo})
	    .then(function successCallback(response) {
	    	
	    }, function errorCallback(response) {
	    		    	
	    });
	}	
	
	//Solicitar Acabamento 
	$scope.solicitarAcabamento = function(){
		$scope.acabamento.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.acabamento.categoria = "Acabamento"
		$scope.acabamento.dia = RetornaDataAtual();
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.acabamento})
	    .then(function successCallback(response) {
	    	
	    }, function errorCallback(response) {
	    	
	    });
	}
	
	//Solicitar Eletricista 
	$scope.solicitarEletricista = function(){
		$scope.eletricista.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.eletricista.categoria = "Eletricista"
		$scope.eletricista.dia = RetornaDataAtual();
		$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.eletricista})
	    .then(function successCallback(response) {
	    	
	    }, function errorCallback(response) {
	    	
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
    
    function RetornaDataAtual(){
    	var dNow = new Date();
    	var localdate = dNow.getDate() + '/' + (dNow.getMonth()+1) + '/' + dNow.getFullYear();
    	return localdate;
    }
    
})