var hagm = angular.module('hagmapp', []);
hagm.controller('grievanceController', function($scope, $http){
	$http.get('http://localhost:8080/HAGM_app/grievance/findAppealsByUser')
		.success(function(response){
			$scope.appeals = response.grievances;
//			$scope.user = grievances[0].user;
	});
	
});