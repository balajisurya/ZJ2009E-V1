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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
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
      <!-- Load jQuery JS -->
      <!-- Load jQuery UI Main JS  -->
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      <!-- Load SCRIPT.JS which will create datepicker for input field  -->
      <!-- //chart -->
      <style>
         .x_title {
         border-bottom: 3px solid #E91E63;
         padding: 1px 5px 6px;
         margin-bottom: 10px;
         }
         #secondstep{
         display:none
         }
         .thumb-image {
         width:250px;
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
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
            
                 <div class="form-group">
                              
                  <button type="button" style="float: left" class="btn btn-info col-md-3" onclick="showDiv()">Compose New Communication</button>
                  </div>
               

               <br />
             
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               <h3 class="title1">Inbox</h3>
               <div class="form-three widget-shadow">
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
<p>${communicationAndIssuesOrQueries.getCommunicationMessage()} </p>								<form>
									<input type="text" placeholder="Reply to sender" required="">
									<input type="submit" value="Send">
								</form>
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
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Message</h3>
                    
                     <div class="form-three widget-shadow">
                        <div class="panel-default">
                           
                           <div class="panel-body">
                              
                              <form class="com-mail" id="communication" action="${pageContext.request.contextPath}/student/addCommunicationMessage" method="post">
                                 <div class="form-group">
                                    <label class="col-md-3 control-label">Select Message Mode</label>
                                    <div class="col-md-6">
                                        <select name="MessageMode" id="MessageMode" class="form-control1">
                                             <option value="" disabled selected>Select Message Mode</option>
                                             <option value="Issue">Issue</option>
                                             <option value="Admin Notice">Do Not Reply to this message</option>
                                          </select>
                                    
                                    </div>
                                 </div>
                                 <br /> <br />
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <br />
                                 <div class="form-group">
                                    <label for="" class="col-md-3 control-label">Select Communication Target Group</label> 
                                   <div class="col-sm-6">
                                     <select name="communicationTargetGroupId" id="communicationTargetGroupId" class="form-control1">
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
                               
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <br />
                                 <div class="form-group">
                                  <label for="" class="col-md-3 control-label">Select Type of Message</label> 
                                   <div class="col-sm-6">
                                    <select name="TypeOfMessage" id="TypeOfMessage" class="form-control1 control3" >
                                     <option selected>Select Type Of Message</option>
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
                               
                                 <input type="button"  style="float: right;margin-left: 5px"class="btn btn-success" name="saveCommunicationMessage" id="saveCommunicationMessage" value="Send Message"> 
                                <input type="button"  style="float: right" class="btn btn-danger" onclick="location.reload();" value="Cancel"> 
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
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script>
         $(document).ready(function() {
                 $("#fileUpload").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder");
                   
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
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                     alert("Pls select only images");
                   }
                 });
               });
      </script>
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
      
      <script src="${pageContext.request.contextPath}/resources/themes/script/communication.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/department.js" type="text/javascript"></script>
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