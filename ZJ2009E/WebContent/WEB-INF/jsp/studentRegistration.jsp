<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>  
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/validate.js"></script>
      
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
     		 <div class="forms">
                  <div class="row">
                      <h3 class="title1">New Student Registration</h3>
                        
               <br />
                     <div class="form-three widget-shadow">
                    		<div class="row">
                               
                                 <div class="col-sm-offset-3">
                                  <form action="${pageContext.request.contextPath}/student/studentExcelFormat" method="get">
                                  <button style="float:right"  type="submit" id="downloadStudentExcelFormat" class="btn btn-success">Download Format</button>
                                  </form>
                                 	
                                    <a style="float:right;margin-right: 20px"href="#" class="btn btn-info"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#browse-file">Browse the bulk upload excel sheet
			                             </a>
                                   
                                                          </div>
                              </div>
                        <form class="form-horizontal" id="studentRegistrationform" action="${pageContext.request.contextPath}/student/add" method="post" enctype='multipart/form-data'>
                          
                          <h4>Personal Information</h4> 
                          	<div class="form-group">
                          	
                           
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="lastName"  name="lastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="parentOrGuardianFirstName" name="parentOrGuardianFirstName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="parentOrGuardianLastName" name="parentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="parentOrGuardianEmail"  name="parentOrGuardianEmail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="studentGender" id="studentGender" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>

                                             
                                              <option value="Others">Others</option>
                                          </select>                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" id="dateOfBirth" name="dateOfBirth" placeholder="" required="required" maxlength="10">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="email" class="form-control" id="eMail"  name="eMail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="contact" name="contact" placeholder=""  onkeypress="return isNumber(event)" maxlength="10">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="parentContact" name="parentContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="10" required="required">
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="categoryId" id="categoryId" class="form-control1" required="required">
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
                                          <select name="specialCategoryId" id="specialCategoryId" class="form-control1" required="required">
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

                                 <label for="" class="col-sm-3 control-label">Father Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="fatherIncome" name="fatherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                 <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Mother Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="motherIncome" name="motherIncome" placeholder=""onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                     <h4>Contact Information</h4>   
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="addressLine1"  name="addressLine1" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="countryId" id="geographicallocation" class="form-control1" required="required">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countries}">
		                                       			<c:forEach items="${countries}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>   
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="stateId" id="geographicallocationstate" class="form-control1" required="required">
                                    	 <option value="" disabled selected>Select Country First</option>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="cityId" id="geographicallocationcity" class="form-control1" required="required">
                                     	<option value="" disabled selected>Select State First </option>
                                     </select>
                                 </div>
                              </div>   
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="postCode" name="postCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                           
                             
                          <h4>Upload Photo</h4> 
                                 <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Student Photo</label> 
                                 <div class="col-sm-6">
                                    <input name="studentProfilePic" id="studentProfilePic" type="file" />
                                    <div id="image-holder2" >
                                    
                                    </div>
                                 </div>
                              </div>
                           <!--    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-6">
                                    <input class="image2" name="image2" id="" type="file"/>
                                    <div class="viewimage2"></div>
                                 </div>
                              </div> -->
                                <h4>Academic Information</h4> 
                              
                                   
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Joining Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="joinedClass" id="joinedClass" class="form-control1" required="required">
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
                                          <select name="joinedsection" id="joinedsection" class="form-control1" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="academicYearId" id="academicYearId"  class="form-control1" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYear}">
                                      		<option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Roll No (unique)</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="rollNo" name="rollNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="joinedDate" name="joinedDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="studentAccessNo" name="studentAccessNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              
                               <h4>Other Information</h4> 
	                               <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
	                                 <div class="col-sm-6"> 
	                                    <input type="text" class="form-control" id="passportNo"  name="passportNo" placeholder="" maxlength="100">
	                                 </div>
	                              </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-6">
                                           <select name="bloodGroupId" id="bloodGroupListId" class="form-control1">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroups}">
		                                       			<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       					<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                              
                                    <button style="float:right"  type="button" id="studentSave" class="btn btn-success">Register</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-info-reset">Clear</button>
                                     <button style="float:right" type="button" onclick="location.reload();" class="btn btn-danger">Cancel</button>
                                                          </div>
                              </div>
                             
                                   
                        </form>
                   
                  </div>
               </div>
            </div>
        </div>
 
       
       
       
       
       
                <div class="modal fade" id="studentSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ? You are about to create new student ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="studentSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="browse-file" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                  <form class="form-horizontal" enctype="multipart/form-data" id="studentExcelUploadForm" action="${pageContext.request.contextPath}/student/uploadStudentExcel" method="post">
                  	<div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Student Bulk Upload</h4>
                     </div>
                     <div class="modal-body">
                       <div class="form-group">
                                 <label for="" class="col-sm-2 control-label">Excel File</label> 
                                 <div class="col-sm-6">
                                    <input class="" name="studentExcelfile" id="studentExcelfile" type="file"  required="required"/>
                                 </div>
                              </div>
                                <br>
                                 
                     </div>
                     <div class="modal-footer">
                        <button type="submit" id="confirmExcelUpload" class="btn btn-primary">Upload</button>
                     </div>
                  </form>
                  </div>
               </div>
            </div>
         </div>
		</div>
		
	</div>
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
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/schoolStudentRegistration.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
	<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>

<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
</body>
</html>