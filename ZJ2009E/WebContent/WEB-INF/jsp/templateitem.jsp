

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
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/validate.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
      
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
                     <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Fees Item</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <h3 class="title1">Fees Items</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                        <table class="table table-bordered" id="table">
                           <thead style="background-color:#673AB7;color:#ffffff;">
                              <tr>
                                 <th>Fees Item Name</th>
                                 <th>Fees</th>
                                 <th>Ledger</th>
                                 <th>Action</th>
                              </tr>
                           </thead>
                           <tbody id="templateitemlist">
                              <c:if test="${!empty feesstructureitemlist}">
                                 <c:forEach items="${feesstructureitemlist}" var="feesstructureitem">
                                    <tr >
                                       <td>${feesstructureitem.getTemplateItemName()}</td>
                                       <td>${feesstructureitem.getTemplateItemPrice()}</td>
                                       <td>${feesstructureitem.getLedgerAccount().getLedgerAccountName()}</td>
                                       <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="${feesstructureitem.getTemplateItemId()}" data-toggle="modal" onclick="showeditDiv()">
                                          <span class="glyphicon glyphicon-edit"></span> 
                                          </a>
                                          <a href="#" class="test" id="delete"  type="button" data-href="#"  data-id="${feesstructureitem.getTemplateItemId()}" data-toggle="modal" data-target="#confirm-delete">
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
               
                <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure ?, You want to delete this Fees Item ??</h5>
                                 </div>
                                 <div class="modal-footer">
                                 <form id="deleteTemplateItemForm" action="${pageContext.request.contextPath}/feestemplate/item/delete" method="post">
                     	      <input type="hidden" id="deleteTemplateItemId" name="deleteTemplateItemId">
                     		<button type="button" id="confirmDeleteTemplateItem"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                     	</form>
                                    
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
										 <h5>Are you sure ?, You want to update this Fees Item ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="saveConfirm" id="saveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
               <div id="FormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Create New Fees Item</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="templateitemform" action="${pageContext.request.contextPath}/feestemplate/item/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Item Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="template-name" class="form-control" id="template-name" placeholder="" required maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Item Price<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="item-price" class="form-control " id="number" placeholder="" required onkeypress="return decimalAmount(this, event, 2)" maxlength="255" >
                                    
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Ledger<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="ledgerAccountId" id="ledgerAccountId" class="form-control1" required="required">
                                      			<option value="" disabled selected>Select Ledger</option>
		                                       <c:if test="${!empty ledgerAccounts}">
		                                          <c:forEach items="${ledgerAccounts}" var="ledgerAccount">
		                                             <option value="${ledgerAccount.getLedgerAccountId()}">${ledgerAccount.getLedgerAccountName()}</option>
		                                          </c:forEach>
		                                       </c:if>
                                    	</select>
                                       </div>
                                    </div>
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="templateitemSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  <div class="modal fade" id="templateitemSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure ?, You want to add this Fees Item ??</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="templateitemSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="EditFormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Edit Fees Item</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="updateTemplateItemForm" action="${pageContext.request.contextPath}/feestemplate/item/update" method="post" >
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Item Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" disabled="disabled"  id="editFeesItemName" name="editFeesItemName" required placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Fees Item Price<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editFeesItemPrice" name="editFeesItemPrice" placeholder="" required onkeypress="return decimalAmount(this, event, 2)" maxlength="255" >
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Ledger<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editLedgerAccountId" disabled="disabled"  id="editLedgerAccountId"  class="form-control1" required="required">
                                      			<option value="" disabled selected>Select Ledger</option>
		                                       <c:if test="${!empty ledgerAccounts}">
		                                          <c:forEach items="${ledgerAccounts}" var="ledgerAccount">
		                                             <option value="${ledgerAccount.getLedgerAccountId()}">${ledgerAccount.getLedgerAccountName()}</option>
		                                          </c:forEach>
		                                       </c:if>
                                    	</select>
                                       </div>
                                    </div>
                              <input type="hidden" id="updateTemplateItemId" name="updateTemplateItemId">
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <a href="#" id="updateFeesTemplateItem" style="float:right" class="btn btn-success" type="submit"  data-id=""  >
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/templateitem.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
               <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      
      
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
     
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

   </body>
</html>

