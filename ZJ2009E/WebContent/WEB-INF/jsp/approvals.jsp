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
             
              
               
                    
                        <h3 class="title1">Leave Requisition</h3>
                  <div class="tables">
                      
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead>
                                 <tr>
                                   	<th>Staff Name</th>
                                   	<th>Applied Date</th>
                                   	<th>Leave Reason</th>
                               		<th>Leave type</th>
                               		<th>Leave Date(s)</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="approvalsList">
                              	<c:if test="${!empty leaveApporvalsList}">
                                     <c:forEach items="${leaveApporvalsList}" var="leaveApporvals">
                                     	<tr >
		                                  	<td>${leaveApporvals.getStaff().getStaffFirstName()} ${leaveApporvals.getStaff().getStaffLastName()}</td>
		                                    <td>${leaveApporvals.getCreatedDate()}</td>
		                                    <td>${leaveApporvals.getStaffLeaveReason()}</td>
		                                    <td>${leaveApporvals.getStaffLeaveType().getStaffLeaveType()}</td>
		                                    <td>${leaveApporvals.getStaffLeaveStartDate()} - ${leaveApporvals.getStaffLeaveStartDate()}</td>
		                                   	<td>
		                                   	     <button  type="button"  id="staffLeaveApprove"class="btn btn-success"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> </button>
		                                   	     <button  type="button" id="staffLeaveRejection" class="btn btn-info"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></button>
		                                   	</td>
                                   		</tr>
                                     </c:forEach>
                                 </c:if>
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
                   
                        
                         <h3 class="title1"> Facility Booking</h3> 
                        
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Building Name</th>
                                   		<th>Facility Category</th>
                               		<th>Facility Type</th>
                                  	<th>Facility No</th>
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
              
                         <h3 class="title1">Purchase Requisition</h3> 
                      <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table  table-bordered" id="datatable3">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Purchase Type</th>
                                   		<th>Requester Name</th>
                               		<th>Requester Type</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    	<span class="glyphicon glyphicon-eye-open"></span>
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
                   
                        
                         <h3 class="title1">Travel Request</h3> 
                        
                       <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable4">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Travel Type</th>
                                   		<th>Travel Mode</th>
                               		<th>Requester ID</th>
                                  	<th>Requester Name</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                  	<td>Column content</td>
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    		<span class="glyphicon glyphicon-eye-open"></span> 
                                    	</a>
                                   		
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                     </div>
                 
            
            <div class="modal fade" id="confirm-rejected" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Reject this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="confirm-approved" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Accept this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
         $(document).ready(function() {
        	 
        		  $("#selector").change(function() {
        		    var val = $(this).val();
        		    if(val === "leaverequisition") {
        		        $("#leaverequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#travelrequisition").hide();
        		        
        		    }
        		    else if(val === "purchaserequisition") {
        		        $("#purchaserequisition").show();
        		        $("#leaverequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#travelrequisition").hide();
        		      
        		    }
        		    else if(val === "bookingfacilityrequisition") {
        		        $("#bookingfacilityrequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#leaverequisition").hide();
        		        $("#travelrequisition").hide();
        		      
        		    }
        		    else if(val === "travelrequisition") {
        		        $("#travelrequisition").show();
        		        $("#purchaserequisition").hide();
        		        $("#bookingfacilityrequisition").hide();
        		        $("#leaverequisition").hide();
        		      
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/approvals.js" type="text/javascript"></script>
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