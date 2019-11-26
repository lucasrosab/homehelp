app.controller("PrestadorController", function($scope, $http, $location, $rootScope){
	
	$scope.prestador = {};
	$scope.prestadores = [];
	$scope.prestadordetalhe = [];
	
	$rootScope.presLogado;
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todos os prestadores
	carregarPrestadores = function(){
		 $http({method: 'GET',url: 'http://localhost:8080/pres/todos'})
		 .then(function successCallback(response) {
		     $scope.prestadores = response.data
		 }, function errorCallback(response) {

		 });
	};
	
	carregarPrestadores();
	
	//Salvar Prestador 
	$scope.salvarPrestador = function(){
		
		if(validarCPF($scope.prestador.cpf) == false) {
			mensagem("Insira um CPF Válido", "Erro")
		} else if($scope.formCadastroPrestador.$valid){
			$http({method: 'POST',url: 'http://localhost:8080/pres/novo',data:$scope.prestador})
		    .then(function successCallback(response) {
		    	carregarPrestadores();
		    	$scope.formCadastroPrestador.$setPristine(true)
		    	$('#InfoCadPrestadorModal').modal('show');
		    }, function errorCallback(response) {

		    });
		} else {
			console.log("Erro")
		}
	}	 
	
	//Alterar Prestador
	$scope.alterarPrestador = function(){
		$scope.updatepres = $scope.presLogado.pres
		if($scope.formUpdateDadosPrestador.$valid){
			$http({method: 'PUT',url: 'http://localhost:8080/pres/alterar',data:$scope.updatepres})
		    .then(function successCallback(response) {
		    	carregarPrestadores();
	            mensagem("Dados Alterados com Sucesso", "Sucesso")
		    }, function errorCallback(response) {

		    });
		} else {
			mensagem("Preencha todos os campo", "Erro")
		}
	}
	
	$scope.cancelarAlteracaoPrestador = function(){
		$scope.prestador = {}
	}
	
	 
	//Excluir Prestador
	//Ao chamar essa funcao, passar o valor como parametro para a exclusao 
	$scope.excluirPrestador= function(prestador){
	 $http({method: 'DELETE',url: 'http://localhost:8080/pres/excluir/' + $rootScope.presLogado.prestador.id})
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
    
    $scope.InfoPrestador = function() {
		$('#InfoCadPrestadorModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		$location.path('/')
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