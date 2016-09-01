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
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>  
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/validate.js"></script>
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
		 
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Reconcillation</h3>
		<div class="main-page">
		   <form class="form-horizontal" id="reconcillationCriteriaForm">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode</label> 
                                 <div class="col-sm-6"> 
                                  <select name="paymentModeId" id="paymentModeId" class="form-control1" required="required">
                                  	<c:if test="${!empty paymentModes}">
                                  		 <option value="" disabled selected>Select PaymentMode</option>
                                      		<c:forEach items="${paymentModes}" var="paymentMode">
                                      		 	<option value="${paymentMode.getPaymentModeId()}">${paymentMode.getPaymentModeTitle()}</option>
                                      		 </c:forEach>
                                          </c:if>
                                    </select>
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Status</label> 
                                 <div class="col-sm-6"> 
                                  <select name="paymentStatusId" id="paymentStatusId" class="form-control1" required="required">
                                  		 <option value="" disabled selected>Select Payment Status</option>
                                    </select>
                                 </div>
                              </div>
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="getReceiptsRecords"  class="btn btn-success">Get Receipt Records</button>
                                  </div>
                              </div>
              </form>
             <div class="x_title">
                  				<div class="clearfix">
                  				</div>  
               				</div>
               	        <div id="receiptdetailsdiv" style="display:none;">          
            				   <h3 class="title1">Receipts</h3>
                  
                     <div class="tables" id="cashReconPendingTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="cashReconPending">
                              <thead>
                                 <tr>
                                    <th>Transaction No</th>
                                 	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>Cash Received Date</th>
                                   	<th>Action</th>
                               	</tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        <div class="tables" id="cashReconClearedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="cashReconCleared">
                              <thead>
                                 <tr>
                                    <th>Transaction No</th>
                                 	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>Cash Cleared Date</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="chequeReconPendingTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconPending">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>Cheque No</th>
                                 	<th>Received Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                   	<th>Action</th>
                               	</tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="chequeReconClearedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconCleared">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>Cheque No</th>
                                 	<th>Cheque Cleared Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                        <div class="tables" id="chequeReconBouncedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconBounced">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>Cheque No</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="ddReconPendingTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconPending">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>DD No</th>
                                 	<th>DD Received Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                   	<th>Action</th>
                               	</tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                        <div class="tables" id="ddReconClearedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconCleared">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                  	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>DD No</th>
                                 	<th>DD Cleared Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="ddReconBouncedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconBounced">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                  	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                 	<th>DD No</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                      <!--   <div class="tables" id="paymentGatewayReconPendingTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="paymentGatewayReconPending">
                              <thead>
                                 <tr>
                                    <th>Serial No</th>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                  	<th>Gateway Name</th>
                                 	<th>Gateway Payment Mode</th>
                                 	<th>Transaction No</th>
                                 	<th>Payment Date</th>
                                 	<th>Action</th>
                               	</tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                        <div class="tables" id="paymentGatewayReconClearedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="paymentGatewayReconCleared">
                              <thead>
                                 <tr>
                                    <th>Serial No</th>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                  	<th>Gateway Name</th>
                                 	<th>Gateway Payment Mode</th>
                                 	<th>Transaction No</th>
                                 	<th>Payment Cleared Date</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div> -->
                        
                 </div>
                 
                 
                 
               <div class="modal fade" id="cash_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateCashReconForm" action="${pageContext.request.contextPath}/receipt/cashRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                  <select name="cashReconPaymentStatusId" id="cashReconPaymentStatusId" class="form-control1" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="cashReconClearanceDate" name="clearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-6"> 
	                                    <textarea  class="form-control1" rows="3" id="cashReconComment" name="cashReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		  <input type="hidden" id="cashReconReceiptId"  name="cashReconReceiptId">
	                     		<a href="#" id="updateCashRecon" style="float:right"  class="btn btn-success" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
            <!-- Cheque -->
            
            <div class="modal fade" id="cheque_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateChequeReconForm" action="${pageContext.request.contextPath}/receipt/chequeRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                  <select name="chequeReconPaymentStatusId" id="chequeReconPaymentStatusId" class="form-control1" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="chequeReconClearanceDate" name="chequeReconClearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-6"> 
	                                    <textarea  class="form-control1" rows="3" id="chequeReconComment" name="chequeReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		  <input type="hidden" id="chequeReconReceiptId" name="chequeReconReceiptId">
	                     		<a href="#" id="updateChequeRecon" style="float:right"  class="btn btn-success" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
            
            <!-- DD -->
            
            <div class="modal fade" id="dd_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateDdReconForm" action="${pageContext.request.contextPath}/receipt/ddRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                  <select name="ddReconPaymentStatusId" id="ddReconPaymentStatusId" class="form-control1" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-6"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="ddReconClearanceDate" name="ddReconClearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-6"> 
	                                    <textarea  class="form-control1" rows="3" id="ddReconComment" name="ddReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		  <input type="hidden" id="ddReconReceiptId" name="ddReconReceiptId">
	                     		<a href="#" id="updateDdRecon" style="float:right"  class="btn btn-success" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
         </div>
		</div>
		
	</div>
		

     


<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/reconcillation.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/datatable/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.flash.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatable/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>