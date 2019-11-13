app.controller("LoginCtrl", function($scope, $rootScope, $http) {

    $scope.usuario = {}
    $rootScope.dadosUsuario = []
        //Retorna os dados solicitados com base nos parametros passados
    $scope.acessar = function() {
    	$http({
            method: 'GET',
            url: '/login?email=' + $scope.usuario.email + '&senha=' + $scope.usuario.senha,
        }).then(function successCallback(response) {
            $scope.usuarioLogin = response.data
        	var teste = $scope.usuarioLogin  
            if ($scope.usuarioLogin.length == 0) {
            	console.log("Errou")
            } else {
            	console.log("Teste")
            	//window.location.href = '../../partes/cliente/index.html'
            }
            console.log($rootScope.dadosUsuario)
        }, function errorCallback(response) {
            console.log("Erro")
        });
    }
    
});