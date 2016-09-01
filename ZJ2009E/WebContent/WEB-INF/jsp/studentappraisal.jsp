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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
<!-- //chart -->

<!--//Metis Menu -->
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
                              
                  <button type="button" style="float: left" class="btn btn-info col-md-3" onclick="showDiv()">Create Student Appraisal</button>
                  </div>
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                <h3 class="title1">View And Edit Student Appraisal</h3> 
                 
              
               <form class="form-horizontal" id="getDetails">
                <div class="form-three widget-shadow">
                
                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Enter Student Id</label> 
                                 <div class="col-sm-6">
                                      <input type="text" class="form-control" name="getStudentId" id="getStudentId" placeholder="">
                                    
                                 </div>
                              </div>
                               <div class="row">
                                 <div class="col-sm-offset-3">
                                      <button style="float:right"  type="button" id="getStudentPerformance" class="btn btn-success">Get Details</button>
                                    
                                 </div>
                              </div>                              
                      <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               
                          <div class="tables">
                     <div class="table-responsive bs-example ">
                         <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Student Performance (Appraisal) Id</th>
                                   	<th>Appraisal Term</th>
                               		<th>Appraisal Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="studentPerformance">
                         
                              </tbody>
                           </table>
                         
                        </div>
                        </div>
                           </div>
                      </form>
                       </div>
                     </div>
                 
                  <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure to delete?</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmDelete"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
             <div id="EditFormDiv" style="display:none;">
             
                     <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Student Appraisal</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="editAppraisal" >
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editStudentId" id="studentId" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Term</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editAppraisalTerm" id="appraisalTerm" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="editRelationshipRating" id="relationshipRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editRelationshipComments" id="relationshipComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="editAttitudeRating" id="attitudeRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                     <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 
                                 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editAttitudeComments" id="attitudeComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Rating</label> 
                                 <div class="col-sm-6"> 
                                     <select name="editAcademicRating" id="academicRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editAcademicComments" id="academicComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="editInitiativeRating" id="initiativeRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editInitiativeComments" id="initiativeComments" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Rating</label> 
                                 <div class="col-sm-6"> 
                                     <select name="editCreativityRating" id="creativityRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editCreativityComments" id="creativityComments" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="editPunctualityRating" id="punctualityRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editPunctualityComments" id="punctualityComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="editSportsAndSocialRating" id="sportsAndSocialRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editSportsAndSocialComments" id="sportsAndSocialComments" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Recommendations</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="editRecommentation" id="recommentation" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Status</label> 
                                 <div class="col-sm-6"> 
                                   <select name="editAppraisalStatus" id="appraisalStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Completed</option>
                                       <option value="0">In-Process</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateStudentAppraisal" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                           </form>
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
                  <div id="FormDiv" style="display:none;">
                  
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Student Appraisal</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="appraisal" action="${pageContext.request.contextPath}/student/addStudentAppraisal" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student ID</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="studentId" id="studentId" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Term</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="appraisalTerm" id="appraisalTerm" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="relationshipRating" id="relationshipRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="relationshipComments" id="relationshipComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="attitudeRating" id="attitudeRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                     <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 
                                 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="attitudeComments" id="attitudeComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Rating</label> 
                                 <div class="col-sm-6"> 
                                     <select name="academicRating" id="academicRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="academicComments" id="academicComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="initiativeRating" id="initiativeRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="initiativeComments" id="initiativeComments" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Rating</label> 
                                 <div class="col-sm-6"> 
                                     <select name="creativityRating" id="creativityRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="creativityComments" id="creativityComments" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="punctualityRating" id="punctualityRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="punctualityComments" id="punctualityComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Rating</label> 
                                 <div class="col-sm-6"> 
                                    <select name="sportsAndSocialRating" id="sportsAndSocialRating" class="form-control1">
                                       <option value="" disabled selected>Select Rating</option>
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Comments</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="sportsAndSocialComments" id="sportsAndSocialComments" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Recommendations</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="recommentation" id="recommentation" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Status</label> 
                                 <div class="col-sm-6"> 
                                   <select name="appraisalStatus" id="appraisalStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Completed</option>
                                       <option value="0">In-Process</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 <div class="row">
                                 <div class="col-sm-offset-3">
                                  
                                    <button style="float:right"  type="button" id="addStudentAppraisal" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()"  >Cancel</button>
                                    
                                 </div>
                              </div>
                           </form>
                      </div>
               </div>
            </div>
       </div>
       
         </div>
		</div>
		

	
		
	<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
		<script>
		
	  
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
<!--scrolling js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/script/studentappraisal.js"></script>

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