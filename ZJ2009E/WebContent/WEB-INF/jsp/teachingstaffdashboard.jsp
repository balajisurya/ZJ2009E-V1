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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/monthly.css" type="text/css" />
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
      <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script>  
      <!-- //chart -->
      <style>
         
         .legend {
         float: left;
         font-size: 12px;
         border: 1px solid #4CAF50;
         padding: 10px;
         width: 176px;
         margin: 1em 0 0 1em;
         }
         .card{
         pointer-events: none;
         transform: translateZ(0);
         padding: 30px;
         background: rgba(246, 41, 96, 0.51);
         border-radius: 5px;
         width: 160px;
         height: 200px;
         margin: auto;
         transform-style: preserve-3d;
         backface-visibility: hidden;
         display: flex;
         box-shadow: 0 0 5px rgba(246, 41, 96, 0.51);
         position: relative;
         &:after{
         content:" ";
         position: absolute;
         width: 100%;
         height: 10px;
         border-radius: 50%;
         left:0;
         bottom:-50px;
         box-shadow: 0 30px 20px rgba(0,0,0,.3);
         }
      </style>
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
                  <br />
                  <div class="col-xs-12 col-md-2">
                     <div class="card">
                        <img class="img-thumbnail" src="${pageContext.request.contextPath}/resources/themes/images/staff.jpg" alt=""> 
                     </div>
                  </div>
                  <div class="col-xs-12 col-md-10">
                     <div class="table-responsive">
                        <table class="table table-bordered">
                           <tbody>
                              <tr >
                                 <th class="success"scope="row">Staff ID</th>
                                 <td>CS125</td>
                                 <th class="success"scope="row">Date of Birth</th>
                                 <td>06-06-1994</td>
                              </tr>
                              <tr >
                                 <th class="info" scope="row">Staff Name</th>
                                 <td><span>C Smitha</span></td>
                                 <th class="info" scope="row">Joining Date</th>
                                 <td>16-05-2016</td>
                              </tr>
                              <tr >
                                 <th class="danger" scope="row">User ID</th>
                                 <td>smitha@jdsoft.in</td>
                                 <th class="danger" scope="row">Total Experience</th>
                                 <td>1 month</td>
                              </tr>
                              <tr >
                                 <th class="info" scope="row">Designation</th>
                                 <td>Head of Department</td>
                                 <th class="info" scope="row">Mobile No</th>
                                 <td>987654321</td>
                              </tr>
                              <tr >
                                 <th  class="warning" scope="row">Department</th>
                                 <td>Electronics and Communication</td>
                                 <th  class="warning" scope="row">Email ID</th>
                                 <td>smitha@gmail.com</td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <div class="form-three widget-shadow">
                     <ul id="myTabs" class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                           <a href="#events" id="events-tab" role="tab" data-toggle="tab" aria-controls="events" aria-expanded="true">Events</a>
                        </li>
                        <li role="presentation" class="dropdown">
                           <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents" aria-expanded="false">Time Table<span class="caret"></span></a> 
                           <ul class="dropdown-menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
                              <li class=""><a href="#dropdown1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1" aria-expanded="false">Daily</a></li>
                              <li class=""><a href="#dropdown2" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2" aria-expanded="false">Weekly</a></li>
                           </ul>
                        </li>
                        <li role="presentation" >
                           <a href="#attendance" role="tab" id="attendance-tab" data-toggle="tab" aria-controls="attendance" aria-expanded="false">Attendance</a>
                        </li>
                        <li role="presentation" >
                           <a href="#moduleshandled" role="tab" id="moduleshandled-tab" data-toggle="tab" aria-controls="educationalqualifications" aria-expanded="false">Modules Handled</a>
                        </li>
                     </ul>
                     <div id="myTabContent" class="tab-content scrollbar1">
                        <div role="tabpanel" class="tab-pane fade active in" id="events" aria-labelledby="events-tab">
                           <div class="row calender widget-shadow">
				
					<div class="monthly" id="mycalendar"></div>
				</div>
				<div class="clearfix"> </div>
                        </div>
                        
                        
                        
                         <div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
                          <div class="table-responsive">
                           <br />
                             <table class="table table-bordered">
                                 <thead style="background-color:#673AB7;color:#ffffff;">
                                    <tr>
                                       <th>Course</th>
                                       <th>Department</th>
                                       <th>Class Timing</th>
                                       <th>Subject</th>
                                       <th>Batch</th>
                                        <th>Block</th>
                                       <th>Room</th>
                                       <th>Lesson And Lab Plan</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    <tr>
                                    
                                       <td>UG</td>
                                       <td>Computer Science</td>
                                       <td>8:00 AM - 9:00 AM</td>
                                       <td>Operating System</td>
                                       <td>Batch 2</td>
                                       <td>Block C</td>
                                        <td>125</td>
                                        <td>
                                        
                                        <a href="#" id="viewanddownload"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="">
                                    		<span class="glyphicon glyphicon-eye-open"></span> 
                                    	</a>
                                        
                                        
                                        
                                        
                                        
                                        </td>
                                    </tr>
                                   
                                 </tbody>
                              </table>
                           </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="dropdown2" aria-labelledby="dropdown2-tab">
                        <br />
                         <div class="table-responsive">
                            
                                     
                              <table class="table table-bordered">
                  <thead style="background-color:#673AB7;color:#ffffff;">
                    
                      <tr>
                        <th>Class Timing</th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Saturday</th>
                  
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <th scope="row">9:00 AM - 10:00 AM</th>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>WT ( Room no-201 ) 
( MCA-Section-01 )</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                     </tr>
                     <tr>
                        <th scope="row">10:00 AM - 11:00 AM	</th>
                        <td>WT ( Room no-202 ) 
( MCA-Section-01 )</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                     </tr>
                     
                  </tbody>
               </table>
                           </div>
                        </div>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                       
                        <div role="tabpanel" class="tab-pane fade" id="attendance" aria-labelledby="attendance-tab">
                           <br />
                          <form class="form-horizontal">
                              <h4 class="title1">Select Criteria</h4>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Month</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control1" id="date-picker" placeholder="Month">
                                 </div>
                              </div>
                            
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Get Details</button>
                                 </div>
                              </div>
                           </form>
                          
                           <div class="x_title">
                              <div class="clearfix">
                              </div>
                           </div>
                           <br />
                           <h4 class="title1">Attendance Details</h4>
                           <br />
                         
                             
                                 <div class="tables">
                                
                                    <div class="table-responsive bs-example widget-shadow">
                                       <table class="table table-bordered">
                                          <thead style="background-color:#673AB7;color:#ffffff;">
                                             <tr>
                                                <th>Absent Days</th>
                                                <th>Leave Type</th>
                                                <th>Total Leave</th>
                                                <th>Balance Leave</th>
                                                <th>Description</th>
                                             </tr>
                                          </thead>
                                          <tbody>
                                             <tr class="active">
                                                <td>Column content</td>
                                                <td>Column content</td>
                                                <td>Column content</td>
                                              <td>Column content</td>
                                                <td>Column content</td>
                                             </tr>
                                          </tbody>
                                       </table>
                                    </div>
                                   </div>
                           
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="moduleshandled" aria-labelledby="moduleshandled-tab">
                           <br />
                            <div class="table-responsive">
                                          <table class="table table-bordered">
                                             <thead style="background-color:#673AB7;color:#ffffff;">
                                                <tr>
                                                   <th>Course Type</th>
                                                   <th>Course Category</th>
                                                   <th>Department</th>
                                                    <th>Module Name</th>
													<th>Student-Attendance</th>
                                                   
                                                </tr>
                                             </thead>
                                             <tbody>
                                                <tr class="active">
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   <td>Column content</td>
                                                   <td>
                                        
                                        <a href="#" id="student-attendance"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    		<span class="glyphicon glyphicon-eye-open"></span> 
                                    	</a>
                                        
                                        
                                        
                                        
                                        
                                        </td>
                                                </tr>
                                             </tbody>
                                          </table>
                                       </div>
                        </div>
                     </div>
                  </div>
               </div>
			   <div id="FormDiv" style="display:none;">
			   
			     <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                               <table class="table table-bordered">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                     <th style="width:20px"><input class='check_all' type='checkbox' onclick="select_all()"/></th>
                                    <th>Student ID</th>
                               
                                    <th>Student Name</th>
                                  
                                    <th>Mobile No</th>
                                     
                                     <th>Total Leave</th>
                                     
                                     
                                     <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                      <th style="width:20px"><input class='case' type='checkbox'/></th>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   
                                  
                                    <td>
                                    
                                    <td> <select name="selector1" id="selector1" class="form-control1">
                                            
                                             <option>Present</option>
                                             <option>PL</option>
                                             <option>SL</option>
                                              <option>Not-Informed</option>
                                          
                                          </select></td>
                                    
                                    </td>
                                    
                                 </tr>


                                 
                                 
                             
                                
                              </tbody>
                           </table>
						   <script>
								 
								 function select_all() {
	$('input[class=case]:checkbox').each(function(){ 
		if($('input[class=check_all]:checkbox:checked').length == 0){ 
			$(this).prop("checked", false); 
		} else {
			$(this).prop("checked", true); 
		} 
	});
}
								 </script>
								 <script>
								 <!--this script code used to get the group  of id(checked ) in student-attendance table-->
								 $('#list').click(function() {
         var generatelist = [];

         $.each($(".case:checked"), function(){            

        	 generatelist.push($(this).attr('id'));

         });

         alert(generatelist);
	 
	 });
								 
								 
								 </script>
						   
                        </div>
                        </div>
			   
			   <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                 
                   
        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" id="list"  class="btn btn-success">Absent</button>
                                 
                                                                     </div>
                              </div>
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   </div>
			   
			   
            </div>
         </div>
         <div class="clearfix"> </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jquery.mtz.monthpicker.js"></script>

		<script>
$('#date-picker').monthpicker();
/* $('#demo-2').monthpicker({pattern: 'yyyy-mm', 
    selectedYear: 2015,
    startYear: 1900,
    finalYear: 2212,});
	var options = {
    selectedYear: 2015,
    startYear: 2008,
    finalYear: 2018,
    openOnFocus: false // Let's now use a button to show the widget
};

$('#demo-3').monthpicker(options);

$('#demo-3').monthpicker().bind('monthpicker-change-year', function (e, year) {
    $('#demo-3').monthpicker('disableMonths', []); // (re)enables all
    if (year === '2015') {
        $('#demo-3').monthpicker('disableMonths', [1, 2, 3, 4]);
    }
    if (year === '2014') {
        $('#demo-3').monthpicker('disableMonths', [9, 10, 11, 12]);
    }
});

$('#demo-3-button').bind('click', function () {
    $('#demo-3').monthpicker('show');
}); */
</script>

<script src="${pageContext.request.contextPath}/resources/themes/js/monthly.js"></script>
      <script>
         $(document).ready(function() {
          
          var card = $(".card");
         
          $(document).on("mousemove",function(e) {  
            var ax = -($(window).innerWidth()/2- e.pageX)/20;
            var ay = ($(window).innerHeight()/2- e.pageY)/10;
            card.attr("style", "transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-webkit-transform: rotateY("+ax+"deg) rotateX("+ay+"deg);-moz-transform: rotateY("+ax+"deg) rotateX("+ay+"deg)");
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
      <!--scrolling js-->
      <script type="text/javascript">
	$(window).load( function() {

		$('#mycalendar').monthly({
			mode: 'event',
			xmlUrl: '${pageContext.request.contextPath}/resources/themes/script/events.xml'
		});

		

	switch(window.location.protocol) {
	case 'http:':
	case 'https:':
	// running on a server, should be good.
	break;
	case 'file:':
	alert('Just a heads-up, events will not work when run locally.');
	}

	});
</script>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
   </body>
</html>
