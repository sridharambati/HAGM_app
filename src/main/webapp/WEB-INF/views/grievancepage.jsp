<!DOCTYPE html>
<html ng-app="hagmapp" >
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="./static/css/app.css" rel="stylesheet"></link>
<link href="./static/css/page_style.css" rel="stylesheet" />
</head>
<body ng-app="hagmapp" class="ng-cloak">
<div class="generic-container" ng-controller="grievanceController">
	<!-- <div id="templatemo_banner_wrapper"> -->
	    <div id="templatemo_banner">
	    	<div id="banner_content" >
				<table width="100%" border="0" celpadding="0" cellspacing="0">
					<tr>
						<td width="50%"  align="left"><img height="105" src="./static/images/help.png"/></td>
	                            <td align="right"><img height="100" src="./static/images/home.png"/></td>
					<tr>
				</table>
			</div>
		</div> <!-- end of templatemo_banner -->
	<!--</div>  end of templatemo_banner_wrapper -->
 	<!-- <div id="templatemo_menu_wrapper">
        <div id="templatemo_menu">
            <ul>
                <li><a href="logout" id="home" class="modalInput" rel="#showprocessor"><span></span>Home</a></li>
                <li><a href="index"  id="grievance" class="modalInput current" rel="#showprocessor"><span></span>Grievance</a></li>
                <li><a href="index" id="track" class="modalInput" rel="#showprocessor"><span></span>Track</a></li>
            </ul>

        </div>
    </div> -->
    
    <div id="templatemo_content">
        <div class="section_w940">
            <div class="product_box margin_r_20">
                <img src="./static/images/grievp.png" /><h2 >Grievance</h2>
                <p>Add new grievance or view the current status of the grievances that have been submitted.</p>
                <div class="cleaner"></div>
            </div>
            <div class="product_box">
                <h2>Login Information</h2>
                <p>User ID: skysol</p>
                <p>Profile: Contract Holder</p>
                <div class="cleaner"></div>
            </div>
        </div>
        
         <div class="section_w940">
         <table>
         	<tr>
         		<td colspan="2">
         			<h3>&nbsp;<img src="./static/images/add.gif" ng-click="addGrievance()" style="cursor: hand" />&nbsp;Click to add new grievance</h3>
         		</td>
         		<td colspan="2">&nbsp;</td>
         		<td colspan="2">&nbsp;</td>
         		<td >
         			<h3>&nbsp;<img src="./static/images/add.gif" ng-click="trackGrievance()" style="cursor: hand" />&nbsp;Click to track All grievance</h3>
         		</td>
         	</tr>
         </table>
            <div class="cleaner"></div>
        </div>
        <div class="section_w940">
            <div class="cleaner"></div>
        </div>
        
        <div class="section_w940" ng-hide="hide" ng-show="show">
            
             <!-- <div style="width: 848px;" >  -->
             <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Add New Appeal / Grievance </span></div>
              <div class="formcontainer">
                   <form action="./grievance/save" method="post" modelAttribute="grievance" class="form-horizontal"> 
                  <!-- <form name="grivanceForm" ng-submit="submitForm()" class="form-horizontal">-->
                      <input type="hidden" ng-model="user.id" />
                      <input type="hidden" ng-model="user.username" />
                      <input type="hidden" ng-model="user.emailAddress" />
                      <!-- <div ng-controller = "appealController">
                      	<table>
                      		<tr>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Member ID</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.memberId" id="memberId" placeholder="Enter Member ID" required ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Member SSN</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.memberSSN" id="memberSSN" ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      		</tr>
                      		<tr>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Member Name</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.memberName" id="memberName" ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Insurance Type</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.insuranceType" id="insuranceType" ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      		</tr>
                      		<tr>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Grievance Type</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.grievanceType" id="grievanceType" ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      			<td>
	                          		<div class="form-group col-md-12">
		                              	<label class="col-md-2 control-lable" >Date</label>
		                              	<div class="col-md-7">
		                                  <input type="text" ng-model="grievance.requestedDate" id="requestedDate" ng-minlength="3"/>
		                              	</div>
	                          		</div>
                      			</td>
                      		</tr>
                      	</table>
                      </div> -->
						<table>
                      		<tr>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Member ID</label></td>
		                              	<td>
		                                  <input type="text" name="memberId" id="memberId" />
                      			</td>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Member SSN</label> </td>
		                                 <td> <input type="text" name="memberSSN" id="memberSSN" />
                      			</td>
                      		</tr>
                      		<tr>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Member Name</label></td>
		                                 <td> <input type="text" name="memberName" id="memberName" />
                      			</td>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Insurance Type</label></td>
		                                <td> <input type="text" name="insuranceType" id="insuranceType" />
                      			</td>
                      		</tr>
                      		<tr>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Grievance Type</label></td>
		                                 <td> <input type="text" name="grievanceType" id="grievanceType" />
                      			</td>
                      			<td>
		                              	<label class="col-md-2 control-lable" >Date</label></td>
		                                 <td> <input type="text" name="requestedDate" id="requestedDate" />
                      			</td>
                      		</tr>
                      	</table>
                      <div class="row">
                          <div class="form-actions center">
                              <input type="submit"  class="btn btn-primary btn-sm">
                          </div>
                      </div>
                      <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
							
                  </form>
              </div>
          </div>
          <div class="cleaner"></div>
        </div>
        <div class="section_w940">
            <div class="cleaner"></div>
        </div>
        
        <div class="panel panel-default">
		<!-- Default panel contents -->
	    <div class="panel-heading"><span class="lead"> Appeals / Grievances </span></div>
		<div class="tablecontainer">
			<table cellpadding="2" cellspacing="2" border="1" class="table table-striped table-bordered table-condensed table-hover">
				<tr>
					<th>Member ID</th>
					<th>Member SSN</th>
					<th>Member Name</th>
					<th>Insurance Type</th>
					<th>Grievance Type</th>
					<th>Date</th>
					<th>Status</th>
				</tr>
				<tr ng-repeat= "appeal in appeals">
					<td>{{appeal.memberId}}</td>
					<td>{{appeal.memberSSN}}</td>
					<td>{{appeal.memberName}}</td>
					<td>{{appeal.insuranceType}}</td>
					<td>{{appeal.grievanceType}}</td>
					<td>{{appeal.requestedDate}}</td>
					<td>{{appeal.status}}</td>
					<input type="hidden" ng-model="appeal.user.id" />
                    <input type="hidden" ng-model="appeal.user.username" />
                    <input type="hidden" ng-model="appeal.user.emailAddress" />
				</tr>
			</table>
		</div>
	</div>

    </div>
    <div id="templatemo_footer">  
        Copyright © 2010 <a href="./logout">grievance</a> | Development
	</div> <!-- end of footer -->	
	
</div>


 	

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="./static/js/controller/grievancecontroller.js"></script>
</body>
</html>