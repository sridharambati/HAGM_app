var hagm = angular.module('hagmapp', []);
hagm.controller('grievanceController', function($scope, $http){
	$scope.hide = true;
	$scope.show = true;
	//$scope.grievance = {};
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
	
	$scope.reset=function(){
		$scope.grievance={};
	}
	
	$scope.submitGrievance=function(){
		//console.log("entered into ajngular controller");
		//console.log(" member Id - "+$scope.grievance.memberId);
		 $http.post('http://localhost:8080/HAGM_app/grievance/saveGrievance',$scope.grievance)
		 .success(function(response){
			alert("Grievance Submitted Successfully!!");
			$scope.reset();
		 });
	};
	
});

    
	
	
