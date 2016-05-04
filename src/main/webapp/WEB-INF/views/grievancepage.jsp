<!DOCTYPE html>
<html ng-app="hagmapp" >
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="../static/css/app.css" rel="stylesheet"></link>
<link href="../static/css/page_style.css" rel="stylesheet" />
</head>
<body ng-app="hagmapp" class="ng-cloak">
<div class="generic-container" ng-controller="grievanceController">
	<div id="templatemo_banner_wrapper">
		
	    <div id="templatemo_banner">
	    
	    	<div id="banner_content" >
				<table width="100%" border="0" celpadding="0" cellspacing="0">
					<tr>
						<td width="50%"  align="left"><img height="105" src="../static/images/help.png"/></td>
	                            <td align="right"><img height="100" src="../static/images/home.png"/></td>
					<tr>
				</table>
			
			
		</div>
	</div> <!-- end of templatemo_banner -->
	</div> <!-- end of templatemo_banner_wrapper -->
 	<div id="templatemo_menu_wrapper">
        <div id="templatemo_menu">
            <ul>
                <li><a href="logout" id="home" class="modalInput" rel="#showprocessor"><span></span>Home</a></li>
                <li><a href="index"  id="grievance" class="modalInput current" rel="#showprocessor"><span></span>Grievance</a></li>
                <li><a href="index" id="track" class="modalInput" rel="#showprocessor"><span></span>Track</a></li>
            </ul>

        </div>
    </div>
    
    <div id="templatemo_content">
        <div class="section_w940">
            <div class="product_box margin_r_20">
                <img src="../static/images/grievp.png" /><h2 >Grievance</h2>
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
        <div class="section_w940" ng-hide="true">

            <div style="width: 848px;"> 
             <!-- <div style="width: 848px;" >  -->
             <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Add New Appeal / Grievance </span></div>
              <div class="formcontainer">
                  <form ng-submit="submit()" name="provAppealForm" class="form-horizontal">
                      <input type="hidden" ng-model="user.id" />
                      <input type="hidden" ng-model="user.username" />
                      <input type="hidden" ng-model="user.emailAddress" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="provAppealForm.$dirty">
                                      <span ng-show="provAppealForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="provAppealForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="provAppealForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="user.address" id="address" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="provAppealForm.$dirty">
                                      <span ng-show="provAppealForm.email.$error.required">This is a required field</span>
                                      <span ng-show="provAppealForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="provAppealForm.$invalid">
                              <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="provAppealForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
            	
                
                <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
        </div>
        <div class="section_w940">
            <div class="cleaner"></div>
        </div>

    </div>
    
	<div class="panel panel-default">
		<!-- Default panel contents -->
	    <div class="panel-heading"><span class="lead"> Appeals / Grievances </span></div>
		<div class="tablecontainer">
			<table cellpadding="2" cellspacing="2" border="1" class="table table-hover">
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
 	

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="../static/js/controller/grievancecontroller.js"></script>
</body>
</html>