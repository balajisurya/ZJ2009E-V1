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
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
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
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
        <!-- Include Required Prerequisites -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>

 
<!-- Include Date Range Picker -->
<script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
     
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script> 
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
               <div class="col-md-3 col-sm-3 col-xs-12"> 
                  <button type="button" class="btn btn-info" onclick="showDiv()">Create New Lesson Plan</button>
                  </div>
                  <div class="col-md-3 col-sm-3 col-xs-12"> 
                  <button type="button" class="btn btn-success" onclick="showsetupDiv()">Create New Lesson Plan Schedule</button>
                  </div> 
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
              
                  
                      
                         <h3 class="title1">Lessons </h3> 
                       
                       
                        <div class="tables">
                        <div class="table-responsive  bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Document ID</th>
                                   	<th>Course Name</th>
                               		<th>Department Name</th>
                                  	<th>Module Name</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    			<span class="glyphicon glyphicon-eye-open"></span>
                                    	</a>
                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    			<span class="glyphicon glyphicon-download-alt"></span>
                                    	 </a>
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                   
                
                <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                      <h3 class="title1">Lesson Plan Schedule</h3> 
                       
                       
                        <div class="tables">
                        <div class="table-responsive  bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Lesson Plan ID</th>
                                   	<th>Lesson Plan Name</th>
                               		<th>Start And End Date</th>
                                  	<th>Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                 
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    			<span class="glyphicon glyphicon-eye-open"></span>
                                    	</a>
                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    			<span class="glyphicon glyphicon-download-alt"></span>
                                    	 </a>
                                    </td>
                                   </tr>
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
                        <h5>Are you sure ?, You want to download this Document ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="confirm-save" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Plan ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Plan</h3>
                     <div class="form-three widget-shadow">
                 
                 
            
                 	<form class="form-horizontal" >
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Module ID</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                        <c:if test="${!empty facilityCategoryList}">
                                          <option value="" disabled selected>Select Facility Category </option>
                                          <c:forEach items="${facilityCategoryList}" var="facilityCategory">
                                             <option value="${facilityCategory.getFacilityCategoryId()}">${facilityCategory.getFacilityCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 </div>
                              </div>
                            
                               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Name or Purpose</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Objectives</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Teacher Procedure</label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="date" class="form-control" name="" placeholder="">
                                 </div>
                              </div> 
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Activities</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                             
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Assessment </label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="date" class="form-control" name="" placeholder="">
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">About The Assignments</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>   
                             
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Framework</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Handout</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Materials</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Questions</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                            
                                <div class="row">
                                 <div class="col-sm-offset-3"> 
                                    <button style="float:right"  id="lessonplansave"   class="btn btn-success">Add Lesson Plan</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
                                 </div>
                              </div>
                                </form>
                     
                  
                        
                      
                     </div>
                  </div>
               </div>
            </div>
           <div id="SetupDiv" style="display:none;">
            
         
            <div class="forms">
                  <div class="row">
                     <h3 class="title1"> New Lesson Schedule</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal">
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Lesson Plan ID/Name </label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector" class="form-control1">
                                             <option value="" disabled selected>Please Select </option>
                                            
                                              
                                               
                                          </select>
                                       </div>
                                    </div> 
                                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label"> Schedule Start Date</label> 
                               <div class="col-sm-6"> 
                                <input type="text" class="form-control form-control-datepicker"  placeholder="">
 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Schedule End Date</label> 
                                
                                 <div class="col-sm-6">
												
												<input class="form-control form-control-datepicker" type="text" placeholder="">
											</div>
                                 </div>
                        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Remarks</label> 
                                
                                 <div class="col-sm-6">
												
												<input class="form-control" type="text" placeholder="">
											</div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hours Required</label> 
                                
                                 <div class="col-sm-6">
												
												<input class="form-control" type="text" placeholder="">
											</div>
                                 </div>
                              
                        
                          <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Status</label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector" class="form-control1">
                                             <option value="" disabled selected>Please Select </option>
                                               <option value="">Visible</option>
                                                 <option value="">Invisible </option>
                                            
                                              
                                               
                                          </select>
                                       </div>
                                    </div> 
                               
                            
                             
                              
                              
                              
                              
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="lessonplanschedulesave"  class="btn btn-success">Add Plan Schedule</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="showDiv()">Cancel</button>
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
                     <h3 class="title1">View Plan</h3>
                     <div class="form-three widget-shadow">
                     <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Plan Available"</p>
                  			
                  			
                  			 <div class="row">
                                 <div class="col-sm-offset-3">
                                   
                                    <button style="float: right" class="btn btn-danger" onclick="cancelDiv()">Cancel</button>
                                 </div>
                              </div>
                        				</div>
                        
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
      	<script type="text/javascript">
$(function() {

  $('input[name="datefilter"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });

  $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
  });

  $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/lessons.js" type="text/javascript"></script>
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