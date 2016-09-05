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
     
      <script src="${pageContext.request.contextPath}/resources/themes/printpage/js/jquery.printPage.js"></script>
     
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
      <c:if test="${!empty receiptId1}">
      <script>
         $(document).ready(function() {
        	 var receiptId='${receiptId}'
        	$("#print").printPage();
           $('#printreceipt').modal('show');
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
		<div class="main-page">
          <div id="FormDiv" style="display:block;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create Receipt</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="getDetailsForm">
                        <div class="form-group">
										<label class="col-md-3 control-label">Admission No (Student Id)<span class="at-required-highlight">*</span></label>
										<div class="col-md-6">
											<div class="input-icon right spinner">
												<i class="fa fa-fw fa-spin fa-spinner"></i>
												 <input type="text" class="form-control" id="admissionNo" name="admissionNo" placeholder="" required="required">
											</div>
										</div>
										
									</div>
									  <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit"  id="getdetails" class="btn btn-success">Get Term  Fees Details </button>
                                
                                                                     </div>
                              </div>
                        </form>
                         
                              
                           
                    <div id="invoicedetailsdiv" style="display:none;">          
            
               <div class="x_title">
                  <div class="clearfix">
                  </div>  
               </div>
               <br />
                               <h3 class="title1">Student Fees Details</h3>
                   
                     <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="studentReceiptListTable">
                              <thead>
                                 <tr>
                                    <th></th>
                                    <th>Academic Year</th>
                                    <th>Term</th>
                                  	<th>Invoice Amount</th>
                                 	<th>Details</th>
                               	</tr>
                              </thead>
                      
                           </table>
                        </div>
                         <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="proceedForPayment"  class="btn btn-success">Proceed For Payment</button>
                                 </div>
                              </div>
                        </div>
                               
               
               </div>
                      </div>
                </div> </div>
                               </div>
                              
 
                 
                 
                 
                 
                 
             <div id="feesItemFormDiv" style="display:none;">
                         <div class="forms">
                  <div class="row">
                     <h3 class="title1">Term Fees Details</h3>
                     <div class="form-three widget-shadow">
                       	 <div class="tables">
                         		<div class="table-responsive bs-example widget-shadow">
                             		<table class="table table-bordered" id="studentInvoiceFeesItems">
			                              <thead>
			                                 <tr>
			                                    <th>Serial No</th>
			                                  	<th>Fees Item Name</th>
			                                 	<th>Fees Amount</th>
			                                </tr>
			                              </thead>
                           			</table>
                        		</div>
                        	 </div>
                        </div>
                </div> </div>
             </div>
             
             
             
             
             
             	<div id="confirmedInvoiceFormDiv" style="display:none;">
                         <div class="forms">
                  			<div class="row">
                    			<h3 class="title1">Payment Details</h3>
                     				<div class="form-three widget-shadow">
                        				<form class="form-horizontal" id="paymentDetailsForm"  action="${pageContext.request.contextPath}/receipt/generate" method="post">
                      							<div class="tables">
							                         <div class="table-responsive bs-example widget-shadow">
							                             <table class="table table-bordered" id="finalPaymentDetailTable">
							                              <thead>
							                                 <tr>
							                                    <th>Serial No</th>
							                                    <th>Academic Year</th>
							                                  	<th>Selected Fees Term</th>
							                                 	<th>Invoice Amount</th>
							                                </tr>
							                              </thead>
							                           </table>
							                        </div>
							                        <div id="hiddenPaidInvoices">
							                        </div>
							                     </div>
                            					<br>   
                <h3 class="title1">Payment Details</h3>
                               <br>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total Amount</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="amount" name="amount" placeholder="" readonly="readonly">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                 <select name="paymentMode" id="paymentMode" class="form-control1" required="required">
                                 	<c:if test="${!empty paymentmodes}">
                                 		<option value="" disabled selected>Select Mode</option>
                                       	<c:forEach items="${paymentmodes}" var="paymentmode">
                                       		<option value="${paymentmode.getPaymentModeId()}">${paymentmode.getPaymentModeTitle()}</option>
                                       	</c:forEach>
                                     </c:if>
                                       
                                       
                                  </select>
                                 
                                                                  </div>
                              </div>
                               
                               
                               <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeNo" name="chequeNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-cheque-input" id="" name="chequeDate" placeholder="" >
                                 </div>
                                 
                              </div>
                               
                                 <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddNo" name="ddNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-dd-input" id="ddDate" name="ddDate" placeholder="">
                                 </div>
                                 
                              </div>
                               
                               
                               <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBankName"  name="chequeBankName" placeholder="">
                                 </div>
                              </div><div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Branch Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBranchName"  name="chequeBranchName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBankName" name="ddBankName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD Bank Branch Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBranchName" name="ddBranchName" placeholder="">
                                 </div>
                              </div>
                              
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Received Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="receivedDate" name="receivedDate" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fine</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="fineAmount" name="fineAmount" placeholder="">
                                 </div>
                              </div>
                             
                               <div class="row">
                                 <div class="col-sm-offset-3">
                                 
                               <button style="float:right" type="submit" id="generateFCR"  class="btn btn-success">Save And Print</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                             
                           </form>
             
                       </div>
                </div> </div>
                  </div>
             
             
             
             
             
             
             
             
             
             
             
             
           
            
       <div class="modal fade" id="printreceipt" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this receipt ??</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="print" href="${pageContext.request.contextPath}/receipt/print?receiptId=${receiptId}">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
       
         </div>
		</div>
		
	</div>
		
	
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
		<script src="${pageContext.request.contextPath}/resources/themes/script/receipt.js"></script>

 <script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>