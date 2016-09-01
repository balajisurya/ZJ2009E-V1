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
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
     
     
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Staff Category</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
             
                 
                     
                      
                         <h3 class="title1">Staff Category</h3> 
                      
                       
                         <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	<th>Staff Category Name</th>
                                   	<th>Staff Type</th>
                                   	<th>Visible</th>
                               		<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                              		<c:if test="${!empty staffTypeList}">
		                                   <c:forEach items="${staffCategories}" var="staffCategories">
		                                       	<tr id="staffCategoryList">
				                                  	<td>${staffCategories.getStaffCategoryName()}</td>
				                                    <td>${staffCategories.getStaffType().getStaffTypeTitle()}</td>
				                                    <td>
		                                                <c:if test="${staffCategories.getStaffCategoryVisible()==0}">
		                                                   No
		                                                </c:if>
		                                                <c:if test="${staffCategories.getStaffCategoryVisible()==1}">
		                                                   Yes
		                                                </c:if>
                                             		</td>
				                                   	<td>
				                                    	<a href="#" id="edit"  type="button" data-href="#" data-id="${staffCategories.getStaffCategoryId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    		<span class="glyphicon glyphicon-edit"></span> 
				                                    	</a>
				                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${staffCategories.getStaffCategoryId()}" data-toggle="modal" data-target="#staff-category-delete-modal">
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
            <div class="modal fade" id="staff-category-delete-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this Staff Category ??</h5>
                     </div>
                     <div class="modal-footer">
                     		<a href="" id="deleteStaffCategory"  class="btn btn-primary" type="button">Yes
                            </a>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addStaffCategoryConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Staff Category ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffCategoryConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="SaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Action ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="SaveConfirm" id="SaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Staff Category</h3>
                     <div class="form-three widget-shadow">
                  <form class="form-horizontal" id="addNewStaffCategory">
                          
                                      <div class="form-group">
                                      <label for="" class="col-sm-3 control-label">Staff Type<span class="at-required-highlight">*</span></label> 
                                        <div class="col-sm-6">
                                           <select name="staffTypeId" id="staffTypeId" class="form-control1" required="required">
                                           	   <option value="" disabled selected>Select Type</option>
                                     			 <c:if test="${!empty staffTypeList}">
		                                       		<c:forEach items="${staffTypeList}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeTitle()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                    		</select>
                                       </div>
                                    </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Category Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" id="staffCategoryName" name="staffCategoryName" class="form-control" id="" placeholder="" required="required">
                                 </div>
                                 </div>
                                 
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Category Role Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                           <select name="staffRoleType" id="staffRoleType" class="form-control1" required="required">
                                           			<option value="" disabled selected>Select Staff Category Role Type</option>
                                     			 <c:if test="${!empty staffRoleTypes}">
		                                       		<c:forEach items="${staffRoleTypes}" var="staffRoleType">
		                                       			<option value="${staffRoleType.getTypeId()}">${staffRoleType.getUserTypeName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                    		</select>
                                       </div>
                                    </div>
                                    
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Category Visible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="staffCategoryVisible" id="staffCategoryVisible"  class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                    </select>
                                 </div>
                              </div>
                              
                          
                                <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffCategory" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                                          </div>
                              </div>
                  
                        </form>
       
                     </div>
                  </div>
               </div>
            </div>
            <div id="EditFormDiv" style="display:none;">
                <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Staff Category</h3>
                     <div class="form-three widget-shadow">
                  <form class="form-horizontal" id="editStaffCategory">
                          
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type</label> 
                                       <div class="col-sm-6">
                                           <select disabled name="editStaffTypeId" id="editStaffTypeId" class="form-control1">
                                           		<option value="" disabled selected>Select Type</option>
                                           			 <c:if test="${!empty staffTypeList}">
		                                       		<c:forEach items="${staffTypeList}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeTitle()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                     		</select>
                                       </div>
                                    </div>
                                    
                                <%--  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Category Role Type</label> 
                                       <div class="col-sm-6">
                                           <select disabled name="editStaffRoleType" id="editStaffRoleType" class="form-control1">
                                           			<option value="" disabled selected>Select Staff Category Role Type</option>
                                     			 <c:if test="${!empty staffRoleTypes}">
		                                       		<c:forEach items="${staffRoleTypes}" var="staffRoleType">
		                                       			<option value="${staffRoleType.getTypeId()}">${staffRoleType.getUserTypeName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                    		</select>
                                       </div>
                                    </div> --%>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Category Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" id="editStaffCategoryName" name="editStaffCategoryName" class="form-control"  placeholder="">
                                 </div>
                                 </div>
                                    
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Category Visible</label> 
                                 <div class="col-sm-6">
                                    <select name="editStaffCategoryVisible" id="editStaffCategoryVisible"  class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                    </select>
                                 </div>
                              </div>
                              
                          
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                <a href="#" id="updateStaffCategory" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
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
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/staffCategory.js" type="text/javascript"></script>
              <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
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