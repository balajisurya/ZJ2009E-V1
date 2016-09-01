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
#os-budget-lbl {
    border-left:#00BCD4 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
}
#os-income-lbl {
    border-left: #795548 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
}
#os-expenses-lbl {
    border-left: #4F52BA solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
}#os-out-lbl {
    border-left: #e94e02 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
}
.legend {
    float: left;
    font-size: 12px;
    border: 1px solid #4CAF50;
    padding: 10px;
    width: 176px;
    margin: 1em 0 0 1em;
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
			
				
			<h3 class="title1">My Performance</h3>
			<div class="main-page charts-page">
				
				<div class="charts">
					
				<div class="col-md-6 charts chrt-page-grids">
						<h4 class="title">My Performance Radar</h4>
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