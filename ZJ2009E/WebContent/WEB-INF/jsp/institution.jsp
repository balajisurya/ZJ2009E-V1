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
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->

<!-- Metis Menu -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<!-- chart -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 


      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
     
      <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/script/institutions.js"></script>	
     
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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Institution</button>
               </div>
               
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <br />
           <h3 class="title1">Institutions</h3>
                  <div class="tables">
                       
                        <div class="table-responsive bs-example widget-shadow">
                                <table class="table table-bordered">
                              <thead>
                                 <tr>
                                      <th>Institution ID</th>
                                      <th>Institution Name</th>
	                                  <th>Institution Country</th>
                                      <th>Institution Contact</th>
                                      <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="institutionlist">
                               <c:if test="${!empty institutionList}">
                                       <c:forEach items="${institutionList}" var="institution">
                                          <tr>
                                             <td>${institution.getInstitutionId()}</td>
                                             <td>${institution.getInstitutionName()}</td>
                                             <td>${geographicallocationService.getGeographicalLocationById(institution.getInstitutionCountryId()).getGeographicalLocationName()}</td>
                                             <td>${institution.getInstitutionContact()}</td>
                                             <td>
                                                <a href="#" id="edit"  type="button"data-href="#" data-id="${institution.getInstitutionId()}" data-toggle="modal" onclick="showeditDiv()">
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${institution.getInstitutionId()}" data-toggle="modal" data-target="#confirm-delete">
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
                     
                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
			               <div class="modal-dialog" role="document">
			                  <div class="modal-content">
			                     <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
			                     </div>
			                     <div class="modal-body">
			                        <h5>Are you sure ?, You want to delete this Institution??</h5>
			                     </div>
			                     <div class="modal-footer">
			                        <a href="" id="confirmiInstitutionDelete"  class="btn btn-primary" type="button">Yes
			                         </a>
			                     </div>
			                  </div>
			               </div>
           			 </div>
                     
                    
                     
                     
                 
             
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Institution</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newInstitutionForm" >
                       
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="institutionName" class="form-control" id="instituteName" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Logo <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <input name="institutionLogo" class="image1" id="institutionLogo"  type="file" required="required"/>
                                    <div class="viewimage1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Description </label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="institutiondescription" class="form-control" id="institueDescription" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="email" name="institutionEmail" class="form-control" id="instituteEmail" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionContact" class="form-control" id="instituteContact" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 1<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionAddressLine1" class="form-control" id="instituteAddressline1" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionAddressLine2" class="form-control" id="instituteAddressline2" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Admin Name</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionAdminName" class="form-control" id="instituteAdminname" placeholder="">
                                   
                                 </div>
                              </div>
                             
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Account No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionAccountNo" class="form-control" id="instituteAccountno" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Account Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionAccountName" class="form-control" id="instituteAccountname" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                                 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Currency<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="currencyCode" id="currencyCode" class="form-control1" required="required">
                                       <c:if test="${!empty currencyList}">
                                          <option value="" disabled selected>Select Currency</option>
                                          <c:forEach items="${currencyList}" var="currency">
                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Country<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="instituteCountryId" id="instituteCountryId" class="form-control1" required="required">
                                       <c:if test="${!empty geographicallocationList}">
                                          <option value="" disabled selected>Select Country </option>
                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
                                             <option id="geoid" value="${geographicallocation.getGeographicalLocationId()}">${geographicallocation.getGeographicalLocationName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution State <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="instituteStateId" id="instituteStateId" class="form-control1" required="required">
                                     <option value="" disabled selected>Select Country First </option>
                                    
                                    </select>
                                 </div>
                              </div>
                             
                             
                             
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution City<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="instituteCityId" id="instituteCityId" class="form-control1" required="required">
                                     <option value="" disabled selected>Select State First </option>
                                    
                                    </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="institutionPostcode" class="form-control" id="institutionPostcode" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="instituteStatus" id="instituteStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                              
                            
                              
                              <div class="row">
                               <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                               
                                 <div class="col-sm-offset-3">
                                 
                                    <button style="float:right"  type="submit" id="institutionSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                       </form>
                     </div>
                  </div>
               </div>
                  <div class="modal fade" id="institutionSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to add this Institution ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="institutionSaveConfirm" id="institutionsSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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
                     <h3 class="title1">Edit Institution</h3>
                     <div class="form-three widget-shadow">
                      <form class="form-horizontal" id="updateInstitutionDetails">
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editInstitutionName" class="form-control" id="editInstitutionName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Logo</label> 
                                 <div class="col-sm-6">
                                    <input name="institutionLogo" id="institutionLogo"  type="file" />
                                    <div id="image-holder1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Description </label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editInstitutionDescription" class="form-control" id="editInstitutionDescription" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Email</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionEmail" class="form-control" id="editInstitutionEmail" placeholder="">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Contact</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionContact" class="form-control" id="editInstitutionContact" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 1 </label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionAddressLine1" class="form-control" id="editInstitutionAddressLine1" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 2</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionAddressLine2" class="form-control" id="editInstitutionAddressLine2" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Admin Name</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionAdminName" class="form-control" id="editInstitutionAdminName" placeholder="">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Account Name</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionAccountName" class="form-control" id="editInstitutionAccountName" placeholder="">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Account No</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionAccountNo" class="form-control" id="editInstitutionAccountNo" placeholder="">
                                   
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Post Code</label> 
                                 <div class="col-sm-6">
                                     <input type="text" name="editInstitutionPostCode" class="form-control" id="editInstitutionPostCode" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Currency</label> 
                                 <div class="col-sm-6">
                                    <select name="editCurrencyCode" id="editCurrencyCode" class="form-control1">
                                       <c:if test="${!empty currencyList}">
                                          <option value="" disabled selected>Select Currency</option>
                                          <c:forEach items="${currencyList}" var="currency">
                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institute Country</label> 
                                 <div class="col-sm-6">
                                    <select name="editInstituteCountryId" id="editInstituteCountryId" class="form-control1">
                                       <c:if test="${!empty geographicallocationList}">
                                          <option value="" disabled selected>Select Country </option>
                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
                                             <option id="geoid" value="${geographicallocation.getGeographicalLocationId()}">${geographicallocation.getGeographicalLocationName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution State </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editInstituteStateId" id="editInstituteStateId" class="form-control1">
                                     <c:if test="${!empty geographicallocationStateList}">
                                          <option value="" disabled selected>Select State</option>
                                          <c:forEach items="${geographicallocationStateList}" var="geographicallocation">
                                             <option id="geoid" value="${geographicallocation.getGeographicalLocationId()}">${geographicallocation.getGeographicalLocationName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                             
                             
                             
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution City </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="editInstituteCityId" id="editInstituteCityId" class="form-control1">
                                     <c:if test="${!empty geographicallocationCityList}">
                                          <option value="" disabled selected>Select City </option>
                                          <c:forEach items="${geographicallocationCityList}" var="geographicallocation">
                                             <option id="geoid" value="${geographicallocation.getGeographicalLocationId()}">${geographicallocation.getGeographicalLocationName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              
                              
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Status</label> 
                                 <div class="col-sm-6">
                                    <select name="editInstituteStatus" id="editInstituteStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-sm-offset-3">
                           
                                 
                                  <a href="#" id="updateInstitution" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
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
		
	</div>
		
		
	
	
		
	<!-- Bootstrap Core JavaScript -->

<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>

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