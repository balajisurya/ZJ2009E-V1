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
    
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
     
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
         <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
          <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
    
    
      
   
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
    <c:if test="${!empty message}">
        <c:if test="${message.getStatus()=='exception'}">
         <% System.out.println("hai"); %>
         <c:set var="message" value="${message.getMessage()}"/>
         <script>
         
	      	$(document).ready(function(){
	      		alert(message);
	      		});
      	</script>
        </c:if>
    </c:if>
   <div class="main-content">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Course</button>
               </div>
              
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
            <h3 class="title1">Courses</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                              <table class="table table-bordered" id="datatable">
                                 <thead style="background-color:#673AB7;color:#ffffff;">
                                    <tr>
                                       <th>Course Type</th>
                                       <th>Course Code</th>
                                       <th>Course Name</th>
                                       <th>Course Years/Semester</th>
                                       <th>Department</th>
                                       <th>Course Status</th>
                                       <th style="width:70px">Action</th>
                                    </tr>
                                 </thead>
                                 <tbody id="courselist">
                                    <c:if test="${!empty courseList}">
                                       <c:forEach items="${courseList}" var="course">
                                          <tr>
                                             <td>${course.getCourseType().getCourseTypeName()}</td>
                                             <td>${course.getCourseCode()}</td>
                                             <td>${course.getCourseName()}</td>
                                             <td>${course.getDurationInYears()}</td>
                                             <td>${course.getDepartment().getDepartmentName()}</td>
                                             <td>
                                                <c:if test="${course.getCourseStatus()==0}">
                                                   In Active
                                                </c:if>
                                                <c:if test="${course.getCourseStatus()==1}">
                                                   Active
                                                </c:if>
                                             </td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${course.getCourseId()}" data-toggle="modal" onclick="showeditDiv()" >
                                                <span class="glyphicon glyphicon-edit"></span> 
                                                </a>
                                                	
                                                <a href="#"  id="delete"  type="button" data-href="#"  data-id="${course.getCourseId()}" data-toggle="modal" data-target="#confirm-delete">
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
                      
            
            </div>
            <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this course??</h5>
                     </div>
                     <div class="modal-footer">
                     	<button type="button" id="confirmcourseDelete" class="btn btn-primary" data-dismiss="modal">Yes</button>
                       <!--  <a href="" id="confirmcourseDelete"  class="btn btn-primary" type="button">Yes
                         </a> -->
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="courseSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this course ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="courseSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms" id="error">
                  <div class="row">
                     <h3 class="title1">Create New Course</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newCourseForm">
                           <fieldset id="firststep" class="" >
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="course_name" class="form-control" id="coursename" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="courseType" id="courseType" class="form-control1">
                                       <c:if test="${!empty courseTypeList}">
                                          <option value="" disabled selected>Select Type</option>
                                          <c:forEach items="${courseTypeList}" var="courseType">
                                             <option value="${courseType.getCourseTypeId()}">${courseType.getCourseTypeName()}</option>
                                          </c:forEach>
                                       </c:if>
                                       
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="coursecategories" id="coursecategory" class="select2_multiple form-control" multiple style="width:580px">
                                     	<option value="" disabled>Select Course Category</option>
                                     <c:if test="${!empty courseCategoryList}">
                                          <c:forEach items="${courseCategoryList}" var="courseCategory">
                                             <option value="${courseCategory.getCourseCategoryId()}">${courseCategory.getCourseCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Semester System<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="semestersystem" id="semestersystem"  class="form-control">
                                      <c:if test="${!empty semesterSystemsList}">
                                          <option value="" disabled selected>Select Semester System</option>
                                          <c:forEach items="${semesterSystemsList}" var="semesterSystem">
                                             <option value="${semesterSystem.getSemSystemId()}">${semesterSystem.getSemSystemTitle()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for=""  class="col-sm-3 control-label">Department<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="department" id="department" class="form-control1">
                                       <c:if test="${!empty departmentList}">
                                          <option value="" disabled selected>Select Department</option>
                                          <c:forEach items="${departmentList}" var="department">
                                             <option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="txtarea1" class="col-sm-3 control-label">Course Description<span class="at-required-highlight">*</span></label>
                                 <div class="col-sm-6"><textarea name="description" id="coursedescription" cols="50" rows="4" class="form-control1"></textarea></div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Duration in years<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="years" class="form-control" id="years" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Duration in Semesters<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="sems" class="form-control" id="sems" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total Seats<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="totalSeats" class="form-control" id="totalSeats" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Image<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <input name="photo" id="imageUpload" class="image1" type="file" />
                                    <div class="viewimage1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="status" id="status" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="courseNextButton" class="btn btn-success" type="button">Next</button>
                                    <button style="float: right" class="btn btn-info" type="reset">Clear</button>
                                                                        <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                    
                                 </div>
                              </div>
                           </fieldset>
                           <fieldset id="secondstep" class="" >
                              <h3 class="title">Semester and Module Details</h3>
                              <div id="semesterModules">
                              <br>
                              </div>
                              <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="courseSave" type="submit" class="btn btn-success">Save</button>
                                    <button style="float:right"  id="courseBackButton" type="button" class="btn btn-info">Back</button>
                                    <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
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
                     <h3 class="title1">Edit Course</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updateCourseDetails">
                        <fieldset id="firststep" class="" >
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editCourse_name" class="form-control" id="editCoursename" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Type</label> 
                                 <div class="col-sm-6">
                                    <select name="editCourseType" id="editCourseType" class="form-control1">
                                       <c:if test="${!empty courseTypeList}">
                                          <option value="" disabled selected>Select Type</option>
                                          <c:forEach items="${courseTypeList}" var="courseType">
                                             <option value="${courseType.getCourseTypeId()}">${courseType.getCourseTypeName()}</option>
                                          </c:forEach>
                                       </c:if>
                                       
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Category</label> 
                                 <div class="col-sm-6">
                                     <select name="editCoursecategories" id="editCoursecategory" class="select2_multiple form-control" multiple style="width:520px" >
                                     	<option value="" disabled>Select Course Category</option>
                                     <c:if test="${!empty courseCategoryList}">
                                          <c:forEach items="${courseCategoryList}" var="courseCategory">
                                             <option value="${courseCategory.getCourseCategoryId()}">${courseCategory.getCourseCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Semester System</label> 
                                 <div class="col-sm-6">
                                     <select name="editSemestersystem" id="editSemestersystem"  class="form-control"  style="width:520px">
                                      <c:if test="${!empty semesterSystemsList}">
                                          <option value="" disabled selected>Select Semester System</option>
                                          <c:forEach items="${semesterSystemsList}" var="semesterSystem">
                                             <option value="${semesterSystem.getSemSystemId()}">${semesterSystem.getSemSystemTitle()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for=""  class="col-sm-3 control-label">Department</label> 
                                 <div class="col-sm-6">
                                    <select name="editDepartment" id="editDepartment" class="form-control1">
                                       <c:if test="${!empty departmentList}">
                                          <option value="" disabled selected>Select Department</option>
                                          <c:forEach items="${departmentList}" var="department">
                                             <option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="txtarea1" class="col-sm-3 control-label">Course Description</label>
                                 <div class="col-sm-6"><textarea name="EditDescription" id="editCoursedescription" cols="50" rows="4" class="form-control1"></textarea></div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Duration in years</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="EditYears" class="form-control" id="editYears" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Duration in Semesters</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editSems" class="form-control" id="editSems" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editTotalSeats" class="form-control" id="editTotalSeats" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Image</label> 
                                 <div class="col-sm-6">
                                    <input name="editPhoto" id="editImageUpload" class="image1" type="file" />
                                    <div class="viewimage1"></div>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Status</label> 
                                 <div class="col-sm-6">
                                    <select name="editStatus" id="editStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                              
                             <h3 class="title">Semester and Module Details</h3>
                              <div id="editSemesterModules">
                              <br>
                              </div>
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateCourse" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                   
                                    <button style="float:right"   type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                           </fieldset>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      
      <script type="text/javascript">
         $(document).ready(function(){
         
         	$("#courseNextButton").click(function(){
         		var inp1 = $("#coursename").val();
         		var inp2 =$("#department").val();
         		var inp3= $("#coursedescription").val();
         		var inp4 = $("#imageUpload").val();
         		var inp5 = $("#years").val();
         		var inp6 = $("#sems").val();
         		var inp7 =$("#status").val();
         		var inp8 =$("#coursecategory").val();
         		var inp9 =$("#semestersystem").val();
         		var inp10=$("#totalSeats").val();
         		
         		if ((jQuery.trim(inp1).length && jQuery.trim(inp2).length && jQuery.trim(inp7).length && jQuery.trim(inp5).length && jQuery.trim(inp6).length && jQuery.trim(inp4).length && jQuery.trim(inp3).length && jQuery.trim(inp8).length && jQuery.trim(inp9).length  && jQuery.trim(inp10).length) > 0){
         		current_fs = $('#firststep');
         		next_fs = $('#secondstep');
         		next_fs.show(); 
         		current_fs.hide();
         		
         		var semesterCount=$("#sems").val();
          		 for(i=1;i<=semesterCount;i++){
          			 var semester="semester"+i;
          			 var semesterSystemSubset="semesterSystemSubset"+i;
          			 $("#semesterModules").append('<div id="dd" class="form-group">'+'<h4>Semester '+i+'</h4>'
          		         	+'<label class="col-sm-3 control-label">Semester System Sub-System<span class="at-required-highlight">*</span></label>'
          	         		+'<div class="col-md-3 col-sm-3 col-xs-12">'
          	         		+'<div id="semesterSubsetDropdown">'
          	         		+'<select  name="'+semesterSystemSubset+'" required class="form-control1">'
       	                    	+'<option value="" disabled selected>Select Sub-System</option>'
       						+'</select>'
          	         		+'</div>'
          	         		+'</div>'
         	+'<label class="col-md-1 col-sm-1 control-label">Modules<span class="at-required-highlight">*</span></label>'
         	
         	+'<div class="col-md-5 col-sm-5 col-xs-12">'
         		+'<select  name="'+semester+'" class="select2_multiple form-control" required multiple style="width:400px" >'
         				+'<c:if test="${!empty moduleList}">'
         					+'<c:forEach items="${moduleList}" var="module">'
         						+'<option value="<c:out value="${module.getModuleId()}"/>">'
                    				+'<c:out value="${module.getModuleName()}"/>'
                    			+'</option>'
         					+'</c:forEach>'
             			+'</c:if>'
         			+'</select>'
         		+'</div>'
            +'</div>'); 
          		}
          		getSemesterSubset();
         	multiselect();
         		}
         		
         		else{
           		  
         	         
         		    $("#newCourseForm").before(
         		        '<div class="alert alert-danger alert-dismissable">'+
         		            '<button type="button" class="close" ' + 
         		                    'data-dismiss="alert" aria-hidden="true">' + 
         		                '&times;' + 
         		            '</button>' + 
         		            'Please enter the input Or valid input to corresponding fields...' + 
         		            '</div>'+
         		         '</div>');
         		}
         	window.setTimeout(function() {
         	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
         	        $(this).remove(); 
         	    });
         	},2000);
         
         });
         
         	
         
         	$('#courseBackButton').click(function(){
             	current_fs = $('#secondstep');
             	next_fs = $('#firststep');
             	next_fs.show(); 
             	current_fs.hide();
             	 $('#semesterModules #dd').remove();
             }); 
         	
         	
         
         
         });
        
      </script>
    
        <script type="text/javascript">
         $(document).ready(function(){
        	 
        	 $("#courseNextButton").change(function(){
        		 
        	
				var semesterCount=$("#editSems").val();
				 for(i=1;i<=semesterCount;i++){
					 var editsemester="semester"+i;
					 var editsemesterSystemSubset="semesterSystemSubset"+i;
					 $("#editSemesterModules").append('<div id="edit" class="form-group">'+'<h4>Semester '+i+'</h4>'
				         	+'<label class="col-sm-3 control-label">Semester System Sub-System</label>'
			         		+'<div class="col-md-3 col-sm-3 col-xs-12">'
			         		+'<div id="editsemesterSubsetDropdown">'
			         		+'<select  name="'+editsemesterSystemSubset+'" required class="form-control1">'
		                    	+'<option value="" disabled selected>Select Sub-System</option>'
							+'</select>'
			         		+'</div>'
			         		+'</div>'
			+'<label class="col-md-1 col-sm-1 control-label">Modules</label>'
			
			+'<div class="col-md-5 col-sm-5 col-xs-12">'
				+'<select  name="'+editsemester+'" class="select2_multiple form-control" required multiple style="width:400px" >'
						+'<c:if test="${!empty moduleList}">'
							+'<c:forEach items="${moduleList}" var="module">'
								+'<option value="<c:out value="${module.getModuleId()}"/>">'
		         				+'<c:out value="${module.getModuleName()}"/>'
		         			+'</option>'
							+'</c:forEach>'
		  			+'</c:if>'
					+'</select>'
				+'</div>'
		 +'</div>'); 
				}
				editSemesterSubset();
				multiselect();
       		
       	window.setTimeout(function() {
       	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
       	        $(this).remove(); 
       	    });
       	},2000);
        	 
        	 });
        	 
         });
       </script>
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/course.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
     
          <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>  
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