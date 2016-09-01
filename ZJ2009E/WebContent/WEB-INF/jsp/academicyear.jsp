

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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
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
      <!-- //chart -->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/daterangepicker.css" />
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/moment.min.js"></script>
      <!-- Include Date Range Picker -->
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
                     <div class="col-md-4 col-sm-4 col-xs-12"> 
                        <button type="button" class="btn btn-info col-md-8 col-xs-12" onclick="showDiv()">Add New Academic Year</button>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12"> 
                        <button type="button" class="btn btn-danger col-md-8 col-xs-12" onclick="showsemestersystemDiv()">Semester System</button>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12"> 
                        <button type="button" class="btn btn-success col-md-8 col-xs-12" onclick="showsetupDiv()">Setup Academic Day Schedule</button>
                     </div>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <h3 class="title1">Academic Details</h3>
                  <div class="panel-body widget-shadow">
                     <ul id="myTabs" class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#currentacademicyear" id="currentacademicyear-tab" role="tab" data-toggle="tab" aria-controls="currentacademicyear" aria-expanded="true">Current Academic Year</a></li>
                        <li role="presentation" class=""><a href="#academicyearlist" role="tab" id="academicyearlist-tab" data-toggle="tab" aria-controls="academicyearlist" aria-expanded="false">Academic Year List</a></li>
                        <li role="presentation" class=""><a href="#semestersystemlist" role="tab" id="semestersystemlist-tab" data-toggle="tab" aria-controls="semestersystemlist" aria-expanded="false">Semester System List</a></li>
                        <li role="presentation" class=""><a href="#academicdaytypelist" role="tab" id="academicdaytypelist-tab" data-toggle="tab" aria-controls="academicdaytypelist" aria-expanded="false">Academic Day Type List</a></li>
                     </ul>
                     <div id="myTabContent" class="tab-content scrollbar1">
                        <div role="tabpanel" class="tab-pane fade active in" id="currentacademicyear" aria-labelledby="currentacademicyear-tab" >
                           <br>  
                           <c:choose>
                              <c:when test="${!empty currentAcademicYear}">
                                 <div class="tables">
                                    <div class="table-responsive">
                                       <div class="col-md-12 col-sm-12 col-xs-12">
                                          <table class="table table-bordered">
                                             <tbody >
                                                <tr>
                                                   <th class="success"scope="row">Academic Year Name</th>
                                                   <td>${currentAcademicYear.getAcademicYearTitle()}</td>
                                                </tr>
                                                <tr >
                                                   <th class="info" scope="row">Start Date And End Date</th>
                                                   <td><span>${currentAcademicYear.getAcademicYearStartDate()} - ${currentAcademicYear.getAcademicYearEndDate()}</span></td>
                                                </tr>
                                                <tr >
                                                   <th class="danger" scope="row">Academic Year - Working Days</th>
                                                   <td>${currentAcademicYear.getAcademicYearWorkingDays()}</td>
                                                </tr>
                                             </tbody>
                                          </table>
                                          <div class="x_title">
                                             <div class="clearfix">
                                             </div>
                                          </div>
                                          <h3>Semester System And Sub-System</h3>
                                          <c:set var="academicSemesterSystems"  value="${currentAcademicYear.getAcademicSemesterSystems()}"/>
                                          <div class="forms">
                                             <div class="form-horizontal">
                                                <br>
                                                <c:if test="${!empty academicSemesterSystems}">
                                                   <c:forEach items="${academicSemesterSystems}" var="academicSemesterSystem">
                                                      <div class="form-group">
                                                         <label for="" class="col-sm-3 control-label">Semester System Name:</label> 
                                                         <div class="col-sm-6"> 
                                                            <label class="col-sm-3 control-label"><span style="color:blue;">${academicSemesterSystem.getSemesterSystem().getSemSystemTitle()}</span></label> 
                                                         </div>
                                                      </div>
                                                      <div class="form-group">
                                                         <label for="" class="col-sm-3 control-label">Semester System Sub-System:</label> 
                                                         <div class="col-sm-6">
                                                            <c:set var="academicSemesterSystemSubsets"  value="${academicSemesterSystem.getAcademicSemesterSystemSubsets()}"/>
                                                            <c:if test="${!empty academicSemesterSystemSubsets}">
                                                               <c:forEach items="${academicSemesterSystemSubsets}" var="academicSemesterSystemSubset">
                                                                  <button type="button" class="btn btn-success"><i class="fa fa-play" aria-hidden="true"></i>&nbsp;&nbsp;<strong>${academicSemesterSystemSubset.getSemesterSystemSubset().getSemSystemSubsetTitle()}</strong></button>
                                                               </c:forEach>
                                                            </c:if>
                                                         </div>
                                                      </div>
                                                   </c:forEach>
                                                </c:if>
                                                <div class="x_title">
                                                   <div class="clearfix">
                                                   </div>
                                                </div>
                                                <div class="row">
                                                   <div class="col-sm-offset-3">
                                                      <button style="float:right"  id="academicyearclose" value="${currentAcademicYear.getAcademicYearId()}" class="btn btn-success" type="button">Close</button>
                                                   </div>
                                                </div>
                                             </div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </c:when>
                              <c:otherwise>
                                 <div class="alert alert-info">
                                    <h5>Messages:</h5>
                                    <p>"No Current Academic Year Available "</p>
                                 </div>
                              </c:otherwise>
                           </c:choose>
                        </div>
                        <div role="tabpanel" class="tab-pane fade " id="academicyearlist" aria-labelledby="academicyearlist-tab">
                           <br>
                           <div class="tables">
                              <div class="table-responsive">
                                 <table class="table table-bordered">
                                    <thead style="background-color:#673AB7;color:#ffffff;">
                                       <tr>
                                          <th>Academic Year Name</th>
                                          <th>Academic Year Start And End</th>
                                          <th>Academic Year-Working Days</th>
                                          <th>Academic Year Status</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                       <c:if test="${!empty academicYearList}">
                                          <c:forEach items="${academicYearList}" var="academicYear">
                                             <tr>
                                                <td>${academicYear.getAcademicYearTitle()}</td>
                                                <td>${academicYear.getAcademicYearStartDate()} - ${academicYear.getAcademicYearStartDate()}</td>
                                                <td>${academicYear.getAcademicYearWorkingDays()}</td>
                                                <td>${academicYear.getAcademicYearStatus().getAcademicYearStatusName()}</td>
                                             </tr>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade " id="semestersystemlist" aria-labelledby="semestersystemlist-tab">
                           <br>
                           <div class="tables">
                              <div class="table-responsive">
                                 <table class="table table-bordered">
                                    <thead style="background-color:#673AB7;color:#ffffff;">
                                       <tr>
                                          <th>Semester System Title</th>
                                          <th>Semester Per Year</th>
                                          <th>Semester System Status</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                       <c:if test="${!empty semesterSystemList}">
                                          <c:forEach items="${semesterSystemList}" var="semesterSystem">
                                             <tr>
                                                <td>${semesterSystem.getSemSystemTitle()}</td>
                                                <td>${semesterSystem.getSemestersPerYear()}</td>
                                                <c:if test="${semesterSystem.getSemesterSystemStatus()==1}">
                                                   <td>Active</td>
                                                </c:if>
                                                <c:if test="${semesterSystem.getSemesterSystemStatus()==0}">
                                                   <td>In Active</td>
                                                </c:if>
                                             </tr>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade " id="academicdaytypelist" aria-labelledby="academicdaytypelist-tab">
                           <br>
                           
                           <button  style="float:right" id="addmore" type="button" class="btn btn-success"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                         <br>
                           <br>
                           <div class="tables">
                           
                                                      
                           
                              <div class="table-responsive">
                                 <table class="table table-bordered">
                                    <thead>
                                       <tr>
                                          <th style="width:350px">Academic Year Name</th>
                                          <th>Name Of The Day Type</th>
                                          
                                          <th style="width: 150px">Action</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                       <tr>
                                         
                                          <td>Column content</td>
                                          <td>Column content</td>
                                          <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" data-target="#edit_day_type">
			                                    		<span class="glyphicon glyphicon-edit"></span> 
			                                    	</a>
			                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm_delete_day_type">
			                                    			<span class="glyphicon glyphicon-trash"></span> 
			                                    	 </a></td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="confirm-save-academicyear" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to add this Academic Year ??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="confirm-save-academicyear-schedule-day" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to add this Academic Year Schedule Day ??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
                           <h5>Are you sure ?, You want to delete this Academic Year ??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="academicyearcloseconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to close this Academic Year ??</h5>
                        </div>
                        <div class="modal-footer">
                           <a href="" id="confirmAcademicYearClosing"  class="btn btn-primary" type="button">Yes</a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="semestersystemsub-systemcloseconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to close this Semester System Sub-System ??</h5>
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
                        <h3 class="title1">Create New Academic Year</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="academicYearSaveForm" action="${pageContext.request.contextPath}/academic/academicyear/add" method="post">
                              <fieldset id="firststep" class="">
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Academic Year Name<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6"> 
                                       <input type="text" class="form-control" id="academicYearName" name="academicYearName" placeholder="">
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label"> Start Date And End Date<span class="at-required-highlight">*</span> </label> 
                                    <div class="col-md-6"> 
                                       <input type="text"  class="form-control form-control-datepicker-range" id="academicYearStartEndDate"  name="academicYearStartEndDate" placeholder="">
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Academic Year - Working Days<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6"> 
                                       <input type="text" class="form-control" id="academicYearWorkingDays" name="academicYearWorkingDays" placeholder="" onkeypress="return isNumber(event)">
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Semester Systems<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6">
                                       <!-- class="select2_multiple form-control" -->
                                       <select name="semesterSystems" id="semesterSystems"  multiple="multiple" class="select2_multiple form-control" style="width:515px">
                                          <c:if test="${!empty semesterSystemList}">
                                             <c:forEach items="${semesterSystemList}" var="semesterSystem">
                                                <option value="${semesterSystem.getSemSystemId()}">${semesterSystem.getSemSystemTitle()}</option>
                                             </c:forEach>
                                          </c:if>
                                       </select>
                                    </div>
                                 </div>
                                 <div class="row">
                                 
                                    <div class="col-sm-offset-3">
                                       <button style="float:right"  id="nextButtonacademicyear" class="btn btn-success" type="button">Next</button>
                                       <button style="float: right" class="btn btn-info" type="reset">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                    </div>
                                 </div>
                              </fieldset>
                              <fieldset id="secondstep" class="" >
                                 <h3 class="title1">Select Current Semester Subset</h3>
                                 <br>
                                 <div id="semestersystemsubsetforacademicyear">
                                 </div>
                                 <div class="row">
                                   <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                    <div class="col-sm-offset-3">
                                       <button style="float:right"  id="academicYearSave" type="submit" class="btn btn-success">Save</button>
                                       <button style="float:right"  id="academicYearBackButton" type="button" class="btn btn-info">Back</button>
                                       <button style="float: right" id="academicYearCancel" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                    </div>
                                 </div>
                              </fieldset>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="semestersystemDiv" style="display:none;">
                  <div class="forms" id="error">
                     <div class="row">
                        <h3 class="title1">Create New Semester System</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="semesterSystemSaveForm" action="${pageContext.request.contextPath}/academic/semesterSystem/add" method="post">
                              <fieldset id="firststepforsemestersystem" class="" >
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Semester System Title<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6"> 
                                       <input type="text" name="semesterSystemTitle" class="form-control" id="semestersystemtitle" placeholder="">
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Semester System Per Year<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6"> 
                                       <input type="text" name="semesterPerYear" class="form-control" id="ssperyear" placeholder="" onkeypress="return isNumber(event)">
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Semester System Status<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-6">
                                       <select name="semesterSystemStatus" id="status" class="form-control1">
                                          <option value="" disabled selected>Select Status</option>
                                          <option value="1">Active</option>
                                          <option value="0">Inactive</option>
                                       </select>
                                    </div>
                                 </div>
                                 <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                    <div class="col-sm-offset-3">
                                       <button style="float:right"  id="NextButton" class="btn btn-success" type="button">Next</button>
                                       <button style="float: right" class="btn btn-info" type="reset">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload(true)">Cancel</button>
                                    </div>
                                 </div>
                              </fieldset>
                              <fieldset id="secondstepforsemestersystem" class="" >
                                 <h3 class="title1">Semester System Sub-System</h3>
                                 <br>
                                 <div id="semesterSystemSubset">
                                 </div>
                                 <div class="row">
                                    <div class="col-sm-offset-3">
                                       <button style="float:right"  id="semesterSystemSave" type="submit" class="btn btn-success">Save</button>
                                       <button style="float:right"  id="BackButton" type="button" class="btn btn-info">Back</button>
                                       <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload(true)">Cancel</button>
                                    </div>
                                 </div>
                              </fieldset>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="semesterSystemSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want create new semester system??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" id="semesterSystemSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="academicYearSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want create new Academic year?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" id="academicYearSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="SetupDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Setup Academic Day Schedule</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="academic_year_calendar_form">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year Name</label> 
                                 <div class="col-sm-6">
                                      <input type="text"  class="form-control" id=""  placeholder="" readonly="readonly"/>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Name of the Day<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Day Type</option>
                                       <option>Holiday</option>
                                       <option>Exam</option>
                                  
                                    </select>
                                 </div>
                                 
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control form-control-datepicker-range" id=""  placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Description</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                              <div class="row">
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="submit" id="addacademicyearscheduleday" class="btn btn-success">Save and Add Another</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                           </form>
                           
                           
                           </div>
                           <br>
                           
                           <div class="x_title">
                                                   <div class="clearfix">
                                                   </div>
                                                </div>
                                                <br>
                               <h3 class="title1">Academic Calendar Details</h3>
                           <div class="form-three widget-shadow">
                       
                            <div class="tables">
                              <div class="table-responsive">
                                 <table class="table table-bordered">
                                    <thead>
                                       <tr>
                                        
                                          <th>Name Of The Day</th>
                                          <th>From And To Dates</th>
                                          <th>Description</th>
                                          <th>
                                          
                                          Action
                                          </th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                       <tr>
                                       
                                          <td>Column content</td>
                                          <td>Column content</td>
                                          <td>Column content</td>
                                          <td>
                                          
                                           <a href="#" id=""  type="button"data-href="#" data-id="" data-toggle="modal" data-target="#edit_academic_day">
			                                    		<span class="glyphicon glyphicon-edit"></span> 
			                                    	</a>
			                                   		 <a href="#"  id=""  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm_delete_academic_year_day">
			                                    			<span class="glyphicon glyphicon-trash"></span> 
			                                    	 </a></td>
                                         
                                       </tr>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                        </div>
                     </div>
                  </div>
                  
                    <div class="modal fade" id="edit_academic_day" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Edit Academic Day</h4>
                           </div>
                           <div class="modal-body">
                            <form class="form-horizontal">
                              <div class="form-group">
                                 <label for="" class="col-sm-4 control-label">Academic Year Name</label> 
                                 <div class="col-sm-6">
                                      <input type="text"  class="form-control" id=""  placeholder="" readonly="readonly"/>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-4 control-label">Name of the Day</label> 
                                 <div class="col-sm-6">
                                    <select name="selector1" id="selector1" class="form-control1">
                                       <option value="" disabled selected>Select Day Type</option>
                                       <option>Holiday</option>
                                       <option>Exam</option>
                                  
                                    </select>
                                 </div>
                                 
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-4 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control form-control-datepicker-range" id=""  placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-4 control-label">Description</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="" placeholder="">
                                 </div>
                              </div>
                             
                                 
                                    
                                   
                                
                           
                           </form>
                           
                            
                            
                           </div>
                           <br/>
                           <div class="modal-footer">
                             <button  type="button" id="" class="btn btn-success">Save</button>
                                    
                           </div>
                        </div>
                     </div>
                  </div>
                  
                  <div class="modal fade" id="confirm_delete_academic_year_day" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to delete this Academic Year Day ??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
                            
                  
                  
                  
                 
               </div>
                <div class="modal fade" id="day_type" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Create New Day Type</h4>
                           </div>
                           <div class="modal-body">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Day Type Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="day_type_name" placeholder="">
                                 </div>
                              </div>
                           </div>
                           <br/>
                           <div class="modal-footer">
                              <button type="button"  id="save" class="btn btn-success">Save</button>
                           </div>
                        </div>
                     </div>
                  </div>
                   <div class="modal fade" id="edit_day_type" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Edit Day Type</h4>
                           </div>
                           <div class="modal-body">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Day Type Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" id="edit_day_type_name" placeholder="">
                                 </div>
                              </div>
                           </div>
                           <br/>
                           <div class="modal-footer">
                              <button type="button"  id="edit_save" class="btn btn-success">Save</button>
                           </div>
                        </div>
                     </div>
                  </div>
      
                  <div class="modal fade" id="confirm_delete_day_type" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to delete this Academic Year Day Type??</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/script/academicyear.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/academicyearcalendar.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/semestersystem.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/jspatch.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
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

