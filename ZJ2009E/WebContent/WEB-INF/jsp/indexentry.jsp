
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
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		<div class="main-page">
            
       
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Index</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Index ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Document Reference</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Document Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Document Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Document Path (Location)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                               
                            
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Document Status</label> 
                                 <div class="col-sm-6"> 
                                   <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option>Secured</option>
                                       <option>Archive</option>
                                       <option>Shareable</option>
                                    </select>
                                 </div>
                              </div>
                              
                              
                              
                              
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Add Index and Add Another Entry</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
                                 </div>
                              </div>
                             
                             
                  
                             
                              
                             
                           
                        
                        </form>
                   
                  </div>
               </div>
            </div>
       
       
         </div>
		</div>
		
	</div>
		
	
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
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