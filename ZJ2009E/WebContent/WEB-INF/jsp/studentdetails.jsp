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
       <style>
      
      .loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('${pageContext.request.contextPath}/resources/themes/images/page-loader.gif') 50% 50% no-repeat rgba(255, 255, 255, 0.71);
}
      
      
      </style>
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 <div class="loader"  style="display: none"></div>
		<!-- main content start-->
		<div id="page-wrapper">
		
		<div class="main-page">
		
		 <div id="ListDiv" style="display:block;">
		  <h3 class="title1">Student Details</h3>
		   <form class="form-horizontal" id="getDetails" name="getDetails" method="post">
                    
                              <div class="row">
                                 <div class="col-sm-offset-3">
                              </div>
                                                              
                              </div>
                               <br>
                               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                <select name="class" id="class" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                           		 <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Section<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="section" id="section" class="form-control1" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="category" id="category" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                             <option value="specificstudent">Specific Student</option>
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                               <div class="form-group form-group-student-id" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required" />
                                 </div>
                              </div>
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="specialCategoryId" id="specialCategoryId" class="form-control1"  required="required">
                                      <option value="" disabled selected>Select Special Category </option>
                                       <c:if test="${!empty specialCategories}">
                                          <c:forEach items="${specialCategories}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                    
                                 </div>
                              </div>
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                 <button style="float:right" type="button"  id="getDetailsFromSelectedCriteria" class="btn btn-success">Get List</button>
                                  <button style="float:right;margin-right: 20px"  type="button" name="studentDataExce1" id="studentDataExcel" class="btn btn-danger">Download Excel</button>
                                 <a  style="float:right;margin-right: 20px"id="upload" href="#" class="btn btn-info"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#browse-file">Upload ModifiedExcel</a>
                                 </div>
                              </div>
            </form>
              
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   <h3 class="title1">Student List</h3>
                   <form class="form-horizontal" id="deleteStudentForms" action="${pageContext.request.contextPath}/student/bulkdelete" method="post">
                   
                     <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="studentList">
                              <thead>
                                 <tr>
                                  <th> <input name="select_all" value="1" id="example-select-all" type="checkbox"/>
                                   </th>
                                 <th>Admission No</th>
                                   <th>Student Name</th>
                                  	
                                   	<th>Student Contact Tel</th>
                                   	<th>Parent Contact Tel</th>
                                   	
                                  	<th>Special Category</th>
                                  	
                               		<th>Action</th>
                                 </tr>
                              </thead>
                             
                           </table>
                        </div>
                        </div>
                        	<input id="selectedStudentIds" name="selectedStudentIds" type="hidden">
             
                    <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="button" id="deleteStudents" class="btn btn-success">Delete Selected Student</button>
                                 </div>
                              </div>
                         
                    </form>
                               
						 
             
       
                               
                               </div>
                               
                               <div class="modal fade" id="confirm_delete_std" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this student ??</h5>
                     </div>
                     <div class="modal-footer">
                     		<form id="deleteStudentIdForm" action="${pageContext.request.contextPath}/student/delete" method="post">
                     	      <input type="hidden" id="deleteStudentId" name="deleteStudentId">
                     		<button type="button" name="deleteStdConfirm" id="deleteStdConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										</form>
                     </div>
                  </div>
               </div>
            </div>
                               
                                <div class="modal fade" id="updateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure?, You want to update this Student Details ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="updateConfirm" id="updateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
						
                               
                                
           
                               
                                 <div id="EditFormDiv" style="display:none;">
                                 
                                 
                                 
                                 
                                  <div class="forms">
                  <div class="row">
                      <h3 class="title1">Edit Student Details</h3>
                        
               <br />
                     <div class="form-three widget-shadow">
                    
            <form class="form-horizontal" id="editStudentForm" action="${pageContext.request.contextPath}/student/update" method="post" enctype='multipart/form-data'>
                          
                          <h4>Personal Information</h4> 
                          	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editAdmissionNo" readonly="readonly" name="editAdmissionNo" placeholder="" required="required" maxlength="50">
                                 </div>
                             </div>
                           	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editFirstName" name="editFirstName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editLastName"  name="editLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianFirstName" name="editParentOrGuardianFirstName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianLastName" name="editParentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="editParentOrGuardianEmail"  name="editParentOrGuardianEmail" maxlength="100" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="editStudentGender" id="editStudentGender" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                             <option value="Others">Others</option>
                                          </select>                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="editDateOfBirth" name="editDateOfBirth" placeholder="" required="required" maxlength="10">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="editEMail"  name="editEMail" placeholder="" maxlength="100" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editContact" name="editContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="10" >
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editParentContact" name="editParentContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="10" required="required">
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="editCategoryId" id="editCategoryId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Category </option>
                                      <c:if test="${!empty categories}">
                                           <c:forEach items="${categories}" var="category">
                                             <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editSpecialCategoryId" id="editSpecialCategoryId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Special Category </option>
                                       <c:if test="${!empty specialCategories}">
                                          <c:forEach items="${specialCategories}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Father Income In lakhs(Currency Format)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editFatherIncome" name="editFatherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Mother Income In lakhs(Currency Format)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editMotherIncome" name="editMotherIncome" placeholder=""onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editAddressLine1"  name="editAddressLine1" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editAddressLine2" name="editAddressLine2" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editCountryId" id="geographicallocation" class="form-control1" required="required">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>                                
                                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editStateId" id="geographicallocationstate" class="form-control1" required="required">
                                     <option value="" disabled selected>Select State </option>
                                    <c:if test="${!empty stateList}">
		                                       			<c:forEach items="${stateList}" var="stateList">
		                                       				<option value="${stateList.getGeographicalLocationId()}">${stateList.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editCityId" id="geographicallocationcity" class="form-control1" required="required">
                                     <option value="" disabled selected>Select City </option>
                                       <c:if test="${!empty cityList}">
		                                       			<c:forEach items="${cityList}" var="cityList">
		                                       				<option value="${cityList.getGeographicalLocationId()}">${cityList.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                     </select>
                                 </div>
                              </div> 
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editPostCode" name="editPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                            <h4>Upload Photo</h4> 
                                 <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Student Photo</label> 
                                 <div class="col-sm-6">
                                    <input name="studentProfilePic" id="studentProfilePic" type="file" />
                                    <div id="image-holder2" >

                                    <img src="#" id="studentImage"></img>
                                    </div>
                                 </div>
                              </div>
                                <h4>Academic Information</h4> 
                                   
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Current Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editJoinedClass" id="joinedClass" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                           		 <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Section<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editJoinedSection" id="joinedSection" class="form-control1" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                           		 <c:if test="${!empty  sections}">
		                                       			<c:forEach items="${ sections}" var="section">
		                                       				<option value="${ section.getSectionId()}">${ section.getSectionName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Roll No (unique)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editRollNo" name="editRollNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              
                                
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="editStudentAccessNo" name="editStudentAccessNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              
                               <h4>Other Information</h4> 
	                               <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
	                                 <div class="col-sm-6"> 
	                                    <input type="text" class="form-control" id="editPassportNo"  name="editPassportNo" placeholder="" maxlength="100">
	                                 </div>
	                              </div>
	                              
	                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Student Status<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="editStudentStatus" id="editStudentStatus" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Status</option>
                                           		 <c:if test="${!empty studentStatusList}">
		                                       			<c:forEach items="${studentStatusList}" var="studentStatus">
		                                       				<option value="${studentStatus.getStudentStatusId()}">${studentStatus.getStatusTitle()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-6">
                                           <select name="editBloodGroupId" id="editBloodGroupId" class="form-control1">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroups}">
		                                       			<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       					<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     <input type="hidden" id="updateStudentId" name="updateStudentId">
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                              
                                  <a href="#" id="updateStudent" style="float:right" class="btn btn-success" type="submit" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-info-reset">Clear</button>
                                     <button style="float:right" type="button" onclick="location.reload();" class="btn btn-danger">Cancel</button>
                                                          </div>
                              </div>
                             
                                   
                        </form>
                   
                  </div>
               </div>
            </div>
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 </div>
                               
                               
                               
                               
                               
                               
                               
                               
                               
                              
                               
                               
                               
                               
                                 <div id="OpenFormDiv" style="display:none;">
                                 
                                 
                                 <h4>test</h4>
                                 </div>
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                                <div class="modal fade" id="browse-file" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
              						 <div class="modal-dialog" role="document">
              						 <form id="studentBulkUpdateForm" action="${pageContext.request.contextPath}/student/updateStudentExcel" method="post" enctype="multipart/form-data">
                  						<div class="modal-content">
                  					     	<div class="modal-header">
                        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        							<h4 class="modal-title" id="exampleModalLabel">Browse the File</h4>
                     						</div>
                     						<div class="modal-body">
                     						
                     							<div class="form-group">
                                 					<label for="" class="col-sm-2 control-label">Upload</label> 
                                 				<div class="col-sm-6">
                                    				<input class="" name="studentBulkUpdate" required="required" id="studentBulkUpdate" type="file"/>
                                  				</div>
                              			</div>
                     						
                       			<br>
                                 
                     </div>
                     <div class="modal-footer">
                        <button type="submit" id="studentBulkUpdateSave" class="btn btn-primary">Update</button>
                     </div>
                  </div>
                  </form>
               </div>
            </div>
              <div class="modal fade" id="updateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
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
						
						     <div class="modal fade" id="bulkConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure? You want to delete this Students Details ?? </h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="bulkConfirm" id="bulkConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
            <div class="modal fade" id="confirm_delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this student record ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="confirmSave" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
			/* $("#getDetails").change(function() {
				

				 var value1 = $("#class").val();
				 var value2 = $("#section").val();
				 var value3 = $("#category").val();
				
				
				
				
		 if((jQuery.trim(value1).length && jQuery.trim(value2).length && jQuery.trim(value3).length) > 0)
			{
				
				 $("#download").attr("enable", true);
				 $("#upload").attr("enable", true);
			
			} 
		
			}); */
			
			
			$("#category").change(function() {
		
		
				 var value = $(this).val();
				 
				 if(value ==="specificstudent"){
					 
					 $(".form-group-student-id").show();
				        $(".form-group-special-category").hide(); 
					 
				 }
				 else if(value==="specialcategory"){
					 
					 
					 
					 $(".form-group-student-id").hide();
				        $(".form-group-special-category").show();  
					 
				 }
				 else
					 {
					 
					 
					 $(".form-group-student-id").hide();
				        $(".form-group-special-category").hide();  
					 
					 
					 }
					
					 
		
		
			});
		
		
		});
		
		
		</script>
		<script>
		
	     

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
			 <script> 
         $(document).ready(function() {
                 $("#studentProfilePic").on('change', function() {
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
                    	 $('#studentProfilePic').val(''); 
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                	   $('#studentProfilePic').val(''); 
                     alert("Please select only images");
                   }
                 });
               });
      </script>
 
	<!-- Bootstrap Core JavaScript -->
	 <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/script/schoolstudentdetails.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<!--//scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>