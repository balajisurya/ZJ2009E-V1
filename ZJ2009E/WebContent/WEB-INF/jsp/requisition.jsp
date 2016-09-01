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
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <!--webfonts-->
      <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
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
       <!-- Include Required Prerequisites -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>

 

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script>
     
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Create New Requisition</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               
                    
                        <h3 class="title1">Leave Requisition</h3>
                  <div class="tables">
                      
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead>
                                 <tr>
                                   	<th>Leave type</th>
                                   	<th>Applied Date</th>
                                   	<th>Leave Reason</th>
                               		<th>Leave Date(s)</th>
                                  	<th>Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="leaveRequisitionsList">
                              		<c:if test="${!empty staffLeaveRequistions}">
                                      <c:forEach items="${staffLeaveRequistions}" var="staffLeaveRequistion">
                                      		<tr >
		                                  	<td>${staffLeaveRequistion.getStaffLeaveType().getStaffLeaveType()}</td>
		                                    <td>${staffLeaveRequistion.getCreatedDate()}</td>
		                                    <td>${staffLeaveRequistion.getStaffLeaveReason()}</td>
		                                    
		                                    <td>${staffLeaveRequistion.getStaffLeaveStartDate()} - ${staffLeaveRequistion.getStaffLeaveEndDate()}</td>
		                                    <c:if test="${staffLeaveRequistion.getApprovalStatus()=='Pending'}">
		                                    		<td style="color:red;">
		                                              ${staffLeaveRequistion.getApprovalStatus()}
		                                    </td>
		                                    </c:if>
		                                    <td>
		                                    	<a href="#" id="leaveCancel"  type="button" data-href="#" data-id="${staffLeaveRequistion.getStaffLeaveRequisitionId()}" data-toggle="modal" data-target="#leaveCancelConfirmation">
                                                	<span class="glyphicon glyphicon-remove"></span> 
                                                </a>
		                                    </td>
                                         </tr>
		                              </c:forEach>
                                    </c:if>
                              </tbody>
                           </table>
                        </div>
                       
                 </div>
                 
              
                <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                   
                        
                         <h3 class="title1">Booking Facility</h3> 
                        
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Building Name</th>
                                   	<th>Facility Category</th>
                               		<th>Facility Type</th>
                                  	<th>Facility No</th>
                                    <th>Status</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td style="color:red;">
                                    	Rejected
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                 
                    <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
              
                         <h3 class="title1">Purchase Requisition</h3> 
                      <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table  table-bordered" id="datatable3">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Purchase Type</th>
                                   		<th>Requester Name</th>
                               		<th>Requester Type</th>
                                    <th>Status</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                   		<td style="color:green;">
                                         Approved
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                              <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                   
                        
                         <h3 class="title1">Travel Request</h3> 
                        
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable4">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Travel Type</th>
                                   		<th>Travel Mode</th>
                               		<th>Requester ID</th>
                                  	<th>Requester Name</th>
                                    <th>Status</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   		<td style="color:red;">
                                    	Rejected
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                     </div>
                 
             <div class="modal fade" id="leaveCancelConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
		               <div class="modal-dialog" role="document">
		                  <div class="modal-content">
		                     <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
		                     </div>
		                     <div class="modal-body">
		                        <h5>Are you sure ?, You want to cancel your leave??</h5>
		                     </div>
		                     <div class="modal-footer">
		                        <button type="button" id="leaveCancelConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
		                     </div>
		                  </div>
		               </div>
                </div>
            
            <div class="modal fade" id="addStaffLeaveRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Leave ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addStaffPurchaseRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Purchase ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addStaffTravelRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Travel ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="addStaffFacilityRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Travel ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Requisition </h3>
                     <div class="form-three widget-shadow">
                  <form class="form-horizontal">
                         
                         
                            <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Requisition Type</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector" class="form-control1">
                                             <option value="" disabled selected>Select Type </option>
                                             <option value="leaverequisition">Leave Requisition</option>
                                              <option value="bookingfacilityrequisition">Booking Facility</option>
                                               <option value="purchaserequisition">Purchase Requisition</option>
                                                 <option value="travelrequisition">Travel Request</option>
                                               
                                          </select>
                                       </div>
                                    </div> 
                                    </form>
                                     
               
              
                <div id="leaverequisition" style="display:none;">
                <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
               <h4>Leave Requisition</h4>   
                
               
                <form class="form-horizontal" id="addStaffLeaveRequisitionForm" action="${pageContext.request.contextPath}/staff/requisition/staffLeaveRequest" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Leave Type</label> 
                                 <div class="col-sm-6"> 
                                  <select name="staffLeaveType" id="staffLeaveType" class="form-control1" required="required">
                                    <c:if test="${!empty staffLeaveTypeList}">
                                          <option value="" disabled selected>Select Leave Type</option>
                                        <c:forEach items="${staffLeaveTypeList}" var="staffLeaveType">
                                        <option value="${staffLeaveType.getStaffLeaveTypeId()}">${staffLeaveType.getStaffLeaveType()}</option>
                                        </c:forEach>
                                      </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control" id="" name="staffLeaveStartAndEndDate" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffLeaveReason" class="form-control" id="staffLeaveReason" placeholder="" required="required">
                                 </div>
                              </div>
                              
                      
                                <!--  <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div> -->
                       
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffLeaveRequisition" class="btn btn-success">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float:right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                                          </div>
                              </div>
                              </form>
                             
                             </div>
                             
                              <div id="bookingfacilityrequisition" style="display:none;">
                               <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                                       <h4>Facility Booking Request</h4> 
