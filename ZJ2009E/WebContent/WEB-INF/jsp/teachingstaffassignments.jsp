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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Create New Assignment</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
              
                 
                    
                        
                         <h3 class="title1">Assignments</h3> 
                        
                          <div class="tables">
                        
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   
                               		<th>Assignment Name</th>
                               		<th>Course Name</th>
                               		<th>Department Name</th>
                               		
                                  	<th>Assignment Status</th>
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
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    		<span class="glyphicon glyphicon-edit"></span> 
                                    	</a>
                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    			<span class="glyphicon glyphicon-trash"></span> 
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
                        <h5>Are you sure ?, You want to delete this Action ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="departmentAddingConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
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
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">New Assignment </h3>
                     <div class="form-three widget-shadow">
                       <form class="form-horizontal">
                            
                            
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Module</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>os</option>
                                       <option>dsp</option>
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
                                 <label for="" class="col-sm-3 control-label">Student Activities</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date </label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="date" class="form-control" name="datepicker" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Target Date </label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="date" class="form-control" name="datepicker" placeholder="">
                                 </div>
                              </div>
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Estimated Hours Required</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Questions and Text</label> 
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
                                 <label for="" class="col-sm-3 control-label">Remarks</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="" placeholder="">
                                   
                                 </div>
                              </div>
                            
                             
                              
                               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">To Student</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select from Checkbox</option>
                                       <option>Student ID</option>
                                       <option>Group 1</option>
                                       <option>Group 2</option>
                                       <option>Group 3</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>Visible</option>
                                       <option>Invisible</option>
                                    </select>
                                   
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="submit"  class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="showDiv()">Cancel</button>
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
                     <h3 class="title1">Edit Assignment</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal">
                        
                              
                          
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Course Category</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>C</option>
                                       <option>EC123</option>
                                       <option>EE123</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Department</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>CS123</option>
                                       <option>EC123</option>
                                       <option>EE123</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Semester</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>sm1</option>
                                       <option>sm2</option>
                                       <option>sm3</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Module</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>os</option>
                                       <option>dsp</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">To</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Please Select</option>
                                       <option>Student ID</option>
                                       <option>Group 1</option>
                                       <option>Group 2</option>
                                       <option>Group 3</option>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload Assignment</label>
                                       <div class="col-sm-6">
                                          <input type="file" name="editsignatureFile" id="exampleInputFile"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Target Date </label> 
                                 <div class="col-sm-6"> 
                                    <input type="date" class="form-control" name="datepicker" placeholder="">
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Update</button>
                                  
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="cancelDiv()">Cancel</button>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/department.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js" type="text/javascript"></script>
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