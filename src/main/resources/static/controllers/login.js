app.controller("LoginCtrl", function($scope, $rootScope, $http) {

    $scope.usuario = {}
    $rootScope.dadosUsuario = []
        //Retorna os dados solicitados com base nos parametros passados
    $scope.acessar = function() {
    	$http({
            method: 'GET',
            url: '/login?email=' + $scope.usuario.email + '&senha=' + $scope.usuario.senha,
        }).then(function successCallback(response) {
            $rootScope.dadosUsuario = response.data  
            if ($rootScope.dadosUsuario.length == 0) {
            	console.log("Errou")
            	window.location.href = '../../partes/cliente/index.html'
            } else {
            	console.log("Teste")
            }
        }, function errorCallback(response) {
            console.log("Erro")
        });
    }

});