<html lang="en" ng-app>
<head>
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
    
    <style type="text/css">
    
        #submit{
            
            text-align: center;
        }
        #track{
            
            text-align: center;
        
        }
        
    
    </style>
    </head>
    <body>
    <div>
    <form action="/grievance" method="post" class="form-horizontal">
     <div ng-controller="myController">
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
             <tr>
         
     <td width="50%" align="left"><img src="/static/images/left%20picture.png" style="height:200px; width:150px";/></td>
                 
    <td align="right"><img src="/static/images/Right%20picture.png" style="height:200px; width:150px";/></td>
        </tr>
        </table>
        </div>
        
    <div id="menu">
            <table id="list" align="center" >
               <tr>
                <li>
                    <div> 
                    <td> HOME </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td> GRIEVANCE</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td> TRACKING </td>
                        </div>
                </li>
                </tr>
                 </table>
            </div>
                
            <div id = "welcome" >
                <h2> Welcome John David </h2>
                </div>

                <div id="submit" ng-controller="myController" >
                    <h3> Submit for Grievance </h3>
                    <img src="/static/images/submit.png"/> 
                <p> submit for a new grievance</p> 
                    <img src="/static/images/start.png"/>
                <div class="form-actions">
								<input type="button" name="submit"
									class="btn btn-block btn-primary btn-default" value="Submit">
							</div>
                </div>
                <div id="track" ng-controller="myController">
                    <h3> Track Grievance</h3>
                    <img src="/static/images/notes.png"/>
                    <p> View the Grievance list</p>
                    <img src="/static/images/track.png"/>
                    <div class="form-actions">
								<input type="button" name="submit"
									class="btn btn-block btn-primary btn-default" value="Track">
							</div>
                </div>
                </form>
            </div>
        
    </body>
</html>