<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <% int timeout = session.getMaxInactiveInterval();response.setHeader("Refresh", timeout + "; URL =");%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <!-- Bootstrap Core CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/bootstrap.css" rel='stylesheet' type='text/css' />
      <!-- Custom CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/style.css" rel='stylesheet' type='text/css' />
      <!-- font CSS -->
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/cdntolocal/css/smoothness-jquery-ui.css" />
      <!-- font-awesome icons -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
      <!-- //font-awesome icons -->
      <!-- js-->
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <!--webfonts-->
      <link href='${pageContext.request.contextPath}/resources/cdntolocal/css/fonts-googleapis.css' rel='stylesheet' type='text/css'>
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
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
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
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <div class="col-md-4 col-sm-4 col-xs-12"> 
                     <button type="button" class="btn btn-success col-md-8 col-xs-12" onclick="showClassAndSectionDiv()">Add New Class And Section</button>
                  </div>
               </div>
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <h3 class="title1">Classes</h3>
               <div class="tables">
                  <div class="table-responsive bs-example widget-shadow">
                     <table class="table table-bordered">
                        <thead>
                           <tr>
                              <th>Class Name</th>
                              <th>No of Sections</th>
                              <th>Action</th>
                           </tr>
                        </thead>
                        <tbody id="classList">
                           <c:if test="${!empty classList}">
                              <c:forEach items="${classList}" var="clazz">
                                 <tr>
                                    <td>${clazz.getClassName()}</td>
                                    <td>${clazz.getSections().size()}</td>
                                    <td>
                                       <a href="#" id="edit"  type="button"data-href="#" data-id="${clazz.getClassId()}" data-toggle="modal"onclick="showeditclassandsectionDiv()">
                                       <span class="glyphicon glyphicon-edit"></span> 
                                       </a>
                                       <a href="#"  id="delete"  type="button" data-href="#"  data-id="${clazz.getClassId()}" data-toggle="modal" data-target="#confirm_delete_class">
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
               <br>
               <br>
               <h3 class="title1">Sections</h3>
               <div class="tables">
                  <div class="table-responsive bs-example widget-shadow">
                     <table class="table table-bordered">
                        <thead>
                           <tr>
                              <th>Section Name</th>
                              <th>Action</th>
                           </tr>
                        </thead>
                        <tbody id="sectionList">
                           <c:if test="${!empty sectionList}">
                              <c:forEach items="${sectionList}" var="section">
                                 <tr>
                                    <td>${section.getSectionName()}</td>
                                    <td><a href="#" id="edit"  type="button"data-href="#" data-id="${section.getSectionId()}" onclick="showeditsectionDiv()"data-toggle="modal">
                                       <span class="glyphicon glyphicon-edit"></span> 
                                       </a>
                                       <a href="#"  id="delete"  type="button" data-href="#"  data-id="${section.getSectionId()}" data-toggle="modal" data-target="#confirm_delete_class_section">
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
            <div class="modal fade" id="confirm_delete_class" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this class ??</h5>
                     </div>
                     <div class="modal-footer">
                        <form id="deleteClassForm" action="${pageContext.request.contextPath}/class/delete" method="post">
                           <input type="hidden" id="deleteClassId" name="deleteClassId">
                           <button type="button" id="confirmDeleteClass"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="confirm_delete_class_section" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this section ??</h5>
                     </div>
                     <div class="modal-footer">
                        <form id="deleteSectionForm" action="${pageContext.request.contextPath}/class/section/delete" method="post">
                           <input type="hidden" id="deleteSectionId" name="deleteSectionId">
                           <button type="button" id="deleteSectionConfirm"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div id="classAndSectionDiv" style="display:none;">
               <div class="forms" id="error">
                  <div class="row">
                     <h3 class="title1">Create Section and Class</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/class/add" method="post" id="createclassform">
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Class Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="className" class="form-control" id="className" required="required" maxlength="50">
                                 <span id="errorclassName" class="error"></span>
                              </div>
                              <div class="col-md-3 col-sm-3 col-xs-12"> 
                                 <button  style="float:right" id="addsection"  type="button" class="btn btn-success"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp; Add New Section</button>
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Section Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6">
                                 <select name="sections" id="sections" class="select2_multiple form-control" multiple="multiple" required="required" style="width: 585px">
                                    <c:if test="${!empty sectionList}">
                                       <c:forEach items="${sectionList}" var="section">
                                          <option id="test" value="${section.getSectionId()}">${section.getSectionName()}</option>
                                       </c:forEach>
                                    </c:if>
                                 </select>
                                 <span id="errorsections" class="error"></span>
                              </div>
                           </div>
                           <div class="row">
                              <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              <div class="col-sm-offset-3">
                                 <button style="float:right"  type="button" id="classandsectionsavebutton" class="btn btn-success">Save</button>
                                 <button style="float:right" type="reset" id="reset" class="btn btn-info">Clear</button>
                                 <button style="float:right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                              </div>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="classAndSectionAddingConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this class ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="confirmAddClass" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="sectionAddingConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this section ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="confirmAddSection" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addSectionPopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <form action="${pageContext.request.contextPath}/class/section/add" id="classandsectionsettingform" method="post">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Create New Section</h4>
                        </div>
                        <div class="modal-body">
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Section Name</label> 
                              <div class="col-sm-6"> 
                                 <input type="text" class="form-control" id="sectionName" name="sectionName" placeholder="" required="required" maxlength="50">
                              </div>
                           </div>
                        </div>
                        <br/>
                        <div class="modal-footer">
                           <button id="createnewsection" type="submit" class="btn btn-primary">Save</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
            <div class="modal fade" id="update_Class_Section_Confirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>     Are you sure you want to update Class?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" name="saveConfirm" id="saveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="update_Section_Confirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>    Are you sure you want to update section?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" name="updateSectionConfirm" id="updateSectionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="EditClassFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Class</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updateClassAndSectionForm" action="${pageContext.request.contextPath}/class/editUpdate" method="post">
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Class Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="editClassName" class="form-control" id="editClassName" required="required" maxlength="50">
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Section Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6">
                                 <select name="editSections" id="editSections" class="select2_multiple form-control" multiple="multiple" required="required" style="width: 585px">
                                    <c:if test="${!empty sectionList}">
                                       <c:forEach items="${sectionList}" var="section">
                                          <option  value="${section.getSectionId()}">${section.getSectionName()}</option>
                                       </c:forEach>
                                    </c:if>
                                 </select>
                              </div>
                           </div>
                           <input type="hidden" id="updateClassId" name="updateClassId">
                           <div class="row">
                              <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              <div class="col-sm-offset-3">
                                 <a href="#" id="updateClassAndSection" style="float:right"  class="btn btn-success" type="submit" data-id="" >
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
            <div id="EditSectionFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Section</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="updateSectionForm" action="${pageContext.request.contextPath}/class/section/editUpdate" method="post" >
                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Section Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" class="form-control" id="editSectionName" name="editSectionName" placeholder="" required="required" maxlength="50">
                              </div>
                           </div>
                           <input type="hidden" id="updateSectionId" name="updateSectionId">
                           <div class="row">
                              <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              <div class="col-sm-offset-3">
                                 <a href="#" id="updateSection" style="float:right" class="btn btn-success" type="submit" data-id="" >
                                 Update
                                 </a>     
                                 <button style="float:right" type="reset"  class="btn btn-info">Clear</button>
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
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/classandsection.js" type="text/javascript"></script>     
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/resetselect.js"></script> 
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
   </body>
</html>