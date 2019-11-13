app.controller("CadastroClienteCtrl", function($scope, $rootScope, $http) {

    $scope.cliente = {}
    $scope.clientes = []
    $scope.clienteDetalhado = []
    $scope.atualizaCliente = {}
    $scope.atualizaLogin = {}
    
    console.log($rootScope.dadosUsuario)
    
    //Função para carregar o tipo de mensagem ao cadastrar
    function mensagem(mensagem, status) {
        $scope.mensagem = mensagem
        $scope.status = status
        $('.toast').toast({ delay: 3000 });
        $('.toast').toast('show');
    }

    //Cadastrar o Cliente
    $scope.cadastrar = function() {
        $http({
            method: "POST",
            url: "/cliente",
            datatype: "json",
            data: JSON.stringify($scope.cliente)
        }).then(function mySuccess(response) {
            $scope.clientes = response.data;
            mensagem("Cadastrado com Sucesso", "Sucesso")
            window.location.href = '../../partes/cliente/index.html'
        }, function myError(response) {
            mensagem("Preencha todos os campos", "Erro")
        });
    };

    //Carrega todos os clientes
    function exibirPessoa() {
        $http({
            method: 'GET',
            url: '/cliente',
        }).then(function successCallback(response) {
            $scope.clientes = response.data
        }, function errorCallback(response) {

        });
    }

    exibirPessoa();
    
    //Exibe todos os dados do cliente "Logado"
    function detalhar() {
        $http({
            method: 'GET',
            url: '/cliente/' + 1,
        }).then(function successCallback(response) {
            $scope.clienteDetalhado = response.data
        }, function errorCallback(response) {
        	
        });
    }

    detalhar()
    
    //Atualiza os dados da aba Dados Pessoais do cliente
    $scope.editarDadosPessoais = function(){
        $http({
            method: "PUT",
            url: "/cliente/cli/dados/"+ 1,
            datatype: "json",
            data: JSON.stringify($scope.atualizaCliente)
        }).then(function mySuccess(response) {
            $scope.atualizaCliente = response.data;
            $scope.atualizaCliente = {}
            detalhar()
        }, function myError(response) {
            
        });
    }
    
    //Atualiza os dados da aba Dados Pessoais do cliente
    $scope.editarLogin = function(){
        $http({
            method: "PUT",
            url: "/cliente/cli/login/"+ 1,
            datatype: "json",
            data: JSON.stringify($scope.atualizaLogin)
        }).then(function mySuccess(response) {
            $scope.atualizaLogin = response.data;
            $scope.atualizaLogin = {}
            detalhar()
        }, function myError(response) {
            
        });
    }
});