app.controller("CadastroClienteCtrl", function($scope, $http) {

    $scope.cliente = {}
    $scope.clientes = []
    $scope.clienteDetalhado = []

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
            $scope.cliente = {}
        });
    };

    function exibirPessoa() {
        $http({
            method: 'GET',
            url: '/cliente',
        }).then(function successCallback(response) {
            $scope.clientes = response.data
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    exibirPessoa();


    function detalhar() {
        $http({
            method: 'GET',
            url: '/cliente/' + 1,
        }).then(function successCallback(response) {
            $scope.clienteDetalhado = response.data
            console.log($scope.clienteDetalhado)
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    detalhar()

});