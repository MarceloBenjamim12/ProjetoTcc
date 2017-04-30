var app = angular.module("myApp", ['ngRoute', 'ngCookies', 'ControllerApp', 'controllerService']);

app.config(function($routeProvider, $locationProvider) {	
	
	$routeProvider
	.when('/home', {
        templateUrl: "views/homePage.html",
        controller: "homeController"
    })
    .when('/', {
	    templateUrl: "views/login.html",
	    controller : "primeController"
    })
    .when('/menu', {
	    templateUrl: "views/menu.html",
	    controller : "menuController"
    })  
    .when('/search', {
	    templateUrl: "views/pesquisar.html",
	    controller : "pesquisaController"
    })  
    .when('/perfil', {
	    templateUrl: "views/perfil.html",
	    controller : "perfilController"
    })
    .when('/chat', {
	    templateUrl: "views/chat.html"
    }) 
    .when('/planos', {
	    templateUrl: "views/planos.html"
    })
    .otherwise({
    	redirectTo : '/'
    });
 });