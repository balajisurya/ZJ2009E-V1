

<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <% int timeout = session.getMaxInactiveInterval();response.setHeader("Refresh", timeout + "; URL =");%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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
                  <div class="form-group">
                     <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Add New Ledger Account</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  <h3 class="title1">Ledger Accounts</h3>
                  <div class="tables">
                     <div class="table-responsive bs-example widget-shadow">
                        <table class="table table-bordered" id="table">
                           <thead style="background-color:#673AB7;color:#ffffff;">
                              <tr>
                                 <th>Ledger Account Name</th>
                                 <th>Account Reference</th>
                                 <th>Action</th>
                              </tr>
                           </thead>
                           <tbody id="ledgerAccountList">
                              <c:if test="${!empty institutionAccountsList}">
                                 <c:forEach items="${institutionAccountsList}" var="institutionAccount">
                                    <tr >
                                       <td>${institutionAccount.getLedgerAccountName()}</td>
                                       <td>${institutionAccount.getLedgerReferenceNo()}</td>
                                       <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="${institutionAccount.getLedgerAccountId()}" data-toggle="modal" onclick="showeditDiv()">
                                          <span class="glyphicon glyphicon-edit"></span> 
                                          </a>
                                          <a href="#" class="test" id="delete"  type="button" data-href="#"  data-id="${institutionAccount.getLedgerAccountId()}" data-toggle="modal" data-target="#confirm-delete">
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
               <div class="modal fade" id="updateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to update ledger account ?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" name="updateConfirm" id="updateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure ?, You want to delete this Ledger??</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deleteLedgerForm" action="${pageContext.request.contextPath}/institution/ledgerAccount/delete" method="post">
                              <input type="hidden" id="deleteLedgerId" name="deleteLedgerId">
                              <button type="button" id="confirmDeleteLedger"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="FormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Create New Ledger Account</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="ledgerAccountform" action="${pageContext.request.contextPath}/institution/ledgerAccount/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Ledger Account Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="ledgerAccountName" class="form-control" id="ledgerAccountName" placeholder="" required maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Ledger Account Reference <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="ledgerAccountReferenceNo" class="form-control" id="ledgerAccountReferenceNo" placeholder="" required maxlength="100" >
                                 </div>
                              </div>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="ledgerAccountSave" class="btn btn-success">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
                  <div class="modal fade" id="ledgerAccountSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure ?, You want to create new ledger account ??</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="ledgerAccountSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="EditFormDiv" style="display:none;">
                  <div class="forms">
                     <div class="row">
                        <h3 class="title1">Edit Ledger Account</h3>
                        <div class="form-three widget-shadow">
                           <form class="form-horizontal" id="updateLedgerAccountForm" action="${pageContext.request.contextPath}/institution/ledgerAccount/editUpdate" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Ledger Account Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editLedgerAccountName" class="form-control" id="editLedgerAccountName" placeholder="" required maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Ledger Account Reference <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" name="editLedgerAccountReferenceNo" class="form-control" id="editLedgerAccountReferenceNo" placeholder="" required maxlength="100">
                                 </div>
                              </div>
                              <input type="hidden" id="updateLedgerId" name="updateLedgerId">
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateLedgerAccount" style="float:right" class="btn btn-success" type="submit" data-id=""  >
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/institutionLedgerAccount.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
   </body>
</html>

