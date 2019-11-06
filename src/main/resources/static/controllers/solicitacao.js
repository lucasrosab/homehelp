app.controller("SolicitacaoCtrl", function($scope, $http) {

    $scope.solicitacao = {}
    $scope.solicitacoesCliente = []
    $scope.solicitacoesAtivas = []
    $scope.profissionalDisponivel = []

    //Solicitar Hidráulica
    $scope.solicitarHidraulica = function() {
        $scope.solicitacao.codCliente = "Lucas"
        $scope.solicitacao.codPrestador = "Matheus"

        $http({
            method: "POST",
            url: "/solicitacao",
            datatype: "json",
            data: JSON.stringify($scope.solicitacao)
        }).then(function mySuccess(response) {
            $scope.solicitacoesCliente = response.data;
            console.log("Salvou")
            $scope.solicitacao = {}
            window.location.href = '../../partes/cliente/conteudo/solicitacao/solicitacao.html'
        }, function myError(response) {
            $scope.prestadores = response.statusText;
        });
    }

    //Solicitar Reparo
    $scope.solicitarReparos = function() {
        $scope.solicitacao.codCliente = "Lucas"
        $scope.solicitacao.codPrestador = "Matheus"

        $http({
            method: "POST",
            url: "/solicitacao",
            datatype: "json",
            data: JSON.stringify($scope.solicitacao)
        }).then(function mySuccess(response) {
            $scope.solicitacoesCliente = response.data;
            console.log("Salvou")
            $scope.solicitacao = {}
            window.location.href = '../../partes/cliente/conteudo/solicitacao/solicitacao.html'
        }, function myError(response) {
            $scope.prestadores = response.statusText;
        });
    }



    //Solicitações criadas pelo usuário
    function minhasSolicitacoes() {
        $http({
            method: 'GET',
            url: '/solicitacao/cliente/' + 1,
        }).then(function successCallback(response) {
            $scope.solicitacoesCliente = response.data
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    //Solicitações disponível para o profissional	
    function profissionalDisponivel() {
        $http({
            method: 'GET',
            url: '/prestador/ativo',
        }).then(function successCallback(response) {
            $scope.profissionalDisponivel = response.data
            console.log($scope.profissionalDisponivel)
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

    profissionalDisponivel();

    function solicitacaoDisponivel() {
        $http({
            method: 'GET',
            url: '/solicitacao/ativa',
        }).then(function successCallback(response) {
            $scope.solicitacoesCliente = response.data
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    }

});