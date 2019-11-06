app.controller("LoginCtrl", function($scope, $rootScope, $http) {

    $scope.usuario = {}
    $rootScope.dadosUsuario = []
        //Retorna os dados solicitados com base nos parametros passados
    $scope.acessar = function() {
        console.log($scope.usuario)
        console.log($scope.usuario.email)
        console.log($scope.usuario.senha)

    	$http({
            method: 'GET',
            url: '/login?email=' + $scope.usuario.email + '&senha=' + $scope.usuario.senha,
        }).then(function successCallback(response) {
            $rootScope.dadosUsuario = response.data
            console.log($rootScope.dadosUsuario)
        }, function errorCallback(response) {
            console.log("Erro")
        });
    }

});