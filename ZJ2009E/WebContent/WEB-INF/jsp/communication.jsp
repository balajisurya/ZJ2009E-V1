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
   
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
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
     
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Compose New Communication</button>
               </div>
              
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               <h3 class="title1">Inbox</h3>
                
               
                
               
                
               <div class="inbox-page">
              
               <h4>Today</h4>
                   <c:choose>         
                 <c:when test="${!empty communicationAndIssuesOrQueriesList}">
               <c:forEach items="${communicationAndIssuesOrQueriesList}" var="communicationAndIssuesOrQueries">
          
          		<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
					
						<div class="mail"><img src="${pageContext.request.contextPath}/resources/themes/images/i2.png" alt=""/></div>
						<div class="mail mail-name"><h6>${communicationAndIssuesOrQueries.getCommunicationCreatedByUser()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#${communicationAndIssuesOrQueries.getCommunicationId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationAndIssuesOrQueries.getCommunicationSubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a role="button" data-toggle="collapse" data-parent="#accordion" href="#${communicationAndIssuesOrQueries.getCommunicationId()}" aria-expanded="true" aria-controls="collapseTwo">
											<i class="fa fa-reply mail-icon"></i>
											Reply
										</a>
									</li>
									<li>
										<a href="#" title="">
											<i class="fa fa-download mail-icon"></i>
											Archive
										</a>
									</li>
									<li>
										<a href="#" class="font-red" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p>${communicationAndIssuesOrQueries.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="${communicationAndIssuesOrQueries.getCommunicationId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
<p>${communicationAndIssuesOrQueries.getCommunicationMessage()} </p>								
									<input type="text" placeholder="Action Taken" required="required">
									<input type="submit" value="Set Status to In-Process">
									<input type="submit" value="Set Status to Closed">
								
							</div>
						</div>
					</div>
				
				 </c:forEach>
            </c:when>
				
           <c:otherwise>
            <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div>
             </c:otherwise>
              </c:choose>
				
					</div>
				
             
            </div>
         
            
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Message</h3>
                     <br />
                     <div class="col-md-8 compose-right widget-shadow">
                        <div class="panel-default">
                           <div class="panel-heading">
                           </div>
                           <div class="panel-body">
                              <div class="alert alert-info">
                                 Please fill in details to send a new message
                              </div>
                              <form class="com-mail" id="communication" action="${pageContext.request.contextPath}/communication/addCommunicationMessage" method="post">
                                 <div class="form-group">
                                    <label class="col-md-3 control-label">Select Message Mode</label>
                                    <div class="col-md-6">
                                        <select name="MessageMode" id="MessageMode" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Message Mode</option>
                                             <option value="Issue">Issue</option>
                                             <option value="Admin Notice">Do Not Reply to this message</option>
                                          </select>
                                    
                                    </div>
                                 </div>
                                 <br />
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <br />
                                 <div class="form-group">
                                    <label for="" class="col-md-3 control-label">Select Communication Target Group</label> 
                                   <div class="col-sm-6">
                                     <select name="communicationTargetGroupId" id="communicationTargetGroupId" class="form-control1" required="required">
                                      <c:if test="${!empty communicationTargetGroupList}">
                                          <option value="" disabled selected>Select Communication Target Group </option>
                                          <c:forEach items="${communicationTargetGroupList}" var="communicationTargetGroup">
                                             <option value="${communicationTargetGroup.getCommunicationTargetGroupId()}">${communicationTargetGroup.getCommunicationTargetGroupName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                                 </div>
                                 
                                 
                                    
                                 <br />
                                 <br />
                                 <br />
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <br />
                                 <div class="form-group">
                                  <label for="" class="col-md-3 control-label">Select Type of Message</label> 
                                   <div class="col-sm-6">
                                    <select name="TypeOfMessage" id="TypeOfMessage" class="form-control1 control3" required="required">
                                     <option disabled selected>Select Type Of Message</option>
                                       <option value="Administrative Notification">Administrative Notification</option>
                                       <option value="Admission Related Notification">Admission Related Notification </option>
                                       <option value="Issue: Course or Faculty Related">Issue: Course or Faculty Related</option>
                                       <option value="Issue: Fees Related">Issue: Fees Related</option>
                                       <option value="Issue: Facility Related">Issue: Facility Related</option>
                                       <option value="Issue: Help Desk">Issue: Help Desk</option>
                                       <option value="Issue: Exam Related">Issue: Exam Related</option>
                                    </select>
                                    </div>
                                    <textarea rows="6" class="form-control1 control2" placeholder="Message :"  name="message" id="message"></textarea>
                                 </div>
                               
                                   <button style="float:right"   type="submit" name="saveCommunicationMessage" id="saveCommunicationMessage" class="btn btn-success">Send Message</button>
                                
                                
                                 
                                 
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                              
                              </form>
                             
                           </div>
                        </div>
                     </div>
                     <div class="clearfix"> </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
      
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
    
     
       <script src="${pageContext.request.contextPath}/resources/themes/script/communication.js"></script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
     
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
    
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
   </body>
</html>