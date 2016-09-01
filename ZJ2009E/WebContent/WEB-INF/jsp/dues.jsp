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
      <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>    
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
		  <h3 class="title1">View Payment Pending List and Apply Penalty</h3>
		<div class="main-page">
		<div class="form-three widget-shadow">
		   <form class="form-horizontal" id="getDetailsForm">
                    <div class="form-group">
                                    <label for="" class="col-sm-4 control-label"> Select Pending Invoices with Due Dates in Range <span class="at-required-highlight">*</span></label> 
                                    <div class="col-md-6"> 
                                       <input type="text"  class="form-control form-control-datepicker-range" id="startandenddate"  name="startandenddate" placeholder="" required="required">
                                    </div>
                                 </div>
                           
                            
                              
                              
                              
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit"  id="getdetails" class="btn btn-success">Get Student List</button>
                                
                                                                     </div>
                              </div>
            
              </form>
              </div>
              <div id="invoicedetailsdiv" style="display:none;">  
              <br>
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   <h3 class="title1">Select Student(s) to Generate Invoice  for Penalty or Late Fee</h3>
                   <form class="form-horizontal" id="penaltyfeeform" action="${pageContext.request.contextPath}/invoice/penalty" method="post">
                     <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="penaltyInvoicesTable">
                              <thead>
                                 <tr>
                                 <th> <input name="select_all" value="1" id="example-select-all" type="checkbox"/>
                                 <th>Due Date</th>
                                    <th>Invoice No</th>
                                  	<th>Student Name</th>
                                 	<th>Class/Section</th>
                                   	<th>Invoice Amount</th>
                                   	<th>Penalty Amount</th>
                               		<th>Pending Fee</th>
                               		
                                 </tr>
                              </thead>
                              <tbody >
                              </tbody>
                           </table>
                        </div>
                        </div>
                   
                     
                     
						
                  <br>
                
                   
             <div class="form-group">
									
								<div class="col-md-6 control-label">
								
                                
                                 <label for="" class="col-md-4 control-label">Next due date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-8"> 
                                       <input type="text"  class="form-control form-control-datepicker" id="nextduedate"  name="nextduedate" placeholder="" required="required">
                                 </div>
                                 </div>
								<div class="col-md-6 control-label">
								
                                 <label for="" class="col-md-4 control-label">Additional Amount of Penalty<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" id="penaltyamount" name="penaltyamount" class="form-control" required="required" onkeypress="return isFloatNumber(this,event)"/>
                                 </div>
                                 </div>
                                 
                                 
                             
                              </div>
                               <div class="form-group">
                               <div class="col-md-6 control-label">
                               <label for="txtarea1" class="col-sm-4 control-label">Name of the Fine<span class="at-required-highlight">*</span></label>
									
									<div class="col-sm-8"><input type="text" name="fineName"  id="" required="required" class="form-control"></input></div>
                               
                               
                               </div>
                               </div>
                               	<input id="selectedStudentIds" name="selectedStudentIds" type="hidden">
                              <br>
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="generateduesinvoice" class="btn btn-success">Generate Invoice</button>
                      </div>
                              </div>
                              </form>
       </div>
         </div>
		</div>
		
	</div>
		
	
	
		
		
	
	
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/dues.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp	_menu.js"></script> 
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