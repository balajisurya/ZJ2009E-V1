<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet"> 
<link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
<!-- //font-awesome icons -->
 <!-- js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
<!-- Metis Menu -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">

<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">

<!-- chart -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
 
 
  <script src="${pageContext.request.contextPath}/resources/themes/script/staffprofile.js"></script>
<!-- //chart -->
<style type="text/css">

.ui-datepicker-calendar {
    display: none;
    }

.chart-legend li span{
    display: inline-block;
    width: 12px;
    height: 12px;
    margin-right: 5px;
}
</style>
<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">View Staff Details</h3>
		<div class="main-page charts-page">
		<div id="ListDiv" style="display:block;">
		  
                       
              <form class="form-horizontal" id="getDetails">
                 
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Enter Staff Id</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="getStaffId" name="getStaffId" placeholder="">
                                 </div>
                              </div>
                           
                             <div class="row">
                                 <div class="col-sm-offset-3">
                              
                                     <button style="float:right"  type="button" id="getStaffProfile" class="btn btn-success">Get Details</button>
                                                                     </div>
                              </div>
              </form>
              <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  
                     </div>
						 <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to delete this Action ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						
                     
                     
                     
                     
                  </div>
                  
                    <!--   <div id="OpenFormDiv" style="display:block;">
                         
                     </div> -->
                  
       <div id="OpenFormDiv" style="display:block;">
			       <%--  <div class="col-xs-12 col-md-2" style="display:none;" id="staffImage">
                           
                               <img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/themes/images/staff.jpg" alt=""> 
                           
                          </div>
                  <div class="col-xs-12 col-md-10">
                     <div class="table-responsive ">
                        <div id="table">
                      
                        </div>
                     </div>
                  </div>  
                --%>
			                 
                  <div class="col-xs-12 col-md-2">
                   
                        <img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/themes/images/staff.jpg" alt=""> 
                     
                  </div>
                  <div class="col-xs-12 col-md-10">
                     <div class="table-responsive">
                        <table class="table table-bordered">
                           <tbody >
                              <tr>
                                 <th class="success"scope="row">Staff ID</th>
                                 <td>CS125</td>
                                 <th class="success"scope="row">Date of Birth</th>
                                 <td>06-06-1994</td>
                              </tr>
                              <tr >
                                 <th class="info" scope="row">Staff Name</th>
                                 <td><span>C Smitha</span></td>
                                 <th class="info" scope="row">Joining Date</th>
                                 <td>16-05-2016</td>
                              </tr>
                              <tr >
                                 <th class="danger" scope="row">User ID</th>
                                 <td>smitha@jdsoft.in</td>
                                 <th class="danger" scope="row">Total Experience</th>
                                 <td>1 month</td>
                              </tr>
                              <tr >
                                 <th class="info" scope="row">Designation</th>
                                 <td>Head of Department</td>
                                 <th class="info" scope="row">Mobile No</th>
                                 <td>987654321</td>
                              </tr>
                              <tr >
                                 <th  class="warning" scope="row">Department</th>
                                 <td>Electronics and Communication</td>
                                 <th  class="warning" scope="row">Email ID</th>
                                 <td>smitha@gmail.com</td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <div class="form-three widget-shadow">
                     <ul id="myTabs" class="nav nav-tabs" role="tablist">
                     <li role="presentation" class="active">
                           <a href="#performance" role="tab" id="performance-tab" data-toggle="tab" aria-controls="performance" aria-expanded="true">Performance</a>
                        </li>
                       <li role="presentation">
                           <a href="#attendance" role="tab" id="attendance-tab" data-toggle="tab" aria-controls="attendance" aria-expanded="false">Attendance</a>
                        </li>
                        <li role="presentation" class="dropdown">
                           <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents" aria-expanded="false">Time Table<span class="caret"></span></a> 
                           <ul class="dropdown-menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
                              <li class=""><a href="#dropdown1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1" aria-expanded="false">Daily</a></li>
                              <li class=""><a href="#dropdown2" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2" aria-expanded="false">Weekly</a></li>
                           </ul>
                        </li>
                        
                        <li role="presentation" >
                           <a href="#moduleshandled" role="tab" id="moduleshandled-tab" data-toggle="tab" aria-controls="educationalqualifications" aria-expanded="false">Modules Handled</a>
                        </li>
                     </ul>
                     <div id="myTabContent" class="tab-content scrollbar1">
                        
                        
                        
                        
                         <div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
                         <br/>
                          <div class="table-responsive">
                       
                              <table class="table table-bordered">
                                 <thead style="background-color:#673AB7;color:#ffffff;">
                                    <tr>
                                       <th>Course</th>
                                       <th>Department</th>
                                       <th>Class Timing</th>
                                       <th>Subject</th>
                                       <th>Batch</th>
                                        <th>Block</th>
                                       <th>Room</th>
                                       <th>Lesson And Lab Plan</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    <tr>
                                    
                                       <td>UG</td>
                                       <td>Computer Science</td>
                                       <td>8:00 AM - 9:00 AM</td>
                                       <td>Operating System</td>
                                       <td>Batch 2</td>
                                       <td>Block C</td>
                                        <td>125</td>
                                        <td>
                                        
                                        <a href="#" id="viewanddownload"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="">
                                    		<span class="glyphicon glyphicon-eye-open"></span> 
                                    	</a>
                                        
                                        
                                        
                                        
                                        
                                        </td>
                                    </tr>
                                   
                                 </tbody>
                              </table>
                           </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="dropdown2" aria-labelledby="dropdown2-tab">
                        <br />
                         <div class="table-responsive">
                            
                              <table class="table table-bordered">
                  <thead style="background-color:#673AB7;color:#ffffff;">
                    
                      <tr>
                        <th>Class Timing</th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Saturday</th>
                  
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <th scope="row">9:00 AM - 10:00 AM</th>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>WT ( Room no-201 ) 
( MCA-Section-01 )</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                     </tr>
                     <tr>
                        <th scope="row">10:00 AM - 11:00 AM	</th>
                        <td>WT ( Room no-202 ) 
