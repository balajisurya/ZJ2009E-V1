<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS -->
       <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
<!-- //chart -->
<style>


.chart-legend li span{
    display: inline-block;
    width: 12px;
    height: 12px;
    margin-right: 5px;
}

      
      .loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('${pageContext.request.contextPath}/resources/themes/images/page-loader.gif') 50% 50% no-repeat rgba(255, 255, 255, 0.71);
}
      
      
      </style>
<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 <div class="loader"  style="display: none"></div>
		<!-- main content start-->
		<div id="page-wrapper">
			
					<div class="main-page charts-page">
				<h3 class="title1">Dashboard</h3>
				<div class="charts">
						<div class="col-md-6 charts chrt-page-grids" style=" height:auto;">
						<h4 class="title">Special Category Wise Student Count</h4>
						  
						<div class="form-group" id="specialCategoryDiv" style="display:block;">
                                 <div class="col-sm-6">
                                  <select name="specialCategory" id="specialCategory" class="form-control" style="width: 410px">
                                    <c:if test="${!empty specialCategoryList}">
                                    		<c:forEach items="${specialCategoryList}" var="specialCategory">
                                    			<option  value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                    		</c:forEach>
                                    		</c:if>
                                    </select>
                                    
                                     </div>
                              </div>
                              <br>
                              <br>
						<div class="doughnut-grid" id="specialCategoryChart" style="display:block;">
							<canvas id="doughnut1" style="width:400px; height: 250px;"></canvas>
						</div>
						<div id="d1-legend" class="chart-legend" style="display:block;"></div>
						
                                    <div id="specialCateoryImage" style="width:400px; height: 400px;display:none;">
						<br><br><br>
					<br><br><br><br>
						<div class="col-sm-12 col-md-12 col-xs-8">
						<div class="alert alert-info" style="margin-left: 50px">
						
                                    <p style="text-align: center;">No Data Available</p>
                  							</div>
						</div>
						
							   
                  							</div>
                              		   </div>
					
					   
					   			<div class="col-md-6 charts chrt-page-grids chrt-right" style=" height:auto;">
						<h4 class="title">Category Wise Student Count</h4>
						<div class="form-group" id="categoryDiv" style="display:block;">
                                 <div class="col-sm-12 col-xs-12">
                               <select name="Category" id="Category" class="form-control">
                                    <c:if test="${!empty categories}">
                                    		<c:forEach items="${categories}" var="categories">
                                    			<option  value="${categories.getCategoryId()}">${categories.getCategoryName()}</option>
                                    		</c:forEach>
                                    		</c:if>
                                    </select>
                                    
                                     </div>
                              </div>
                             <br>
                             <br>
						<div class="doughnut-grid"  id="categoryChart" style="display:block;" >
							<canvas id="doughnut2" style="width:400px; height: 250px;"></canvas>
						</div>
						<div id="d1-legend2" class="chart-legend" style="display:block;"></div>
						<div  id="cateoryImage" style="width:400px; height: 400px;display:none;">
						<br><br><br><br><br><br>
					<br>
						<div class="col-sm-12 col-md-12 col-xs-8">
						<div class="alert alert-info" style="margin-left: 50px">
						
                                    <p style="text-align: center;">No Data Available</p>
                  							</div>
							   </div>
                  							
                  							</div>
					   </div>
					   
					   
					   	
					   		<div class="col-md-6 charts chrt-page-grids" style=" height:auto;">
						<h4 class="title">Blood Group Wise Students</h4>
							<div class="pie-grid" id="bloodGroupChart" style="display:block;">
								<canvas id="pie" height="320" width="400" style="width: 400px; height: 250px;"></canvas>
							</div>
							<div id="p-legend" class="chart-legend" style="display:block;"></div>
                                    <div id="bloodGroupImage" style="width:400px; height: 480px;display:none;">
							        
                                   <br><br><br>
					<br><br><br><br><br>
						<div class="col-sm-12 col-md-12 col-xs-8">
						<div class="alert alert-info" style="margin-left: 50px">
						
                                    <p style="text-align: center;">No Data Available</p>
                  							</div>
							   
                  						</div>
                  							</div>
                              		   </div>
                              		   
                              		  
					
					<div class="col-md-6 charts chrt-page-grids chrt-right">
						<h4 class="title">Class Wise Students</h4>
							<div class="form-group" id="classDiv" style="display:block;">
                                 <div class="col-sm-6">
                                  <select name="classList" id="classList" class="form-control" style="width: 410px">
                                    <c:if test="${!empty classList}">
                                    		<c:forEach items="${classList}" var="classes">
                                    			<option  value="${classes.getClassId()}">${classes.getClassName()}</option>
                                    		</c:forEach>
                                    		</c:if>
                                    </select>
                                    
                                     </div>
                              </div>
                              <div id="classChart" style="display:block;" >
						<canvas id="bar1" height="300" width="800" style="width: 400px; height: 370px;"></canvas>
						</div>
						<div id="b1-legend" class="chart-legend"></div>
						
						<div id="classImage" style="width:400px; height: 465px;display:none;">
							        <br><br><br>
					<br><br><br><br><br>
						<div class="col-sm-12 col-md-12 col-xs-8">
						<div class="alert alert-info" style="margin-left: 50px">
						
                                    <p style="text-align: center;">No Data Available</p>
                  							</div>
							   </div>
                  							</div>
					</div>
					
			
					
			</div>	
			</div>
			</div>
			<div class="clearfix"> </div>
			<br>
				
			</div>
	

		
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script>
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>