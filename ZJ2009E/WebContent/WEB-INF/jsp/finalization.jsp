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
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
      <script src="${pageContext.request.contextPath}/resources/themes/script/finalization.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
       
      <!-- Load jQuery JS -->
      <!-- Load jQuery UI Main JS  -->
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      <!-- Load SCRIPT.JS which will create datepicker for input field  -->
      <!-- //chart -->
      
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
     <div id="page-wrapper">
		  <h3 class="title1">Finalization</h3>
		<div class="main-page">
		   <form class="form-horizontal" id="shortcandidateForm">
		   
		    		
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="courseId" id="selector1" class="form-control1" required="required">
                                   			<option value="" disabled selected>Select Course</option>
                                   		<c:if test="${!empty courseList}">
	                                       <c:forEach items="${courseList}" var="course">
	                                      		<option value="${course.getCourseId()}">${course.getCourseName()}</option>
	                                       </c:forEach>
                                       </c:if>
                                       </select> 
                                 </div>
                       </div>
                       
                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="courseCategoryId" id="selector2" class="form-control1" required="required">
                                             <option value="" disabled selected>Select Course Category</option>
                                            <c:if test="${!empty courseCategoryList}">
	                                       <c:forEach items="${courseCategoryList}" var="courseCategory">
	                                      		<option value="${courseCategory.getCourseCategoryId()}">${courseCategory.getCourseCategoryName()}</option>
	                                       </c:forEach>
                                       </c:if>
                                    </select> 
                                 </div>
                       </div>
                        <div class="form-group">
                               <label for="" class="col-sm-3 control-label">Business Logic1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                   <select name="ruleId" id="selector3" class="form-control1" required="required">
                                   <option value="" disabled selected>Select Business Rule to apply</option>
                                             <option value="1">Rule 1</option>
                                             <option value="2">Rule 2</option>
                                    </select> 
                                 </div>
                              </div>
                               
                                <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" id="shortCandidateList" type="submit" class="btn btn-success">Short list Candidates</button>
                                 </div>
                              </div>
              </form>
        
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
       
   				<h3 class="title1">Applicant Details</h3>
   				
   				  <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   <th>Admission Code</th>
                                  
                               		 <th>Student Name</th>
                                  	 <th>Date Of Birth</th>
                                     <th>Gender</th>
                                     <th>Admission Rank</th>
                                     <th>
            <input class='check_all' type='checkbox' onclick="select_all()" />
        </th>
                                    
                                 </tr>
                              </thead>
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
										 <h5>Are you sure ?, You want to delete this Academic Year ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						
                     
                     
                     
                     
                  </div>
                  
               
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                 
                   
        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" id="list"  class="btn btn-success">Notify To Selected Candidates</button>
                                 
                                                                     </div>
                              </div>
                            
       
         </div>
		</div>
     
      
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
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