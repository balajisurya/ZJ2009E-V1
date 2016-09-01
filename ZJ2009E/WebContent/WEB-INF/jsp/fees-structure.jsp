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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Fees Structure</button>
               </div>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br />
              
                     
                       <h3 class="title1">Fees Structure</h3>
                  <div class="tables">   
                       
                       
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	 <th>Fees Structure Title</th>
                               		 <th>Total Fees Item</th>
                               		 <th>Amount</th>
                                  	 <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="feestemplatelist">
                              		<c:if test="${!empty feesstructurelist}">
                                         <c:forEach items="${feesstructurelist}" var="feesstructure">
                                         	<tr>
                                    			<td>${feesstructure.getTemplateName()}</td>
                                    			<td>${feesstructure.getFeesTemplateItems().size()}</td>
                                    				<c:set var="totalAmount" value="0"/>
                                    				<c:if test="${!empty feesstructure.getFeesTemplateItems()}">
                                    					<c:set var="feesTemplateItems" value="${feesstructure.getFeesTemplateItems()}"/>
                                    					<c:forEach items="${feesTemplateItems}" var="feesTemplateItem">
                                         					<c:set var="totalAmount" value="${totalAmount+feesTemplateItem.getTemplateItemPrice()}"/>
                                         				</c:forEach>
                                         			</c:if>
                                    			<td>${totalAmount}</td>
                                    			<td>
				                                    <a href="#" id="edit"  type="button" data-href="#" data-id="${feesstructure.getTemplateId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    <span class="glyphicon glyphicon-edit"></span> 
				                                    </a>
				                                   
				                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="${feesstructure.getTemplateId()}" data-toggle="modal" data-target="#deleteFeesStructureConfirmation">
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
            <div class="modal fade" id="deleteFeesStructureConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure ?, You want to delete this Fees Structure ??</h5></div>
                                 <div class="modal-footer">
                                 	<form id="deleteFeesStructureForm" action="${pageContext.request.contextPath}/feestemplate/delete" method="post">
                     	      <input type="hidden" id="deleteFeesStructureId" name="deleteFeesStructureId">
                     		<button type="button" id="confirmFeesTemplateDelete"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                     	</form>
                                   
                                 </div>
                              </div>
                           </div>
                        </div>
                       
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Fees Structure</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="feestemplateform" action="${pageContext.request.contextPath}/feestemplate/add" method="post">
                          
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Structure Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="structure-name" class="form-control" id="" placeholder="" required="required" maxlength="100">
                                    <span id="errorstructure-name" class="error"></span>
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                       <label for="selector1" class="col-sm-3   control-label">Select Fees Items<span class="at-required-highlight">*</span></label>
                                       <div class="col-md-6 ">
                                          <select name="templateItemList" id="templateItemList" class="select2_multiple form-control1" multiple="multiple" style="width: 585px;" required="required">
                                        		
                                        		<c:if test="${!empty feesstructureitemlist}">
                                         			<c:forEach items="${feesstructureitemlist}" var="feesstructureitem">
                                         				<option value="${feesstructureitem.getTemplateItemId()}">${feesstructureitem.getTemplateItemName()}</option>
                                         			</c:forEach>
                                         		</c:if>
                                          </select>
                                            <span id="errortemplateItemList" class="error"></span>
                                                   
                                          
                                       </div>
                                    </div>
                              
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   type="submit" id="feesStructureSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" id="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                           
                        
                        </form>
                     </div>
                  </div>
               </div>
                <div class="modal fade" id="feesStructureSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to add this Fees Structure ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" id="feesStructureConfirmSave" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
                     
            </div>
            
            <div class="modal fade" id="saveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure?, You want to update this Fees Structure ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="saveConfirm" id="saveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
						
             <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Fees Structure</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updateFeesStructureDetails" action="${pageContext.request.contextPath}/feestemplate/update" method="post">
                        
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Structure Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStructure-name" class="form-control" id="editStructure-name" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                       <label for="selector1" class="col-sm-3 control-label">Select Fees Items<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-6">
                                          <select name="editTemplateItemList" id="editTemplateItemList" class="select2_multiple form-control1" multiple="multiple" style="width: 465px;" required="required">
                                        		
                                        		<c:if test="${!empty feesstructureitemlist}">
                                         			<c:forEach items="${feesstructureitemlist}" var="feesstructureitem">
                                         				<option value="${feesstructureitem.getTemplateItemId()}">${feesstructureitem.getTemplateItemName()}</option>
                                         			</c:forEach>
                                         		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                       <input type="hidden" id="updateFeesStructureId" name="updateFeesStructureId">
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateFeesStructure" style="float:right" class="btn btn-success" type="submit"  data-id="" >
                                    
                                    				Update
                                    			</a>   
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                     <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)">Cancel</button>
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


<script src="${pageContext.request.contextPath}/resources/themes/script/feesstructure.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/resetselect.js"></script>
 
 <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js" type="text/javascript"></script>


<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
	
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
</body>
</html>