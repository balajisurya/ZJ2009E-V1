 <!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap Core CSS -->
 <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
    
       <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
       <!-- //chart -->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>
      <!-- Include Date Range Picker -->
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script>
<!-- chart -->
     
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Fees and Fine Collection</h3>
		<div class="main-page">
		<div class="form-three widget-shadow">
		
          <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
                <div class="tables" id="fessCollectionTableDiv" style="display: block">
                
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="fineTable">
                              <thead>
                                 <tr>
                                 <th>Receipt No</th>
                                 <th>Admission No</th>
                                 <th>Class</th>
                                 <th>Section</th>
                                 <th>Academic Year</th>
                                 <th>Term</th>
                                 <th>Fine Amount</th>
                                 </tr>
                              </thead>
                              <tbody >
                              <c:if test="${!empty fineReceipts}">
                              <c:forEach items="${fineReceipts}" var="fineReceipt">
                                 <tr>
                                   <c:set var="fineAmount" value="0"></c:set>
                                    <td>${fineReceipt.getReceiptId()}</td>
                                    <td>${fineReceipt.getStudent().getAdmissionNo()}</td>
                                    <td>${fineReceipt.getStudent().getStudentClass().getClassName()}</td>
                                    <td>${fineReceipt.getStudent().getSection().getSectionName()}</td>
                                    <td>${fineReceipt.getAcademicYear().getAcademicYearTitle()}</td>
                                    <td>${fineReceipt.getStudentInvoice().getAcademicYearFeesTerm().getFeesTermTitle()}</td>
                                    <%-- <c:forEach items="${fineReceipt.getReceiptFines()}" var="receiptFineRecord">
                                    <c:set var="fineAmount" value="${fineAmount+receiptFineRecord.fineAmount}"></c:set>
                                    </c:forEach>
                                    <td>${fineAmount}</td> --%>
                                 </tr>
                              </c:forEach>
                           </c:if>
                              </tbody>
                           </table>
                        </div>
                        </div>
                  <br>
                  
         
         </div>
		</div>
		
	</div>
		</div>
	
	
		
		
	
	
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/collectionreport.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp	_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/datatable/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.flash.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.print.min.js"></script>
<!-- Classie -->
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