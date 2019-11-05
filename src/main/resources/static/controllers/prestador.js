app.controller("CadastroPrestadorCtrl", function($scope, $http) {

    $scope.prestador = {}
    $scope.prestadores = []
    $scope.prestadorDetalhado = []

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

});