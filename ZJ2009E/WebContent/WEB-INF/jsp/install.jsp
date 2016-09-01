
<!DOCTYPE html>
<html>
	

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="Coderthemes">
		<title>Setup Page</title>
		<!--Form Wizard-->
		<link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/install/css/jquery.steps.css" />
		<link href="${pageContext.request.contextPath}/resources/themes/install/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/core.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/components.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/switchery.min.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>	
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/modernizr.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
<style>


</style>

	</head>

	<body class="fixed-left">

		<!-- Begin page -->
		<div id="wrapper">

          <div class="login-logo">
                 <img style="max-width:300px;max-height:200px;"src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png" alt="">                                                                         
         </div>
          
            
			<div class="content-page">
				<!-- Start content -->
				<div class="content">
					<div class="container">
                       <div class="row">
							<div class="col-sm-11">
								<div class="card-box">
									<h4 class="m-t-0 header-title"><b>Configuration Details</b></h4>
									<p class="text-muted m-b-30 font-13">
										
									</p>
									
									<form id="wizard-validation-form" action="${pageContext.request.contextPath}/install" method="post" enctype='multipart/form-data'>
                                        <div>
										  
											<h3>Institute Details</h3>
											 <section>

                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="institutionName"> Institution Name <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionName" name="institutionName" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
                                                
                                                    <div class="form-group clearfix">
                                 <label for="institutionProfilePic" class="col-lg-3 control-label">Institution Logo<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <input name="institutionProfilePic" id="institutionProfilePic" type="file" required="required"/>
                                   <br>
                                    <div id="image-holder2">
                                    </div>
                                 </div>
                              </div>

                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionEmail">Institution Email <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionEmail" name="institutionEmail" type="text" class="required email form-control" maxlength="100">
                                                    </div>
                                                </div>
										<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionContact"> Institution Contact <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionContact" name="institutionContact" type="text" class=" required form-control" onkeypress="return isNumber(event)" maxlength="10">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionAddressLine1">Address Line 1 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionAddressLine1" name="institutionAddressLine1" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionAddressLine2">Address Line 2 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionAddressLine2" name="institutionAddressLine2" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCountry">Country <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCountry" id="geographicallocation" class="required form-control">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getGeographicalLocationId()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionState">State <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionState" id="geographicallocationstate" class="required form-control">
                                    	 						<option value="" disabled selected>Select Country First</option>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCity">City <span>*</span> </label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCity" id="geographicallocationcity" class="required form-control">
                                     						<option value="" disabled selected>Select State First </option>
                                     					</select>
                                                    </div>
                                                </div>
                                                    <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionPostCode"> Post Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionPostCode" name="institutionPostCode" type="text" class="required form-control" onkeypress="return isNumber(event)" maxlength="6">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCurrencyCode">Currency Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCurrencyCode" id="institutionCurrency" class="required form-control" required="required">
					                                       <c:if test="${!empty currencies}">
					                                          <option value="" disabled selected>Select Currency </option>
					                                          <c:forEach items="${currencies}" var="currency">
					                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label  style="color:red"class="col-lg-12 control-label ">(*) Mandatory</label>
                                                </div>

                                            </section>
                                             
                                            <h3>Admin Details</h3>
                                           <section>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="adminName">Name <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input class="required form-control" id="adminName" name="adminName" type="text" maxlength="100">
                                                    </div>
                                                </div>
												 <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="adminEmail"> Email<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="adminEmail" name="adminEmail" type="text" class="required email form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="adminPassword"> Password <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="adminPassword" name="adminPassword" type="password" class="required form-control">

                                                    </div>
                                                </div>

                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="adminConfirmPassword">Confirm Password<span>*</span> </label>
                                                    <div class="col-lg-9">
                                                        <input id="adminConfirmPassword" name="adminConfirmPassword" type="password" class="required form-control" maxlength="100" onChange="checkPasswordMatch();">
                                                    </div>
                                                </div>
                                               <div class="error1" style="margin-left:200px;color:red"></div>
                                                 <div class="form-group clearfix">
                                                    <label  style="color:red"class="col-lg-12 control-label ">(*) Mandatory</label>
                                                </div>
                                            </section>
											
                                           
                                          
                                            
                                        </div>
                                    </form>
								</div>
							</div>
						</div>



                        
                       
                    </div> <!-- container -->
                               
                </div> <!-- content -->

                <footer class="footer">
                    <a style="color:white" href="http://edumaat.com/">2016 © Edumaat.com</a>
                </footer>

            </div>
          




        </div>
        <!-- jQuery  -->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/install.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/detect.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/fastclick.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.slimscroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.blockUI.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/waves.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.nicescroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.scrollTo.min.js"></script>
  		<script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>

        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.app.js"></script>
        <!--Form Validation-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrapValidator.js" type="text/javascript"></script>
        <!--Form Wizard-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.steps.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.validate.min.js"></script>
        <!--wizard initialization-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.wizard-init.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
	
	</body>


</html>