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

<!-- Include Required Prerequisites -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>

 
<!-- Include Date Range Picker -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script>


<!-- //chart -->

<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Time Table Generator</h3>
		<div class="main-page">
		   <form class="form-horizontal">
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course</label> 
                                 <div class="col-sm-6"> 
                                      <select name="course" id="" class="form-control1">
                                       
                                          <option value="" disabled selected>Select Course</option>
                                          
                                       
                                    </select>
                                 </div>
                              </div>
							  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Semester</label> 
                                 <div class="col-sm-6"> 
                               <select name="coursesem" id="" class="form-control1">
                                       
                                          <option value="" disabled selected>Select Semester</option>
                                          
                                       
                                    </select>
                                 </div>
                              </div>
                               
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Generate Time Table</button>
                                 
                                                                     </div>
                              </div>
              </form>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br />
       
   <h3 class="title1">Generated Time table Details</h3>
                  
                   
                      
                       
                          <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <tr>
													 <td align="center">
													 <td>8:30-9:30
													 <td>9:30-10:30
													 <td>10:3-11:30
													 <td>11:30-12:30
													 <td>12:30-2:00
													 <td>2:00-3:00
													 <td>3:00-4:00
													 <td>4:00-5:00
													</tr>
													<tr>
													 <td align="center">MONDAY
													 <td align="center">---<td align="center"><font color="blue">SUB1<br>
													 <td align="center"><font color="pink">SUB2<br>
													 <td align="center"><font color="red">SUB3<br>
													 <td rowspan="6"align="center">L<br>U<br>N<br>C<br>H
													 <td align="center"><font color="maroon">SUB4<br>
													 <td align="center"><font color="brown">SUB5<br>
													 <td align="center">counselling class
													</tr>
													<tr>
													 <td align="center">TUESDAY
													 <td align="center"><font color="blue">SUB1<br>
													 <td align="center"><font color="red">SUB2<br>
													 <td align="center"><font color="pink">SUB3<br>
													 <td align="center">---
													 <td align="center"><font color="orange">SUB4<BR>
													 <td align="center"><font color="maroon">SUB5<br>
													 <td align="center">library
													</tr>
													<tr>
													 <td align="center">WEDNESDAY
													 <td align="center"><font color="pink">SUB1<br>
													 <td align="center"><font color="orange">SUB2<BR>
													 <td align="center"><font color="brown">SWA<br>
													 <td align="center">---
													 <td colspan="3" align="center"><font color="green"> lab
													</tr>
													<tr>
													 <td align="center">THURSDAY
													 <td align="center">SUB1<br>
													 <td align="center"><font color="brown">SUB2<br>
													 <td align="center"><font color="orange">SUB3<BR>
													 <td align="center">---
													 <td align="center"><font color="blue">SUB4<br>
													 <td align="center"><font color="red">SUB5<br>
													 <td align="center">library
													</tr>
													<tr>
													 <td align="center">FRIDAY
													 <td align="center"><font color="orange">SUB1<BR>
													 <td align="center"><font color="maroon">SUB2<br>
													 <td align="center"><font color="blue">SUB3<br>
													 <td align="center">---
													 <td align="center"><font color="pink">SUB4<br>
													 <td align="center"><font color="brown">SUB5<br>
													 <td align="center">library
													</tr>
													<tr>
													 <td align="center">SATURDAY
													 <td align="center"><font color="red">SUB1<br>
													 <td colspan="3" align="center">seminar
													 <td align="center"><font color="pink">SUB4<br>
													 <td align="center"><font color="brown">SUB5<br>
													 <td align="center">library
													</tr>
                            
                                 
                           </table>
                        </div>
                        </div>
						
						
						
						<div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br />
						
						
						 <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Generate Time Table</button>
                                 
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
                  
            
        
       
         </div>
		</div>
		
	</div>
		
	
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		<script type="text/javascript">
$(function() {

  $('input[name="datefilter"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });

  $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
  });

  $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
  });

});
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