<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
<!-- //chart -->
<style>


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
			
					<div class="main-page charts-page">
				<h3 class="title1">Dashboard</h3>
				<div class="charts">
						<div class="col-md-6 chrt-page-grids " style=" height:auto;">
						<h4 class="title">Employee Distribution</h4>
						<div class="doughnut-grid" >
							<canvas id="doughnut1" style="width:416px; height: 245px;"></canvas>
							
						</div>
						<div id="d1-legend" class="chart-legend"></div>
					</div>
					
					<div class="col-md-6 chrt-page-grids chrt-right">
						<h4 class="title">Issue Distribution</h4>
						<div class="doughnut-grid">
							<canvas id="doughnut2" style="width:416px; height: 245px;"></canvas>
							
						</div>
						<div id="d2-legend" class="chart-legend"></div>
					</div>
					
					
					<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">Department Ratios</h4>
						<canvas id="bar" height="300" width="400" style="width: 400px; height: 250px;">
						
						</canvas>
						<div id="b-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Asset Distribution</h4>
						<div class="pie-grid">
							<canvas id="pie" height="300" width="400" style="width: 400px; height: 340px;"></canvas>
							
						</div>
						<div id="p-legend" class="chart-legend"></div>
					</div>
					
					<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">Financial Indicators (Rs Lakhs)</h4>
						<canvas id="bar1" height="300" width="400" style="width: 400px; height: 265px;"></canvas>
						<div id="b1-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Student Distribution</h4>
						<div class="pie-grid">
							<canvas id="pie1" height="300" width="400" style="width: 400px; height: 350px;"></canvas>
							
						</div>
						<div id="p1-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6  charts chrt-page-grids">
						<h4 class="title">Admission</h4>
						<canvas id="line6" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
						<div id="l6-legend" class="chart-legend">
						
						
						
						</div>
					</div>
					
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Asset Utilization</h4>
						<div class="doughnut-grid">
							<canvas id="doughnut"  style="width:416px; height: 306px;"></canvas>
							
						</div>
						<div id="d-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6  charts chrt-page-grids">
						<h4 class="title">Key Trends: Workshops and Seminars</h4>
						<canvas id="line2" height="300" width="300" style="width: 400px; height: 295px;"></canvas>
						<div id="l2-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Key Trends: Placements</h4>
						<canvas id="line3" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
						<div id="l3-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6  charts chrt-page-grids">
						<h4 class="title">Key Trends: Student Academic Success Ratio</h4>
						<canvas id="line4" height="300" width="400" style="width: 400px; height: 295px;"></canvas>
						<div id="l4-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Key Trends: No. of Outstanding Issues</h4>
						<canvas id="line5" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
						<div id="l5-legend" class="chart-legend"></div>
					</div>
					
			<div class="col-md-6  charts chrt-page-grids">
						<h4 class="title">Key Trends: Research Projects</h4>
						<div class="line-grid">
						<canvas id="line" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
						</div>
						<div id="l-legend" class="chart-legend"></div>
						
					</div>
					
					
			</div>
							
				</div>
					<div class="clearfix"> </div>
							<script>
							
							var doughnutData2 = [
													{
														value: 30,
														color:"#4F52BA",
														 label: "Facilities"
															 
													},
													{
														value : 50,
														color : "#F2B33F",
														 label: "Exam Related"
													},
													{
														value : 100,
														color : "#585858",
														 label: "Faculty & Course Related"
													},
													{
														value : 40,
														color : "#e94e02",
														 label: "Fees Related"
													},
													{
														value : 120,
														color : "#9358ac",
														 label: "Help Desk"
													}
												
												];
							var doughnutData1 = [
												{
													value: 30,
													color:"#512DA8",
													 label: "Teaching-Staff"
												},
												{
													value : 50,
													color : "#03A9F4",
													 label: "Non-Teaching-Staff"
												},
												{
													value : 40,
													color : "#e94e02",
													 label: "Collection Clerk"
												},
												{
													value : 50,
													color : "#9358ac",
													 label: "Librarian"
												},
												{
													value : 50,
													color : "#F2B33F",
													 label: "System Administrator"
												}
												
											
											];
							var doughnutData = [
									{
										value: 30,
										color:"#4F52BA",
										 label: "Commerce"
									},
									{
										value : 50,
										color : "#F2B33F",
										 label: "Leadership Management"
									},
									{
										value : 100,
										color : "#585858",
										label: "Development Studies"
									},
									{
										value : 40,
										color : "#e94e02",
										 label: "Physics"
									},
									{
										value : 120,
										color : "#9358ac",
										 label: "Computer Science"
									}
								
								];
							var pieData = [
											{
												value: 30,
												color:"#4F52BA",
												label: "Computer Science"
											},
											{
												value : 50,
												color : "#585858",
												label: "Physics"
											},
											{
												value : 100,
												color : "#e94e02",
												label: "Development Studies"
											}
										
										];
									var barChartData = {
										labels : ["Physics","Chemistry","Commerce","Management","Social Studies","Elec Engineering","Mathematics"],
										datasets : [
											{
												fillColor : "rgba(233, 78, 2, 0.83)",
												strokeColor : "#ef553a",
												highlightFill: "#ef553a",
												data : [65,59,90,81,56,55,40],
												label: "Student Success Ratio"
											},
											{
												fillColor : "rgba(79, 82, 186, 0.83)",
												strokeColor : "#4F52BA",
												highlightFill: "#4F52BA",
												data : [50,65,60,50,70,70,80],
												label: "Student-Staff Ratio"
											},
											{
												fillColor : "rgba(88, 88, 88, 0.83)",
												strokeColor : "#585858",
												highlightFill: "#585858",
												data : [28,48,40,19,96,27,100],
												label: "Admission Ratio"
											},
											{
												fillColor : "#03A9F4",
												strokeColor : "#03A9F4",
												highlightFill: "#03A9F4",
												data : [12,60,20,50,50,40,96],
												label: "Placement Ratio"
											}
											
										]
										
									};
							var lineChartData = {
								labels : ["H1 13","H2 13","H1 14","H2 14","H1 15","H2 15","H1 16"],
								datasets : [
									{
										fillColor : "rgba(51, 51, 51, 0)",
										strokeColor : "#4F52BA",
										pointColor : "#4F52BA",
										pointStrokeColor : "#fff",
										data : [50,65,68,71,67,70,65],
										label: "Physics"
									},
									{
										fillColor : "rgba(51, 51, 51, 0)",
										strokeColor : "#F2B33F",
										pointColor : "#F2B33F",
										pointStrokeColor : "#fff",
										data : [55,60,54,58,62,55,58],
										label: "Development Studies"
									},
									{
										fillColor : "rgba(51, 51, 51, 0)",
										strokeColor : "#e94e02",
										pointColor : "#e94e02",
										pointStrokeColor : "#fff",
										data : [50,55,52,45,46,49,52],
										label: "Computer Science"
									}
								]
								
							};
							var lineChartData2 = {
									labels : ["H1 13","H2 13","H1 14","H2 14","H1 15","H2 15","H1 16"],
									datasets : [
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [50,65,68,71,67,70,65],
											 label: "Commerce"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#F2B33F",
											pointColor : "#F2B33F",
											pointStrokeColor : "#fff",
											data : [55,60,54,58,62,55,58],
											label: "Computer Science"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [50,55,52,45,46,49,52],
											label: "Development Studies"
										}
									]
									
								};
							var lineChartData3 = {
									labels : ["H1 13","H2 13","H1 14","H2 14","H1 15","H2 15","H1 16"],
									datasets : [
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [50,65,68,71,67,70,65],
											label: "Development Studies"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#F2B33F",
											pointColor : "#F2B33F",
											pointStrokeColor : "#fff",
											data : [55,60,54,58,62,55,58],
											 label: "Commerce"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [50,55,52,45,46,49,52],
											label: "Computer Science"
										}
									]
									
								};
							var lineChartData4 = {
									labels : ["H1 13","H2 13","H1 14","H2 14","H1 15","H2 15","H1 16"],
									datasets : [
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [50,65,68,71,67,70,65],
											label: "Computer Science"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#F2B33F",
											pointColor : "#F2B33F",
											pointStrokeColor : "#fff",
											data : [55,60,54,58,62,55,58],
											 label: "Commerce"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [50,55,52,45,46,49,52],
											label: "Development Studies"
										}
									]
									
								};
							var lineChartData5 = {
									labels : ["H1 13","H2 13","H1 14","H2 14","H1 15","H2 15","H1 16"],
									datasets : [
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [50,65,68,71,67,70,65],
											label: "Development Studies"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#F2B33F",
											pointColor : "#F2B33F",
											pointStrokeColor : "#fff",
											data : [55,60,54,58,62,55,58],
											label: "Commerce"
										},
										{
											fillColor : "rgba(51, 51, 51, 0)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [50,55,52,45,46,49,52],
											label: "Computer Science"
										}
									]
									
								};
					
						var barChartDatas = {
								labels : ["H2 2014","H1 2015","H2 2015","H1 2016"],
								datasets : [
									{
										fillColor : "rgba(233, 78, 2, 0.9)",
										
										highlightFill: "#e94e02",
										highlightStroke: "#e94e02",
										data : [45,29,60,51],
										label: "Income"
									},
									{
										fillColor : "rgba(79, 82, 186, 0.9)",
										
										highlightFill: "#4F52BA",
										highlightStroke: "#4F52BA",
										data : [30,30,30,30],
										label: "Expenses"
									},
									{
										fillColor : "#00BCD4",
									
										highlightFill: "#00BCD4",
										highlightStroke: "#00BCD4",
										data : [50,45,40,20],
										label: "Budgeted Expenses"
									},
									{
										fillColor : "#795548",
									
										highlightFill: "#795548",
										highlightStroke: "#795548",
										data : [15,15,55,15],
										label: "Outstanding Collection"
									}
								]
								
							};
							var lineChartDatas = {
									labels : ["H2 2014","H1 2015","H2 2015","H1 2016"],
								datasets : [
									{
										fillColor : "rgba(242, 179, 63, 1)",
										strokeColor : "#F2B33F",
										pointColor : "rgba(242, 179, 63, 1)",
										pointStrokeColor : "#fff",
										data : [70,60,72,61],
										label: "Computer Science"

									},
									{
										fillColor : "rgba(97, 100, 193, 1)",
										strokeColor : "#6164C1",
										pointColor : "rgba(97, 100, 193,1)",
										pointStrokeColor : "#9358ac",
										data : [50,65,51,67],
										label: "Development Studies"

									},
									{
										fillColor : "#00BCD4",
										strokeColor : "#00BCD4",
										pointColor : "#00BCD4",
										pointStrokeColor : "#9358ac",
										data : [40,65,41,67],
										label: "Physics"

									}
								]
								
							};
							var pieDatas = [
									{
										value: 90,
										color:"rgba(233, 78, 2, 2)",
										label: "Morning Batch"
									},
									{
										value : 50,
										color : "rgba(242, 179, 63, 1)",
										label: "Evening Batch"
									},
									{
										value : 60,
										color : "rgba(88, 88, 88,1)",
										label: "Distance Education"
									}
									
								];
							
						
						
						
						
						
					
					var l6=	new Chart(document.getElementById("line6").getContext("2d")).Line(lineChartDatas);
					var b1=	new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartDatas);
						var p1=new Chart(document.getElementById("pie1").getContext("2d")).Pie(pieDatas);
							
							var d=new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(doughnutData);
						var d1	=new Chart(document.getElementById("doughnut1").getContext("2d")).Doughnut(doughnutData1);
						var d2	=new Chart(document.getElementById("doughnut2").getContext("2d")).Doughnut(doughnutData2);
						var l=	new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
						var l2=	new Chart(document.getElementById("line2").getContext("2d")).Line(lineChartData2);
						var l3=	new Chart(document.getElementById("line3").getContext("2d")).Line(lineChartData3);
						var l4=	new Chart(document.getElementById("line4").getContext("2d")).Line(lineChartData4);
						var l5=new Chart(document.getElementById("line5").getContext("2d")).Line(lineChartData5);
							var b=new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
						var p=	new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
							document.getElementById('d-legend').innerHTML = d.generateLegend();
							document.getElementById('d1-legend').innerHTML = d1.generateLegend();
							document.getElementById('d2-legend').innerHTML = d2.generateLegend();
							document.getElementById('p1-legend').innerHTML = p1.generateLegend();
							document.getElementById('p-legend').innerHTML = p.generateLegend();
							document.getElementById('l-legend').innerHTML = l.generateLegend();
							document.getElementById('l2-legend').innerHTML = l2.generateLegend();
							document.getElementById('l3-legend').innerHTML = l3.generateLegend();
							document.getElementById('l4-legend').innerHTML = l4.generateLegend();
							document.getElementById('l5-legend').innerHTML = l5.generateLegend();
							document.getElementById('l6-legend').innerHTML = l6.generateLegend();
							document.getElementById('b-legend').innerHTML = b.generateLegend();
							document.getElementById('b1-legend').innerHTML = b1.generateLegend();

							</script>
							
				
				
					
				 
				<div class="clearfix"> </div>
			</div>
			</div>
			
		
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		<script>
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
<script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>

</body>
</html>