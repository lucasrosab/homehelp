app.controller("AdministradorController", function($scope, $http, $location, $rootScope){
	
	$scope.admin = {};
	$scope.administradores = [];
	$scope.admindetalhe = [];
	$rootScope.adminLogado;
	
	//-----------------------------------------------------------------------------------------------//
	//Carregar todos os Administradores
	carregarAdministradores = function(){
		 $http({method: 'GET',url: 'http://localhost:8080/admin/todos'})
		 .then(function successCallback(response) {
		     $scope.administradores = response.data
		 }, function errorCallback(response) {

		 });
	};
	
	carregarAdministradores();

	//Salvar Administrador 
	$scope.salvarAdministrador = function(){
		if(validarCPF($scope.admin.cpf) == false) {
			mensagem("Insira um CPF Válido", "Erro")
		} else if (verificadata($scope.admin.dataNascimento) == 2) {
			mensagem("Insira uma data menor que a data atual", "Erro")
        } else if (verificadata($scope.admin.dataNascimento) == 3) {
            mensagem("Insira uma data diferente da atual", "Erro")
        } else if (verificadata($scope.admin.dataNascimento) == 4) {
            mensagem("Para se cadastrar, é preciso possuir no mínimo 18 anos", "Erro")
        } else if (verificadata($scope.admin.dataNascimento) == 5) {
            mensagem("Insira um ano válido", "Erro")
        } else {
        	$http({method: 'POST',url: 'http://localhost:8080/admin/novo',data:$scope.admin})
    	    .then(function successCallback(response) {
    	    	carregarAdministradores();
                mensagem("Cadastrado com Sucesso", "Sucesso")
                $scope.admin = {}
    	    }, function errorCallback(response) {
    	    	mensagem("Administrador já Cadastrado", "Erro")
    	    });
        }
	}	 
	
	//Alterar Administrador
	$scope.alterarAdministrador = function(){
		$scope.updateadmin = $scope.adminLogado.admin
		$http({method: 'PUT',url: 'http://localhost:8080/admin/alterar',data:$scope.updatecli})
	    .then(function successCallback(response) {
	    	carregarClientes();
            mensagem("Dados Alterados com Sucesso", "Sucesso")
	    }, function errorCallback(response) {

	    });
	}
	
	$scope.cancelarAlteracaoAdmin = function(){
		$scope.admin = {}
	}
	
	 
	//Excluir Admin
	//Ao chamar essa funcao, passar o valor como parametro para a exclusao 
	$scope.excluirAdmin= function(admin){
	 $http({method: 'DELETE',url: 'http://localhost:8080/admin/excluir/' + $rootScope.adminLogado.admin.id})
	    .then(function successCallback(response) {
	   	 pos = $scope.administradores.indexOf(admin)
	   	 $scope.administradores.splice(pos, 1);
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
    
	$("#ClienteDataNascimento").mask("39/19/2999", {
	    placeholder: "00/00/0000",
	    selectOnFocus: true,
	    clearIfNotMatch: true,
	    translation: {
	        1: {
	            pattern: /[0-1]/
	        },
	        2: {
	            pattern: /[0-2]/
	        },
	        3: {
	            pattern: /[0-3]/
	        },
	        4: {
	            pattern: /[0-4]/
	        },
	        9: {
	            pattern: /[0-9]/
	        }
	    }
	});
	
    function verificadata(data) {
        var dia = data.substring(0, 2);
        var mes = data.substring(3, 5);
        var ano = data.substring(6, 10);
        var dataFormatada = Date.parse(mes + "/" + dia + "/" + ano);


        var now = new Date()
        var hojeDia = now.getDay() + 1
        var hojeMes = now.getMonth() + 1
        var hojeAno = now.getFullYear()
        var anoMenorIdade = now.getFullYear() - 18
        var dataMenorIdade = Date.parse(hojeMes + "/" + hojeDia + "/" + anoMenorIdade)
        var hoje = Date.parse(hojeMes + "/" + hojeDia + "/" + hojeAno)
        var dataAntiga = Date.parse(hojeMes + "/" + hojeDia + "/" + 1920)
        
        if (dataFormatada > hoje) {
            return 2
        } else if (dataFormatada == hoje) {
            return 3
        } else if (dataFormatada > dataMenorIdade) {
            return 4
        } else if (dataFormatada <= dataAntiga) {
        	return 5
        }
    }
})