( MCA-Section-01 )</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                     </tr>
                     
                  </tbody>
               </table>
                           </div>
                        </div>
                        
                        
                       
                        <div role="tabpanel" class="tab-pane fade " id="attendance" aria-labelledby="attendance-tab">
                           <br />
                           <form class="form-horizontal">
                              <h4 class="title1">Select Criteria</h4>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Month</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control1" id="date-picker" placeholder="Month">
                                 </div>
                              </div>
                            
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Get Details</button>
                                 </div>
                              </div>
                           </form>
                          
                           <div class="x_title">
                              <div class="clearfix">
                              </div>
                           </div>
                           <br />
                           <h4 class="title1">Attendance Details</h4>
                           <br />
                         
                             
                                 <div class="tables">
                                
                                    <div class="table-responsive bs-example widget-shadow">
                                       <table class="table table-bordered">
                                          <thead style="background-color:#673AB7;color:#ffffff;">
                                             <tr>
                                                <th>Absent Days</th>
                                                <th>Leave Type</th>
                                                <th>Total Leave</th>
                                                <th>Balance Leave</th>
                                                <th>Description</th>
                                             </tr>
                                          </thead>
                                          <tbody>
                                             <tr class="active">
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                              <td>Column content</td>
                                                <td>Column content</td>
                                             </tr>
                                          </tbody>
                                       </table>
                                    </div>
                                   </div>
                           
                          
               
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="moduleshandled" aria-labelledby="moduleshandled-tab">
                      
                                
                                   <br>
                                  <br>
                                   
                                       <div class="table-responsive">
                                          <table class="table table-bordered">
                                             <thead style="background-color:#673AB7;color:#ffffff;">
                                                <tr>
                                                   <th>Course Type</th>
                                                   <th>Course Category</th>
                                                   <th>Department</th>
                                                    <th>Module Name</th>
                                                   
                                                </tr>
                                             </thead>
                                             <tbody>
                                                <tr class="active">
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   
                                                </tr>
                                             </tbody>
                                          </table>
                                       </div>
                                   
                                
                          
                        </div>
                                     <div role="tabpanel" class="tab-pane fade active in" id="performance" aria-labelledby="performance-tab">
                      
                                
                            
                                   
                                      <div class="charts">
					
				<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">Performance Radar</h4>
						<div class="radar-grid">
							<canvas id="radar" height="300" width="400" style="width: 400px; height: 340px;"></canvas>
							<div id="r-legend" class="chart-legend"></div>
						</div>
					</div>
					
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Module Wise Student Academic Success Ratio</h4>
						<canvas id="bar" height="300" width="400" style="width: 600px; height: 300px;"></canvas>
					<div id="b-legend" class="chart-legend"></div>
					</div>
					<script>
					function per()
					{
					var radarChartData = {
															labels : ["Relationship","Teaching","Research","Initiative and Organization","Innovation","Punctuality","Goal Alignment"],
															datasets : [
																	
																{
																	fillColor : "rgba(101, 245, 242, 0.7)",
																		strokeColor : "#4F52BA",
																	pointColor : "#4F52BA",
																	pointStrokeColor : "#fff",
																	data : [30,48,60,19,96,30,100],
																	label:"Performance"
																	}
																]
																
															};
					var barChartData = {
							labels : ["2011","2012","2013","2014","2015","2016","2017"],
							datasets : [
								{
									fillColor : "rgba(233, 78, 2, 0.83)",
									strokeColor : "#ef553a",
									highlightFill: "#ef553a",
									data : [65,59,90,81,56,55,40],
									label:"Module 1"
								},
								{
									fillColor : "rgba(79, 82, 186, 0.83)",
									strokeColor : "#4F52BA",
									highlightFill: "#4F52BA",
									data : [50,65,60,50,70,70,80],
									label:"Module 2"
								},
								{
									fillColor : "rgba(88, 88, 88, 0.83)",
									strokeColor : "#585858",
									highlightFill: "#585858",
									data : [28,48,40,19,96,27,100],
									label:"Module 3"
								}
							]
							
						};
				var b=	new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
					var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
					document.getElementById('b-legend').innerHTML = b.generateLegend();
					document.getElementById('r-legend').innerHTML = r.generateLegend();
					}
					</script>
					
					
			</div>
                                   
                                
                          
                        </div>
                     </div>
                  </div>
				
			
							
				</div>
       </div>
         </div>
		</div>
		
	
		
	
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		
<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.mtz.monthpicker.js"></script>

		<script>
