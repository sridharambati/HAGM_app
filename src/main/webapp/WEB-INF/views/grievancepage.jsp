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
	    	<div id="banner_content">
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
        
        <!-- <div class="section_w940" ng-hide="hide" ng-show="show"> -->
            
             <div style="width: 888px;" ng-hide="hide" ng-show="show">  
             <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Add New Appeal / Grievance </span></div>
              <div class="formcontainer">
                   <form ng-submit="submitGrievance()" name="grievanceForm" class="form-horizontal" method="post">
                     <!--  <input type="hidden" ng-model="user.id" />
                      <input type="hidden" ng-model="user.username" />
                      <input type="hidden" ng-model="user.emailAddress" /> -->
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="memberid">Member ID</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="grievance.memberId" id="memberid" class="username form-control input-sm" required />
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="ssn">SSN</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="grievance.memberSSN" id="ssn" class="form-control input-sm" required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="name">Member Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="grievance.memberName" id="name" class="form-control input-sm" required/>
                                  <!-- <div class="has-error" ng-show="provAppealForm.$dirty">
                                      <span ng-show="provAppealForm.email.$error.required">This is a required field</span>
                                      <span ng-show="provAppealForm.email.$invalid">This field is invalid </span>
                                  </div> -->
                              </div>
                          </div>
                      </div>
                       <!-- <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="reqType">Insurance Type</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="grievance.insuranceType" id="reqType" class="form-control input-sm" required/>
                              </div>
                          </div>
                      </div> -->
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="reqType">Request Type</label>
                              <div class="col-md-7">
                                  <select ng-model="grievance.requestType" id="reqType" class="form-control input-sm" required>
    								<option value="">
    								<option>Appeal</option>
    								<option>Grievance</option>
    								<option>Other</option>
 								 </select>
                                 <!--  <input type="text" ng-model="grievance.requestType" id="reqType" class="form-control input-sm" /> -->
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="date">Date</label>
                              <div class="col-md-7">
                                  <input type="date" ng-model="grievance.requestedDate" id="date" class="form-control input-sm" required/>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email Address</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="grievance.memberEmail" id="email" class="email form-control input-sm" required/>
                                  <!-- <div class="has-error" ng-show="provAppealForm.$dirty">
                                      <span ng-show="provAppealForm.email.$error.required">This is a required field</span>
                                      <span ng-show="provAppealForm.email.$invalid">This field is invalid </span>
                                  </div> -->
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="phone">Contact Phone</label>
                              <div class="col-md-7">
                                  <input type="number" maxlength="10" ng-model="grievance.memberPhone" id="phone" class="form-control input-sm" />
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="comments">Comments</label>
                              <div class="col-md-7">
                                  <textarea ng-model="grievance.grievanceComments" id="comments" class="form-control input-sm" required/></textarea>
                              </div>
                          </div>
                      </div>
						<!--   <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />-->
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"   value="Add" class="btn btn-primary btn-sm" >
                              <button type="button" ng-click="reset()" value="Reset" class="btn btn-warning btn-sm" >Reset Form</button>
                          </div>
                      </div>
                     <%-- <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /> --%>
                  </form>
              </div>
          </div>
          <div class="cleaner"></div>
        </div>
        <div class="section_w940">
            <div class="cleaner"></div>
        </div>
        
        <div class="panel panel-default" ng-hide="show" ng-show="hide">
		<!-- Default panel contents -->
	    <div class="panel-heading" ><span class="lead"> Appeals / Grievances </span></div>
		<div class="tablecontainer" >
			<table cellpadding="2" cellspacing="2" border="1" class="table table-striped table-bordered table-condensed table-hover">
				<tr>
					<th>Member ID</th>
					<th>Member SSN</th>
					<th>Member Name</th>
					<th>Member Email</th>
					<th>Grievance Type</th>
					<th>Date</th>
					<th>Phone</th>
					<th>Comments</th>
					<th>Status</th>
				</tr>
				<tr ng-repeat= "appeal in appeals">
					<td>{{appeal.memberId}}</td>
					<td>{{appeal.memberSSN}}</td>
					<td>{{appeal.memberName}}</td>
					<td>{{appeal.memberEmail}}</td>
					<td>{{appeal.requestType}}</td>
					<td>{{appeal.requestedDate}}</td>
					<td>{{appeal.memberPhone}}</td>
					<td>{{appeal.grievanceComments}}</td>
					<td>{{appeal.status}}</td>
					<!-- <input type="hidden" ng-model="appeal.user.id" />
                    <input type="hidden" ng-model="appeal.user.username" />
                    <input type="hidden" ng-model="appeal.user.emailAddress" /> -->
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