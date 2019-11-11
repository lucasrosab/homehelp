app.controller("CadastroPrestadorCtrl", function($scope, $http) {

    $scope.prestador = {}
    $scope.prestadores = []
    $scope.prestadorDetalhado = []
    $scope.atualizarDados = {}
    $scope.atualizarLogin = {}
    
    //Função para carregar o tipo de mensagem ao cadastrar
    function mensagem(mensagem, status) {
        $scope.mensagem = mensagem
        $scope.status = status
        $('.toast').toast({ delay: 3000 });
        $('.toast').toast('show');
    }

    //Cadastrar Prestador
    $scope.cadastrar = function() {

        $http({
            method: "POST",
            url: "/prestador",
            datatype: "json",
            data: JSON.stringify($scope.prestador)
        }).then(function mySuccess(response) {
            $scope.prestadores = response.data;
            $scope.prestador = {}
            mensagem("Cadastrado com Sucesso", "Sucesso")
            window.location.href = '../../partes/prestador/index.html'
        }, function myError(response) {
            mensagem("Preencha todos os campos", "Erro")
            $scope.prestador = {}
        });
    };
    
    //Exibe todos os prestadores cadastrados
    function exibir() {
        $http({
            method: 'GET',
            url: '/prestador',
        }).then(function successCallback(response) {
            $scope.prestadores = response.data
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    exibir();
    
    //Carrega todos os dados do prestador logado
    function detalhar() {
        $http({
            method: 'GET',
            url: '/prestador/' + 1,
        }).then(function successCallback(response) {
            $scope.prestadorDetalhado = response.data
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    detalhar()
    
    //Atualizar os dados pessoais do prestador "logado"
    $scope.atualizarDadosPessoais = function() {

        $http({
            method: "PUT",
            url: "/prestador/pres/dados/"+ 1,
            datatype: "json",
            data: JSON.stringify($scope.atualizarDados)
        }).then(function mySuccess(response) {
            $scope.atualizarDados = response.data;
            $scope.atualizarDados = {}
            detalhar()
        }, function myError(response) {
        	console.log("Erro")
        });
    };
    
    //Atualizar os dados pessoais do prestador "logado"
    $scope.atualizarDadosLogin = function() {

        $http({
            method: "PUT",
            url: "/prestador/pres/login/"+ 1,
            datatype: "json",
            data: JSON.stringify($scope.atualizarLogin)
        }).then(function mySuccess(response) {
            $scope.atualizarLogin = response.data;
            $scope.atualizarLogin = {}
            detalhar()
        }, function myError(response) {
        	console.log("Erro")
        });
    };
    
    
    
    

});