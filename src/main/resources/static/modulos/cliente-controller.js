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

		 });
	};
	
	carregarClientes();

	//Salvar Cliente 
	$scope.salvarCliente= function(){
		
		if(validarCPF($scope.cliente.cpf) == false) {
			mensagem("Insira um CPF Válido", "Erro")
		} else if($scope.formCadastroCliente.$valid){
			$http({method: 'POST',url: 'http://localhost:8080/cli/novo',data:$scope.cliente})
		    .then(function successCallback(response) {
		    	carregarClientes();
	            mensagem("Cadastrado com Sucesso", "Sucesso")
	            $location.path('/login/cliente')
		    }, function errorCallback(response) {

		    });
		} else {
			mensagem("Preencha todos os campo", "Erro")
		}
	}	 
	
	//Alterar Cliente
	$scope.alterarCliente = function(){
		$scope.updatecli = $scope.cliLogado.cliente
		if($scope.formUpdateDadosCliente.$valid){
			$http({method: 'PUT',url: 'http://localhost:8080/cli/alterar',data:$scope.updatecli})
		    .then(function successCallback(response) {
		    	carregarClientes();
	            mensagem("Dados Alterados com Sucesso", "Sucesso")
		    }, function errorCallback(response) {

		    });
		} else {
			mensagem("Preencha todos os campo", "Erro")
		}
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
	/*
	function validaData(data){
		
		//Data
		var dia = data.substring(0, 2) 
		var mes = data.substring(4, 6)
		var ano = data.substring(8, 12)
		
		return console.log("Dia:" + dia + ",Mes" + mes ",Ano" ano)
		
	}
	*/
})