$('#date-picker').monthpicker();
/* $('#demo-2').monthpicker({pattern: 'yyyy-mm', 
    selectedYear: 2015,
    startYear: 1900,
    finalYear: 2212,});
	var options = {
    selectedYear: 2015,
    startYear: 2008,
    finalYear: 2018,
    openOnFocus: false // Let's now use a button to show the widget
};

$('#demo-3').monthpicker(options);

$('#demo-3').monthpicker().bind('monthpicker-change-year', function (e, year) {
    $('#demo-3').monthpicker('disableMonths', []); // (re)enables all
    if (year === '2015') {
        $('#demo-3').monthpicker('disableMonths', [1, 2, 3, 4]);
    }
    if (year === '2014') {
        $('#demo-3').monthpicker('disableMonths', [9, 10, 11, 12]);
    }
});

$('#demo-3-button').bind('click', function () {
    $('#demo-3').monthpicker('show');
}); */
</script>
		<script>
		
	      $(document).ready(
	    	
	    		  /* This is the function that will get executed after the DOM is fully loaded */
	    		  function () {
	    		    $( "#datepicker2" ).datepicker({
	    		      changeMonth: true,//this option for allowing user to select month
	    		      changeYear: true //this option for allowing user to select from year range
	    		    });
	    		  }
	    		  
	    		  
               
	    		);
$(document).ready(
	    		  
	    		  /* This is the function that will get executed after the DOM is fully loaded */
	    		  function () {
	    		    $( "#datepicker1" ).datepicker({
	    		      changeMonth: true,//this option for allowing user to select month
	    		      changeYear: true //this option for allowing user to select from year range
	    		    });
	    		  }
	    		  
	    		  
               
	    		);
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
			per();
		</script>
	<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script><!--map js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.vmap.world.js" type="text/javascript"></script>
<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/clndr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>