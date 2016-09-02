 <!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <% int timeout = session.getMaxInactiveInterval();response.setHeader("Refresh", timeout + "; URL =");%>
 <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
  
       <script src="${pageContext.request.contextPath}/resources/themes/printpage/js/jquery.printPage.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
      
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
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  
		<div class="main-page">
		<div class="loader"  style="display: none"></div>
		               <div id="ListDiv" style="display:block;">
<h3 class="title1">View and Print Invoice / Fee Collection Record (FCR)</h3>    
		
		 <div class="form-three widget-shadow">
		   <form class="form-horizontal" id="getDetailsForm">
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="academicYearId" id="academicYearId"  class="form-control1" required="required">
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
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="class" id="class" class="form-control1" required="required">
                                  <c:if test="${!empty classes}">
                                  		<option value="" disabled selected>Select Class</option>
                                       <c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="section" id="section" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Class</option>
                                   </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="criteria" id="criteria" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                             <option value="specificstudent">Specific Student</option>
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                               <div class="form-group form-group-student-id" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
                                 </div>
                              </div>
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="specialCategoryId" id="specialCategoryId" class="form-control1" required="required">
                                  	<c:if test="${!empty specialCategories}">
                                  		 <option value="" disabled selected>Select Special Category</option>
                                      		 <c:forEach items="${specialCategories}" var="specialCategory">
                                      			 <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                            </c:forEach>
                                      </c:if>
                                    </select>
                                    
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Invoice / FCR<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="invoiceandfcr" id="invoiceandfcr" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Invoice/FCR</option>
                                            <option value="invoice">Invoice</option>
                                             <option value="fcr">FCR</option>
                                            
                                          </select>
                                    
                                 </div>
                              </div>
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button"  id="getdetailsfromselectedcriteria" class="btn btn-success">Get Details</button>
                                
                                                                     </div>
                              </div>
              </form>
              </div>
              
              
               <div id="invoicedetailsdiv" style="display:none;">     
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   <h3 class="title1">Invoice Details</h3>
                  
                     <div class="tables">
                     
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="invoicedatatable">
                              <thead>
                                 <tr>
                                 	<th>Invoice No</th>
                                    <th>Admission No</th>
                                    <th>Student Name</th>
                                  	<th>Due Date</th>
                                  	<th>Fees Amount</th>
                                  	<th>Paid Amount</th>
                                  	<th>Penalty</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              
                           
                           </table>
                        </div>
                        </div>
        </div>
                  <div id="receiptdetailsdiv" style="display:none;">     
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   <h3 class="title1">Receipt Details</h3>
                  
                     <div class="tables">
                     
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="receiptdatatable">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                    <th>Admission No</th>
                                    <th>Student Name</th>
                                    <th>Payment Received Date</th>
                                    <th>Payment Mode</th>
                                    <th>Payment Status</th>
                               		<th>Fees Amount</th>
                               		<th>Action</th>
                               		
                                 </tr>
                              </thead>
                              
                           </table>
                        </div>
                        </div>
                   
                    
                     
						 
             
        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Print Invoice</button>
                                 
                                                                     </div>
                              </div>
                             
        </div>
        </div>
                    
                              <div class="modal fade" id="invprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this invoice.</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printinv" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
             <div class="modal fade" id="recprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this receipt.</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printrec" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
         </div>
		</div>
		
	</div>
		
	
	
		
		
		
      

<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
	<script src="${pageContext.request.contextPath}/resources/themes/script/invoiceandreceipt.js"></script>
   <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
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