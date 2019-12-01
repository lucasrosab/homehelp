app.controller("ContaController", function($scope, $http, $location, $rootScope){
	$scope.conta = {};
	$scope.contas = [];
	$scope.contadetalhe = [];
	$rootScope.presLogado;
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todas as Contas cadastradas
	carregarContas = function(){
		 $http({method: 'GET',url: 'http://localhost:8080/conta/todas'})
		 .then(function successCallback(response) {
		     $scope.contas = response.data
		     console.log($scope.contas)
		 }, function errorCallback(response) {

		 });
	};
	
	carregarContas();

	//Salvar Conta 
	$scope.salvarConta= function(){
		$scope.conta.titular = {id: $rootScope.presLogado.pres.id}
		$http({method: 'POST',url: 'http://localhost:8080/conta/nova',data:$scope.conta})
		    .then(function successCallback(response) {
		    	carregarContas();
	            mensagem("Cadastrado com Sucesso", "Sucesso")
		    }, function errorCallback(response) {
	    });
	}	 
	
	//Alterar Conta
	$scope.alterarConta = function(conta){
		$http({method: 'PUT',url: 'http://localhost:8080/conta/alterar',data: conta})
	    .then(function successCallback(response) {
	    	carregarContas();
            mensagem("Dados Alterados com Sucesso", "Sucesso")
	    }, function errorCallback(response) {

	    });
	}
	
	$scope.cancelarAlteracaoConta = function(){
		$scope.conta = {}
	}
	
	$scope.excluirConta = function(conta){
		$http({method: 'DELETE',url: 'http://localhost:8080/conta/excluir/' + conta.id})
	    .then(function successCallback(response) {
		   	 pos = $scope.contas.indexOf(conta)
		   	 $scope.contas.splice(pos, 1);
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
	
    function validarCPF(cpf) {	
    	cpf = cpf.replace(/[^\d]+/g,'');	
    	if(cpf == '') return false;	
	
    	if (cpf.length != 11 || 
    		cpf == "00000000000" || 
    		cpf == "11111111111" || 
    		cpf == "22222222222" || 
    		cpf == "33333333333" || 
    		cpf == "44444444444" || 
    		cpf == "55555555555" || 
    		cpf == "66666666666" || 
    		cpf == "77777777777" || 
    		cpf == "88888888888" || 
    		cpf == "99999999999")
    			return false;	
    	
    	add = 0;	
    	for (i=0; i < 9; i ++)		
    		add += parseInt(cpf.charAt(i)) * (10 - i);	
    		rev = 11 - (add % 11);	
    		if (rev == 10 || rev == 11)		
    			rev = 0;	
    		if (rev != parseInt(cpf.charAt(9)))		
    			return false;		

    	add = 0;	
    	for (i = 0; i < 10; i ++)		
    		add += parseInt(cpf.charAt(i)) * (11 - i);	
    	rev = 11 - (add % 11);	
    	if (rev == 10 || rev == 11)	
    		rev = 0;	
    	if (rev != parseInt(cpf.charAt(10)))
    		return false;		
    	return true;   
    }
    
    $scope.apenasLetras = function(){
        evt = window.event;
        var tecla = evt.keyCode;

        if((tecla > 32 && tecla < 65) || (tecla > 90 && tecla < 97)){ 
          evt.preventDefault();
        }
      }
})