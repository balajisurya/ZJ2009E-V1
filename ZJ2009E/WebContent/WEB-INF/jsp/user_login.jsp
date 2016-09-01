<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en" class="body-full-height">
    
<head>        
        <!-- META SECTION -->
        <title>Edumaat Login Page</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
      
        <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="${pageContext.request.contextPath}/resources/themes/css/theme-default.css" />
        <!-- EOF CSS INCLUDE -->  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/validator/fv.css" type="text/css" /> --%>
		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         <script src="${pageContext.request.contextPath}/resources/themes/script/user_login.js"></script>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>

    </head> 
    <body >
        
        <div class="login-container lightmode">
       
        <div class="login-logo">
                 <img style="max-width:300px;max-height:400px;"src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png" alt="">                                                                         
         </div>
            <div id="ListDiv" style="display:block;">
               
            <div class="login-box animated fadeInDown">
             	   <c:if test="${!empty message}">
		 					<c:if test="${message.getStatus()=='success'}">
		 						 <div id="login-alert" class="alert alert-success" >
						           	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						  			 <strong>Success! </strong>"${message.getMessage()}"
						   		 </div>
		 					</c:if>
		 					<c:if test="${message.getStatus()=='failed'}">
		 						<div id="login-alert" class="alert alert-danger">
						            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						  			<strong>Error : </strong>"${message.getMessage()}"
							   </div>
		 					</c:if>
 					</c:if>
                <div class="login-body">
                    <div class="login-title"><strong>Log In</strong> to your account</div>
                    <form  class="form-horizontal" id="signIn" action="${pageContext.request.contextPath}/authenticate/login" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="email" name="user-name" class="form-control" placeholder="E-mail" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" name="pass-word" class="form-control" placeholder="Password" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        
                        <div class="col-md-12">
                            <button class="btn btn-success btn-block" id="login"type="submit">Log In</button>
                        </div>
                        <div class="col-md-12">
                            <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
                        </div>
                    </div>
                    <div class="login-or">OR</div>
                    <div class="form-group">
                    <div class="login-title">Sign Up For Online Admission :</div>
                      
                       <div class="col-md-12">
                            <button  style="float: center" class="btn btn-info btn-block" onclick="showSignUpForm()" type="button">Sign Up</button>
                        </div>
                    </div>
                    
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2016 Edumaat-Education Delivery
                    </div>
                    <div class="pull-right">
                        <a href="#">About</a> |
                        <a href="#">Privacy</a> |
                        <a href="#">Contact Us</a>
                    </div>
                </div>
            </div>
            </div>
             <div id="FormDiv" style="display: none;">
              <div class="login-box animated fadeInDown">
              <div id='loadingmessage' style='display:none'>
  						<img class="img-responsive" src='${pageContext.request.contextPath}/resources/themes/images/loading.gif'/>
				</div>
				<div id="message"></div>
             <div class="login-body">
                    <div class="login-title"><strong>sign up</strong> for Admission</div>
                    <form  class="form-horizontal" id="signup" action="${pageContext.request.contextPath}/admissions/candidate/signup" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" name="name" class="form-control" placeholder="Name" required="required"/>
                        </div>
                    </div>
                   
                     <div class="form-group">
                        <div class="col-md-12" id="emailDiv">
                            <input type="email" name="e-mail" id="email"  class="form-control" placeholder="Email" required="required"/>
                        </div>
                     </div>
                      
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" name="pass_word" class="form-control" placeholder="Password" id="password" required="required"/>
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" name="pass_word_confirm" class="form-control" placeholder="confirm Password" id="password_again" required="required"/>
                        </div>
                    </div>
                     <div class="form-group">
                                      
                                        <div class="col-md-12">                                        
                                            <select name="institutionId" class="form-control" required="required">
                                           		<option selected="selected" disabled>Select Institute</option>
                                           			<c:if test="${!empty institutionList}">
                                       					<c:forEach items="${institutionList}" var="institution">
                                       						<option value="${institution.getInstitutionId()}">${institution.getInstitutionName()}</option>
                                                		</c:forEach>
                                       			    </c:if>
                                                
                                            </select>
                                        </div>
                                    </div>	
                    <div class="form-group">
                    	      <button  style="float: center" id="signupvalid"class="btn btn-info btn-block" type="submit">Sign Up</button>
                    	      <!--  <button  style="float: center" class="btn btn-info btn-block" type="submit">Sign Up</button> -->
                    </div>
                  </form>
                </div>
             </div>
             </div>
           <!--    <div id="verificationDiv" style="display: none;">
              <div class="login-box animated fadeInDown">
             <div class="login-body">
                    <div class="login-title"><strong>E-Mail</strong> Verification :</div>
                    <form  class="form-horizontal" action="" method="post" >
                    <h6>Please check your email and click on the link or enter the verification code</h6>
                      <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" name="vericationcode" class="form-control" placeholder="Verification Code"/>
                        </div>
                        
                    </div>                                 
                     <div class="pull-right">
                       - <a class="btn btn-success btn-block" href="${pageContext.request.contextPath}/course" type="button">Logout</a>
                            <button  style="float: right" class="btn btn-success btn-block"  type="button">Submit</button>
                        </div>
                    </form>
                </div>
             </div>
              </div> -->
        </div>
         <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
         <script src="${pageContext.request.contextPath}/resources/themes/js/validator/multifield.js"></script>
         <script src="${pageContext.request.contextPath}/resources/themes/js/validator/validator.js"></script>
         <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
    </body>
</html>


