var hagm = angular.module('hagmapp', []);
hagm.controller('grievanceController', function($scope, $http){
	$scope.hide = true;
	$scope.grievance = {};
	$scope.showAllGrievance = function(){
		$http.get('http://localhost:8080/HAGM_app/grievance/findAppealsByUser')
		.success(function(response){
			$scope.appeals = response.grievances;
		});
	}
	
	
	$scope.addGrievance = function(){
		$scope.show = true;
		$scope.hide = false;
		$scope.appeals = null;
	}
	
	$scope.trackGrievance = function(){
		$scope.show = false;
		$scope.hide = true;
		$scope.showAllGrievance();
	}
	
	$scope.submitForm = function() {
        $http.post({
        		method : 'POST', 
        		url : 'http://localhost:8080/HAGM_app/grievance/save', 
        		data : $scope.grievance,
        		headers : {'Content-Type':'application/x-www-form-urlencoded'}
        })
        .success(function(data, status) {
            $scope.appeal = data;
        });
    }  
	
});

    
	
	
