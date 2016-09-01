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
			
					<div class="main-page">
				<h3 class="title1">Admissions Dashboard</h3>
				
				<div class="charts">
					
					<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title"> Fulfilment Potential</h4>
						<div class="radar-grid">
							<canvas id="radar" height="300" width="400" style="width: 400px; height: 310px;"></canvas>
							
						</div>
						<div id="r-legend" class="chart-legend"></div>	
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right ">
						<h4 class="title">Applicant Category Distribution</h4>
						<div class="pie-grid">
							<canvas id="pie" height="300" width="400" style="width: 400px; height: 270px;"></canvas>
						<div id="p-legend" class="chart-legend"></div>
						</div>
					</div>
					<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">Course-wise Application Status </h4>
						<canvas id="bar" height="300" width="400" style="width: 400px; height: 250px;"></canvas>
						<div id="b-legend" class="chart-legend"></div>
					</div>
					<div class="col-md-6 charts chrt-page-grids chrt-right ">
						<h4 class="title">Gender Breakups </h4>
						<canvas id="bar1" height="300" width="400" style="width: 400px; height:295px;"></canvas>
						<div id="b1-legend" class="chart-legend"></div>
						
									
									
									
								 </div>
								 
								 
					</div>
					
					<script>
					var radarChartData = {
							labels : ["Computer Science","Mechanical","Civil","Leadership Management","Commerce","Development Studies","Physics"],
							datasets : [
										{
											fillColor : "rgba(239, 85, 58, 0.87)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [65,59,90,81,56,55,40],
											label:"Available Seats"
										},
										{
											fillColor : "rgba(79, 82, 186, 0.87)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [28,48,40,19,96,27,100],
											label:"Applications"
										}
									]
							
						};
					var barChartData = {
							labels : ["Computer Science","Mechanical","Civil","Leadership Management","Commerce","Development Studies","Physics"],
							datasets : [
								{
									fillColor : "rgb(51, 204, 51)",
									strokeColor : "#33cc33",
									highlightFill: "#33cc33",
									data : [65,59,90,81,56,55,40],
									label:"Registered"
								},
								{
									fillColor : "rgb(255, 51, 0)",
									strokeColor : "#ff3300",
									highlightFill: "#ff3300",
									data : [50,65,60,50,70,70,80],
									label:"Selected"
								},
								{
									fillColor : "rgb(255, 255, 0)",
									strokeColor : "#ffff00",
									highlightFill: "#ffff00",
									data : [28,48,40,19,96,27,100],
									label:"Waiting List"
								},
								{
									fillColor : "rgba(88, 88, 88, 0.83)",
									strokeColor : "#585858",
									highlightFill: "#585858",
									data : [98,88,40,58,46,27,10],
									label:"Rejected"
								}
							]
							
						};
					var barChartData1 = {
							labels : ["Computer Science","Mechanical","Civil","Leadership Management","Commerce","Development Studies","Physics"],
							datasets : [
								{
									fillColor : "rgb(102, 204, 255)",
									strokeColor : "#66ccff",
									highlightFill: "#66ccff",
									data : [55,59,100,22,56,89,40],
									label:"Male"
								},
								{
									fillColor : "rgb(255, 51, 0)",
									strokeColor : "#ff3300",
									highlightFill: "#ff3300",
									data : [50,65,60,50,70,46,80],
									label:"Female"
								}
								
							]
							
						};
					var pieData = [
									{
										value: 30,
										color:"#4F52BA",
										label:"Scheduled Caste"
									},
									{
										value : 50,
										color : "#585858",
										label:"Scheduled Tribe"
									},
									{
										value : 100,
										color : "#e94e02",
										label:"Disadvantaged"
									},
									{
										value : 100,
										color : "#66ccff",
										label:"Normal"
									}
								
								];
					var b1=new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartData1);
					var b=new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
					var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
					var p=new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
					document.getElementById('b1-legend').innerHTML = b1.generateLegend();
					document.getElementById('b-legend').innerHTML = b.generateLegend();
					document.getElementById('r-legend').innerHTML = r.generateLegend();
					document.getElementById('p-legend').innerHTML = p.generateLegend();
					</script>
					
					
			</div>	
					
					
					
					
				
					
				
					
					
					
					
					
			
					
					
			</div>
							
				</div>
					<div class="clearfix"> </div>
							
							
				
				
					
			
		
	
	
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