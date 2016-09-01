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
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
<!-- Metis Menu -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
<!-- chart -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
 
 <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
 

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
		  <h3 class="title1">View Student Details</h3>
		<div class="main-page charts-page">
		<div id="ListDiv" style="display:block;">
		  
                <form class="form-horizontal" id="getDetails">
                 
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Enter Student Id</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="getStudentId" name="getStudentId" placeholder="">
                                 </div>
                              </div>
                           
                             <div class="row">
                                 <div class="col-sm-offset-3">
                              
                                     <button style="float:right"  type="button" id="getStudentProfile" class="btn btn-success">Get Details</button>
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
                   <div id="OpenFormDiv" style="display:block;">
                           <div class="col-xs-12 col-md-2" style="display:none;" id="studentImage">
                           
                               <img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/themes/images/staff.jpg" alt=""> 
                           
                          </div>
                  <div class="col-xs-12 col-md-10">
                     <div class="table-responsive ">
                        <div id="table">
                      
                        </div>
                     </div>
                  </div>
                 <div id="studentGraph">
                 </div>
                  </div>
                 
<%--        <div id="OpenFormDiv" style="display:block;">
			              
      
              <div class="x_title">
                <div class="clearfix">
                </div>
             </div>
             <div class="form-three widget-shadow">
                <ul id="myTabs" class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active">
                      <a href="#performance" role="tab" id="performance-tab" data-toggle="tab" aria-controls="performance" aria-expanded="true">Performance And Exam Results</a>
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
                   
                                <div role="tabpanel" class="tab-pane fade active in" id="performance" aria-labelledby="performance-tab">
                 
                            <div class="charts">
             <div class="col-md-6 charts chrt-page-grids">
                <h4 class="title">Over All Percentage</h4>
                <div class="pie-grid" style="width: 320px;">
                   <canvas id="pie1" height="300" width="400" style="width: 416px; height: 280px;"></canvas>
                  
                </div>
                <div id="p1-legend" class="chart-legend"></div>
             </div>
             <div class="col-md-6 charts chrt-page-grids chrt-right">
					<h4 class="title">Key Trend: Semester Wise</h4>
					<canvas id="line1" height="300" width="300" style="width: 400px; height: 245px;"></canvas>
					<div id="l1-legend" class="chart-legend"></div>
				</div>
          </div>
          <div class="x_title">
             <div class="clearfix">
             </div>
          </div>
          <h3 class="title1">Recent Exam Results</h3>
          <div class="form-three widget-shadow">
             <div class="charts">
                <div class="col-md-4 charts-grids widget">
                   <h4 class="title">Efforts: Board Exam vs Model Exams </h4>
                   <canvas id="bar" height="365" width="400"> </canvas>
                   <div id="b-legend" class="chart-legend"></div>
                </div>
                <div class="col-md-4 charts-grids widget states-mdl">
                   <h4 class="title">Internal Assessment Trend</h4>
                   <canvas id="line" height="365" width="400"> </canvas>
                     <div id="l-legend" class="chart-legend"></div>
                </div>
                <div class="col-md-4 charts-grids widget">
                   <h4 class="title">Exam Results - Module Wise</h4>
                   <canvas id="pie" height="300" width="400"> </canvas>
                     <div id="p-legend" class="chart-legend"></div>
                </div>
                <div class="clearfix"> </div>
                
                <script>
                   var barChartData = {
                   	labels : ["CS002","CS003","CS004","CS005","CS006"],
                   	datasets : [
                   		{
                   			fillColor : "rgba(233, 78, 2, 0.9)",
                   			strokeColor : "rgba(233, 78, 2, 0.9)",
                   			highlightFill: "#e94e02",
                   			highlightStroke: "#e94e02",
                   			data : [65,59,90,81,56],
                   			label:"University Exam"
                   		},
                   		{
                   			fillColor : "rgba(79, 82, 186, 0.9)",
                   			strokeColor : "rgba(79, 82, 186, 0.9)",
                   			highlightFill: "#4F52BA",
                   			highlightStroke: "#4F52BA",
                   			data : [40,70,55,20,45],
                   			label:"Model Exam"
                   		}
                   	]
                   	
                   };
                   var lineChartData = {
                   	labels : ["Jan","Feb","March","April","May","June","July"],
                   	datasets : [
                   		{
                   			fillColor : "rgba(242, 179, 63, 1)",
                   			strokeColor : "#F2B33F",
                   			pointColor : "rgba(242, 179, 63, 1)",
                   			pointStrokeColor : "#fff",
                   			data : [100,100,100,100,100,100,100],
                   			label:"Internal Assessment Total Marks"
                   
                   		},
                   		{
                   			fillColor : "rgba(97, 100, 193, 1)",
                   			strokeColor : "#6164C1",
                   			pointColor : "rgba(97, 100, 193,1)",
                   			pointStrokeColor : "#9358ac",
                   			data : [65,69,76,75,77,81,82],
                   			label:"Obtained Overall Marks"
                   
                   		}
                   	]
                   	
                   };
                   var pieData = [
                   		{
                   			value: 90,
                   			color:"rgba(233, 78, 2, 1)",
                   			label: "Operating System"
                   		},
                   		{
                   			value : 50,
                   			color : "rgba(242, 179, 63, 1)",
                   			label: "Computer Graphics"
                   		},
                   		{
                   			value : 60,
                   			color : "rgba(88, 88, 88,1)",
                   			label: "Computer Networks"
                   		},
                   		{
                   			value : 40,
                   			color : "rgba(79, 82, 186, 1)",
                   			label: "Software Testing"
                   		},
                   		{
                   			value : 20,
                   			color : "rgba(3, 169, 244, 0.91)",
                   			label: "Software Testing"
                   		}
                   		
                   	];
                 
                   
                   var l=new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
                   var b=new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
                   var p=new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
                  
                   document.getElementById('l-legend').innerHTML = l.generateLegend();
                
                   document.getElementById('b-legend').innerHTML = b.generateLegend();
                   document.getElementById('p-legend').innerHTML = p.generateLegend();
                </script>
             </div>
             <br>
             <br>
             <div class="table-responsive">
                <table class="table table-bordered">
                   <thead style="background-color:#673AB7;color:#ffffff;">
                      <tr>
                         <th>Module Code</th>
                         <th>Module Name</th>
                         <th>Grade</th>
                         <th>Exam Results</th>
                      </tr>
                   </thead>
                   <tbody>
                      <tr>
                         <td>Table cell</td>
                         <td>Table cell</td>
                         <td>Table cell</td>
                         <td>Table cell</td>
                      </tr>
                   </tbody>
                </table>
             </div>
             <div class="x_title">
                <div class="clearfix">
                </div>
             </div>
             <h3 class="title1">Internal Assessment Details</h3>
            
                <div class="table-responsive">
                   <table class="table table-bordered">
                      <thead style="background-color:#673AB7;color:#ffffff;">
                         <tr>
                            <th>Module Code</th>
                             <th>Module Name</th>
                            <th>Attended/Total Period</th>
                            <th>Assessment Mark (Out Of 100)</th>
                            
                         </tr>
                      </thead>
                      <tbody>
                         <tr>
                            <td>Column content</td>
                            <td>Column content</td>
                                                           
                            
                            <td>Column content</td>
                            <td>Column content</td>
                         </tr>
                      </tbody>
                   </table>
                </div>
            
             
                <div class="table-responsive">
                   <table class="table table-bordered">
                      <thead style="background-color:#673AB7;color:#ffffff;">
                         <tr>
                            <th>Module Code</th>
                            <th>Module Name</th>
                            <th>Assessment Mark (Out Of 100)</th>
                            <th>Internal Marks</th>
                         </tr>
                      </thead>
                      <tbody>
                         <tr>
                            <td>Column content</td>
                                                             
                            
                            <td>Column content</td>
                            <td>Column content</td>
                            <td>Column content</td>
                         </tr>
                      </tbody>
                   </table>
                </div>
            
          </div>
       
       <div class="x_title">
          <div class="clearfix">
          </div>
       </div>
       <h3 class="title1">Previous Exam Results</h3>
       <div class="form-three widget-shadow">
          <h3>Semester One</h3>
          <br>
          <div class="table-responsive">
             <table class="table table-bordered">
                <thead style="background-color:#673AB7;color:#ffffff;">
                   <tr>
                      <th>Module Code</th>
                      <th>Module Name</th>
                      <th>Grade</th>
                      <th>Exam Results</th>
                   </tr>
                </thead>
                <tbody>
                   <tr>
                      <td>Table cell</td>
                      <td>Table cell</td>
                      <td>Table cell</td>
                      <td>Table cell</td>
                   </tr>
                </tbody>
             </table>
          </div>
          <h3>Semester Two</h3>
          <br>
          <div class="table-responsive">
             <table class="table table-bordered">
                <thead style="background-color:#673AB7;color:#ffffff;">
                   <tr>
                      <th>Module Code</th>
                      <th>Module Name</th>
                      <th>Grade</th>
                      <th>Exam Results</th>
                   </tr>
                </thead>
                <tbody>
                   <tr>
                      <td>Table cell</td>
                      <td>Table cell</td>
                      <td>Table cell</td>
                      <td>Table cell</td>
                   </tr>
                </tbody>
             </table>
          </div>
       </div>
                     <div class="x_title">
             <div class="clearfix">
             </div>
          </div>   
                   <h3 class="title1">Performance</h3>           
                                		<div class="charts">
				
				<div class="col-md-6 charts chrt-page-grids">
					<h4 class="title">Performance Radar</h4>
					<div class="radar-grid">
						<canvas id="radar" height="300" width="400" style="width: 400px; height: 380px;"></canvas>
						
					</div>
					<div id="r-legend" class="chart-legend"></div>
				</div>
				
				<div class="col-md-6 charts chrt-page-grids chrt-right">
					<h4 class="title">Academic Success Ratio</h4>
					<canvas id="bar1" height="300" width="400" style="width: 400px; height: 350px;"></canvas>
					<div id="b1-legend" class="chart-legend"></div>
				</div>
				<script>
				var radarChartData1 = {
						labels : ["Attitude","Relationship","Initiative","Punctuality","Academic","Creativity","Sports and Social"],
						datasets : [
							
							{
								fillColor : "rgba(79, 82, 186, 0.87)",
								strokeColor : "#4F52BA",
								pointColor : "#4F52BA",
								pointStrokeColor : "#fff",
								data : [28,48,40,19,96,27,100],
								label:"Performance"
							}
						]
						
					};
				var barChartData1 = {
						labels : ["2011","2012","2013","2014","2015","2016","2017"],
						datasets : [
							{
								fillColor : "rgba(233, 78, 2, 0.83)",
								strokeColor : "#ef553a",
								highlightFill: "#ef553a",
								data : [65,59,90,81,56,55,40],
								label:"Physics"
							},
							{
								fillColor : "rgba(79, 82, 186, 0.83)",
								strokeColor : "#4F52BA",
								highlightFill: "#4F52BA",
								data : [50,65,60,50,70,70,80],
								label:"Computer Science"
							},
							{
								fillColor : "rgba(88, 88, 88, 0.83)",
								strokeColor : "#585858",
								highlightFill: "#585858",
								data : [28,48,40,19,96,27,100],
								label:"Development Studies"
							}
						]
						
					};
				var b1=	new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartData1);
				var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData1);
				document.getElementById('b1-legend').innerHTML = b1.generateLegend();
				document.getElementById('r-legend').innerHTML = r.generateLegend();
				</script>
				
				
		</div>
                              
                           
                     
                   </div>
                </div>
             </div>
							
				</div> --%>
       </div>
         </div>
		</div>
		
	
		
	
	<!-- Classie -->
		
  <!--     <script>
         var pieData1 = [
         				{
         					value: 30,
         					color:"#512DA8",
         					label: "Total Percentage"
         				},
         				{
         					value : 50,
         					color : "#2196F3",
         					label: "Obtained Percentage"
         				}
         				
         			
         			];
         var lineChartData1 = {
					labels : ["Sem 1","Sem 2","Sem 3","Sem 4","Sem 5","Sem 6","Sem 7"],
					datasets : [
						{
							fillColor : "rgba(51, 51, 51, 0)",
							strokeColor : "#4F52BA",
							pointColor : "#4F52BA",
							pointStrokeColor : "#fff",
							data : [75,65,68,71,67,70,80],
							 label: "Percentage"
						}
					]
					
				};
         
         
         
         var p1=	new Chart(document.getElementById("pie1").getContext("2d")).Pie(pieData1);
         
         var l1=	new Chart(document.getElementById("line1").getContext("2d")).Line(lineChartData1);
        
         document.getElementById('l1-legend').innerHTML = l1.generateLegend();
         
         
         document.getElementById('p1-legend').innerHTML = p1.generateLegend();
         
         
      </script> -->
		<!-- <script>
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
 -->
<!-- 		<script>
		
		
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
		</script> -->
	
	<!-- Bootstrap Core JavaScript -->

 <script src="${pageContext.request.contextPath}/resources/themes/script/studentprofile.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		
<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.mtz.monthpicker.js"></script>

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