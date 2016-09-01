<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
      
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
   
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
     
 <c:if test="${!empty errorMessage}">
       		<script type="text/javascript">
		       	$(document).ready(function(){
			 		var message='${errorMessage.getMessage()}';
					alert(message);
		         });
       		</script>
       </c:if>
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <div class="main-content">
         <!-- main content start-->
         <div id="page-wrapper">
            <div class="main-page">
               <div id="ListDiv" style="display:block;">
                    <h3 class="title1">Backup And Restore</h3>
                  <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               
              
                  
                  <div class="form-group">
                  <div class="row">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/BackupAndRestore/backup" method="post" id="backupform">
                          
                     <button type="button" id="backup" class="btn btn-info col-md-3" >BACKUP</button>
                         </form>
                          <form class="form-horizontal" action="${pageContext.request.contextPath}/BackupAndRestore/restore" method="post" id="restoreform">
                          
                         <button type="button" id="restore"  class="btn btn-danger col-md-3" >RESTORE</button>
                  </form>
                  </div>
                  </div>
                <div class="modal fade" id="browse-file" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                  <form class="form-horizontal" enctype="multipart/form-data" id="restoreform" action="${pageContext.request.contextPath}/BackupAndRestore/restore" method="post">
                  	<div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Restore </h4>
                     </div>
                     <div class="modal-body">
                       <div class="form-group">
                                 <label for="" class="col-sm-2 control-label">SQL File</label> 
                                 <div class="col-sm-6">
                                    <input class="" name="restorefile" id="restorefile" type="file"  required="required"/>
                                 </div>
                              </div>
                                <br>
                                 
                     </div>
                     <div class="modal-footer">
                        <button type="submit" id="confirmUpload" class="btn btn-primary">Upload</button>
                     </div>
                  </form>
                  </div>
               </div>
            </div>
               </div>
                
           
        
            </div>
         </div>
      </div>
    
       <script> 
         $(document).ready(function() {
                 $("#restorefile").on('change', function() {
                   var imgPath = $(this)[0].value;                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();               
                   if (extn == "sql") {
                   } else {
                	   $('#restorefile').val(''); 
                     alert("Please select only sql file");
                   }
                 });
               });
      </script>
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/backupandrestore.js" type="text/javascript"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
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

