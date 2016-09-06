 <!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
        
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
     
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
       <c:if test="${!empty errorMessage}">
       		<script type="text/javascript">
		       	$(document).ready(function(){
			 		var message='${errorMessage.getMessage()}';
					alert(message);
		         });
       		</script>
       </c:if>
     
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 <div class="loader"  style="display: none"></div>
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Manage Receipts</h3>
		<div class="main-page">
		<div class="form-three widget-shadow">
		   <form class="form-horizontal" id="studentReceiptCriteriaForm">
                      <div class="form-group form-group-studentid" style="display:block">
                            <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
                                 </div>
                              </div>
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="submit"  id="getAllReceipts" class="btn btn-success">Get Student Receipts</button>
                                 <button style="float:right; margin-right: 20px " type="button" class="btn btn-danger" onclick="location.reload(true)">Back</button>
                                  
                                  </div>
                              </div>
            
               </form>
               </div>
                <div class="modal fade" id="confirm_delete_receipt" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this Receipt??</h5>
                     </div>
                     <div class="modal-footer">
                        <form id="deleteReceiptForm" action="${pageContext.request.contextPath}/receipt/delete" method="post">
                           <input type="hidden" id="deleteReceipitId" name="deleteReceiptId">
                           <button type="button" id="confirmDeleteReceipt"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
                 <div id="receiptDetailDiv" style="display:none;">
                 <br>
                
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
                                 
     
                   		<h3 class="title1">Receipts</h3>
                   		 
                      <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="studentReceipts">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                    <th>Admission No</th>
                                  	<th>Student Name</th>
                                   	<th>Class</th>
                               		<th>Section</th>
                               		<th>Action</th>
                                 </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                       <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br>
        </div>         
</div>
         </div>
		</div>
		
	
		
	
	
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/managereceipts.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

</body>
</html>