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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/cdntolocal/css/smoothness-jquery-ui.css" />
      <!-- font-awesome icons -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
      <!-- //font-awesome icons -->
      <!-- js-->
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <!--webfonts-->
      <link href='${pageContext.request.contextPath}/resources/cdntolocal/css/fonts-googleapis.css' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">

     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <link href="${pageContext.request.contextPath}/resources/datatable/css/jquery.dataTables.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/datatable/css/buttons.dataTables.min.css" rel="stylesheet">
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>  
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/validate.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
           	 <c:if test="${!empty errorMessage}">
       		<script type="text/javascript">
		       	$(document).ready(function(){
			 		var message='${errorMessage.getMessage()}';
					alert(message);
		         });
       		</script>
       </c:if>
       <style>
      
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
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 <div class="loader"  style="display: none"></div>
		<!-- main content start-->
		<div id="page-wrapper">
		
		<div class="main-page">
		
		 <div id="ListDiv" style="display:block;">
		  <h3 class="title1">Fees Term Reports</h3>
		   <form class="form-horizontal" id="getStudentDetailsForm"  name="getFeesTermDetails">
                    
                              <div class="row">
                                 <div class="col-sm-offset-3">
                              </div>
                                                              
                              </div>
                               <br>
                               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                <select name="academicYear" id="academicYear" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Academic Year</option>
                                           		 <c:if test="${!empty academicYears}">
		                                       			<c:forEach items="${academicYears}" var="academicYear">
		                                       				<option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Term<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="feesTermId" id="feesTermId" class="form-control1" required="required">
                                            	<option value="" disabled selected>Select Fees Term</option>
                                          </select>
                                 </div>
                              </div>
                              
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                 <button style="float:right" type="button"  id="getStudentList" class="btn btn-success">Get List</button>
                                 </div>
                              </div>
            </form>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  
                <div id="studentList" style="display:none;">
                  <h3 class="title1">Student List</h3>
                   <form class="form-horizontal" id="deleteStudentForms" action="${pageContext.request.contextPath}/student/bulkdelete" method="post">
                   
                     <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="studentListTable">
                              <thead>
                                 <tr>
                                    <th>Admission No</th>
                                    <th>Student Name</th>
                                  	<th>Class</th>
                                  	<th>Section</th>
                                  	<th>Special Category</th>
                                 </tr>
                              </thead>
                             
                           </table>
                        </div>
                        </div>
                    </form>
                </div>
        </div>
      
         </div>
		</div>
		
	</div>
		
	
			
 
		<!-- Bootstrap Core JavaScript -->
		 <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
		<script src="${pageContext.request.contextPath}/resources/themes/script/termfeesreport.js"></script>
		<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
	
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
		<!--scrolling js-->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

	<script src="${pageContext.request.contextPath}/resources/datatable/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.flash.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.print.min.js"></script>

<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>