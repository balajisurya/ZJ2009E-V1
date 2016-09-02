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
       
      <!-- font-awesome icons -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
      <!-- //font-awesome icons -->
      <!-- js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/admission.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js"></script>
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <!--webfonts-->
      <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
       <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
      
      <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/date.js"></script>
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
      <!-- Load jQuery JS -->
   
    <!-- Load jQuery UI Main JS  -->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    
    
   
      <!-- //chart -->
      <style>
         .thumbnail {
         height: 200px;
         overflow: hidden;
         }
         .thumbnail {
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
    <div class="main-content">
      <!-- main content start-->
      <div id="page-wrapper">
      <div class="main-page">
          <c:choose>
          	 	<c:when test="${!empty admissionConfig}">
          	 			 <div id="ListDiv" style="display:block;">
            <div class="form-group">
               <button type="button" class="btns btns-c1 col-md-4" onclick="showDiv()">Apply for Admission</button>
               <button  style="margin-left:10%" type="button"class="btns btns-c2 col-md-4">Download Application Form</button>
            </div>
             <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
            
                   <div class="tables">
                       
                       
                     
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                    <th>Applicant Id</th>
                                   	<th>Applicant Code</th>
                               		<th>Applicant Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                              		<c:if test="${!empty appliedApplicationsList}">
                                       <c:forEach items="${appliedApplicationsList}" var="appliedApplications">
                                       		 <tr class="active" id="applicationList">
                                       		 <td>${appliedApplications.getAdmissionId()}</td>
                                  				<td>${appliedApplications.getAdmissionCode()}</td>
                                    			<td>${appliedApplications.getAdmissionStatus().getAdmissionStatusTitle()}</td>
                                 				<td>
                                    				<a href="#" id="edit"  type="button"data-href="#" data-id="${appliedApplications.getAdmissionId()}" data-toggle="modal">
	                                    				<span class="glyphicon glyphicon-edit"></span> 
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
         
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Application</h3>
                     <div class="form-three widget-shadow">
                     
                       <form class="form-horizontal" id="newadmissionForm">
                        <div class="row">
                                 <div class="col-sm-offset-3">
  
                        <button  style="float: right; display:none;"  class="btn btn-info" type="submit" id="admissionSave">
      								<i class="fa fa-floppy-o"></i>
      								 </button>
      								<button style="float: right;" type="button" class="btn btn-danger" onclick="location.reload()">
      								<i class="fa fa-times" aria-hidden="true"></i>
    				     </button>
    				     </div>
    				     </div>
                        <ul id="myTabs" class="nav nav-tabs" role="tablist">
                           <li role="presentation" class="active">
                              <a href="#generalinstructions" id="generalinstructions-tab" role="tab" data-toggle="tab" aria-controls="generalinstructions" aria-expanded="true">General Instructions</a>
                           </li>
                           <li role="presentation">
                              <a href="#personalinformation" id="personalinformation-tab" role="tab" data-toggle="tab" aria-controls="personalinformation" aria-expanded="false">Personal Information</a>
                           </li>
                           <li role="presentation" >
                              <a href="#contactdetails" role="tab" id="contactdetails-tab" data-toggle="tab" aria-controls="contactdetails" aria-expanded="false">Contact Details</a>
                           </li>
                           
                           <li role="presentation" >
                              <a href="#educationalqualifications" role="tab" id="educationalqualifications-tab" data-toggle="tab" aria-controls="educationalqualifications" aria-expanded="false">Educational Qualifications</a>
                           </li>
                           <li role="presentation" >
                              <a href="#course" role="tab" id="course-tab" data-toggle="tab" aria-controls="course" aria-expanded="false">Apply for Course</a>
                           </li>
                           <li role="presentation" >
                              <a href="#document" role="tab" id="document-tab" data-toggle="tab" aria-controls="document" aria-expanded="false">Upload Documents</a>
                           </li>
                           <li role="presentation" >
                              <a href="#payment" role="tab" id="payment-tab" data-toggle="tab" aria-controls="payment" aria-expanded="false">Payment</a>
                           </li>
                        </ul>
                        <div id="myTabContent" class="tab-content scrollbar1">
                           <div role="tabpanel" class="tab-pane fade active in" id="generalinstructions" aria-labelledby="generalinstructions-tab">
                              <p style="text-align: justify;">Applicants applying through online to their preferred course should pay application fees using net banking or debit/credit cards (only VISA cards) during step 4 in “Admission 2015 – ‘16” by selecting online payment.</p>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="personalinformation" aria-labelledby="personalinformation-tab">
                              <div class="form-body">
                                
                                 
                                  <h4>Applicant Information</h4>  
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="candidateFirstName" class="form-control" id="test" placeholder="" required="required">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" required="required" name="candidateLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Gender</label> 
                                       <div class="col-sm-6">
                                          <select required="required" name="candidateGender" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Date Of Birth</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" required="required" name="dateOfBirth" class="form-control" id="datepicker" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">religion</label> 
                                       <div class="col-sm-6">
                                          <select name="religionId"  class="form-control1">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty religionList}">
		                                       		<c:forEach items="${religionList}" var="religion">
		                                       			<option value="${religion.getReligionId()}">${religion.getReligionName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Category</label> 
                                       <div class="col-sm-6">
                                          <select name="categoryId"  class="form-control1">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Special Category</label> 
                                       <div class="col-sm-6">
                                          <select name="specialCategoryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Special Category</option>
                                             	<c:if test="${!empty specialCategoryList}">
		                                       		<c:forEach items="${specialCategoryList}" var="specialCategory">
		                                       			   <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Passport or ID No.</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="passportNo" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country ID Issued</label> 
                                       <div class="col-sm-6"> 
                                              <select name="passportissuedCountryId" id="selector1" class="form-control1">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>                                      </div>
                                    </div>
                                    
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Studied here before?</label> 
                                       <div class="col-sm-6">
                                          <select name="IsStudiedBefore" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Previous Student ID of this institute</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="previousStudentId" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Who will sponsor your studies here?</label> 
                                       <div class="col-sm-6">
                                          <select name="sponserId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Sponsored by</option>
                                             	<c:if test="${!empty sponserList}">
		                                       			<c:forEach items="${sponserList}" var="sponser">
		                                       				<option value="${sponser.getSponserId()}">${sponser.getSponserTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Do you have any disability?</label> 
                                       <div class="col-sm-6">
                                          <select name="isDisability" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                     <h4>Parents and Guardian</h4>                 
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="fatherFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="fatherLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Occupation</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="fatherOccupation" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="motherFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="motherLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Occupation</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="motherOccupation"class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father Income</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="fatherIncome" class="form-control" id="" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother Income</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="motherIncome" class="form-control" id="" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="guardianFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="guardianLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                                
                                    
                                  <h4>Details of References</h4>  
                                    <div class="form-group">
                                     <label for="" class="col-sm-2 control-label "><span>Reference 1</span></label> 
                                    </div>
                                   
                                    
                                    
                                      
                                      
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="reference1FirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="reference1LastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">email</label>
                                       <div class="col-sm-6"> 
                                      
                                          <input type="text" name="reference1Email" class="form-control form-control-email" id="" placeholder="">
                                       </div>
                                       </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-6"> 
                                       
                                          <input type="text" name="reference1Mobile" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label ">Address Line 1</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="reference1AddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                        </div> 
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                       <div class="col-sm-6"> 
                                        
                                          <input type="text" name="reference1AddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="reference1CountryId" id="selector1" class="form-control1">
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
                                       <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-6"> 
                                          <input type="text" name="reference1Pincode" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                       
                                  
                                <div class="form-group">     
                           <label for="" class="col-sm-2 control-label"><span>Reference 2</span></label>
                           </div>            
                                
                                     

                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="reference2FirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="reference2LastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                          <label for="" class="col-sm-3 control-label">email</label>
                                        
                                       <div class="col-sm-6"> 
                                          <input type="text" name="reference2Email"  class="form-control form-control-email" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-6"> 
                                        <input type="text" name="reference2Mobile" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-6"> 
                                          <input type="text" name="reference2AddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="reference2AddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="reference2CountryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country </option>
                                            	<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${ country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                
                                        <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-6"> 
                                       
                                          <input type="text" name="reference2Pincode" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        
            						<h4>Additional Data</h4>                             
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">How did you hear about us?</label> 
                                       <div class="col-sm-6">
                                          <select name="hearedUsid" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select</option>
                                             <c:if test="${!empty hearedUsType}">
		                                       		<c:forEach items="${hearedUsType}" var="hearedUs">
		                                       			<option value="${hearedUs.getHearedUsId()}">${hearedUs.getHearedUsTitle()}</option>
		                                       		</c:forEach>
		                                       </c:if>
		                                  </select>
                                       </div>
                                    </div>
                                    
                       <h4>Upload Photo and Signature</h4> 
                                    
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload Photo</label>
                                       <div class="col-sm-6">
                                          <input type="file" name="photoFile" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload Scanned Signature</label>
                                       <div class="col-sm-6">
                                          <input type="file" name="signatureFile" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="contactdetails" aria-labelledby="contactdetails-tab">
                              <div class="form-body">
                                     <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-6"> 
                                          <input type="text" name="candidateAddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="candidateAddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mobile Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="mobileNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Email</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="candidateEmail" class="form-control form-control-email" id="" placeholder="" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select  name="candidateCountryid" id="geographicallocation" class="form-control1">
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
                                          <select name="candidateStateid" id="geographicallocationstate" class="form-control1">
                                             <option value="" disabled selected>Select Country First </option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City</label> 
                                       <div class="col-sm-6">
                                          <select name="candidateCityid" id="geographicallocationcity" class="form-control1">
                                             <option value="" disabled selected>Select State First </option>
                                          </select>
                                       </div>
                                    </div>
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Post Code</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="candidatePostCode" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           
                           <div role="tabpanel" class="tab-pane fade" id="educationalqualifications" aria-labelledby="educationalqualifications-tab">
                              <div class="form-body">
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Education Level</label> 
                                       <div class="col-sm-6"> 
                                          <select name="educationLevelId" id="educationLevel" class="form-control1">
                                             	<option value="" disabled selected>Select Level</option>
                                             	<c:if test="${!empty  educationQualificationLevelList}">
		                                       		<c:forEach items="${educationQualificationLevelList}" var="educationQualificationLevel">
		                                       				<option value="${educationQualificationLevel.getEducationLevelId()}">${educationQualificationLevel.getEducationLevelTitle()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>                                       
                                          </div>
                                    </div> 
                                    
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Board And University Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="boardAndUniversity" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="institutionName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Country</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionCountryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country </option>
                                             <option>India</option>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution State</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionStateId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country First</option>
                                             <option>Tamil Nadu</option>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution City</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionCityId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select State First</option>
                                             <option>Chennai</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Year Of Passing</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="yearOfPassing" class="form-control" id="" placeholder="" onkeypress="return isNumber(event)">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Type</label> 
                                       <div class="col-sm-6">
                                          <select name="markType" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Marks Type </option>
                                             <option>Percentage</option>
                                              <option>CGPA</option>
                                               <option>Grade</option>
                                             
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Obtained</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="marksObtained" class="form-control" id="" placeholder=""onkeypress="return isNumber(event)">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Registration Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="registrationNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Certificate Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="certificateNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group" id="educationLevelSubject"></div>
                                     <div class="col-sm-offset-3">
                                       <button style="float:right" id="saveEducationLevel" class="btn btn-success">Save and Add Another Entry</button>
                                    </div>
                                 
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="course" aria-labelledby="course-tab">
                              <div class="form-body">
                                 
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Course Type</label> 
                                       <div class="col-sm-6">
                                          <select name="courseTypeId" id="selector1" class="form-control1" required="required">
                                          		<option value="" disabled selected>Select Type</option>
                                          			<c:if test="${!empty  courseTypeList}">
		                                       			<c:forEach items="${courseTypeList}" var="courseType">
		                                       					<option value="${courseType.getCourseTypeId()}" >${courseType.getCourseTypeName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                             <option>Undergraduate Degree</option>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Course Category</label> 
                                       <div class="col-sm-6">
                                          <select name="courseCategoryId" id="selector1" class="form-control1" required="required">
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
                                       <label for="selector1" class="col-sm-3 control-label">Select Department</label>
                                       <div class="col-sm-6">
                                          <select name="departmentId" class="form-control" required="required">
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
                                       <label for="selector1" class="col-sm-3 control-label">Select Course</label >
                                       <div class="col-sm-6">
                                          <select name="courseId" class="form-control1" required="required">
                                                <option value="" disabled selected>Select Course</option>
                                        		<c:if test="${!empty courseList}">
		                                       			<c:forEach items="${courseList}" var="course">
		                                       					<option value="${course.getCourseId()}" >${course.getCourseName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="document" aria-labelledby="document-tab">
                              <div class="tables">
                                 <div class="table-responsive bs-example widget-shadow">
                                    <table class="table">
                                       <thead>
                                          <tr>
                                             <th>Document Title</th>
                                             <th>Upload Document File</th>
                                             <th>Document View</th>
                                          </tr>
                                       </thead>
                                       <tbody>
                                       		<c:if test="${!empty admissionDocumentTypeList}">
		                                       	<c:forEach items="${admissionDocumentTypeList}" var="admissionDocumentType">
		                                       		<tr class="active">
                                             				<th scope="row">${admissionDocumentType.getDocumentTypeTitle()}</th>
                                             				<td>
	                                                			<div class="col-sm-6" >
	                                                   				<input type="file" id="exampleInputFile"> 
	                                                   					<p class="help-block">Example block-level help text here.</p>
	                                                			</div>
                                             				</td>
                                             				<td>
				                                                <div class="thumbnail" style="height: 70%; width:70%">
				                                                   <img id="thumbnil" style="width:100%;  display: block;" src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo3.png" alt="" alt="image" />
				                                                </div>
                                             				</td>
                                          			</tr>
		                                       	</c:forEach>
		                                      </c:if>
                                       </tbody>
                                    </table>
                                 </div>
                              </div>
                             
                              
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="payment" aria-labelledby="payment-tab">
                           
                            <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 12pt; color: #f5911f;">Fees are payable to MANAGEMENT UNIVERSITY OF AFRICA at:</span></p>
                        
                            <p style="margin-left:150px">          Co-operative Bank A/c No. 01129504445300, Mombasa Road Branch</p>  
							<p style="margin-left:150px">           Equity Bank A/C No. 0550298813541, Westland's Branch</p>		  
                            <p style="margin-left:150px">            M-PESA Business No. 247247 Account no .0550298813541</p>
                                       
                            <p style="margin-left:150px">           Barclays Bank A/C No. 010-2023842818 Parkside Branch</p>
                           
                           </div>
                              <div class="form-group">
                                 <button type="button" class="btns btns-p1 col-md-4" id="payumoney_button"><img src="${pageContext.request.contextPath}/resources/themes/images/payu_money.png" alt="Payu Money"></button>
                                 <button  style="margin-left:10%" type="button"class="btns btns-p2 col-md-4">Pay Through Bank</button>
                              </div>
                           </div>
                        </div>
                       </form>
                     </div>
                     
                  </div>
               </div>
            </div>
            
            	</c:when>
            	<c:otherwise>
            		<div class="alert alert-info">
							<h5>Admissions:</h5>
                                  <p>"Admissions are not opened !! You Will be Notified Once Admission Process Starts. Thank You."</p>
                  			</div>
			  </c:otherwise>
          </c:choose>
        
            
            <div id="editFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Application</h3>
                     <div class="form-three widget-shadow">
                     
                       <form class="form-horizontal" id="editadmissionForm">
                        <button type="button" class="btn btn-info" id="admissionEdit">
      								<span class="fa fa-floppy-o"></span>
    				     </button>
                        <ul id="myTabs" class="nav nav-tabs" role="tablist">
                           <li role="presentation" class="active">
                              <a href="#editgeneralinstructions" id="editgeneralinstructions-tab" role="tab" data-toggle="tab" aria-controls="generalinstructions" aria-expanded="true">General Instructions</a>
                           </li>
                           <li role="presentation">
                              <a href="#editpersonalinformation" id="editpersonalinformation-tab" role="tab" data-toggle="tab" aria-controls="personalinformation" aria-expanded="false">Personal Information</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editcontactdetails" role="tab" id="editcontactdetails-tab" data-toggle="tab" aria-controls="contactdetails" aria-expanded="false">Contact Details</a>
                           </li>
                           
                           <li role="presentation" >
                              <a href="#editeducationalqualifications" role="tab" id="editeducationalqualifications-tab" data-toggle="tab" aria-controls="educationalqualifications" aria-expanded="false">Educational Qualifications</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editcourse" role="tab" id="editcourse-tab" data-toggle="tab" aria-controls="course" aria-expanded="false">Apply for Course</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editdocument" role="tab" id="editdocument-tab" data-toggle="tab" aria-controls="document" aria-expanded="false">Upload Documents</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editpayment" role="tab" id="editpayment-tab" data-toggle="tab" aria-controls="payment" aria-expanded="false">Payment</a>
                           </li>
                        </ul>
                        <div id="myTabContent" class="tab-content scrollbar1">
                           <div role="tabpanel" class="tab-pane fade active in" id="editgeneralinstructions" aria-labelledby="generalinstructions-tab">
                              <p style="text-align: justify;">Applicants applying through online to their preferred course should pay application fees using net banking or debit/credit cards (only VISA cards) during step 4 in “Admission 2015 – ‘16” by selecting online payment.</p>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editpersonalinformation" aria-labelledby="personalinformation-tab">
                              <div class="form-body">
                                
                                 
                                  <h4>Applicant Information</h4>  
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editcandidateFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editcandidateLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                   
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Gender</label> 
                                       <div class="col-sm-6">
                                          <select name="editcandidateGender" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Date Of Birth</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editdateOfBirth" class="form-control" id="editdatepicker" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">religion</label> 
                                       <div class="col-sm-6">
                                          <select name="editreligionId" id="editreligionId" class="form-control1">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty religionList}">
		                                       		<c:forEach items="${religionList}" var="religion">
		                                       			<option value="${religion.getReligionId()}">${religion.getReligionName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Category</label> 
                                       <div class="col-sm-6">
                                          <select name="editcategoryId"  class="form-control1">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Special Category</label> 
                                       <div class="col-sm-6">
                                          <select name="editspecialCategoryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Special Category</option>
                                             	<c:if test="${!empty specialCategoryList}">
		                                       		<c:forEach items="${specialCategoryList}" var="specialCategory">
		                                       			   <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Passport or ID No.</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editpassportNo" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country ID Issued</label> 
                                       <div class="col-sm-6"> 
                                              <select name="editpassportissuedCountryId" id="selector1" class="form-control1">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>                                      </div>
                                    </div>
                                    
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Studied here before?</label> 
                                       <div class="col-sm-6">
                                          <select name="editIsStudiedBefore" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Previous Student ID of this institute</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editpreviousStudentId" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Who will sponsor your studies here?</label> 
                                       <div class="col-sm-6">
                                          <select name="editsponserId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Sponsored by</option>
                                             	<c:if test="${!empty sponserList}">
		                                       			<c:forEach items="${sponserList}" var="sponser">
		                                       				<option value="${sponser.getSponserId()}">${sponser.getSponserTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Do you have any disability?</label> 
                                       <div class="col-sm-6">
                                          <select name="editisDisability" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                     <h4>Parents and Guardian</h4>                 
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editfatherFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editfatherLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Occupation</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editfatherOccupation" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editmotherFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editmotherLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Occupation</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="editmotherOccupation"class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father Income</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editfatherIncome" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother Income</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editmotherIncome" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="editguardianFirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editguardianLastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                                
                                    
                                  <h4>Details of References</h4>  
                                    <div class="form-group">
                                     <label for="" class="col-sm-2 control-label "><span>Reference 1</span></label> 
                                    </div>
                                   
                                    
                                    
                                      
                                      
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editreference1FirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text"  name="editreference1LastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">email</label>
                                       <div class="col-sm-6"> 
                                      
                                          <input type="text" name="editreference1Email" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-6"> 
                                       
                                          <input type="text" name="editreference1Mobile" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label ">Address Line 1</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="editreference1AddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                        </div> 
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                       <div class="col-sm-6"> 
                                        
                                          <input type="text" name="editreference1AddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="editreference1CountryId" id="selector1" class="form-control1">
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
                                       <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editreference1Pincode" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                       
                                  
                                <div class="form-group">     
                           <label for="" class="col-sm-2 control-label"><span>Reference 2</span></label>
                           </div>            
                                
                                     

                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editreference2FirstName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editreference2LastName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                          <label for="" class="col-sm-3 control-label">email</label>
                                        
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editreference2Email"  class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-6"> 
                                        <input type="text" name="editreference2Mobile" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-6"> 
                                          <input type="text" name="editreference2AddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="editreference2AddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select name="editreference2CountryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country </option>
                                            	<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${ country.getGeographicalLocationId()}">${country.getGeographicalLocationName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                
                                        <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-6"> 
                                       
                                          <input type="text" name="editreference2Pincode" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                        
            						<h4>Additional Data</h4>                             
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">How did you hear about us?</label> 
                                       <div class="col-sm-6">
                                          <select name="edithearedUsid" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select</option>
                                             <c:if test="${!empty hearedUsType}">
		                                       		<c:forEach items="${hearedUsType}" var="hearedUs">
		                                       			<option value="${hearedUs.getHearedUsId()}">${hearedUs.getHearedUsTitle()}</option>
		                                       		</c:forEach>
		                                       </c:if>
		                                  </select>
                                       </div>
                                    </div>
                                    
                       <h4>Upload Photo and Signature</h4> 
                                    
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload Photo</label>
                                       <div class="col-sm-6">
                                          <input type="file" name="editphotoFile" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload Scanned Signature</label>
                                       <div class="col-sm-6">
                                          <input type="file" name="editsignatureFile" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editcontactdetails" aria-labelledby="contactdetails-tab">
                              <div class="form-body">
                                     <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-6"> 
                                          <input type="text" name="editcandidateAddressLine1" class="form-control" id="" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-6"> 
                                          <input type="text" name="editcandidateAddressLine2" class="form-control" id="" placeholder="">
                                       </div>
                                       </div>
                                       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mobile Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editmobileNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Email</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editcandidateEmail" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-6">
                                          <select  name="editcandidateCountryid" id="geographicallocation" class="form-control1">
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
                                          <select name="editcandidateStateid" id="geographicallocationstate" class="form-control1">
                                             <option value="" disabled selected>Select State </option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City</label> 
                                       <div class="col-sm-6">
                                          <select name="editcandidateCityid" id="geographicallocationcity" class="form-control1">
                                             <option value="" disabled selected>Select City </option>
                                          </select>
                                       </div>
                                    </div>
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Post Code</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="editcandidatePostCode" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           
                           <div role="tabpanel" class="tab-pane fade" id="editeducationalqualifications" aria-labelledby="educationalqualifications-tab">
                              <div class="form-body">
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Education Level</label> 
                                       <div class="col-sm-6"> 
                                          <select name="educationLevelId" id="educationLevel" class="form-control1">
                                             	<option value="" disabled selected>Select Level</option>
                                             	<c:if test="${!empty  educationQualificationLevelList}">
		                                       		<c:forEach items="${educationQualificationLevelList}" var="educationQualificationLevel">
		                                       				<option value="${educationQualificationLevel.getEducationLevelId()}">${educationQualificationLevel.getEducationLevelTitle()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>                                       
                                          </div>
                                    </div> 
                                    
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Board And University Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="boardAndUniversity" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Name</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="institutionName" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Country</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionCountryId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Country </option>
                                             <option>India</option>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution State</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionStateId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select State </option>
                                             <option>Tamil Nadu</option>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution City</label> 
                                       <div class="col-sm-6">
                                          <select name="institutionCityId" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select City </option>
                                             <option>Chennai</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Year Of Passing</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="yearOfPassing" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Type</label> 
                                       <div class="col-sm-6">
                                          <select name="markType" id="selector1" class="form-control1">
                                             <option value="" disabled selected>Select Marks Type </option>
                                             <option>Percentage</option>
                                              <option>CGPA</option>
                                               <option>Grade</option>
                                             
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Obtained</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="marksObtained" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Registration Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="registrationNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Certificate Number</label> 
                                       <div class="col-sm-6"> 
                                          <input type="text" name="certificateNumber" class="form-control" id="" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group" id="educationLevelSubject"></div>
                                     <div class="col-sm-offset-3">
                                       <button style="float:right" id="saveEducationLevel" class="btn btn-success">Save and Add Another Entry</button>
                                    </div>
                                 
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editcourse" aria-labelledby="course-tab">
                              <div class="form-body">
                                 
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Course Type</label> 
                                       <div class="col-sm-6">
                                          <select name="editcourseTypeId" id="selector1" class="form-control1">
                                          		<option value="" disabled selected>Select Type</option>
                                          			<c:if test="${!empty  courseTypeList}">
		                                       			<c:forEach items="${courseTypeList}" var="courseType">
		                                       					<option value="${courseType.getCourseTypeId()}" >${courseType.getCourseTypeName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                             <option>Undergraduate Degree</option>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Course Category</label> 
                                       <div class="col-sm-6">
                                          <select name="editcourseCategoryId" id="selector1" class="form-control1">
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
                                       <label for="selector1" class="col-sm-3 control-label">Select Department</label>
                                       <div class="col-sm-6">
                                          <select name="editdepartmentId" class="form-control1" style="width: 670px;">
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
                                       <label for="selector1" class="col-sm-3 control-label">Select Course</label>
                                       <div class="col-sm-6">
                                          <select name="editcourseId" class="form-control1"  style="width: 670px;">
                                                <option value="" disabled selected>Select Course</option>
                                        		<c:if test="${!empty courseList}">
		                                       			<c:forEach items="${courseList}" var="course">
		                                       					<option value="${course.getCourseId()}" >${course.getCourseName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editdocument" aria-labelledby="document-tab">
                              <div class="tables">
                                 <div class="table-responsive bs-example widget-shadow">
                                    <table class="table">
                                       <thead>
                                          <tr>
                                             <th>Document Title</th>
                                             <th>Upload Document File</th>
                                             <th>Document View</th>
                                          </tr>
                                       </thead>
                                       <tbody>
                                       		<c:if test="${!empty admissionDocumentTypeList}">
		                                       	<c:forEach items="${admissionDocumentTypeList}" var="admissionDocumentType">
		                                       		<tr class="active">
                                             				<th scope="row">${admissionDocumentType.getDocumentTypeTitle()}</th>
                                             				<td>
	                                                			<div class="col-sm-6">
	                                                   				<input type="file" id="exampleInputFile"> 
	                                                   					<p class="help-block">Example block-level help text here.</p>
	                                                			</div>
                                             				</td>
                                             				<td>
				                                                <div class="thumbnail" style="height: 70%; width:70%">
				                                                   <img id="thumbnil" style="width:100%;  display: block;" src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo3.png" alt="" alt="image" />
				                                                </div>
                                             				</td>
                                          			</tr>
		                                       	</c:forEach>
		                                      </c:if>
                                       </tbody>
                                    </table>
                                 </div>
                              </div>
                             
                              
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editpayment" aria-labelledby="payment-tab">
                           
                            <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 12pt; color: #f5911f;">Fees are payable to MANAGEMENT UNIVERSITY OF AFRICA at:</span></p>
                        
                            <p style="margin-left:150px">          Co-operative Bank A/c No. 01129504445300, Mombasa Road Branch</p>  
							<p style="margin-left:150px">           Equity Bank A/C No. 0550298813541, Westland's Branch</p>		  
                            <p style="margin-left:150px">            M-PESA Business No. 247247 Account no .0550298813541</p>
                                       
                            <p style="margin-left:150px">           Barclays Bank A/C No. 010-2023842818 Parkside Branch</p>
                           
                           </div>
                              <div class="form-group">
                                 <button type="button" class="btns btns-p1 col-md-4" id="payumoney_button"><img src="${pageContext.request.contextPath}/resources/themes/images/payu_money.png" alt="Payu Money"></button>
                                 <button  style="margin-left:10%" type="button"class="btns btns-p2 col-md-4">Pay Through Bank</button>
                              </div>
                           </div>
                        </div>
                       </form>
                     </div>
                     
                  </div>
               </div>
            </div>
              <div class="modal fade" id="admissionSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>you are about to save your application, you can edit it latter??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="admissionSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
      $(document).ready(
    		  
    		  /* This is the function that will get executed after the DOM is fully loaded */
    		  function () {
    		    $( "#datepicker" ).datepicker({
    		      changeMonth: true,//this option for allowing user to select month
    		      changeYear: true //this option for allowing user to select from year range
    		    });
    		  }

    		
    		);
      
$(document).ready(
    		  
    		  /* This is the function that will get executed after the DOM is fully loaded */
    		  function () {
    		    $( "#editdatepicker" ).datepicker({
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
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      
<script>
            $(document).ready(function () {
                $(".select2_single").select2({
                    placeholder: "Select a state",
                    allowClear: true
                });
                $(".select2_group").select2({});
                $(".select2_multiple").select2({
                    maximumSelectionLength: 4,
                    placeholder: "click here",
                    allowClear: true
                });
            });
        </script>
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