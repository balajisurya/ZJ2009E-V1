<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en" class="body-full-height">
    
<head>        
        <!-- META SECTION -->
        <title>Login Page</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
      
        <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
           
        <link rel="stylesheet" type="text/css" id="theme" href="${pageContext.request.contextPath}/resources/themes/css/theme-default.css" />
        <!-- EOF CSS INCLUDE -->  
        <script src="${pageContext.request.contextPath}/resources/themes/loginpage/js/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/loginpage/css/bootstrap.min.css">
       
		<script src="${pageContext.request.contextPath}/resources/themes/loginpage/js/bootstrap.min.js"></script>
         <script src="${pageContext.request.contextPath}/resources/themes/script/schooluserlogin.js"></script>
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
                        <button  style="float: center" class="btn btn-link btn-block" onclick="showSignUpForm()" type="button">Forgot your password</button>
                         
                        </div> 
                    </div>
                    
                    
                    
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2016 Edumaat-Education Delivery
                    </div>
                    <div class="pull-right">
                      
                        <a href="#">Privacy</a> |
                        <a href="#">Contact Us</a>
                    </div>
                </div>
            </div>
            </div>
            <div id="FormDiv" style="display: none;">
              <div class="login-box animated fadeInDown">
              <div id="message"></div>
             <div class="login-body">
                    <div class="login-title"><strong>Forgot Password</strong></div>
                    <form  class="form-horizontal" id="forgotpasswordform" action="${pageContext.request.contextPath}/schooluser/forgotPassword" method="post">
                  
                   
                     <div class="form-group">
                        <div class="col-md-12" id="emailDiv">
                            <input type="email" name="e_mail" id="email"  class="form-control" placeholder="Email" required="required"/>
                        </div>
                     </div>
                      
                    
                     
              
                    <div class="form-group">
                    	      <button  style="float:center" id="forgotpasswordformvalid"class="btn btn-info btn-block" type="submit">Send</button>
                    	 
                    </div>
                  </form>
                </div>
             </div>
             </div>
        </div>
         <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
         <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
    </body>
</html>


