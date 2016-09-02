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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />

<script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
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
            <div class="main-page">
               <div id="ListDiv" style="display:block;">
                  <div class="form-group">
                     <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Academic Year</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <h3 class="title1">Academic Year</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                        <table class="table table-bordered" id="table">
                           <thead>
                              <tr>
                                 <th>Academic Year</th>
                                 <th>Status</th>
                                 <th>Action</th>
                              </tr>
                           </thead>
                           <tbody id="academicYearList">
                              <c:if test="${!empty academicYearList}">
                                 <c:forEach items="${academicYearList}" var="academicYear">
                                    <tr >
                                       <td>${academicYear.getAcademicYearTitle()}</td>
                                       <td>
                                          <c:if test="${academicYear.getAcademicYearStatus()==1}">Active</c:if>
                                          <c:if test="${academicYear.getAcademicYearStatus()==0}">Closed</c:if>
                                       <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="${academicYear.getAcademicYearId()}" data-toggle="modal" onclick="showeditDiv()">
                                          <span class="glyphicon glyphicon-edit"></span> 
                                          </a>
                                          <a href="#" class="test" id="delete"  type="button" data-href="#"  data-id="${academicYear.getAcademicYearId()}" data-toggle="modal" data-target="#deleteAcademicYearConfirmation">
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
                <!-- <div class="modal fade" id="errorMessage" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Error</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5 id="errorMessageDisplay"></h5>
                                 </div>
                                 <div class="modal-footer">
                                    <a href="" id="deleteAcademicYearConfirm"  class="btn btn-primary" type="button">Yes
                                    </a>
                                 </div>
                              </div>
                           </div>
                     </div> -->
                        
                <div class="modal fade" id="updateAcademicYearConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update academic year  ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="updateAcademicYearConfirm" id="updateAcademicYearConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
						
						   <div class="modal fade" id="deleteAcademicYearConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure ?, You want to delete this Academic Year??</h5>
                                 </div>
                                 <div class="modal-footer">
                                 	<form id="deleteAcademicYearForm" action="${pageContext.request.contextPath}/academicYear/delete" method="post">
                     	      <input type="hidden" id="deleteAcademicYearId" name="deleteAcademicYearId">
                     		<button type="button" id="deleteAcademicYearConfirm"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                     	</form>
                                   
                                 </div>
                              </div>
                           </div>
                        </div>
						
               <div id="FormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Create New Academic Year</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="academicYearform" action="${pageContext.request.contextPath}/academicYear/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="academicYearTitle" class="form-control" id="academicYearTitle" placeholder="" required maxlength="100">
                                   <span id="erroracademicYearTitle" class="error"></span>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                       <label for="selector1" class="col-sm-3   control-label">Select Fees Terms<span class="at-required-highlight">*</span></label>
                                       <div class="col-md-6 ">
                                          <select name="feesTermsList" id="feesTermList" class="select2_multiple form-control1" multiple="multiple" style="width: 585px;" required="required">
                                        		
                                        		<c:if test="${!empty feesTermList}">
                                         			<c:forEach items="${feesTermList}" var="feesTerm">
                                         				<option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                         			</c:forEach>
                                         		</c:if>
                                          </select>
                                            <span id="errorfeesTermsList" class="error"></span>
                                                   
                                          
                                       </div>
                                    </div>
                             
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="academicYearStatus" id="academicYearStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Closed</option>
                                    </select>
                                      <span id="erroracademicYearStatus" class="error"></span>
                                 </div>
                              </div>
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="academicYearSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  
                  
                  <div class="modal fade" id="academicYearSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure ?, You want to add this Academic Year??</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="academicYearSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="EditFormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Edit Academic Year</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="updateAcademicYearform" action="${pageContext.request.contextPath}/academicYear/editUpdate" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editAcademicYearTitle" class="form-control" id="editAcademicYearTitle" placeholder="" required maxLength="100">
                                   <span id="erroreditAcademicYearTitle" class="error"></span>
                                 
                                 </div>
                              </div>
                                    
                              <div class="form-group">
                                       <label for="selector1" class="col-sm-3   control-label">Select Fees Terms<span class="at-required-highlight">*</span></label>
                                       <div class="col-md-6 ">
                                          <select name="editfeesTermsList" id="editfeesTermList" class="form-control1" multiple="multiple" style="width: 585px;" disabled="disabled">
                                        		
                                        	</select>
                                            <span id="erroreditfeesTermsList" class="error"></span>
                                                   
                                          
                                       </div>
                                    </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="editAcademicYearStatus" id="editAcademicYearStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Closed</option>
                                    </select>
                                    <span id="erroreditAcademicYearStatus" class="error"></span>
                                 </div>
                              </div>
                                 <input type="hidden" id="updateAcademicYearId" name="updateAcademicYearId">
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <a href="#" id="updateAcademicYear" style="float:right" class="btn btn-success" type="submit" data-id=""  >
                                    				Update
                                    			</a>   
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                     <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/schoolAcademicYear.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/resetselect.js"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js" type="text/javascript"></script>


<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
	
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
   </body>
</html>

