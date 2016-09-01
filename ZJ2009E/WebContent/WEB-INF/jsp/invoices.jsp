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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datatables.min.js"></script>
<!--animate-->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>

 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
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
		  <h3 class="title1">Invoices</h3>
		<div class="main-page">
		   <form class="form-horizontal" id="getDetails">
                    
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Class</option>
                                             <option value="" >Class I</option>
                                             <option value="">Class II</option>
                                             <option value="" >Class III</option>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Section</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="selector1" class="form-control1">
                                            <option value="" disabled selected>Select Section</option>
                                            <option value="">A</option>
                                             <option value="">B</option>
                                             <option value="">C</option>
                                          </select>
                                    
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Generate Category</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="category" class="form-control1">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                             <option value="specificstudent">Specific Student</option>
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                               <div class="form-group form-group-student-id" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Student ID</label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" class="form-control"/>
                                 </div>
                              </div>
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="selector1" class="form-control1">
                                            <option value="" disabled selected>Select Special Category</option>
                                            <option value="">RBI</option>
                                             <option value="">NON-RBI</option>
                                            
                                          </select>
                                    
                                 </div>
                              </div>
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button"  id="getInvoiceDetails" class="btn btn-success">Get Details</button>
                                
                                                                     </div>
                              </div>
              </form>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   <h3 class="title1">Invoice Details</h3>
                  
                     <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="datatable">
                              <thead>
                                 <tr>
                                 <th>Student Name</th>
                                  	<th>Department</th>
                                 	<th>Course</th>
                                   	<th>Semester</th>
                               		<th>Fees Amount</th>
                                 </tr>
                              </thead>
                              <tbody >
                         
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
                                    <button style="float:right"   class="btn btn-success">Generate Invoice</button>
                                 
                                                                     </div>
                              </div>
       
         </div>
		</div>
		
	</div>
		
	
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		<script>
		
		$(document).ready(function() {
			
			
			$("#category").change(function() {
		
		
				 var value = $(this).val();
				 
				 if(value ==="specificstudent"){
					 
					 $(".form-group-student-id").show();
				        $(".form-group-special-category").hide(); 
					 
				 }
				 else if(value==="specialcategory"){
					 
					 
					 
					 $(".form-group-student-id").hide();
				        $(".form-group-special-category").show();  
					 
				 }
				 else
					 {
					 
					 
					 $(".form-group-student-id").hide();
				        $(".form-group-special-category").hide();  
					 
					 
					 }
					
					 
		
		
			});
		
		
		
		});
		
		
		
		</script>
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
	
	<script src="${pageContext.request.contextPath}/resources/themes/script/invoicesdetails.js"></script>
	
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>