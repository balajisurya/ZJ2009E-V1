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
         .thumbnail {
         height: 200px;
         overflow: hidden;
         }
         .thumbnail {
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
            <div class="form-group">
             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
             
                        <img  id="img-rounded"class="img-responsive" src="${pageContext.request.contextPath}/resources/themes/images/mua.jpg" alt="">                                                                         
                </div>
            </div>
        
           <br />
           <br />
           <br />
               <div class="forms">
                  <div class="row">
                  
                     <div class="form-three widget-shadow"  style="height:500px;">
                       <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 16pt; color: #f5911f; font-family: impact; letter-spacing: 2px;">Welcome to Management University of Africa (MUA)</span></p>
                        </div>
                   
                       
                           <p style="text-align: justify;">The Management University of Africa (MUA) is a premier private university that aims at providing innovation, leadership and management solutions to industries and communities in Africa and beyond. The distinct focus of the Management University of Africa is to be the centre of excellence in capacity building in management, leadership, governance and entrepreneurship.</p>                          
                           <p style="text-align: justify;">At MUA we believe that it is only people who have mastered themselves and discovered their potential, who are best equipped to contribute responsibly and effectively towards the sustainable development of this country. To this end, we have made every effort to create an environment for our students to discover their inherent talents and to equip them with the necessary skills and capacity to employ the same effectively.</p>
                           <p style="text-align: justify;">MUA is Located on Popo Road, South C Nairobi, Nairobi Kenya. The University also owns 80 acres of land in Kisaju, Kitengela for future development.</p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Vision</span><br></strong><span>MUA's Vision is to be a premier university providing management and transformative leadership solutions worldwide&nbsp;</span><span style="font-size: 12pt; font-family: 'Times New Roman', serif;"><br></span></p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Mission</span><br></strong>MUA's mission is to pursue excellence in provision of quality education through innovative teaching and distinguished research to mould leaders, change agents and entreprenuers with a global impact.&nbsp;<span style="font-size: 16pt; line-height: 115%; font-family: 'Book Antiqua', serif;"><br></span></p>
                     <div class="col-sm-offset-3">
                      <a  style="float:right" type="button" class="btn btn-info" href="http://www.mua.ac.ke/">Read More</a>
                                     
                     </div>
              </div>   
              
            </div>
         </div>
      </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
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