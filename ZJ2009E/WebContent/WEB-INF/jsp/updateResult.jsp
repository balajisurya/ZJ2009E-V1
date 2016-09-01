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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datatables.min.js"></script>
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
 <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
<!-- //chart -->

<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Results</h3>
		<div class="main-page">
		   <form class="form-horizontal">
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Exam ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Type ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Category ID</label> 
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
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Update Results</button>
                                 
                                                                     </div>
                              </div>
              </form>
           
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
              
       
   <h3 class="title1">Result History</h3>
                
                    
                       
                       
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   
                                    <th>Exam ID</th>
                               
                                    <th>Course Type Name</th>
                                  
                                    <th>Course Category Name</th>
                                  
                                      
                                    <th>Course Department Name</th>
                                  
                                     
                                     
                                     <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  
                                    <td>Column content</td>
                                    <td>Column content</td>
                                      <td>Column content</td>
                                    <td>Column content</td>
                                    
                                    <td>
                                    
                                    <a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    <span class="glyphicon glyphicon-edit"></span> 
                                    </a>
                                   
                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    <span class="glyphicon glyphicon-trash"></span> 
                                    </a>
                                    
                                    </td>
                                    
                                 </tr>
                                 
                                 <tr class="success">
                                   
                                    <td>Column content</td>
                                    <td>Column content</td>
                                      <td>Column content</td>
                                    <td>Column content</td>
                                    
                                    <td><a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" data-target="#confirm-edit">
                                    <span class="glyphicon glyphicon-edit"></span> 
                                    </a>
                                   
                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    <span class="glyphicon glyphicon-trash"></span> 
                                    </a></td>
                                 </tr>
                                 <tr>
                                   
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                  
                                    <td>
                                    <a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" data-target="#confirm-edit">
                                    <span class="glyphicon glyphicon-edit"></span> 
                                    </a>
                                   
                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    <span class="glyphicon glyphicon-trash"></span> 
                                    </a></td>
                                 </tr>
                                 <tr class="info">
                                   
                                   <td>Column content</td>
                                    <td>Column content</td>
                                      <td>Column content</td>
                                    <td>Column content</td>
                                   
                                    <td>
                                    <a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" data-target="#confirm-edit">
                                    <span class="glyphicon glyphicon-edit"></span> 
                                    </a>
                                   
                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    <span class="glyphicon glyphicon-trash"></span> 
                                    </a></td>
                                 </tr>
                                
                              </tbody>
                           </table>
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
                  
              
        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Print As Excel</button>
                                 
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