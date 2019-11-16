app.controller("MainController", function($scope, $location){
	
	$scope.loginPrestador = function(){
		$('#TipoLoginModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		
		$location.path('/login/prestador')
	}
	
	$scope.loginCliente = function(){
		$('#TipoLoginModal').modal('hide')
	    $('body').removeClass('modal-open');
		$('.modal-backdrop').remove(); 
		$location.path('/login/cliente')
	}
})