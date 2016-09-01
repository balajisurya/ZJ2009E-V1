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
            <!-- <div id="ListDiv" style="display:block;">
            <br> -->
          <!--   <form class="form-horizontal">
               <div class="form-group">
               <div class="col-md-6  col-sm-6 col-xs-12"> 
                  <button type="button" class="btn btn-info col-md-8 col-xs-12" onclick="showDiv()">Add New User</button>
                  </div>
                  
                    <div class="col-md-6 col-sm-6 col-xs-12"> 
                  <button type="button" class="btn btn-success col-md-8 col-xs-12" onclick="showsetupDiv()">Add New Role Type</button>
                  </div>
                 
               </div>
               </form> -->
               
              <%--  <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               <h3 class="title1">User</h3>
              
                    
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table  class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>User Name</th>
                               		<th>User Type</th>
                                  	<th>User Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
	                              <c:if test="${!empty userList}">
	                                    <c:forEach items="${userList}" var="user">
	                                    <c:if test="${user.getUserTypes().getUserTypeName()!='student' && user.getUserTypes().getUserTypeName()!='admission'}">
			                                    <tr id="userlist">
					                                  	<td>${user.getName()}</td>
					                                    <td>${user.getUserTypes().getUserTypeName().toUpperCase()}</td>
					                                    <td>
					                                    	<c:if test="${user.getStatus()==0}">In Active
					                                    	</c:if> 
					                                    	<c:if test="${user.getStatus()==1}">Active
					                                    	</c:if> 
					                                    </td>
					                                   	<td>
					                                    	<a href="#" id="edit"  type="button" data-href="#" data-id="${user.getUserId()}" data-toggle="modal" onclick="showditDiv()">
					                                    		<span class="glyphicon glyphicon-edit"></span> 
					                                    	</a>
					                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${user.getUserId()}" data-toggle="modal" data-target="#userdeleteConfirmation">
					                                    			<span class="glyphicon glyphicon-trash"></span> 
					                                    	 </a>
					                                    </td>
		                                  			 </tr>
	                                    </c:if>
	                                   </c:forEach>
	                               </c:if>
                              </tbody>
                           </table>
                        </div>
                        </div>
                     
                
             
               
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               <h3 class="title1">Students User</h3>
               
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table  class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>User Name</th>
                               		<th>User Type</th>
                                  	<th>User Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
	                              <c:if test="${!empty userList}">
	                                    <c:forEach items="${userList}" var="user">
	                                    <c:if test="${user.getUserTypes().getUserTypeName()=='student'}">
	                                    		<tr id="userlist">
			                                  	<td>${user.getName()}</td>
			                                    <td>${user.getUserTypes().getUserTypeName().toUpperCase()}</td>
			                                    <td>
			                                    	<c:if test="${user.getStatus()==0}">In Active
			                                    	</c:if> 
			                                    	<c:if test="${user.getStatus()==1}">Active
			                                    	</c:if> 
			                                    </td>
			                                   	<td>
			                                    	<a href="#" id="edit"  type="button" data-href="#" data-id="${user.getUserId()}" data-toggle="modal" onclick="showditDiv()">
			                                    		<span class="glyphicon glyphicon-edit"></span> 
			                                    	</a>
			                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${user.getUserId()}" data-toggle="modal" data-target="#userdeleteConfirmation">
			                                    			<span class="glyphicon glyphicon-trash"></span> 
			                                    	 </a>
			                                    </td>
                                  			 </tr>
	                                    </c:if>
	                                    </c:forEach>
	                               </c:if>
                              </tbody>
                           </table>
                        </div>
                        </div>
                     
                
               
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               <h3 class="title1" >Candidate User</h3>
                    <div class="tables">
                        <div class="table-responsive  bs-example widget-shadow">
                               <table   class="table table-bordered" id="datatable3">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>User Name</th>
                               		<th>User Type</th>
                                  	<th>User Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody >
	                              <c:if test="${!empty userList}">
	                                    <c:forEach items="${userList}" var="user">
	                                    <c:if test="${user.getUserTypes().getUserTypeName()=='admission'}">
	                                    	<tr id="userlist">
			                                  	<td>${user.getName()}</td>
			                                    <td>${user.getUserTypes().getUserTypeName().toUpperCase()}</td>
			                                    <td>
			                                    	<c:if test="${user.getStatus()==0}">In Active
			                                    	</c:if> 
			                                    	<c:if test="${user.getStatus()==1}">Active
			                                    	</c:if> 
			                                    </td>
			                                   	<td>
			                                    	<a href="#" id="edit"  type="button" data-href="#" data-id="${user.getUserId()}" data-toggle="modal" onclick="showditDiv()">
			                                    		<span class="glyphicon glyphicon-edit"></span> 
			                                    	</a>
			                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${user.getUserId()}" data-toggle="modal" data-target="#userdeleteConfirmation">
			                                    			<span class="glyphicon glyphicon-trash"></span> 
			                                    	 </a>
			                                    </td>
                                  			 </tr>
	                                    </c:if>
	                                    </c:forEach>
	                               </c:if>
                              </tbody>
                           </table>
                        </div>
                        </div>
                     </div> --%>
                  
            <!-- <div class="modal fade" id="userdeleteConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this User ??</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="userdeleteConfirm"  class="btn btn-primary" type="button">Yes</a>
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
                        <h5>Are you sure ?, You want to add this user ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="userSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div> -->
           <%--  <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New User</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newUserForm">
                        
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Name</label> 
                                 <div class="col-sm-6"> 
                                    <input name="user-name" type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email <small>(user name)</small></label> 
                                 <div class="col-sm-6"> 
                                    <input name="user-email" type="email" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Password</label> 
                                 <div class="col-sm-6"> 
                                    <input name="user-password" type="password" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Profile Picture</label> 
                                 <div class="col-sm-6">
                                    <input name="userProfilePic" id="userProfilePic"  type="file" />
                                    <div id="image-holder"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Type</label> 
                                 <div class="col-sm-6"> 
                                    <select name="master-user-type-id" id="selector1" class="form-control1">
	                                    <option value="" disabled selected>Select Type</option>
	                                    <c:if test="${!empty usertypelist}">
	                                    <c:forEach items="${usertypelist}" var="usertype">
	                                    	   <option value="${usertype.getTypeId()}">${usertype.getUserTypeName().toUpperCase()}</option>
		                                       </c:forEach>
	                              		</c:if>
		                              </select>
	                             </div>
                              </div>
                             
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status</label> 
                                 <div class="col-sm-6">
                                    <select name="user-status" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="userSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
                                 </div>
                              </div>
                           
                        </form>
                     </div>
                  </div>
               </div>
            </div> --%>
            
               <!--Edit Form  <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit User</h3>
                     <div class="form-three widget-shadow">
                       <form class="form-horizontal">
                        
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Email</label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Password</label> 
                                 <div class="col-sm-6"> 
                                    <input type="password" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Type</label> 
                                 <div class="col-sm-6"> 
                                  <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Type</option>
                                       <option>Non-Teaching Admin</option>
                                       <option>Teaching Admin</option>
                                    </select>
                                 </div>
                              </div>
                             
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option>Active</option>
                                       <option>Inactive</option>
                                    </select>
                                 </div>
                              </div>
                            <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Update</button>
                                  
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
                                 </div>
                              </div>
                           
                        </form>
                        </div>
                     </div>
                  </div>
               </div> -->
         <!-- </div> -->
         
               
            <div id="SetupDiv" style="display:block;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">New Role Type</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newrRoleTypeForm">
                          	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Role Type Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                      <input name="roleTYpeName" type="text" class="form-control" id="" placeholder="" required="required">
                                 </div>
                                 </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Role Type Theme<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="userTypeTheme" id="selector1" class="form-control1" required="required">
                                      	 <option value="" disabled selected>Select Theme</option>
                                      	 <option value="themes/generic">Generic</option>
                                         <option value="themes/admin">Admin</option>
                                    </select>
                                 </div>
                                 </div>
                                 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Role Type Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="userTypestatus" id="selector2" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                        <option value="0">Inactive</option>
                                    
                                    </select>
                                 </div>
                                 </div>
                            
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="submit" id="roleTypeSave" class="btn btn-success">Save</button>
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
               <h3 class="title1">User Role Type Details</h3>
                <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	<th>User Type Title</th>
                               		<th>User Theme</th>
                                  	<th>User Type Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="userTypelist">
	                              <c:if test="${!empty usertypelist}">
	                                    <c:forEach items="${usertypelist}" var="usertype">
	                                       <tr>
					                                  	<td>${usertype.getUserTypeName().toUpperCase()}</td>
					                                    <td>${usertype.getUserTheme()}</td>
					                                    <td>
					                                    	<c:if test="${usertype.getStatus()==0}">In Active
					                                    	</c:if> 
					                                    	<c:if test="${usertype.getStatus()==1}">Active
					                                    	</c:if> 
					                                    </td>
					                                   	<td>
					                                    	<a href="#" id="edit1"  type="button" data-href="#" data-id="${usertype.getTypeId()}" data-toggle="modal" onclick="showditDiv()">
					                                    		<span class="glyphicon glyphicon-edit"></span> 
					                                    	</a>
					                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${usertype.getTypeId()}" data-toggle="modal" data-target="#roletypedeleteConfirmation">
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
               
               
               
              <div class="modal fade" id="roletypedeleteConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this RoleType??</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="roletypedeleteConfirm"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="roleTypeSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Role Type ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="roleTypeSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
      </div>
      
      
      
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/usermanagement.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
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