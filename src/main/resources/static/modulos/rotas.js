app.config(function($routeProvider,$locationProvider) {
	
	$routeProvider
	//Página Inicial
	.when("/", {templateUrl : 'view/conteudo.html'})
	//Login
	.when("/login", {templateUrl : 'view/login.html'})
	.when("/recuperar-login", {templateUrl : 'view/reset.html'})
	//Cadastro
	.when("/cadastro/opcao", {templateUrl : 'view/cadastro/opcao.html'})
	.when("/cadastro/prestador", {templateUrl : 'view/cadastro/prestador.html', controller: 'PrestadorController'})
	.when("/cadastro/cliente", {templateUrl : 'view/cadastro/cliente.html', controller: 'ClienteController'})
	//Cliente
	.when("/cliente/inicio", {templateUrl : 'view/cliente/index.html'})
	.when("/cliente/dados-pessoais", {templateUrl : 'view/cliente/conteudo/dados-pessoais.html', controller: 'ClienteController'})
	.when("/cliente/pagamento", {templateUrl : 'view/cliente/conteudo/pagamento.html'})
	.when("/cliente/configuracao", {templateUrl : 'view/cliente/conteudo/configuracao.html'})
	.when("/cliente/solicitacoes", {templateUrl : 'view/cliente/conteudo/solicitacao.html'})
	//Prestador
	.when("/prestador/inicio", {templateUrl : 'view/prestador/index.html'})
	.when("/prestador/dados-pessoais", {templateUrl : 'view/prestador/conteudo/pessoal/dados.html'})
	.when("/prestador/profissional", {templateUrl : 'view/prestador/conteudo/profissional/profissional.html'})
	.when("/prestador/reparos", {templateUrl : 'view/prestador/conteudo/reparos/reparos.html'})
	//Administrador
	.when("/administrador/inicio", {templateUrl : 'view/administrador/index.html'})
	
	.otherwise({redirectTo: "/"})
	  
	$locationProvider.html5Mode(true);
});