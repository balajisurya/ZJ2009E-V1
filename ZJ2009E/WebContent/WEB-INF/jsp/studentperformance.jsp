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
			
				
			<h3 class="title1">My Performance</h3>
			<div class="main-page charts-page">
				
				<div class="charts">
					
					<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">My Performance Radar</h4>
						<div class="radar-grid">
							<canvas id="radar" height="300" width="400" style="width: 400px; height: 380px;"></canvas>
							
						</div>
						<div id="r-legend" class="chart-legend"></div>
					</div>
					
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Academic Success Ratio</h4>
						<canvas id="bar" height="300" width="400" style="width: 400px; height: 350px;"></canvas>
						<div id="b-legend" class="chart-legend"></div>
					</div>
					<script>
					var radarChartData = {
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
					var barChartData = {
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
					var b=	new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
					var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
					document.getElementById('b-legend').innerHTML = b.generateLegend();
					document.getElementById('r-legend').innerHTML = r.generateLegend();
					</script>
					
					
			</div>
							
				</div>
				
				
					
				</div>
				
				<div class="clearfix"> </div>
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