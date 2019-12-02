app.config(function($routeProvider,$locationProvider) {
	
	$routeProvider
	//Página Inicial
	.when("/", {templateUrl : 'view/conteudo.html', controller: 'MainController'})

	//Cadastro
	.when("/cadastro/opcao", {templateUrl : 'view/cadastro/opcao.html'})
	.when("/cadastro/prestador", {templateUrl : 'view/cadastro/prestador.html', controller: 'PrestadorController'})
	.when("/cadastro/cliente", {templateUrl : 'view/cadastro/cliente.html', controller: 'ClienteController'})
	.when("/cadastro/administrador", {templateUrl : 'view/cadastro/administrador.html', controller: 'AdministradorController'})
	
	//Cliente
	.when("/login/cliente", {templateUrl : 'view/cliente/login.html', controller: 'LoginController'})
	.when("/recuperar-cliente", {templateUrl : 'view/cliente/reset.html'})
	.when("/cliente/inicio", {templateUrl : 'view/cliente/index.html', controller: 'SolicitacaoController'})
	.when("/cliente/dados-pessoais", {templateUrl : 'view/cliente/conteudo/dados-pessoais.html', controller: 'ClienteController'})
	.when("/cliente/configuracao", {templateUrl : 'view/cliente/conteudo/configuracao.html', controller: 'ClienteController'})
	.when("/cliente/solicitacoes", {templateUrl : 'view/cliente/conteudo/solicitacao.html', controller: 'SolicitacaoController'})

	//Prestador
	.when("/login/prestador", {templateUrl : 'view/prestador/login.html', controller: 'LoginController'})
	.when("/recuperar-prestador", {templateUrl : 'view/prestador/reset.html'})
	.when("/prestador/inicio", {templateUrl : 'view/prestador/index.html', controller: 'DemandaController'})
	.when("/prestador/dados-pessoais", {templateUrl : 'view/prestador/conteudo/dados-pessoais.html', controller: 'PrestadorController'})
	.when("/prestador/banco", {templateUrl : 'view/prestador/conteudo/banco.html', controller: 'ContaController'})
	.when("/prestador/profissional", {templateUrl : 'view/prestador/conteudo/profissional.html'})
	.when("/prestador/configuracao", {templateUrl : 'view/prestador/conteudo/configuracao.html'})
	.when("/prestador/reparos", {templateUrl : 'view/prestador/conteudo/reparos.html', controller: 'DemandaController'})
	
	//Administrador
	.when("/login/administrador", {templateUrl : 'view/administrador/login.html', controller: 'LoginController'})
	.when("/administrador/inicio", {templateUrl : 'view/administrador/index.html', controller: 'AdministradorController'})
	.when("/administrador/dados-pessoais", {templateUrl : 'view/administrador/dados-pessoais.html', controller: 'AdministradorController'})
	.when("/administrador/cliente", {templateUrl : 'view/administrador/dados-pessoais.html', controller: 'ClienteController'})
	.when("/administrador/prestador", {templateUrl : 'view/administrador/dados-pessoais.html', controller: 'PrestadorController'})
	
	.otherwise({redirectTo: "/"})
	  
	$locationProvider.html5Mode(true);
});