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
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
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
      
        
          
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      

      
     
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
        
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <script  src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
    
        
      

<!-- //chart -->

<!--//Metis Menu -->
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		<div class="main-page">
                <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Create New Fees Record</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                <h3 class="title1">View And Edit Fees Record</h3> 
                
                <div class="form-three widget-shadow">
                
                 		<div class="tables">
                        <div class="table-responsive bs-example ">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Fees Collection Record Id</th>
                                   	<th>Payment Mode</th>
                                  	<th>Amount</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                               <c:if test="${!empty FeesCollectionRecordList}">
                                       <c:forEach items="${FeesCollectionRecordList}" var="FeesCollectionRecordList">
                                          <tr id="FeesCollectionRecordList">
                                             <td>${FeesCollectionRecordList.getFeesCollectionRecordId()}</td>
                                             <td>${FeesCollectionRecordList.getPaymentMode()}</td>
                                            <td>${FeesCollectionRecordList.getAmount()}</td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${FeesCollectionRecordList.getFeesCollectionRecordId()}" data-toggle="modal" >
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${FeesCollectionRecordList.getFeesCollectionRecordId()}" data-toggle="modal" >
                                   					 <span class="glyphicon glyphicon-trash"></span> 
                                    			</a>
                                             </td>
                                          </tr>
                                       </c:forEach>
                                    </c:if>
                               </tbody>
                           </table>
                        </div>
                        </div>
                       
           
                 </div>
                   <br />
               <br />
                <br />
             </div>
             <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Action?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure to delete?</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmDelete"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
                <div id="EditFormDiv" style="display:none;">
                     <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Fees Record</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updatefeesDetails">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Invoice ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editInvoiceId" name="editInvoiceId" placeholder="">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editStudentId" name="editStudentId" placeholder="">
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editInstituteId" name="editInstituteId" placeholder="">
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode</label> 
                                 <div class="col-sm-6"> 
                                 <select name="editPaymentMode" id="editPaymentMode" class="form-control1">
                                       <option value="" disabled selected>Select Mode</option>
                                       <option value="Cash">Cash</option>
                                        <option value="DD">DD</option>
                                       <option value="Cheque">Cheque</option>
                                    
                                        <option value="BankEFT">Bank EFT</option>
                                      
                                        
                                    </select>
                                 
                                                                  </div>
                              </div>
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Amount</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editAmount" name="editAmount" placeholder="">
                                 </div>
                              </div>
                             
                            <div class="form-group form-group-cheque-dd" style="display: none">
                            
                                 <label for="" class="col-sm-3 control-label">DD/Cheque No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editDdOrChequeNo" name="editDdOrChequeNo" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group form-group-cheque-dd" style="display: none">
                                
                                 <label for="" class="col-sm-3 control-label">DD/Cheque Date</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker"  id="editDdOrChequeDate" name="editDdOrChequeDate" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payable at</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editPayableAt" name="editPayableAt" placeholder="">
                                 </div>
                              </div>
                                   <div class="form-group form-group-cheque-dd" style="display: none">
                                 
                                 <label for="" class="col-sm-3 control-label">Outstation Cheque?</label> 
                                 <div class="col-sm-6"> 
                                   <select name="editOutStationCheque" id="editOutStationCheque" class="form-control1">
                                       <option value="" disabled selected>Select Yes/No</option>
                                       <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                     
                                        
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankName"  name="editBankName" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group form-group-cheque-dd-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">Bank Address Line 1</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankAddressLine1" name="editBankAddressLine1" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-cheque-dd-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">Bank Address Line 2</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankAddressLine2" name="editBankAddressLine2" placeholder="">
                                 </div>
                              </div>
                              
                                 <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 
                                       <label for="" class="col-sm-3 control-label">Bank Country</label> 
                                       <div class="col-sm-6">
                                          <select name="editBankCountryId" id="bankgeographicallocation" class="form-control1">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>   
                                       <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                     
                                 <label for="" class="col-sm-3 control-label">Bank State </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editBankStateId" id="bankgeographicallocationstate" class="form-control1">
                                     <option value="0" disabled selected>Select State </option>
                                    <c:if test="${!empty stateList}">
		                                       			<c:forEach items="${stateList}" var="stateList">
		                                       				<option value="${stateList.getGeographicalLocationId()}">${stateList.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>
                                 </div>
                              </div>   
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">Bank City </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editBankCityId" id="bankgeographicallocationcity" class="form-control1">
                                     <option value="" disabled selected>Select City </option>
                                       <c:if test="${!empty cityList}">
		                                       			<c:forEach items="${cityList}" var="cityList">
		                                       				<option value="${cityList.getGeographicalLocationId()}">${cityList.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                     </select>
                                 </div>
                              </div>   
                             <div class="form-group form-group-cheque-dd-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">Bank Post Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankPostCode" name="editBankPostCode" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group form-group-eft" style="display: none">
                             
                                 <label for="" class="col-sm-3 control-label">Bank (EFT) Transaction Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankTransactionCode" name="editBankTransactionCode" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-eft" style="display: none">
                              
                                 <label for="" class="col-sm-3 control-label">EFT Bank IFSC</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankIFSCCode" name="editBankIFSCCode" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group form-group-eft-cash" style="display: none">
                             
                                 <label for="" class="col-sm-3 control-label">Date of EFT or Cash</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="editDateOFEFTOrCash" name="editDateOFEFTOrCash" placeholder="">
                                 </div>
                                 
                              </div>
                              
                                  <div class="form-group form-group-cheque-dd" style="display: none">
                                
                                 <label for="" class="col-sm-3 control-label">Bank Statement Status</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editBankStatementStatus" name="editBankStatementStatus" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally GL Account</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editTallyGLAccount" name="editTallyGLAccount" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Remarks</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editRemarks" name="editRemarks" placeholder="">
                                 </div>
                              </div>
                            
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="updateRecord"  class="btn btn-success">Update</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                             
                           </form>
                   
                     
                  </div>
               </div>
            </div>
                </div>
                  
                     <div class="modal fade" id="SaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
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
                        <button type="button" class="btn btn-primary" name="SaveConfirm" id="SaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
          <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Record</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="feesDetails"  action="${pageContext.request.contextPath}/student/addStudentFeesDetails" method="post">
                        <div class="form-group">
										<label class="col-md-3 control-label">Invoice ID<span class="at-required-highlight">*</span></label>
										<div class="col-md-6">
											<div class="input-icon right spinner">
												<i class="fa fa-fw fa-spin fa-spinner"></i>
												 <input type="text" class="form-control" id="invoiceId" name="invoiceId" placeholder="" required="required">
											</div>
										</div>
										
									</div>
                        
                        
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="studentId" name="studentId" placeholder=""readonly="readonly">
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="instituteId" name="instituteId" placeholder="" readonly="readonly">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total Amount</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="amount1" name="amount1" placeholder="" readonly="readonly">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                 <select name="paymentMode" id="paymentMode" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Mode</option>
                                       <option value="Cash">Cash</option>
                                        <option value="DD">DD</option>
                                       <option value="Cheque">Cheque</option>
                                       
                                        <option value="BankEFT">Bank EFT</option>
                                       
                                        
                                    </select>
                                 
                                                                  </div>
                              </div>
                               
                               
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Paid Amount<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="amount" name="amount" placeholder="" required="required" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/Cheque No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="ddOrChequeNo" name="ddOrChequeNo" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/Cheque Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker"  id="ddOrChequeDate" name="ddOrChequeDate" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payable at</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="payableAt" name="payableAt" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Outstation Cheque /DD?<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="outStationCheque" id="outStationCheque" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Yes/No</option>
                                       <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                     
                                        
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankName"  name="bankName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Address Line 1</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankAddressLine1" name="bankAddressLine1" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Address Line 2</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankAddressLine2" name="bankAddressLine2" placeholder="">
                                 </div>
                              </div>
                              
                                <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Country</label> 
                                 <div class="col-sm-6">
                                    <select name="bankCountryId" id="geographicallocation" class="form-control1">
                                       <c:if test="${!empty geographicallocationList}">
                                          <option value="" disabled selected>Select Country </option>
                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
                                             <option id="geoid" value="${geographicallocation.getGeographicalLocationId()}">${geographicallocation.getGeographicalLocationName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank State </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="bankStateId" id="geographicallocationstate" class="form-control1">
                                     <option value="" disabled selected>Select Country First </option>
                                    
                                    </select>
                                 </div>
                              </div>
                            
                             <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank City </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="bankCityId" id="geographicallocationcity" class="form-control1">
                                     <option value="" disabled selected>Select State First </option>
                                    
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group form-group-cheque-dd-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Post Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankPostCode" name="bankPostCode" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group form-group-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank (EFT) Transaction Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankTransactionCode" name="bankTransactionCode" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group form-group-eft" style="display: none">
                                 <label for="" class="col-sm-3 control-label">EFT Bank IFSC</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankIFSCCode" name="bankIFSCCode" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-eft-cash" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Date of EFT or Cash<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="dateOFEFTOrCash" name="dateOFEFTOrCash" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                              
                              <div class="form-group form-group-cheque-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Bank Statement Status</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankStatementStatus" name="bankStatementStatus" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally GL Account</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="tallyGLAccount" name="tallyGLAccount" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Remarks</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="remarks" name="remarks" placeholder="">
                                 </div>
                              </div>
                            <!--   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Collection Clerk</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div> 
                              </div>
                             
                             -->
                              
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="saveRecord"  class="btn btn-success">Add Record and Add Another Entry</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                             
                           </form>
                   
                  </div>
               </div>
            </div>
       
       </div>
         </div>
		</div>
		
	</div>
		
	
	
		
		
		
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
		<script src="${pageContext.request.contextPath}/resources/themes/script/dataentry.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
	
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