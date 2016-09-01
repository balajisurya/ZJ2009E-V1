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
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
            <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       
       
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
        
        
      
      <!-- Load jQuery JS -->
      <!-- Load jQuery UI Main JS  -->

      <!-- Load SCRIPT.JS which will create datepicker for input field  -->
      <!-- //chart -->
      
       <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script> 
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>  
      
      
      <!--//Metis Menu -->
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Staff</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               		 <h3 class="title1">Teaching Staff</h3> 
                       <div class="tables">
                       <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	<th>Staff Code</th>
                               		<th>Staff Name</th>
                                  	<th>Staff Status</th>
                                  	<th>Department</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="stafflist" >
                              		 <c:if test="${!empty teachingStaffList}">
		                                   <c:forEach items="${teachingStaffList}" var="teachingStaff">
		                                       	 <tr >
				                                  	<td>${teachingStaff.getStaffCode()}</td>
				                                    <td>${teachingStaff.getStaffFirstName()}</td>
				                                    <td><c:if test="${teachingStaff.getStatus()==0}">In Active
					                                    	</c:if> 
					                                    	<c:if test="${teachingStaff.getStatus()==1}">Active
					                                    	</c:if> </td>
				                                    <td>${teachingStaff.getDepartment().getDepartmentName()}</td>
				                                   	<td>
				                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="${teachingStaff.getStaffId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    		<span class="glyphicon glyphicon-edit"></span> 
				                                    	</a>
				                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${teachingStaff.getStaffId()}" data-toggle="modal" data-target="#confirm-delete">
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
                    
                
              
                <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                    
                       
                         <h3 class="title1">Non-Teaching Staff</h3> 
                       <div class="tables">
                      
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                    <th>Staff Code</th>
                               		<th>Staff Name</th>
                                  	<th>Staff Status</th>
                                  	<th>Department</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="stafflist1">
                               <c:if test="${!empty nonteachingStaffList}">
                               		<c:forEach items="${nonteachingStaffList}" var="nonteachingStaff">
		                                      <tr >
				                                  	<td>${nonteachingStaff.getStaffCode()}</td>
				                                  	<td>${nonteachingStaff.getStaffFirstName()}</td>
				                                    <td><c:if test="${nonteachingStaff.getStatus()==0}">In Active
					                                    	</c:if> 
					                                    	<c:if test="${nonteachingStaff.getStatus()==1}">Active
					                                    	</c:if>
					                                </td>
					                                <td>${nonteachingStaff.getDepartment().getDepartmentName()}</td>
				                                   	<td>
				                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="${nonteachingStaff.getStaffId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    		<span class="glyphicon glyphicon-edit"></span> 
				                                    	</a>
				                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${nonteachingStaff.getStaffId()}" data-toggle="modal" data-target="#confirm-delete">
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
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this Staff ??</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="deletestaff"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="saveStaffConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Staff ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="saveStaffConfirm" data-dismiss="modal">Yes</button>
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
                     <h3 class="title1">Create New Staff</h3>
                     <div class="form-three widget-shadow">
                  <form class="form-horizontal" id="newStaff" action="${pageContext.request.contextPath}/staff/add" method="post" enctype='multipart/form-data'>
                          <h4>Personal Information</h4> 
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffFirstName" class="form-control" id="staffFirstName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffLastName" class="form-control" id="staffLastName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffParentOrGuardianFirstName" class="form-control" id="staffParentOrGuardianFirstName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffParentOrGuardianLastName" class="form-control" id="staffParentOrGuardianLastName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <select name="staffGender" id="staffGender" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>
                                       </div>
                              </div>
                              
                             
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                <div class="col-sm-6"> 
                                          <input type="text" name="staffDOB" class="form-control form-control-datepicker" id="staffDOB" placeholder="" required="required">
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" name="staffEmail" class="form-control" id="staffEmail" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffContact" class="form-control" id="staffContact" placeholder="" onkeypress="return isNumber(event)" maxlength="10" required="required">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="categoryId" id="categoryId" class="form-control1" required="required">
                                          			<option value="" disabled selected>Select Category </option>
	                                          	<c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                                   
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Spouse Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text"  name="staffSpouseName" class="form-control" id="staffSpouseName" placeholder="">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffAddressLine1" class="form-control" id="staffAddressLine1" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffAddressLine2" class="form-control" id="staffAddressLine2" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="staffCountryId" id="geographicallocation" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countryList}">
		                                       		<c:forEach items="${countryList}" var="country">
		                                       			<option value="${country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="staffStateId" id="geographicallocationstate" class="form-control1" required="required">
                                             <option value="" disabled selected>No Country Selected</option>
                                          </select>
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="staffCityId" id="geographicallocationcity" class="form-control1" required="required">
                                             <option value="" disabled selected>No State Selected</option>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffPostCode" class="form-control" id="" placeholder="" maxlength="6" required="required">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access ID</label> 
                                 <div class="col-sm-6"> 
                                 		<input class="form-control" name="staffAccessId" id="staffAccessId" type="text" placeholder="">
								 </div>
                              </div>
                           
                               <h4>Account Information</h4> 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffBankName" class="form-control" id="staffBankName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffBankAccountNo" class="form-control" id="staffBankAccountNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffBankIFSC" class="form-control" id="staffBankIFSC" placeholder="">
                                 </div>
                              </div>
                             
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Address</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffBankAddress" class="form-control" id="staffBankAddress" placeholder="">
                                 </div>
                              </div>
                              
                             
                             
                             
                             
                              
                             
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffTallyAccountNo" class="form-control" id="staffTallyAccountNo" placeholder="">
                                 </div>
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffPassportNo" class="form-control" id="staffPassportNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffPANNo" class="form-control" id="staffPANNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PF Account No</label> 
                                       <div class="col-sm-6">
                                           <input type="text" name="staffPFAccountNo" class="form-control" id="staffPFAccountNo" placeholder="">
                                       </div>
                                    </div>
                          <h4>Upload Photo and Signature</h4> 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Image</label> 
                                 <div class="col-sm-6">
                                    <input name="staffProfilePic" id="staffProfilePic"  type="file"/>
                                    <div id="image-holder1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <input name="staffSignature" id="staffSignature" type="file"/>
                                    <div id="image-holder2"></div>
                                 </div>
                              </div>
                                 <h4>Academic Information</h4>       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="staffTypeId" id="staffTypeId" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Type</option>
                                             <c:if test="${!empty staffTypeList}">
		                                       		<c:forEach items="${staffTypeList}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeTitle()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="staffCategoryId" id="staffCategoryId" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Staff Category</option>
                                             
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Department<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="departmentId" id="departmentId" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Department</option>
                                             <c:if test="${!empty departmentList}">
		                                       		<c:forEach items="${departmentList}" var="department">
		                                       			<option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <%--  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Institution</label> 
                                 <div class="col-sm-6"> 
                                     <select name="instituteId" id="instituteId" class="form-control1">
                                             <option value="" disabled selected>Select Institution</option>
                                             <c:if test="${!empty institutionList}">
		                                       		<c:forEach items="${institutionList}" var="institution">
		                                       			<option value="${institution.getInstitutionId()}">${institution.getInstitutionName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                 </div>
                              </div> --%>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Approver<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="approverId" id="approverId" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Approver</option>
                                             <option value="0">Self Approver</option>
                                             <c:if test="${!empty staffList}">
		                                       		<c:forEach items="${staffList}" var="staff">
		                                       			<option value="${staff.getStaffId()}" >${staff.getStaffFirstName()}  ${staff.getStaffLastName()}</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                          </select>
                                       </div>
                                     </div>
                                   
                                   
                                    
                          <h4>Other Information</h4>       
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-6"> 
                                     <input type="text" name="staffJoinedDate" class="form-control form-control-datepicker" id="staffJoinedDate" placeholder="">
                                 </div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Previous Experience</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="previousExp" class="form-control" id="previousExp" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-6">
                                          <select name="staffBloodGroupId" id="staffBloodGroupId" class="form-control1">
                                             <option value="" disabled selected>Select Blood Group</option>
                                             <c:if test="${!empty bloodGroupList}">
		                                       		<c:forEach items="${bloodGroupList}" var="bloodGroup">
		                                       			<option value="${bloodGroup.getBloodGroupId()}">${bloodGroup.getBloodGroupName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Health Insurance</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="healthInsuranceNo" class="form-control" id="healthInsuranceNo" placeholder="">
                                 </div>
                              </div>
                            
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">OfferLetter</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="offerLetter" name="offerletter"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                             
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Form 16</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="form16" name="form_16"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Resume</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="resume" name="resume"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="staffStatus" id="staffStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="submit" id="saveStaff" class="btn btn-success">Save</button>
                                     <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>

                        </form>
       
                     </div>
                  </div>
               </div>
            </div>
            <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Staff</h3>
                     <div class="form-three widget-shadow">
                         <form class="form-horizontal" id="updateStaffDetails">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access ID</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" id="editAccessId" name="editAccessId"  placeholder="">
											
                                 </div>
                              </div>
                          <h4>Personal Information</h4> 
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editStaffCode" name="editStaffCode" disabled placeholder="">
                                 </div>
                              </div>
                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffFirstName" class="form-control" id="editStaffFirstName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="ediStaffLastName" class="form-control" id="ediStaffLastName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffParentOrGuardianFirstName" class="form-control" id="editStaffParentOrGuardianFirstName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffParentOrGuardianLastName" class="form-control" id="editStaffParentOrGuardianLastName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender</label> 
                                 <div class="col-sm-6">
                                          <select name="editStaffGender" id="editStaffGender" class="form-control1">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>
                                       </div>
                              </div>
                              
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-6">
                                          <select name="editStaffBloodGroupId" id="editStaffBloodGroupId" class="form-control1">
                                             <option value="" disabled selected>Select Blood Group</option>
                                             <c:if test="${!empty bloodGroupList}">
		                                       		<c:forEach items="${bloodGroupList}" var="bloodGroup">
		                                       			<option value="${bloodGroup.getBloodGroupId()}">${bloodGroup.getBloodGroupName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth</label> 
                                <div class="col-sm-6"> 
                                          <input type="text" name="editStaffDOB" class="form-control form-control-datepicker" id="editStaffDOB" placeholder="">
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffEmail" class="form-control" id="editStaffEmail" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffContact" class="form-control" id="editStaffContact" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category</label> 
                                       <div class="col-sm-6">
                                          <select name="editCategoryId" id="editCategoryId" class="form-control1">
                                          			<option value="" disabled selected>Select Category </option>
	                                          	<c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                                   
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Spouse Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text"  name="editStaffSpouseName" class="form-control" id="editStaffSpouseName" placeholder="">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffAddressLine1" class="form-control" id="editStaffAddressLine1" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffAddressLine2" class="form-control" id="editStaffAddressLine2" placeholder="">
                                 </div>
                              </div>
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="editStaffCountryId" id="staffgeographicallocation" class="form-control1">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>   
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editStaffStateId" id="staffgeographicallocationstate" class="form-control1">
                                     <option value="" disabled selected>Select State </option>
                                    <c:if test="${!empty stateList}">
		                                       			<c:forEach items="${stateList}" var="stateList">
		                                       				<option value="${stateList.getGeographicalLocationId()}">${stateList.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editStaffCityId" id="staffgeographicallocationcity" class="form-control1">
                                     <option value="" disabled selected>Select City </option>
                                       <c:if test="${!empty cityList}">
		                                       			<c:forEach items="${cityList}" var="cityList">
		                                       				<option value="${cityList.getGeographicalLocationId()}">${cityList.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                     </select>
                                 </div>
                              </div> 
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffPostCode" class="form-control" id="editStaffPostCode" placeholder="">
                                 </div>
                              </div>
                               <h4>Account Information</h4> 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffBankName" class="form-control" id="editStaffBankName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffBankAccountNo" class="form-control" id="editStaffBankAccountNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffBankIFSC" class="form-control" id="editStaffBankIFSC" placeholder="">
                                 </div>
                              </div>
                             
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Address</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffBankAddress" class="form-control" id="editStaffBankAddress" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffTallyAccountNo" class="form-control" id="editStaffTallyAccountNo" placeholder="">
                                 </div>
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffPassportNo" class="form-control" id="editStaffPassportNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editStaffPANNo" class="form-control" id="editStaffPANNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PF Account No</label> 
                                       <div class="col-sm-6">
                                           <input type="text" name="editStaffPFAccountNo" class="form-control" id="editStaffPFAccountNo" placeholder="">
                                       </div>
                                    </div>
                          <h4>Upload Photo and Signature</h4> 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Image</label> 
                                 <div class="col-sm-6">
                                    <input name="editStaffProfilePic" id="editStaffProfilePic"  type="file" />
                                    <div id="image-holder1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <input name="editStaffSignature" id="editStaffSignature" type="file" />
                                    <div id="image-holder2"></div>
                                 </div>
                              </div>
                                 <h4>Academic Information</h4>       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type</label> 
                                       <div class="col-sm-6">
                                          <select name="editStaffTypeId" id="editStaffTypeId" class="form-control1">
                                             <option value="" disabled selected>Select Type</option>
                                             <c:if test="${!empty staffTypeList}">
		                                       		<c:forEach items="${staffTypeList}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeTitle()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Category</label> 
                                       <div class="col-sm-6">
                                          <select name="editStaffCategoryId" id="editStaffCategoryId" class="form-control1">
                                             <option value="" disabled selected>Select Staff Category</option>
                                             <c:if test="${!empty staffCategoryList}">
		                                       		<c:forEach items="${staffCategoryList}" var="staffCategoryList">
		                                       			<option value="${staffCategoryList.getStaffCategoryId()}">${staffCategoryList.getStaffCategoryName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Department</label> 
                                       <div class="col-sm-6">
                                          <select name="editDepartmentId" id="editDepartmentId" class="form-control1">
                                             <option value="" disabled selected>Select Department</option>
                                             <c:if test="${!empty departmentList}">
		                                       		<c:forEach items="${departmentList}" var="department">
		                                       			<option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                   <%--  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Institution</label> 
                                 <div class="col-sm-6"> 
                                     <select name="editInstituteId" id="editInstituteId" class="form-control1">
                                             <option value="" disabled selected>Select Institution</option>
                                             <c:if test="${!empty institutionList}">
		                                       		<c:forEach items="${institutionList}" var="institution">
		                                       			<option value="${institution.getInstitutionId()}">${institution.getInstitutionName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                 </div>
                              </div> --%>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Approver</label> 
                                       <div class="col-sm-6">
                                          <select name="editApproverId" id="editApproverId" class="form-control1">
                                             <option value="" disabled selected>Select Approver</option>
                                             <option value="0">Self Approver</option>
                                             <c:if test="${!empty staffList}">
		                                       		<c:forEach items="${staffList}" var="staff">
		                                       			<option value="${staff.getStaffId()}">${staff.getStaffFirstName()}  ${staff.getStaffLastName()}</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                          </select>
                                       </div>
                                     </div>
                                   
                                   
                                    
                          <h4>Other Information</h4>       
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-6"> 
                                     <input type="text" name="editStaffJoinedDate" class="form-control form-control-datepicker" id="editStaffJoinedDate" placeholder="">
                                 </div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Previous Experience</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editPreviousExp" class="form-control" id="editPreviousExp" placeholder="">
                                 </div>
                                 </div>
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Health Insurance</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editHealthInsuranceNo" class="form-control" id="editHealthInsuranceNo" placeholder="">
                                 </div>
                              </div>
                            
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">OfferLetter</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="editOfferLetter"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                             
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Form 16</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="editForm16"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Resume</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="editResume"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status</label> 
                                 <div class="col-sm-6">
                                    <select name="editStaffStatus" id="editStaffStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                                  <div class="row">
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateStaff" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
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
     
      
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/managestaff.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
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