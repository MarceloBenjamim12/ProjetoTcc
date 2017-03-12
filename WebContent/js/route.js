var app = angular.module("myApp", ['ngRoute', 'ngCookies', 'ControllerApp']);

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
    .otherwise({
    	redirectTo : '/'
    });
 });