var app = angular.module("controllerService", []);

app.service('useRest', function($http){
	
	this.GetMethod = function(url, callback){
		$http({
			method: 'GET',
			url: url,
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(response){
		   callback(response, true);
	    })
	    .error(function(response){
	      callback(response, false);
	    });
	}
	
	this.PostMethod = function(url, entity, callback){
		console.log(entity);
		$http({
			method: 'POST',
			url: url,
			data: angular.toJson(entity),
			headers: {
		        'Content-Type': 'application/json'
		    }
		}).success(function(response){
		   callback(response, true);
	    })
	    .error(function(response){
	      callback(response, false);
	    });
	}
})