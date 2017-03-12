var app = angular.module("ControllerApp", ['ngRoute', 'ngCookies']);

app.controller("menuController", function($scope, $http, $location, $rootScope, $window, $cookies){
	$rootScope.activetab = "login";
})

app.controller("primeController", function($scope, $http, $location, $rootScope, $window, $cookies){
	
	$rootScope.activetab = "login";
	
	$scope.usuario = $cookies.get('Usuario');
	
	$scope.login = function(){
		
		if(($scope.username != null || $scope.username != '') &&
				$scope.password != null || $scope.password != ''){
			var user = {
				username: $scope.username,
				password: $scope.password
			};
			
			console.log(user);
			$http({
				method: 'POST',
				url: 'autcontroller.do',
				data : $.param(user),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(handleSuccess).error(
			handleError);
			
			function handleSuccess(data, status, headers,
					config) {
				
				console.log(data);
				$cookies.put('Usuario', data.nome);
				$cookies.put('email', data.email);
				$cookies.put('UserId', data.id);
				$cookies.put('objetivo', data.Objetivo);
				$cookies.put('peso', data.peso);
				
				sessionStorage.setItem("_u", JSON
						.stringify(data));
				
				var dt = new Date(data.dtCadastro);
				
				$cookies.put('dtCadastro', dt);
				$cookies.put('ultimoAcesso', data.ultimoAcesso);
				$cookies.put('altura', data.altura);
				
				sessionStorage.setItem("usuario", data.nome);
				
				$window.location.href = '#/home';
			}
			

			function handleError(data, status, headers,
					config) {
				var error = data.replace(/"/g, "");
				$scope.error = error;
				console.log(error);
			}
		}
		
		
	}
});

app.controller("homeController", function($scope, $http, $location, $rootScope, $cookies, $window){
	$scope.session = (sessionStorage.usuario);
	$scope.user = {};
	$scope.user = JSON.parse(sessionStorage._u);
	$scope.user.dtCadastro = new Date($scope.user.dtCadastro);
	$scope.user.ultimoAcesso = new Date();
	$scope.objetivo = $scope.user.objetivo;
	console.log($scope.user);
	if($scope.session == null){
		$window.location.href = '#/'
	}else{
		$rootScope.activetab = $location.path();
	}
	
	$scope.AlteraObjetivo = function(){
		$scope.datasource = 'editing';
	}
	
	$scope.cancel = function(){
		var user = JSON.parse(sessionStorage._u);
		$scope.objetivo = user.objetivo;
		$scope.datasource = 'active';
	}
	
	$scope.salvar = function(){
		this.$promise = $http({
			method: 'PUT',
			url: 'rest/usuario/alteraObj/'+$scope.user.id+'/'+$scope.objetivo,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(response){
			$scope.user.objetivo = $scope.objetivo;
			sessionStorage.setItem("_u", JSON
					.stringify($scope.user));
			$scope.datasource = 'active';
		}).error(function(response){
			var user = JSON.parse(sessionStorage._u);
			$scope.objetivo = user.objetivo;
			$scope.datasource = 'active';
			alert("Erro ao salvar");
		});
	
	}
	
	function clone(obj) {
	    var copy;

	    // Handle the 3 simple types, and null or undefined
	    if (null == obj || "object" != typeof obj) return obj;

	    // Handle Date
	    if (obj instanceof Date) {
	        copy = new Date();
	        copy.setTime(obj.getTime());
	        return copy;
	    }

	    // Handle Array
	    if (obj instanceof Array) {
	        copy = [];
	        for (var i = 0, len = obj.length; i < len; i++) {
	            copy[i] = clone(obj[i]);
	        }
	        return copy;
	    }

	    // Handle Object
	    if (obj instanceof Object) {
	        copy = {};
	        for (var attr in obj) {
	            if (obj.hasOwnProperty(attr)) copy[attr] = clone(obj[attr]);
	        }
	        return copy;
	    }

	    throw new Error("Unable to copy obj! Its type isn't supported.");
	}
});

app.controller("perfilController", function($scope, $location){
	$scope.perfil = JSON.parse($location.search().usuario);
	$scope.service = $location.search().service;
	
	console.log($scope.perfil);
});

app.controller("pesquisaController", function($scope, $http){
	$scope.personaList = {};
	
	$scope.pesquisa = " ";
	$scope.select = '1';
	$scope.personaList = [];
	
	$scope.pesquisar = function(){
		if($scope.select == '1'){
			this.$promise = $http({
				method: 'GET',
				url: 'rest/personal',
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data, status, headers, config){	
				$scope.personaList = data;
			}).error(function(data, status, headers, config){
				console.log("erro " + data);
			});
		}else{
			this.$promise = $http({
				method: 'GET',
				url: 'rest/Nutricionista',
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data, status, headers, config){
				$scope.personaList = data;
			}).error(function(data, status, headers, config){
				console.log("erro " + data);
			});
		}
	}
});