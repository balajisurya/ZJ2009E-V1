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
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
      <!-- //chart -->
      <!--//Metis Menu -->
      <style type="text/css">
         .chart-legend li span{
         display: inline-block;
         width: 12px;
         height: 12px;
         margin-right: 5px;
         }
         canvas#line1 {
    width: 100% !important;
}
      </style>
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <div class="main-content">
      
         <!-- main content start-->
         <div id="page-wrapper">
          <h3 class="title1">Exam Result Dashboard</h3>
            <div class="main-page">
              
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
                        <thead>
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
                           <thead>
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
                           <thead>
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
                     <thead>
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
                     <thead>
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
            </div>
         </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script>
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
      </script>
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
      <!--map js-->
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