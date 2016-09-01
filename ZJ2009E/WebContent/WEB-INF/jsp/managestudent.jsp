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
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>    
      <!-- Load jQuery JS -->
      <!-- Load jQuery UI Main JS  -->
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      <!-- Load SCRIPT.JS which will create datepicker for input field  -->
      <!-- //chart -->
      <style>
         .x_title {
         border-bottom: 3px solid #E91E63;
         padding: 1px 5px 6px;
         margin-bottom: 10px;
         }
         #secondstep{
         display:none
         }
          .thumb-image {
         width:250px;
         display: block;
         padding: 4px;
         margin-bottom: 20px;
         line-height: 1.42857143;
         background-color: #fff;
         border: 1px solid #00BCD4;
         border-radius: 4px;
         -webkit-transition: border .2s ease-in-out;
         -o-transition: border .2s ease-in-out;
         transition: border .2s ease-in-out;
         }
      </style>
      <!--//Metis Menu -->
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
              
               		 <h3 class="title1">Teaching Staff</h3> 
                       <div class="tables">
                       <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Staff Code</th>
                               		<th>Staff Name</th>
                                  	<th>Staff Status</th>
                                  	<th>Department</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody >
                              		 <c:if test="${!empty teachingStaffList}">
		                                   <c:forEach items="${teachingStaffList}" var="teachingStaff">
		                                       	 <tr class="active" id="stafflist">
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
                              <tbody>
                               <c:if test="${!empty nonteachingStaffList}">
                               		<c:forEach items="${nonteachingStaffList}" var="nonteachingStaff">
		                                      <tr class="active" id="stafflist">
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
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Staff</h3>
                     <div class="form-three widget-shadow">
                  <form class="form-horizontal" id="newStaff" action="${pageContext.request.contextPath}/staff/add" method="post">
                          <h4>Personal Information</h4> 
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffFirstName" class="form-control" id="staffFirstName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffLastName" class="form-control" id="staffLastName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffParentOrGuardianFirstName" class="form-control" id="staffParentOrGuardianFirstName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffParentOrGuardianLastName" class="form-control" id="staffParentOrGuardianLastName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender</label> 
                                 <div class="col-sm-6">
                                          <select name="staffGender" id="staffGender" class="form-control1">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>
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
                                 <label for="" class="col-sm-3 control-label">Date of Birth</label> 
                                <div class="col-sm-6"> 
                                          <input type="text" name="staffDOB" class="form-control" id="staffDOB" placeholder="">
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffEmail" class="form-control" id="staffEmail" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffContact" class="form-control" id="staffContact" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category</label> 
                                       <div class="col-sm-6">
                                          <select name="categoryId" id="categoryId" class="form-control1">
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
                                 <label for="" class="col-sm-3 control-label">Address Line 1</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffAddressLine1" class="form-control" id="staffAddressLine1" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffAddressLine2" class="form-control" id="staffAddressLine2" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="staffCountryId" id="geographicallocation" class="form-control1">
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
                                       <label for="" class="col-sm-3 control-label">State</label> 
                                       <div class="col-sm-6">
                                          <select name="staffStateId" id="geographicallocationstate" class="form-control1">
                                             <option value="" disabled selected>No Country Selected</option>
                                          </select>
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City</label> 
                                       <div class="col-sm-6">
                                          <select name="staffCityId" id="geographicallocationcity" class="form-control1">
                                             <option value="" disabled selected>No State Selected</option>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="staffPostCode" class="form-control" id="" placeholder="">
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
                                    <input name="staffProfilePic" id="staffProfilePic"  type="file" />
                                    <div id="image-holder1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <input name="staffSignature" id="staffSignature" type="file" />
                                    <div id="image-holder2"></div>
                                 </div>
                              </div>
                                 <h4>Academic Information</h4>       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type</label> 
                                       <div class="col-sm-6">
                                          <select name="staffTypeId" id="staffTypeId" class="form-control1">
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
                                          <select name="staffCategoryId" id="staffCategoryId" class="form-control1">
                                             <option value="" disabled selected>Select Category</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Department</label> 
                                       <div class="col-sm-6">
                                          <select name="departmentId" id="departmentId" class="form-control1">
                                             <option value="" disabled selected>Select Department</option>
                                             <c:if test="${!empty departmentList}">
		                                       		<c:forEach items="${departmentList}" var="department">
		                                       			<option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                   
                                    
                          <h4>Other Information</h4>       
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-6"> 
                                     <input type="text" name="staffJoinedDate" class="form-control" id="staffJoinedDate" placeholder="">
                                 </div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Previous Experience</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="previousExp" class="form-control" id="previousExp" placeholder="">
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
                                          <input type="file" id="offerLetter"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                             
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Form 16</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="form16"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Resume</label>
                                       <div class="col-sm-6">
                                          <input type="file" id="resume"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status</label> 
                                 <div class="col-sm-6">
                                    <select name="staffStatus" id="staffStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="saveStaff" class="btn btn-success">Save</button>
                                     <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="showDiv()">Cancel</button>
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
                         <form class="form-horizontal">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access ID</label> 
                                 <div class="col-sm-6"> 
                                 
											
												<input class="form-control" type="text" placeholder="">
											
                                 </div>
                              </div>
                          <h4>Personal Information</h4> 
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Category </option>
                                             <option></option>
                                          </select>
                                       </div>
                                    </div> 
                                   
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Spouse Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country </option>
                                             <option>India</option>
                                          </select>
                                       </div>
                                    </div>      
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select City </option>
                                             <option>India</option>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                           
                               <h4>Account Information</h4> 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                             
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Address</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              
                             
                             
                             
                             
                              
                             
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PF Account No</label> 
                                       <div class="col-sm-6">
                                           <input type="text" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                          <h4>Upload Photo and Signature</h4> 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Image</label> 
                                 <div class="col-sm-6">
                                    <img src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo3.png" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <img src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo3.png" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
                                 </div>
                              </div>
                                 <h4>Academic Information</h4>       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Type</option>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Category</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Category</option>
                                          </select>
                                       </div>
                                    </div>
                                   
                                    
                          <h4>Other Information</h4>       
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Previous Experience</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                                 </div>
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Health Insurance</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                            
                                  
                               <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">OfferLetter</label> 
                                       <div class="col-sm-6">
                                           <input type="file" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                               
                          
                                   
                             
                              
                               
                                    
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Form 16</label> 
                                 <div class="col-sm-6"> 
                                    <input type="file" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              
                                 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status</label> 
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
            </div>
         </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
       <script>
         $(document).ready(function() {
                 $("#staffProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder1");
                   
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
                     alert("Please select only images");
                   }
                 });
               });
      </script>
      <script>
         $(document).ready(function() {
                 $("#staffSignature").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder2");
                   
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
                     alert("Please select only images");
                   }
                 });
               });
      </script>
      <script>
         $(document).ready(
           
           /* This is the function that will get executed after the DOM is fully loaded */
           function () {
             $( "#staffDOB" ).datepicker({
               changeMonth: true,//this option for allowing user to select month
               changeYear: true, //this option for allowing user to select from year range
               yearRange: "-100:+0"
             });
           }
         
         );
         $(document).ready(
                 
                 /* This is the function that will get executed after the DOM is fully loaded */
                 function () {
                   $( "#staffJoinedDate" ).datepicker({
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/managestaff.js" type="text/javascript"></script>
    
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