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
<script src="${pageContext.request.contextPath}/resources/themes/script/admissionconfig.js"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
 <!-- Include Date Range Picker -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/daterangepicker.js"></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
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
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Create Configuration</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
          
                       
                           <h3 class="title1">Admission Configuration</h3>
                    
                        <div class="tables">
                           <div class="table-responsive bs-example widget-shadow">
                              <table class="table table-bordered">
                                 <thead>
                                    <tr>
                                       <th>Application Code Format</th>
                                       <th>Application Fees</th>
                                       <th>Admission Year</th>
                                       <th>Admission Process Status</th>
                                       <th>Action</th>
                                    </tr>
                                 </thead>
                                 <tbody id="admissionConfiglist">
                                    <c:if test="${!empty admissionConfigList}">
                                       <c:forEach items="${admissionConfigList}" var="admissionConfig">
                                          <tr>
                                             <td>${admissionConfig.getApplicationCodeFormat()}</td>
                                             <td>${admissionConfig.getApplicationFees()}</td>
                                             <td>${admissionConfig.getAdmissionProcessYear()}</td>
                                             <td>${admissionConfig.getAdmissionProcessStatus().getAdmissionProcessStatusTitle()}</td>
                                             <td >
                                                <a href="#" id="edit"  type="button" data-href="#"  data-id="${admissionConfig.getAdmissionConfigId()}" data-toggle="modal" onclick="showeditDiv()">
                                                <span class="glyphicon glyphicon-edit" ></span> 
                                                </a>
                                                <a href="#"  id="delete"  type="button" data-href="#"  data-id="${admissionConfig.getAdmissionConfigId()}" data-toggle="modal" data-target="#confirm-delete">
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
            
            <div id="FormDiv" style="display:none;">
            		<div class="forms">
                  <div class="row">
                     <h3 class="title1">Admission Configuration</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="newadmissionConfigForm" action="${pageContext.request.contextPath}/admissions/admissionconfig/add" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Application Code Format<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="admissionCodeFormat" class="form-control" id="" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Application Fees<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text"  name="admissionApplicationFees" class="form-control" id="" placeholder="" required="required" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control form-control-datepicker-range" id="admissionStartAndEndDate"  name="admissionStartAndEndDate" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Process Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                 <select name="admissionProcessStatusId" id="selector1" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Process Status</option>
                                       <c:if test="${!empty admissionProcessStatusList}">
                                       <c:forEach items="${admissionProcessStatusList}" var="admissionProcessStatus">
                                       		<option value="${admissionProcessStatus.getAdmissionProcessStatusId()}">${admissionProcessStatus.getAdmissionProcessStatusTitle()}</option>
                                       </c:forEach>
                                       </c:if>
                                  </select>
                                 
                                                                  </div>
                              </div>
                                <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="admissionConfigSave" type="submit" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float:right"  type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                    
                                 </div>
                              </div>
                        </form>
                  </div>
               </div>
            </div>
            </div>
            
            <div class="modal fade" id="admissionConfigSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to create new admission Configuration ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="admissionConfigSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
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
                        <h5>Are you sure ?, You want to delete this admission Config??</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmcAdmissionConfigDelete"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
            
            <div id="EditFormDiv" style="display:none;">
            	<div class="forms">
                  <div class="row">
                     <h3 class="title1">Admission Configuration</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Application Code Format</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Application Fees</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Start And End Date</label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="From">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="To">
                                 </div>
                              </div>
                               <!-- <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Process Year</label> 
                                 <div class="col-sm-6"> 
                                    <input type="date" class="form-control" id="" placeholder="">
                                 </div>
                              </div> -->
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Process Status</label> 
                                 <div class="col-sm-6"> 
                                 <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                 </select>
                                 
                                                                  </div>
                              </div>
                 
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Selection Criteria</label> 
                                 <div class="col-sm-6"> 
                                 <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Criteria</option>
                                       
                                        
                                    </select>
                                 
                                                                  </div>
                              </div>
                               
                               

                              
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"   class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                 </div>
                              </div>
                        </form>
                  </div>
               </div>
            </div>
                
            </div>
		
		
       		
       
       
         </div>
		</div>
		
	</div>
		
	
	
		
	<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
<!-- Classie -->
		<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
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