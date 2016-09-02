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
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/validate.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
    
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push" >
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		<div class="main-page">
            
        <div id="ListDiv" style="display:block;">
     		 <div class="forms">
                  <div class="row">
                      <h3 class="title1">Edit Institution</h3>
                        
                      
              
             
                     <div class="form-three widget-shadow">
                    		
                        <form class="form-horizontal" id="editinstitutionform" action="${pageContext.request.contextPath}/institution/update" method="post" enctype='multipart/form-data'>
                         
								<c:if test="${!empty institutionDetails}">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="institutionName"> Institution Name <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionName" name="institutionName" type="text" class="form-control" required="required" maxlength="255" value="${institutionDetails.getInstitutionName()}">
                                                    </div>
                                                </div>
                                          
					   
                                 <div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Logo</label> 
                                 <div class="col-sm-6">
                                    <input name="institutionProfilePic" id="institutionProfilePic" type="file"/>
                                    <br>
                                    <div id="image-holder2" >

                                    
                                     <img src="..${institutionDetails.getInstitutionLogo()}" class="thumb-image"  id="userImage"></img>
                                    </div>
                                   
                                 </div>
                              </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionEmail">Email (without any space) <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionEmail" name="institutionEmail" type="text" class="form-control" required="required"  maxlength="100" value="${institutionDetails.getInstitutionEmail()}">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionContact"> Institution Tel No.<span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionContact" name="institutionContact" type="text" class="form-control" required="required" onkeypress="return isNumber(event)" maxlength="10"  value="${institutionDetails.getInstitutionContact()}">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine1">Address Line 1 <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionAddressLine1" name="institutionAddressLine1" type="text" class="form-control"  maxlength="255" value="${institutionDetails.getInstitutionAddressline1()}" required="required">
                                                    </div>
                                                </div>
												
												<div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine2">Address Line 2 <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionAddressLine2" name="institutionAddressLine2" type="text" class="form-control"  maxlength="255" value="${institutionDetails.getInstitutionAddressline2()}" required="required">
                                                    </div>
                                                </div>
										             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="institutionCountry" id="geographicallocation" class="form-control1" required="required">
                                           
                                              		<c:if test="${!empty geographicallocationList}">
		                                       			<c:forEach items="${geographicallocationList}" var="country">
		                                       			<c:if test="${institutionDetails.getInstitutionCountry()== country.getName()}">
		                                       			<option id="${country.getGeographicalLocationId()}" value="${country.getName()}" selected>${country.getName()}</option>
		                                       			
					                                    	</c:if>
					                                    	<c:if test="${institutionDetails.getInstitutionCountry()!=country.getName()}">
		                                       				<option id="${country.getGeographicalLocationId()}" value="${country.getName()}">${country.getName()}</option>
		                                       				</c:if>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>                                
                                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-6">                                   
                                     <select name="institutionState" id="geographicallocationstate" class="form-control1" required="required">
                                   <c:if test="${!empty geographicallocationStateList}">
		                                       			<c:forEach items="${geographicallocationStateList}" var="stateList">
		                                       			<c:if test="${institutionDetails.getInstitutionState()==stateList.getName()}">
		                                       			<option id="${stateList.getGeographicalLocationId()}" value="${stateList.getName()}" selected>${stateList.getName()}</option>
		                                       			
					                                    	</c:if>
					                                    		
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">                                   
                                     <select name="institutionCity" id="geographicallocationcity" class="form-control1" required="required">
                                      <c:if test="${!empty geographicallocationCityList}">
		                                       			<c:forEach items="${geographicallocationCityList}" var="cityList">
		                                       					<c:if test="${institutionDetails.getInstitutionCity()==cityList.getName()}">
		                                       			<option id="${cityList.getGeographicalLocationId()}" value="${cityList.getName()}" selected>${cityList.getName()}</option>
		     
					                                    	</c:if>
					                                    	
		                                       			</c:forEach>
		                                       		</c:if>
                                     </select>
                                 </div>
</div> 									
									      <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionPostCode"> Post Code <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-6">
                                                        <input id="institutionPostCode" name="institutionPostCode" type="text" class="form-control" onkeypress="return isNumber(event)" maxlength="6"  value="${institutionDetails.getInstitutionPostcode()}">

                                                    </div>
                                                </div>
                                                       <div class="form-group">
                                                    	<label class="col-sm-3 control-label " for="institutionCurrencyCode">Currency Code <span class="at-required-highlight">*</span></label>
                                                		    <div class="col-sm-6">
                                                     		<select name="institutionCurrencyCode" id="institutionCurrency" class="form-control1" required="required">
					                                      
					                                       <c:if test="${!empty currencyList}">
					                                          <c:forEach items="${currencyList}" var="currency">
					                                         	<c:if test="${institutionDetails.getCurrencyCode()==currency.getIsoCode()}">
		                                       			   <option  value="${currency.getIsoCode()}" selected>${currency.getIsoCode()}</option>
					                                    	 </c:if>
					                                    	 	<c:if test="${institutionDetails.getCurrencyCode()!=currency.getIsoCode()}">
		                                       			   <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
					                                    	 </c:if>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                    					 </div>
													</div>
             											
											<input id="updateInstitutionId" name="updateInstitutionId" type="hidden">
                                                 
                          <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                               <a href="#" id="updateinstitution" style="float:right" class="btn btn-success" type="button" data-id="${institutionDetails.getInstitutionId()}" >
                                    				Update
                                    			</a>    
                                  
                                   
                                <!--     <button style="float:right" type="reset" class="btn btn-info btn-info-reset">Clear</button> -->
                                     <button style="float:right" type="button" onclick="location.reload();" class="btn btn-danger">Cancel</button>
                                                          </div>
                              </div>
                                 </c:if>
                                   
                        </form>
                   
                  </div>
               </div>
            </div>
        </div>
 
       
       
       
       
       
                <div class="modal fade" id="institutionupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ? You are about to update institution ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="institutionupdateconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
           
         </div>
		</div>
		
	</div>
 <script> 
         $(document).ready(function() {
                 $("#institutionProfilePic").on('change', function() {
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
                    	 $('#institutionProfilePic').val(''); 
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                	   $('#institutionProfilePic').val(''); 
                     alert("Please select only image");
                   }
                 });
               });
      </script>
 
      <!-- Bootstrap Core JavaScript -->
      
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/editinstitution.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
</body>
</html>