app.config(function($routeProvider,$locationProvider) {
	
	$routeProvider
	//Página Inicial
	.when("/", {templateUrl : 'view/conteudo.html', controller: 'MainController'})

	//Cadastro
	.when("/cadastro/opcao", {templateUrl : 'view/cadastro/opcao.html'})
	.when("/cadastro/prestador", {templateUrl : 'view/cadastro/prestador.html', controller: 'PrestadorController'})
	.when("/cadastro/cliente", {templateUrl : 'view/cadastro/cliente.html', controller: 'ClienteController'})
	//Cliente
	.when("/login/cliente", {templateUrl : 'view/cliente/login.html'})
	.when("/recuperar-cliente", {templateUrl : 'view/cliente/reset.html'})
	
	
	.when("/cliente/inicio", {templateUrl : 'view/cliente/index.html', controller: 'SolicitacaoController'})
	.when("/cliente/dados-pessoais", {templateUrl : 'view/cliente/conteudo/dados-pessoais.html', controller: 'ClienteController'})
	.when("/cliente/pagamento", {templateUrl : 'view/cliente/conteudo/pagamento.html'})
	.when("/cliente/configuracao", {templateUrl : 'view/cliente/conteudo/configuracao.html'})
	.when("/cliente/solicitacoes", {templateUrl : 'view/cliente/conteudo/solicitacao.html'})

	//Prestador
	.when("/recuperar-prestador", {templateUrl : 'view/prestador/reset.html'})
	.when("/login/prestador", {templateUrl : 'view/prestador/login.html'})
	.when("/prestador/inicio", {templateUrl : 'view/prestador/index.html'})
	.when("/prestador/dados-pessoais", {templateUrl : 'view/prestador/conteudo/dados-pessoais.html'})
	.when("/prestador/banco", {templateUrl : 'view/prestador/conteudo/banco.html'})
	.when("/prestador/profissional", {templateUrl : 'view/prestador/conteudo/profissional.html'})
	.when("/prestador/configuracao", {templateUrl : 'view/prestador/conteudo/configuracao.html'})
	.when("/prestador/reparos", {templateUrl : 'view/prestador/conteudo/reparos.html'})
	//Administrador
	.when("/administrador/inicio", {templateUrl : 'view/administrador/index.html'})
	
	.otherwise({redirectTo: "/"})
	  
	$locationProvider.html5Mode(true);
});