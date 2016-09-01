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
    
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
         <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
          <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Group</button>
               </div>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br />
               
                     <h3 class="title1">Groups</h3>
                  <div class="tables">
                       
                       
                     
                        <div class="table-responsive bs-example widget-shadow">
                                 <table class="table table-bordered">
                              <thead>
                              	<tr>
                                      <th>Group Code</th>
                                   	  <th>Group Name</th>
                                   	  <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="grouplist">
                              <c:if test="${!empty grouplist}">
                                         <c:forEach items="${grouplist}" var="group">
                                         		<tr>
				                                  	<td>${group.getGroupCode()}</td>
				                                    <td>${group.getGroupName()}</td>
				                                    <td>
                                    					<a href="#" id="edit"  type="button" data-href="#" data-id="${group.getGroupId()}" data-toggle="modal" onclick="showeditDiv()">
					                                    <span class="glyphicon glyphicon-edit"></span> 
					                                    </a>
					                                   
					                                    <a href="#"  id="delete"  type="button" data-href="#"  data-id="${group.getGroupId()}" data-toggle="modal" data-target="#confirm-delete">
					                                    <span class="glyphicon glyphicon-trash"></span> 
					                                    </a>
                                    				</td>
                                 				</tr>
                                         </c:forEach>
                                 </c:if>
                              </tbody>
                           </table>
                        </div>
                      
                     
                     
						 <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to delete this Group ??</h5>
									</div>
									<div class="modal-footer">
										<a href="" id="confirmDeleteGroup"  class="btn btn-primary" type="button">Yes
                           				 </a>
									</div>
								</div>
							</div>
						</div>
                     
                     
                     </div>
                     
              
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Group</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="addGroupForm"action="${pageContext.request.contextPath}/group/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Group Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input name="group-name" type="text" class="form-control" id="" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Courses For This Group<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="courseSemList" id="courseSem" class="select2_multiple form-control" multiple="multiple" style="width: 580px;" required="required">
                                              <c:if test="${!empty coursesemesterlist}">
                                         			<c:forEach items="${coursesemesterlist}" var="coursesemester">
                                         				<option value="${coursesemester.getCourseSemId()}">${coursesemester.getCourse().getCourseName()} Semester ${coursesemester.getSemester()} </option>
                                         			</c:forEach>
                                         		</c:if>
                                          </select>
                                       </div>
                                    </div>
                            
                              <div class="row">
                               <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="groupSaveButton" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                           
                        
                        </form>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="groupAddingConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to add this Group ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" id="confirmAddGroup" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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
										 <h5>Are you sure?</h5>
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
                     <h3 class="title1">Edit Group</h3>
                     <div class="form-three widget-shadow">
                      <form class="form-horizontal" id="updateGroupDetails">
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Group Name</label> 
                                 <div class="col-sm-6"> 
                                    <input name="editGroup-name" type="text" class="form-control" id="editGroup-name" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Courses For This Group</label> 
                                       <div class="col-sm-6">
                                          <select name="editCourseSemList" id="editCourseSem" class="select2_multiple form-control" multiple="multiple" style="width: 515px;" required="required">
                                              <c:if test="${!empty coursesemesterlist}">
                                         			<c:forEach items="${coursesemesterlist}" var="coursesemester">
                                         				<option value="${coursesemester.getCourseSemId()}">${coursesemester.getCourse().getCourseName()} Semester ${coursesemester.getSemester()} </option>
                                         			</c:forEach>
                                         		</c:if>
                                          </select>
                                       </div>
                                    </div>
                            
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a href="#" id="updateGroup" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/groups.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
     
          <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>  
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