<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <% int timeout = session.getMaxInactiveInterval();response.setHeader("Refresh", timeout + "; URL =");%>
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
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="SetupDiv" style="display:block;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New User</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newuserform" action="${pageContext.request.contextPath}/schooluser/add" method="post">
                          	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="username" type="text" class="form-control" id="username" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="useremail" type="email" class="form-control" id="useremail" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Password<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="userpassword" type="password" class="form-control" id="password" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Confirm Password<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="pass_word_confirm" type="password" class="form-control" id="pass_word_confirm" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                 
                             
                           
                                 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="userstatus" id="userstatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                        <option value="0">Inactive</option>
                                    
                                    </select>
                                 </div>
                                 </div>
                            
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="submit" id="saveuser" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                           
                           	
                        
                        </form>
                     </div>
                       <br />
           
                      <div class="x_title">
                  			<div class="clearfix">
                  			</div>
               		</div>
                 <br/>
               <h3 class="title1">User Details</h3>
                <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	<th>User Name</th>
                               		<th>User Email</th>
                                  	<th>User Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="userslist">
	                              <c:if test="${!empty userList}">
	                                    <c:forEach items="${userList}" var="userList">
	                                       <tr>
					                                  	<td>${userList.getName()}</td>
					                                    <td>${userList.getEmail()}</td>
					                                    <td>
					                                    	<c:if test="${userList.getStatus()==0}">In Active
					                                    	</c:if> 
					                                    	<c:if test="${userList.getStatus()==1}">Active
					                                    	</c:if> 
					                                    </td>
					                                   	<td>
					                                    	<a href="#" id="edit"  type="button" data-href="#" data-id="${userList.getUserId()}" data-toggle="modal" onclick="showsetupDiv()">
					                                    		<span class="glyphicon glyphicon-edit"></span> 
					                                    	</a>
					                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${userList.getUserId()}" data-toggle="modal" data-target="#confirm_delete_user">
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
                  </div>
               </div>
               
               <div id="ListDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit User Details</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updateForm" action="${pageContext.request.contextPath}/schooluser/update" method="post">
                          	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="editUserName" type="text" class="form-control" id="editUserName" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="editUserEmail" type="email" class="form-control" id="editUserEmail" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Password<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="editPassword" type="password" class="form-control" id="editPassword" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Confirm Password<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="editPasswordConfirm" type="password" class="form-control" id="editPasswordConfirm" placeholder="" required="required" maxlength="100">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="editUserStatus" id="editUserStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                        <option value="0">Inactive</option>
                                    
                                    </select>
                                 </div>
                                 </div>
                             <input type="hidden" id="updateUserId" name="updateUserId">
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateUser" style="float:right" class="btn btn-success" type="submit" data-id="" >
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
               
               
               
               
                   <div class="modal fade" id="confirm_delete_user" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this user ??</h5>
                     </div>
                     <div class="modal-footer">
                     		<form id="deleteUserForm" action="${pageContext.request.contextPath}/schooluser/delete" method="post">
                     	      <input type="hidden" id="deleteUserId" name="deleteUserId">
                     		<button type="button" id="confirmDeleteUser"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                     	</form>
                     </div>
                  </div>
               </div>
            </div>
            
         
            <div class="modal fade" id="userSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ? You want to add this user ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="userSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="update_User_Confirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>    Are you sure ? You want to update user ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="updateUserConfirm" id="updateUserConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
      </div>
      </div>
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/schoolusermanagement.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script>
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
</html>