<form class="form-horizontal" id="addStaffFacilityRequisitionForm">
                             
                               <!--  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Building Type</label> 
                                 <div class="col-sm-6"> 
                                   <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Type</option>
                                       <option>Block A</option>
                                       <option>Block B</option>
                                    </select>
                                 </div>
                              </div> -->
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Category</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Category</option>
                                             <option>Academic</option>
                                       <option>Non-Academic</option>
                                      
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Type</label> 
                                 <div class="col-sm-6">
                                    <select name="selector2" id="selector2" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Type</option>
                                         <option>Lab</option>
                                       <option>Class Room</option>
                                    </select>
                                 </div>
                              </div>
                              
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility No</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" id="fno"placeholder="" required="required">
											
                                 </div>
                              </div>
                
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="name1" name="fname"placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> No Of Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="noofseats" name="noofseats" placeholder="" required="required">
                                 </div>
                              </div>
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="1" placeholder="From"  name="fstart"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="2" placeholder="To" name="fend"required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Time And End Time </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="3" placeholder="From" name="ftimestart"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="4" placeholder="To" name="ftimeend"required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="reason" placeholder="" name="freason" required="required">
                                 </div>
                              </div>
                              
                      
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="exampleInputFile" name="f_file"required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                 
                                   
                                    
                        
                          
                                   
                             
                              
                               
                                    
                            
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffFacilityRequisition" class="btn btn-success">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                                          </div>
                              </div>
                              </form>
                             </div>
                              <div id="purchaserequisition" style="display:none;">
                               <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                              <h4>Purchase Requisition</h4> 
                           
                               
                              <form class="form-horizontal" id="addStaffPurchaseRequisitionForm">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_item_group" required="required">
											
                                 </div>
                              </div>
              
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Name</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_item_name" required="required">
											
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Quantity</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_qty"required="required">
											
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">When Required?</label> 
                                 <div class="col-sm-6"> 
                                 
								 
                                
                                    <input type="date" class="form-control" id="rqd" placeholder="" name="p_required" required="required">
                              
                               
                              </div>
											
                                 </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="p_reason" name="p_reason" placeholder="" required="required">
                                 </div>
                              </div>
                              
                      
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="exampleInputFile" required="required" name="p_file"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                 
                                   
                                    
                        
                          
                                   
                             
                              
                               
                                    
                            
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffPurchaseRequisition" class="btn btn-success">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                                          </div>
                                                          
                              </div>
                            </form>
                              </div>
                               <div id="travelrequisition" style="display:none;">
                                <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                              <h4>Travel Requisition</h4>   
                              <form class="form-horizontal" id="addStaffTravelRequisitionForm">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Travel Type</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="selector1" class="form-control1" name="t_type"required="required">
                                    <option value="" disabled selected>Select Type </option>
                                          
                                             </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="From" name="t_start"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="To" name="t_end"required="required">
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Time And End Time </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="" placeholder="From" name="t_start_time"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="" placeholder="To" name="t_end_time"required="required">
                                 </div>
                              </div>
                             
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Travel Mode</label> 
                                 <div class="col-sm-6"> 
                                   <select  id="selector6" class="form-control1" name="travel_mode"required="required">
                                    <option value="" disabled selected>Select Type </option>
                                          
                                             </select>
                                 </div>
                              </div>
                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="" name="t_reason"required="required">
                                 </div>
                              </div>
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="exampleInputFile" name="t_file"required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                 
                                   
                                    
                        
                          
                                   
                             
                              
                               
                                    
                            
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffTravelRequisition" class="btn btn-success">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                                          </div>
                              </div>
                              </form>
                              </div>
                      
       
                     </div>
                  </div>
               </div>
            </div>
            <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View Details</h3>
                     <br />
                     <br />
                     <br />
                         <div class="col-md-8 compose-right widget-shadow">
					<div class="panel-default">
					
						<div class="panel-body">
							<div class="alert alert-info">
								No Available
							</div>
							
						</div>
					</div>
				</div>
                  
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      
      <script>
         $(document).ready(function() {
                 $("#fileUpload").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                     alert("Pls select only images");
                   }
                 });
               });
      </script>
      <script type="text/javascript">
