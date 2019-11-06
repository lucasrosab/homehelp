app.controller("LoginCtrl", function($scope, $rootScope, $http) {

    $scope.usuario = {}
    $rootScope.dadosUsuario = []
        //Retorna os dados solicitados com base nos parametros passados
    $scope.acessar = function() {
        $http({
            method: 'GET',
            url: '/login/' + $scope.usuario,
        }).then(function successCallback(response) {
            $rootScope.dadosUsuario = response.data
            console.log("Sucesso")
        }, function errorCallback(response) {
            console.log("Erro")
        });
    }

});