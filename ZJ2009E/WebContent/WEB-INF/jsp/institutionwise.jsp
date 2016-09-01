<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
      
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <link href="${pageContext.request.contextPath}/resources/datatable/css/jquery.dataTables.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/datatable/css/buttons.dataTables.min.css" rel="stylesheet">
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
   
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
     

   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <div class="main-content">
         <!-- main content start-->
         <div id="page-wrapper">
            <div class="main-page">
            		<!-- <div id="bread-crum">
            		<div id="row">
            		<div class="col-sm-6">
            			<h1 class="title1">Reports</h1>
            		</div>
            		<div class="col-sm-6">
            		<br></br>
            			<ol class="breadcrumb">
  							<li class="breadcrumb-item"><a href="#">Institutions</a></li>
		  					<li class="breadcrumb-item active">Academic Years</li>
		  					<li class="breadcrumb-item active">Classes</li>
		  					<li class="breadcrumb-item active">Sections</li>
		  					<li class="breadcrumb-item active">Students</li>
		  					<li class="breadcrumb-item active">Invoices</li>
						</ol>
            		</div>
            		</div>
            		</div>
            	 <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div> -->
               <div id="ListDiv" style="display:block;">
                  <h3 class="title1">Institution Wise Reports</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                        <table class="table table-bordered" id="institutionWise">
                           <thead style="background-color:#673AB7;color:#ffffff;">
                              <tr>
                                 <th>Institution</th>
                                 <th>Total Of Invoices</th>
                                 <th>Total Of Fines</th>
                                 <th>Total Collections</th>
                                 <th>Total Fines Collected</th>
                                 <th>Total Invoice Outstanding</th>
                                 <th>Total Fines Outstanding</th>
                                <!--  <th>Details</th> -->
                              </tr>
                           </thead>
                           <tbody id="inistitutionWiseReports">
                              <c:if test="${!empty institutionsReports}">
                                 <c:forEach items="${institutionsReports}" var="institutionReports">
                                    <tr >
                                       	<td>${institutionReports.getF1().getInstitutionName()}</td>
                                       	<td>${institutionReports.getF2()}</td>
                                       	<td>${institutionReports.getF3()}</td>
                                	    <td>${institutionReports.getF4()}</td>
                                	    <td>${institutionReports.getF5()}</td>
                                 		<td>${institutionReports.getF6()}</td>
                                 		<td>${institutionReports.getF7()}</td>
                                       <!--  <td>
                                          <a href="#" id="institutionDetail123s"  type="button" data-href="#" data-id="" data-toggle="">
                                          <span class="glyphicon glyphicon-menu-right"></span> 
                                          </a>
                                       </td> -->
                                    </tr>
                                 </c:forEach>
                              </c:if>
                           </tbody>
                        </table>
                       
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
    
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/institutionwise.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/datatable/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.flash.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.print.min.js"></script>
      
      
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
      
       <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
               <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      
      
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
     
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
     
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
   </body>
</html>

