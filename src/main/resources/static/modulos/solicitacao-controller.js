app.controller("SolicitacaoController", function($scope, $http, $location, $rootScope){
	
	$scope.hidraulica = {};
	$scope.reparo = {};
	$scope.acabamento = {};
	$scope.eletricista = {};
	$rootScope.solicitacoes = [];
	$rootScope.cliLogado;
	$rootScope.adminLogado;
	
	$scope.hidraulica.dia = RetornaDataAtual();
	$scope.reparo.dia = RetornaDataAtual();
	$scope.acabamento.dia = RetornaDataAtual();
	$scope.eletricista.dia = RetornaDataAtual();
	
	$scope.hidraulica.endereco = $rootScope.cliLogado.cliente.endereco
	$scope.reparo.endereco = $rootScope.cliLogado.cliente.endereco
	$scope.acabamento.endereco = $rootScope.cliLogado.cliente.endereco
	$scope.eletricista.endereco = $rootScope.cliLogado.cliente.endereco
	
	
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
		if((verificadata($scope.hidraulica.dia) == 3) && (verificahora($scope.hidraulica.horario) == 2 || verificahora($scope.hidraulica.horario) == 3)){
			mensagem("Insira uma hora válida", "Erro")
		} else {
			$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.hidraulica})
		    .then(function successCallback(response) {
		    	redirectSolicitacao('#HidraulicaModal');
		    }, function errorCallback(response) {
		    	
		    });
		}
	}	 
	
	//Solicitar Reparos 
	$scope.solicitarReparos = function(){
		$scope.reparo.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.reparo.categoria = "Reparo"
		
		if((verificadata($scope.reparo.dia) == 3) && (verificahora($scope.reparo.horario) == 2 || verificahora($scope.reparo.horario) == 3)){
			mensagem("Insira uma hora válida", "Erro")
		} else {			
			$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.reparo})
		    .then(function successCallback(response) {
		    	redirectSolicitacao('#ReparosModal');
		    }, function errorCallback(response) {
		    		    	
		    });
		}
	}	
	
	//Solicitar Acabamento 
	$scope.solicitarAcabamento = function(){
		$scope.acabamento.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.acabamento.categoria = "Acabamento"
		
		if((verificadata($scope.acabamento.dia) == 3) && (verificahora($scope.acabamento.horario) == 2 || verificahora($scope.acabamento.horario) == 3)){
			mensagem("Insira uma hora válida", "Erro")
		} else {	
			$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.acabamento})
		    .then(function successCallback(response) {
		    	redirectSolicitacao('#AcabamentoModal');
		    }, function errorCallback(response) {
		    	
		    });
		}
	}
	
	//Solicitar Eletricista 
	$scope.solicitarEletricista = function(){
		$scope.eletricista.cliente = {id: $rootScope.cliLogado.cliente.id};
		$scope.eletricista.categoria = "Eletricista"
		
		if((verificadata($scope.eletricista.dia) == 3) && (verificahora($scope.eletricista.horario) == 2 || verificahora($scope.eletricista.horario) == 3)){
			mensagem("Insira uma hora válida", "Erro")
		} else {		
			$http({method: 'POST',url: 'http://localhost:8080/solicitar/nova',data:$scope.eletricista})
		    .then(function successCallback(response) {
		    	redirectSolicitacao('#EletricistaModal');
		    }, function errorCallback(response) {
		    	
		    });
		}
	}	
	
	$scope.cancelarAlteracaoPrestador = function(){
		$scope.prestador = {}
	}
	
	 
	//Excluir Prestador
	//Ao chamar essa funcao, passar o valor como parametro para a exclusao 
	$scope.excluirSolicitacao= function(solicitacao){
	 $http({method: 'DELETE',url: 'http://localhost:8080/solicitar/excluir/' + solicitacao.id})
	    .then(function successCallback(response) {
	   	 pos = $scope.solicitacoes.indexOf(solicitacao)
	   	 $scope.solicitacoes.splice(pos, 1);
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
    	var localdate = ('0'+dNow.getDate()).slice(-2) + '/' + ('0' + (dNow.getMonth()+1)).slice(-2) + '/' + dNow.getFullYear();
    	return localdate;
    }
    
    function redirectSolicitacao(id) {
		$(id).modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
    	$location.path('/cliente/solicitacoes')
    }

    $("#HorarioHidraulica").mask("23:59", {
        placeholder: "__:__",
        selectOnFocus: true,
        clearIfNotMatch: true,
        translation: {
            2: {
                pattern: /[0-2]/
            },
            3: {
                pattern: /[0-9]/
            },
            5: {
                pattern: /[0-5]/
            },
            9: {
                pattern: /[0-9]/
            }
        }
    });    
   
    $("#HorarioReparos").mask("23:59", {
        placeholder: "__:__",
        selectOnFocus: true,
        clearIfNotMatch: true,
        translation: {
            2: {
                pattern: /[0-2]/
            },
            3: {
                pattern: /[0-9]/
            },
            5: {
                pattern: /[0-5]/
            },
            9: {
                pattern: /[0-9]/
            }
        }
    });
    
    $("#HorarioAcabamento").mask("23:59", {
        placeholder: "__:__",
        selectOnFocus: true,
        clearIfNotMatch: true,
        translation: {
            2: {
                pattern: /[0-2]/
            },
            3: {
                pattern: /[0-9]/
            },
            5: {
                pattern: /[0-5]/
            },
            9: {
                pattern: /[0-9]/
            }
        }
    });
    
    $("#HorarioEletricista").mask("23:59", {
        placeholder: "__:__",
        selectOnFocus: true,
        clearIfNotMatch: true,
        translation: {
            2: {
                pattern: /[0-2]/
            },
            3: {
                pattern: /[0-9]/
            },
            5: {
                pattern: /[0-5]/
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
        console.log(data)

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
    
    function verificahora(hora) {
        var horario = hora.substring(0, 2);
        var minutos = hora.substring(3, 5);
        console.log("A hora atual é: " + horario + ":" + minutos)

        var now = new Date();
        var hojeHora = now.getHours();
        var hojeMinutos = now.getMinutes();

        if (horario > 23 || minutos > 59) {
            return 2
        } else if (horario < hojeHora) {
            return 3
        } else if (horario == hojeHora) {
            return 4
        } else if ((horario == hojeHora) && (minutos < hojeMinutos)) {
            return 5
        } else if ((horario < hojeHora) || (minutos < hojeMinutos)) {
            return 6
        }
    }
    
})