$(function() {

  $('input[name="staffLeaveStartAndEndDate"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });

  $('input[name="staffLeaveStartAndEndDate"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
  });

  $('input[name="staffLeaveStartAndEndDate"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
  });

});
</script>
      
     <script>
         $(document).ready(function() {
        	 
        		  $("#selector").change(function() {
        		    var val = $(this).val();
        		    if(val === "leaverequisition") {
        		        $("#leaverequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#travelrequisition").hide();
        		        
        		    }
        		    else if(val === "purchaserequisition") {
        		        $("#purchaserequisition").show();
        		        $("#leaverequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#travelrequisition").hide();
        		      
        		    }
        		    else if(val === "bookingfacilityrequisition") {
        		        $("#bookingfacilityrequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#leaverequisition").hide();
        		        $("#travelrequisition").hide();
        		      
        		    }
        		    else if(val === "travelrequisition") {
        		        $("#travelrequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#leaverequisition").hide();
        		      
        		    }
        		  });
        		});
             
      </script>
      
      
      
      
      
      
      
     
      <script>
         $(document).ready(
           
           /* This is the function that will get executed after the DOM is fully loaded */
           function () {
             $( "#datepicker" ).datepicker({
               changeMonth: true,//this option for allowing user to select month
               changeYear: true //this option for allowing user to select from year range
             });
           }
         
         );
         
         
            var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
            	showLeftPush = document.getElementById( 'showLeftPush' ),
            	body = document.body;
            	
            showLeftPush.onclick = function() {
            	classie.toggle( this, 'active' );
            	classie.toggle( body, 'cbp-spmenu-push-toright' );
            	classie.toggle( menuLeft, 'cbp-spmenu-open' );
            	disableOther( 'showLeftPush' );
            };
            
            function disableOther( button ) {
            	if( button !== 'showLeftPush' ) {
            		classie.toggle( showLeftPush, 'disabled' );
            	}
            }
      </script>
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/requisition.js" type="text/javascript"></script>
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