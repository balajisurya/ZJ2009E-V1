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
<!-- font CSS -->
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet"> 
<link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
<!-- //font-awesome icons -->
 <!-- js-->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
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
 <!-- Load jQuery JS -->
      <!-- Load jQuery UI Main JS  -->
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<!-- //chart -->
<!-- Include Required Prerequisites -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>

 
<!-- Include Date Range Picker -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 

<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Staff Attendance</h3>
		<div class="main-page">
		
                   
				  <div class="forms">
				  <form class="form-horizontal">
	             		
	               		 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Excel Sheet</label> 
                                 <div class="col-md-4 col-sm-4 col-xs-12">
                                          <input type="file"name="" id=""> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                            
					   
		                 	<div class="col-md-4 col-sm-4 col-xs-12"> 
		                  		<button type="button" class="btn btn-info col-md-8 col-xs-12" id="downloadformat">Download Excel</button>
		                  	</div>
		               </div>
			   
				   		<script>
						  	$("#downloadformat").click(function(event){
			        		  $("#download").modal('show');
			  	        	});
				  		</script> 
			   		</form>
			   
                
                  
            </div>
			<div class="modal fade" id="download" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Download Format</h4>
                     </div>
                     <div class="modal-body">
                       <div class="forms">
					   <form class="form-horizontal">
					     <div class="form-group">
                                 <label for="" class="col-sm-4 control-label">Select Start and End Date</label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control form-control-datepicker-range" id=""  name="" placeholder="">
                                 </div>
                                 
                           </div>
					   </form>
					   </div>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Download</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="confirm-save" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Action ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="" id="save-attendance" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                   <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
		       
		        <div class="forms">
				  <form class="form-horizontal">
	             		<h3 class="title1">Add Attendance</h3>
	             		<br>
			   			 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Attendance Date</label> 
                                <div class="col-sm-6"> 
                                       <input type="text" name="staffAttendanceDate" class="form-control form-control-datepicker" id="staffAttendanceDate" placeholder="">
                                 </div>
                         </div>
                         <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                    <th>Staff Id</th>
                                    <th>Staff Name</th>
                                    <th>Staff Category</th>
                                    <th style="width:300px">Attendance</th>
                                    <th>Remarks</th>
                                 </tr>
                              </thead>
                              <tbody>
                                  <c:if test="${!empty staffList}">
		                                <c:forEach items="${staffList}" var="staff">
		                                      <tr class="active" id="test">
				                                    <td id="${staff.getStaffId()}" style="width:100px">${staff.getStaffId()}</td>
				                                    <td style="width:230px">${staff.getStaffFirstName()} ${staff.getStaffLastName()}</td>
				                                    <td style="width:230px">${staff.getStaffCategory().getStaffCategoryName()}</td>
				                                    <td> 
				                                   
				                                             <select name="staffAttendanceType" id="staffAttendanceType" class="form-control1">
						                                     	<option value="" disabled>Select Attendance</option>
						                                     	<c:if test="${!empty staffAttendanceTypeList}">
						                                     	   <c:forEach items="${staffAttendanceTypeList}" var="staffAttendanceType">
						                                            	 <option value="${staffAttendanceType.getStaffAttendanceTypeId()}">${staffAttendanceType.getStaffAttendanceTypeTitle()}</option>
						                                            </c:forEach>
						                                       </c:if>
						                                    </select>
						                                   
						                            </td>
						                             <td style="width:230px"><input type="text" id="" class="form-control"/></td>
                                 			  </tr>      	
		                                 </c:forEach>
		                           </c:if>
                              </tbody>
                           </table>
                        </div>
                        </div>
                        <div class="x_title">
		                     <div class="clearfix">
		                     </div>
                  		</div>
                        
		                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="button" id="staffattendance" class="btn btn-success">Save</button>
                                   
                                  
                                                          </div>
                              </div>
                        
				  </form>
			  </div>
		    </div>
       		</div>
		</div>
		
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		 <script src="${pageContext.request.contextPath}/resources/themes/script/staffattendance.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
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