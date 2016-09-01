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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
      <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      
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
        <%-- <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>  --%>
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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()"> New Module Allocation</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
             
                     
                           <h3 class="title1">Module Allocation Details</h3>
                        
                        <div class="tables">
                           <div class="table-responsive bs-example widget-shadow">
                              <table class="table table-bordered" id="datatable">
                                 <thead style="background-color:#673AB7;color:#ffffff;">
                                    <tr>
                                       <th>Course Name</th>
                                       <th>Module Name</th>
                                       <th>Staff Name</th>
                                       <th>Semester</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    <c:if test="${!empty courseList}">
                                       <c:forEach items="${courseList}" var="course">
                                          <tr class="active">
                                             <td>${course.getCourseType().getCourseTypeName()}</td>
                                             <td>${course.getCourseCode()}</td>
                                             <td>${course.getCourseName()}</td>
                                             <td>${course.getDurationInYears()}</td>
                                          </tr>
                                       </c:forEach>
                                    </c:if>
                                 </tbody>
                              </table>
                           </div>
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
                        <h5>Are you sure ?, You want to delete this course ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="confirm-allocate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Allocate Module Temporally ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">Yes</button>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Allocate Module Permanently??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade modal-grids" id="staffmoduleadd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Add More Allocate Module</h4>
                     </div>
                      <form>
                     <div class="modal-body">
                           <div class="form-group">
								<label class="control-label">Module Name</label>
										  <select name="modulename" id="modulename" class="form-control">
                                              <c:if test="${!empty modueList}">
                                          		<option value="" disabled selected>Select New Module</option>
                                          			<c:forEach items="${modueList}" var="module">
                                          				<option value="${module.getModuleId()}">${module.getModuleName()}</option>
                                          			</c:forEach>
                                          	  </c:if>
                                         </select>
									</div>
					    </div>
	                     <div class="modal-footer">
	                       <button type="reset" class="btn btn-danger" >Clear</button>
	                       <button style="float: right;marigin-right:2px" id="yes"class="btn btn-success" type="button" data-dismiss="modal">Yes</button>
	                     </div>
                     </form>
                             
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Module Allocation</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal">
                           <fieldset id="firststep" class="" >
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course</label> 
                                 <div class="col-sm-6">
                                    <select name="course" id="course" class="form-control1">
                                       <c:if test="${!empty courseList}">
                                          <option value="" disabled selected>Select Type</option>
                                          <c:forEach items="${courseList}" var="course">
                                             <option value="${course.getCourseId()}">${course.getCourseName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Semester</label> 
                                 <div class="col-sm-6">
                                    <select name="semesters" id="semesters" class="form-control1">
                                          <option value="" disabled selected>Select Semester</option>
                                    </select>
                                 </div>
                              </div>
                              
                             
                              
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="moduleAllocationNextButton" class="btn btn-success">Next</button>
                                    <button style="float: right" class="btn btn-danger" type="reset">Clear</button>
                                 </div>
                              </div>
                           </fieldset>
                            <br />
                   <fieldset id="secondstep"class="" >
                              <div class="tables">
                       			 <div class="table-responsive">
                        			<button style="float:right" id="delete" type="button" class="btn btn-danger"><i class="fa fa-times-circle" aria-hidden="true"></i>
</button>							<button  style="float:right" id="addmore" type="button" class="btn btn-success"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                               				<table class="table table-bordered" id="datatable">
                              					<thead style="background-color:#673AB7;color:#ffffff;">
				                                  <tr>
				                                       <th style="width:20px"><input class='check_all' type='checkbox' onclick="select_all()"/></th>
				                                       <th>Module Name </th>
				                                       <th>Select Staff</th>
				                                   </tr>
                               					 </thead>
				                                <tbody id="List">
				                                </tbody>
                          					 </table>
                       			 </div>
                        	</div>
                   			<div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="allocatemoduleSave" type="submit"class="btn btn-success">Save</button>
                                    <button style="float:right"  type="button" id="courseBackButton" class="btn btn-info">Back</button>
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
                                 </div>
                             </div>
                           </fieldset>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div id="EditFormDiv" style="display:none;">
                <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Course</h3>
                     <div class="form-three widget-shadow">
                       
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script type="text/javascript">
      function select_all() {
    		$('input[class=case]:checkbox').each(function(){ 
    			if($('input[class=check_all]:checkbox:checked').length == 0){ 
    				$(this).prop("checked", false); 
    			} else {
    				$(this).prop("checked", true); 
    			} 
    		});
    	}
        $(document).ready(function(){
        	/*<--add and remove extra new module coding--> */
          	 $("#delete").on('click', function() {
          		$('.case:checkbox:checked').parents("tr").remove();
       		    $('.check_all').prop("checked", false); 
       			check();
                });

              		$("#addmore").on('click',function(){
              			 $('#staffmoduleadd').modal('show');
              		});
              			$("#yes").click(function(){
              				var modulename = $("#modulename option:selected").text(); 
              				$('tbody').append('<tr id="dc">'+'<td>'+'<input type="checkbox" class="case"/>'+'</td>'+
                  					'<td>'+modulename+'</td>'+
                  					'<td>'+
                   						'<select name="selector1" id="selector1" class="form-control1">'+
                                         	 '<c:forEach var="staff" items="${staffList}">'
                                          	+'<option value=${staff.getStaffId()}>'
                                          	 	+'${staff.getStaffFirstName()}'
                                           	 +'</option>'
               							 +'</c:forEach>'
               							 +'</select>'
               						 +'</td>'
   									+'</tr>');
                               });
              	
              		
              $('#courseBackButton').click(function(){
               	current_fs = $('#secondstep');
               	next_fs = $('#firststep');
               	next_fs.show(); 
               	current_fs.hide();
               	 $('#List #dc').remove();
               	
               }); 
        });
        
      </script>
     
      <script type="text/javascript">
      
      $(document).ready(function() {
    		var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    	        	//getCourseSemestersByCourse
    	        	 $("#course").change(function(event){
    	        		 var courseId= $(this).val();
    	        		 $.get(ctx+'/course/get',{courseId:courseId},function(response){
    	        			 for(i=1;i<=response.durationInSemesters;i++){
    	        				 $("#semesters").append('<option value="'+i+'">'+i+'</option>');
    	        			 }
    	     			  });
    	        	 });
    	        	 
    	        	 
    	         	 
    	        	 $("#moduleAllocationNextButton").click(function(){
    	           		current_fs = $('#firststep');
    	      				next_fs = $('#secondstep');
    	      				next_fs.show(); 
    	      				current_fs.hide();
    	             	    var courseId=$("#course").val();
    	             	    var semester=$("#semesters").val();
    	             	      $.get(ctx+'/staff/allocatemodules/getModulesByCourseSemester',{courseId:courseId,semester:semester},function(response){
    	             	    	/*$('tbody').empty();*/
    	             	    	$.each(response, function(index,module) {
    	             	    		$('tbody').append('<tr id="dc">'+'<td>'+'<input type="checkbox" class="case"/>'+'</td>'+
    	               					 '<td>'+module.moduleName+'</td>'+
    	               					 '<td>'+
    	        					'<select name="selector1" id="selector1" class="form-control1">'+
    	                              '<c:forEach var="staff" items="${staffList}">'
    	                               +'<option value=${staff.getStaffId()}>'
    	                                +'${staff.getStaffFirstName()}'
    	                                +'</option>'
    	    							 +'</c:forEach>'
    	    							 +'</select>'
    	    							 +'</td>'+
    	                            +'</tr>');
    	             	    	});
    	                	  });
    	             	});
    	        	
    	         	
    	        	 
    	        	 
    	        	 
    	        	 	 
    	           
    	             
    	 });
    	        
    	    
      
      
      
      
      
      </script>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/allocatemodule.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/custom.js" type="text/javascript"></script>
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