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
<script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
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
.card{
  pointer-events: none;
  transform: translateZ(0);
  padding: 30px;
  background: rgba(246, 41, 96, 0.51);
  border-radius: 5px;
  width: 160px;
  height: 200px;
  margin: auto;
  transform-style: preserve-3d;
  backface-visibility: hidden;
  display: flex;
  box-shadow: 0 0 5px rgba(246, 41, 96, 0.51);
  position: relative;
  
  &:after{
    content:" ";
    position: absolute;
    width: 100%;
    height: 10px;
    border-radius: 50%;
    left:0;
    bottom:-50px;
    box-shadow: 0 30px 20px rgba(0,0,0,.3);
    
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
		 
		  <div id="ListDiv" style="display:block;">
		 	    <br />
                  <div class="col-xs-12 col-md-2">
                  <div class="card">
                 <img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/themes/images/staff.jpg" alt=""> 
                 
                </div>
                                                                                        
         </div>
                   <div class="col-xs-12 col-md-10">
                    <div class="table-responsive">
                               <table class="table table-bordered">
                             
                              
                                
                             
                              <tbody>
                                 <tr >
                                  
                                    <th class="success"scope="row">Student ID</th>
                                    <td>CS125</td>
                                    <th class="success"scope="row">Date of Birth</th>
                                    <td>06-06-1994</td>
                                    
                                   	
                                   </tr>
                                    <tr >
                                  
                                    <th class="info" scope="row">Student Name</th>
                                    <td><span>C Smitha</span></td>
                                    <th class="info" scope="row">Joining Date</th>
                                    <td>16-05-2016</td>
                                  
                                   	
                                   </tr>
                                    <tr >
                                  
                                    <th class="danger" scope="row">User ID</th>
                                    <td>smitha@jdsoft.in</td>
                                   <th class="danger" scope="row">Course Category</th>
                                    <td>B.E</td>
                                    
                                   	
                                   </tr>
                                    <tr >
                                  
                                    <th class="info" scope="row">Course Type</th>
                                    <td>UG</td>
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
                  <br />
                  
			    
			     
			            <div class="form-group">
			             
			               <button  style="margin-left:2%" type="button"class="menu menu-p2 col-md-4" onclick="lessonsDiv()">Lessons</button>
			               <button  style="margin-left:2%"type="button" class="menu menu-c1 col-md-4" onclick="assignmentsDiv()">Assignments</button>
			            
			               
			               <button  style="margin-left:2%" type="button"class="menu menu-c2 col-md-4" onclick="outstandingDiv()">Fees And Outstanding</button>
			               <button  style="margin-left:2%" type="button" class="menu menu-p1 col-md-4" onclick="notificationsDiv()">Attendance</button>
			               <button  style="margin-left:2%" type="button"class="menu menu-p3 col-md-4" onclick="labsDiv()">Labs</button>
			            </div>
               	
                 </div>
                 
				<div id="lessonsDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Lessons</h3>
                     <div class="form-three widget-shadow" style="height:500px;">
                      <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Available"</p>
                  							</div>
                      
                     
                 </div>
                 </div>
            </div>
				</div>
				<div id="assignmentDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Assignments</h3>
                     <div class="form-three widget-shadow" style="height:500px;">
                      <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Available"</p>
                  							</div>
                 </div>
                 </div>
            </div>
				</div>
				<div id="outstandingDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Fees Details And Outstanding</h3>
                     <div class="form-three widget-shadow" style="height:500px;">
                      <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Available"</p>
                  							</div>
                 </div>
                 </div>
            </div>
				</div><div id="notificationsDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Attendance</h3>
                     <div class="form-three widget-shadow" style="height:500px;">
                 </div>
                 </div>
            </div>
				</div>
				<div id="labsDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Labs</h3>
                     <div class="form-three widget-shadow" style="height:500px;">
                      <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Available"</p>
                  							</div>
                 </div>
                 </div>
            </div>
			
				
				
					
				</div>
				
				<div class="clearfix"> </div>
			</div>
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
		<script>
         $(document).ready(function() {
        	 
        	 var card = $(".card");

        	 $(document).on("mousemove",function(e) {  
        	   var ax = -($(window).innerWidth()/2- e.pageX)/20;
        	   var ay = ($(window).innerHeight()/2- e.pageY)/10;
        	   card.attr("style", "transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-webkit-transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-moz-transform: rotateY("+ax+"deg) rotateX("+ay+"deg)");
        	 });
        		});
             
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