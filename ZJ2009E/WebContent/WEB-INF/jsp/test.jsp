

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
                     <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Special Category</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <h3 class="title1">Special Category</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                        <table class="table table-bordered" id="table">
                           <thead style="background-color:#673AB7;color:#ffffff;">
                              <tr>
                                 <th>Special Category</th>
                                 <th>Action</th>
                              </tr>
                           </thead>
                           <tbody id="specialCategorylist">
                              <c:if test="${!empty feesstructureitemlist}">
                                 <c:forEach items="${feesstructureitemlist}" var="feesstructureitem">
                                    <tr >
                                       <td>${feesstructureitem.getTemplateItemName()}</td>
                                       <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="${feesstructureitem.getTemplateItemId()}" data-toggle="modal" onclick="showeditDiv()">
                                          <span class="glyphicon glyphicon-edit"></span> 
                                          </a>
                                          <a href="#" class="test" id="delete"  type="button" data-href="#"  data-id="${feesstructureitem.getTemplateItemId()}" data-toggle="modal" data-target="#deleteSpecialCategoryConfirmation">
                                          <span class="glyphicon glyphicon-trash"></span> 
                                          </a>
                                       </td>
                                    </tr>
                                 </c:forEach>
                              </c:if>
                           </tbody>
                        </table>
                        <div class="modal fade" id="deleteSpecialCategoryConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure ?, You want to delete this Special Category ??</h5>
                                 </div>
                                 <div class="modal-footer">
                                    <a href="" id="confirmDeleteSpecialCategory"  class="btn btn-primary" type="button">Yes
                                    </a>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
                <div class="modal fade" id="specialCategoryUpdateonfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update special category ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="specialCategoryUpdateConfirm" id="specialCategoryUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
               <div id="FormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Create New Special Category</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="templateitemform" action="${pageContext.request.contextPath}/specialCategory/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Special Category Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="specialCategoryName" class="form-control" id="specialCategoryName" placeholder="" required>
                                 </div>
                              </div>
                              <div class="row">
                                                             <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="specialCategorySave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  <div class="modal fade" id="specialCategorySaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure ?, You want to add this Special Category??</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="specialCategorySaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="EditFormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Edit Special Category</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="updateTemplateItemForm">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Special Category Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editSpecialCategoryName" class="form-control" id="editSpecialCategoryName" placeholder="" required>
                                 </div>
                              </div>
                             
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                     <a href="#" id="updateSpecialCategory" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>   
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                     <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload()">Cancel</button>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/specialCategory.js" type="text/javascript"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
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

