var hagm = angular.module('hagmapp', []);
hagm.controller('userController', function($scope, $http){
	$http.get('http://localhost:8080/HAGM_app/findAllUsers')
		.success(function(response){
			$scope.users = response;
	});
	
});