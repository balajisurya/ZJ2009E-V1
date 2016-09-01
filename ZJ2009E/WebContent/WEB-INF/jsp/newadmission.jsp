<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		<div class="main-page">
            
        <div id="ListDiv" style="display:block;">
     		 <div class="forms">
                  <div class="row">
                      <h3 class="title1">New Student Registration</h3>
                        
               <br />
                     <div class="form-three widget-shadow">
                    
                        <form class="form-horizontal" id="saveStudentDetails" action="${pageContext.request.contextPath}/student/saveStudentDetails" method="post" >
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission ID<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                 
												<input class="form-control1" type="text" id="admissionId" name="admissionId" >
											
                                 </div>
                              </div>
                          <h4>Personal Information</h4> 
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="lastName"  name="lastName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="parentOrGuardianFirstName" name="parentOrGuardianFirstName" required="required" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="parentOrGuardianLastName" name="parentOrGuardianLastName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="parentOrGuardianEmail"  name="parentOrGuardianEmail" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="studentGender" id="studentGender" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="dateOfBirth" name="dateOfBirth" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="eMail"  name="eMail" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="contact" name="contact" placeholder=""  onkeypress="return isNumber(event)" maxlength="10" required="required">
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="categoryId" id="categoryId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Category </option>
                                      <c:if test="${!empty categoryList}">
                                           <c:forEach items="${categoryList}" var="categoryList">
                                             <option value="${categoryList.getCategoryId()}">${categoryList.getCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="specialCategoryId" id="specialCategoryId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Special Category </option>
                                       <c:if test="${!empty specialCategoryList}">
                                          <c:forEach items="${specialCategoryList}" var="specialCategoryList">
                                             <option value="${specialCategoryList.getSpecialCategoryId()}">${specialCategoryList.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Father Income(Currency Format)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="fatherIncome" name="fatherIncome" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Mother Income(Currency Format)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="motherIncome" name="motherIncome" placeholder=""onkeypress="return isFloatNumber(this,event)">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="addressLine1"  name="addressLine1" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="countryId" id="countryId" class="form-control1" required="required">
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
                                 <label for="" class="col-sm-3 control-label">State <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="stateId" id="stateId" class="form-control1" required="required">
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
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="cityId" id="cityId" class="form-control1" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="postCode" name="postCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                           
                               <h4>Account Information</h4> 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankName" name="bankName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankAccountNo" name="bankAccountNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankIFSCCode" name="bankIFSCCode" placeholder="">
                                 </div>
                              </div>
                             
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Address</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="bankAddress" name="bankAddress" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Account No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="tallyAccountNo" name="tallyAccountNo" placeholder="">
                                 </div>
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="passportNo" name="passportNo" placeholder="">
                                 </div>
                              </div>
                          <h4>Upload Photo and Signature</h4> 
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Image</label> 
                                 <div class="col-sm-6">
                                    <input class="image1" name="image1" id=""  type="file"/>
                                    <div class="viewimage1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <input class="image2" name="image2" id="" type="file"/>
                                    <div class="viewimage2"></div>
                                 </div>
                              </div>
                                
                                 
                                   <h4>Academic Information</h4> 
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Batch</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="batch" name="batch" placeholder="">
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Current Semester<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="currentSemester" name="currentSemester" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined Semester<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="joinedSemester" name="joinedSemester" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="joinedDate" name="joinedDate" placeholder="">
                                 </div>
                                 </div>
                                
                               <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Scholarship </label> 
                                       <div class="col-sm-6">
                                          <select name="scholarShip" id="scholarShip" class="form-control1">
                                             <option value="" disabled selected>Select Scholarship </option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                               
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Course Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="courseTypeId" id="courseTypeId" class="form-control1" required="required">
                                           <option value="" disabled selected>Select Course Type</option>
                                          			<c:if test="${!empty  courseTypeList}">
		                                       			<c:forEach items="${courseTypeList}" var="courseType">
		                                       					<option value="${courseType.getCourseTypeId()}" >${courseType.getCourseTypeName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                             
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Course Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="courseCategoryId" id="courseCategoryId" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Category</option>
                                             <c:if test="${!empty  courseCategoryList}">
		                                       			<c:forEach items="${courseCategoryList}" var="courseCategory">
		                                       					<option value="${courseCategory.getCourseCategoryId()}" >${courseCategory.getCourseCategoryName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="selector1" class="col-sm-3 control-label">Department Name<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-6">
                                         <select name="departmentId" id="departmentId" class="form-control1" required="required">
                                          	<option value="" disabled selected>Select Department</option>
                                        		<c:if test="${!empty departmentList}">
		                                       			<c:forEach items="${departmentList}" var="department">
		                                       					<option value="${department.getDepartmentId()}" >${department.getDepartmentName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="selector1" class="col-sm-3 control-label">Course Name<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-6">
                                          <select name="courseId" id="courseId" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Course</option>
                                        		<c:if test="${!empty courseList}">
		                                       			<c:forEach items="${courseList}" var="course">
		                                       					<option value="${course.getCourseId()}" >${course.getCourseName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="studentAccessNo" name="studentAccessNo" placeholder="">
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Approver</label> 
                                 <div class="col-sm-6">
                                     <select name="approverId" id="approverId" class="form-control1">
                                      <option value="" disabled selected>Select Approver</option>
                                      <c:if test="${!empty staffList}">
                                           <c:forEach items="${staffList}" var="staff">
                                             <option value="${staff.getStaffId()}">${staff.getStaffFirstName()} ${staff.getStaffLastName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                    
                                    
                                    
                                    
                                    
                                    <div class="form-group">
                                       <label for="selector1" class="col-sm-3 control-label">Fees Structure<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-6">
                                           <select name="feesTemplateListId" id="feesTemplateListId" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Fees Structure</option>
                                        		<c:if test="${!empty feesTemplateList}">
		                                       			<c:forEach items="${feesTemplateList}" var="feesTemplateList">
		                                       					<option value="${feesTemplateList.getTemplateId()}" >${feesTemplateList.getTemplateName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                           
                             
                                <h4>Other Information</h4> 
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-6">
                                           <select name="bloodGroupListId" id="bloodGroupListId" class="form-control1">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroupList}">
		                                       			<c:forEach items="${bloodGroupList}" var="bloodGroupList">
		                                       					<option value="${bloodGroupList.getBloodGroupId()}" >${bloodGroupList.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Achievement</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="achievement" name="achievement" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">At Risk Category </label> 
                                 <div class="col-sm-6"> 
                                 <select name="atRiskCategory" id="atRiskCategory"  class="form-control1">
                                <option value="" disabled selected>Select Risk Category</option>
                                           <option value="1">Very Low</option>
                                       <option value="2">Low</option>
                                          <option value="3">Medium</option>
                                             <option value="4">High</option>
                                               <option value="5">Very High</option>  
                                          </select>
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Allergy</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="allergy" name="allergy" placeholder="">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Medicine Allergy</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="medicineAllergy" name="medicineAllergy" placeholder="">
                                 </div>
                                 </div>
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">My Strength</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="myStrength" name="myStrength" placeholder="">
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="studentStatus" id="studentStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <c:if test="${!empty studentStatusList}">
                                          <c:forEach items="${studentStatusList}" var="studentStatusList">
                                             <option value="${studentStatusList.getStudentStatusId()}">${studentStatusList.getStatusTitle()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                                <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                <!--     <button style="float:right"   class="btn btn-warning">Generate Invoice</button> -->
                                    <button style="float:right"  type="submit" id="studentValid" class="btn btn-success">Register</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-info-reset">Clear</button>
                                     <button style="float:right" type="button" onclick="location.reload();" class="btn btn-danger">Cancel</button>
                                                          </div>
                              </div>
                             
                                   
                        </form>
                   
                  </div>
               </div>
            </div>
        </div>
 
       
       
       
       
       <div id="FormDiv" style="display:none;">

       </div>
                <div class="modal fade" id="confirm-save" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
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
                        <button type="button" id="confirmSave" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
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
                        <h5>Are you sure ?, You want to add this Action ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
         </div>
		</div>
		
	</div>
		
	<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/studentregistration.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>