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
      
        
       
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      

    
     
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
        
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <script  src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
     
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-info col-md-3" onclick="showDiv()">Create New Facilities</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               
               
                <h3 class="title1">View And Edit Facilities</h3> 
                
                <div class="form-three widget-shadow">
                 <form class="form-horizontal" id="viewfacilityCategoryAndType" >
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Category</label> 
                                 <div class="col-sm-6">
                                     <select name="viewfacilityCategoryId" id="viewfacilityCategoryId" class="form-control1">
                                      <c:if test="${!empty facilityCategoryList}">
                                          <option value="" disabled selected>Select Facility Category </option>
                                          <c:forEach items="${facilityCategoryList}" var="facilityCategory">
                                             <option value="${facilityCategory.getFacilityCategoryId()}">${facilityCategory.getFacilityCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Type</label> 
                                 <div class="col-sm-6">
                                  <select name="viewfacilityTypeId" id="viewfacilityTypeId" class="form-control1">
                                      <option value="" disabled selected>No Facility Category Selected </option>
                                   </select>
                                 </div>
                              </div>
                           
                             
                  </form>
                  
                
                <div id="viewClassRoom" style="display:none;">
                 <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
                		<div class="tables">
                        <div class="table-responsive bs-example ">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Facility Type</th>
                                   	<th>Facility Name</th>
                               		<th>Facility No</th>
                                  	<th>Facility Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                               <c:if test="${!empty facilityClassRoomList}">
                                 
                                       <c:forEach items="${facilityClassRoomList}" var="facilityClassRoom">
                                          <tr id="facilityClassRoomlist">
                                          <td>Class Rooms</td>
                                             <td>${facilityClassRoom.getFacilityName()}</td>
                                             <td>${facilityClassRoom.getFacilityNo()}</td>
                                             <td>
                                               <c:if test="${facilityClassRoom.getFacilityStatus()==1}">Available</c:if> 
                                             <c:if test="${facilityClassRoom.getFacilityStatus()==3}">Out Of Service</c:if> 
					                         <c:if test="${facilityClassRoom.getFacilityStatus()==5}">Available For Exams</c:if> 
											 <c:if test="${facilityClassRoom.getFacilityStatus()==4}">Not Available For Exams</c:if>     
                                             </td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${facilityClassRoom.getFacilityClassRoomId()}" data-toggle="modal" >
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${facilityClassRoom.getFacilityClassRoomId()}" data-toggle="modal" data-target="#confirm-delete">
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
                 <div id="viewLaboratory" style="display:none;">
               
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
             		<div class="tables">
                        <div class="table-responsive bs-example ">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Facility Type</th>
                                   	<th>Facility Name</th>
                               		<th>Facility No</th>
                                  	<th>Facility Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                              <c:if test="${!empty facilityLaboratoryList}">
                                  	  	 
                                       <c:forEach items="${facilityLaboratoryList}" var="facilityLaboratory">
                                          <tr class="active" id="facilityLaboratorylist">
                                          <td>Laboratory</td>
                                             <td>${facilityLaboratory.getFacilityName()}</td>
                                             <td>${facilityLaboratory.getFacilityNo()}</td>
                                             <td>
                                                <c:if test="${facilityLaboratory.getFacilityStatus()==1}">Available</c:if> 
                                             <c:if test="${facilityLaboratory.getFacilityStatus()==2}">Not Available</c:if> 
					                         <c:if test="${facilityLaboratory.getFacilityStatus()==3}">Out Of Service</c:if>     
                                             </td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${facilityLaboratory.getFacilityLaboratoryId()}" data-toggle="modal" >
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${facilityLaboratory.getFacilityLaboratoryId()}" data-toggle="modal" data-target="#confirm-delete">
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
                  
                   <div id="viewTransport" style="display:none;">
              
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               		<div class="tables">
                        <div class="table-responsive bs-example ">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Facility Type</th>
                                   	<th>Facility Name</th>
                               		<th>Facility No</th>
                                  	<th>Facility Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                  <c:if test="${!empty facilityTransportList}">
          
                                       <c:forEach items="${facilityTransportList}" var="facilityTransport">
                                          <tr class="active" id="facilityTransportList">
                                          <td>Transport</td>
                                             <td>${facilityTransport.getFacilityName()}</td>
                                             <td>${facilityTransport.getFacilityNo()}</td>
                                             <td>
                                                <c:if test="${facilityTransport.getFacilityStatus()==1}">Available</c:if> 
                                             <c:if test="${facilityTransport.getFacilityStatus()==2}">Not Available</c:if> 
					                         <c:if test="${facilityTransport.getFacilityStatus()==3}">Out Of Service</c:if>     
                                             </td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${facilityTransport.getFacilityTransportId()}" data-toggle="modal" >
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${facilityTransport.getFacilityTransportId()}" data-toggle="modal" data-target="#confirm-delete">
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
                 
                  <div id="viewHostel" style="display:none;">
               
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
              		<div class="tables">
                        <div class="table-responsive bs-example">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Facility Type</th>
                                   	<th>Facility Name</th>
                               		<th>Facility No</th>
                                  	<th>Facility Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:if test="${!empty facilityHostelList}">
              
                                  	  	   
                                       <c:forEach items="${facilityHostelList}" var="facilityHostel">
                                          <tr class="active" id="facilityHostelList">
                                          <td>Hostel</td>
                                             <td>${facilityHostel.getFacilityHostelName()}</td>
                                             <td>${facilityHostel.getFacilityHostelNo()}</td>
                                             <td>
                                             <c:if test="${facilityHostel.getFacilityHostelRoomStatus()==1}">Available</c:if> 
                                             <c:if test="${facilityHostel.getFacilityHostelRoomStatus()==2}">Not Available</c:if> 
					                         <c:if test="${facilityHostel.getFacilityHostelRoomStatus()==3}">Out Of Service</c:if>     
                                             </td>
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${facilityHostel.getFacilityHostelId()}" data-toggle="modal" >
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${facilityHostel.getFacilityHostelId()}" data-toggle="modal" data-target="#confirm-delete">
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
                 
                   <div id="viewEquipment" style="display:none;">
              
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               
               		<div class="tables">
                        <div class="table-responsive bs-example">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                 <th>Facility Type</th>
                                   	<th>Facility Name</th>
                               		<th>Facility No</th>
                                  	<th>Facility Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:if test="${!empty facilityEquipmentList}">
                               <c:forEach items="${facilityEquipmentList}" var="facilityEquipment">
                                        
                                          <tr class="active" id="facilityEquipmentList">
                                         
                                          	<td>Equipment</td>
                                             <td>${facilityEquipment.getFacilityEquipmentName()}</td>
                                             <td>${facilityEquipment.getFacilityEquipmentNo()}</td>
                                             <td>
                                              <c:if test="${facilityEquipment.getFacilityStatus()==1}">Available</c:if> 
                                             <c:if test="${facilityEquipment.getFacilityStatus()==2}">Not Available</c:if> 
					                         <c:if test="${facilityEquipment.getFacilityStatus()==3}">Out Of Service</c:if>      
                                             <td>
                                                <a href="#" id="edit"  type="button" data-href="#" data-id="${facilityEquipment.getFacilityEquipmentId()}" data-toggle="modal" onclick="showeditDiv()">
                                    				<span class="glyphicon glyphicon-edit"></span> 
                                    			</a>
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${facilityEquipment.getFacilityEquipmentId()}" data-toggle="modal" data-target="#confirm-delete">
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
                 </div>
                   <br />
               <br />
                <br />
             </div>
           
            <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure to delete?</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmDelete"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
            
             <div class="modal fade" id="confirm-edit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure?</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmClassRoomEdit"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
        
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Facilities</h3>
                     <div class="form-three widget-shadow">
                
                    <form class="form-horizontal" id="facilityCategoryAndType" >
                      
                                 <div class="col-sm-offset-3">
                                <span style="float:right;margin-top:-15px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                <br>
                                </div>
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="facilityCategoryId" id="facilityCategoryId" class="form-control1">
                                      <c:if test="${!empty facilityCategoryList}">
                                          <option value="" disabled selected>Select Facility Category </option>
                                          <c:forEach items="${facilityCategoryList}" var="facilityCategory">
                                             <option value="${facilityCategory.getFacilityCategoryId()}">${facilityCategory.getFacilityCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                  <select name="facilityTypeId" id="facilityTypeId" class="form-control1">
                                      <option value="" disabled selected>No Facility Category Selected </option>
                                   </select>
                                 </div>
                              </div>
                             
                              </form>
                         <div id="classroom" style="display:none;">
                                      <br />
                    <div class="x_title">
                  <div class="clearfix">
                  </div>
                  
               </div>
               <br />
               <h4>Class Room</h4>   
                                 
                              
                                    
                                                       
                            
                             
                              <form class="form-horizontal" id="newclassRoomForm">
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="ClassRoomName" id="classRoomName" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="ClassRoomNo" id="classRoomNo" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Description<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="ClassRoomDescription" id="classRoomDescription" placeholder="" required="required">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats (Only Number)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="NoOfSeats" id="noOfSeats" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room Location<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="ClassRoomLocation" id="classRoomLocation" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="PersonResponsible" id="personResponsible" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Room Reference: Layout<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="ClassRoomReference1"  id="classRoomReference1" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Room Reference: List of Equipment<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="ClassRoomReference2" id="classRoomReference2" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Room Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="ClassRoomStatus" id="ClassRoomStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Available</option>
                                       <option value="4">Not Available for Exams</option>
                                       <option value="5">Available for Exams</option>
                                       <option value="3">Out of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="classRoomSave" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                    <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)"  >Cancel</button>
                                                          </div>
                              </div>
                              
                               </form>
                              
                                 <div class="modal fade" id="classRoomSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to add this ClassRoom ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="classRoomSaveConfirm" id="classRoomSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
                            
                             
                             </div>
                        
                              <div id="laboratory" style="display:none;">
                               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
                 
               </div>
               <br />
                              <h4>Laboratory</h4> 
                           
                                <form class="form-horizontal" id="newlaboratoryForm">
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="LaboratoryName" id="laboratoryName"  placeholder="" required="required">
                                 </div>
                              </div>
                                    
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="LaboratoryNo" id="laboratoryNo"  placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Description<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="LaboratoryDescription" id="laboratoryDescription" placeholder="" required="required">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats(Only Number)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="NoofSeats" id="noofseats" placeholder="" required="required"onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Location<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="LaboratoryLocation" id="laboratoryLocation" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="LaboratoryPersonResponsible" id="laboratoryPersonResponsible" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Reference: Layout<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="LaboratoryReference1" id="laboratoryReference1" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Reference: List of Equipment<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="LaboratoryReference2" id="laboratoryReference2" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="LaboratoryStatus" id="laboratoryStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Available</option>
                                       <option value="2">Not Available</option>
                                        <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                             
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="laboratorySave" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)"  >Cancel</button>
                                                          </div>
                              </div>
                              </form>
                              
                                  <div class="modal fade" id="laboratorySaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Laboratory ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="laboratorySaveConfirm" id="laboratorySaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                              
                              </div>
                               <div id="transport" style="display:none;">
                                <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               
               </div>
               <br />
                              <h4>Transport</h4>   
                              
                               <form class="form-horizontal" id="newtransportForm">
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportName" id="transportName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportNo" id="transportNo" placeholder="" required="required">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Vehicle Registration Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportRegistrationNumber" id="transportRegistrationNumber" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Vehicle Model<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportVehicleModel" id="transportVehicleModel" placeholder="" required="required">
                                 </div>
                              </div>
                                  
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                 	<input class="form-control" type="text" name="TransportItemGroup" id="transportItemGroup" placeholder="" required="required">	
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats(Number Only)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="NoOfSeats" id="noOfSeats" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Route Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportRouteName" id="transportRouteName" placeholder="" required="required">
                                 </div>
                              </div>
                                
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Vehicle Cost(Currency Format)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportVehicleCost" id="transportVehicleCost" placeholder="" required="required" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">License Renewal Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" name="TransportLicenseRenewalDate" id="transportLicenseRenewalDate" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Insurance Renewal Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control form-control-datepicker" name="TransportInsuranceRenewalDate" id="transportInsuranceRenewalDate" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Location<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportLocation" id="transportLocation" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportPersonResponsible" id="transportPersonResponsible" placeholder="" required="required">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference<span class="at-required-highlight">*</span></label> 
                                  <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="TransportTallyReference" id="transportTallyReference" placeholder="" required="required">
                                 </div>
                              </div>
                           
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="transportStatus" id="transportStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="transportSave" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                       <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)" >Cancel</button>
                                                          </div>
                              </div>
                              </form>
                              
                                  <div class="modal fade" id="transportSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Transport ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="transportSaveConfirm" id="transportSaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                              
                              
                              </div>
                  
                             
                              <div id="hostel" style="display:none;">
                                <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
                 
               </div>
               <br />
                                 <h4>Hostel</h4> 
                           
                               <form class="form-horizontal" id="newhostelForm">
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Hostel Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelName" id="hostelName" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Hostel No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelNo" id="hostelNo" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hostel Room No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelRoomNo" id="hostelRoomNo" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hostel Room Description<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelRoomDescription" id="hostelRoomDescription" placeholder="" required="required">
                                 </div>
                              </div>
                              
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats(Only Number)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="NoOfSeats" id="noOfSeats" placeholder="" required="required"onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Occupied Till Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  
                                    <input type="text" class="form-control form-control-datepicker" name="HostelOccupiedTillDate" placeholder="" required="required">
                                    
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Charge Per Day(Ex:2.5 day)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelChargePerDay" id="hostelChargePerDay" placeholder="" required="required"onkeypress="return isFloatNumber(this,event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="HostelFacilityPersonResponsible" id="hostelFacilityPersonResponsible" placeholder="" required="required">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference<span class="at-required-highlight">*</span></label> 
                                  <div class="col-sm-6"> 
                                    <input type="text" class="form-control"name="HostelTallyReference" id="hostelTallyReference" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Reference: Room Layout<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file"name="HostelReferenceLayout" id="hostelReferenceLayout" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Reference: Tariff<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="HostelReferenceTraiff" id="hostelReferenceTraiff" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="Hostelstatus" id="Hostelstatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="hostelSave" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                      <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)"  >Cancel</button>
                                                          </div>
                              </div>
                              </form>
                              
         <div class="modal fade" id="hostelSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Hostel ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="hostelSaveConfirm" id="hostelSaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                              </div>
                  
                        
                        
                        
                           <div id="equipment" style="display:none;">
                                <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
            
               </div>
               <br />
                                 <h4>Equipment</h4> 
                            <form class="form-horizontal" id="newequipmentForm">
                               
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Equipment (Model) Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentName" id="equipmentName" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentNo" id="equipmentNo" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Description<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentDescription" id="equipmentDescription" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Person Responsible<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentPersonResponsible" id="equipmentPersonResponsible" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Location<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentLocation" id="equipmentLocation" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentItemGroup" id="equipmentItemGroup" placeholder="" required="required">
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentTallyReference" id="equipmentTallyReference" placeholder="" required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Cost(Currency Format)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentCost" id="equipmentCost" placeholder="" required="required" onkeypress="return isFloatNumber(this,event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Quantity Available(Only Number)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EquipmentQuantityAvailable" id="equipmentQuantityAvailable" placeholder="" required="required"onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Maintenance Manual Reference<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EquipmentMaintenanceReference" id="equipmentMaintenanceReference" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Operation Manual Reference<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EquipmentOperationReference" id="equipmentOperationReference" required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="EquipmentStatus" id="EquipmentStatus" class="form-control1" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="equipmentSave" class="btn btn-success">Save</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    
                                      <button style="float: right" type="button" class="btn btn-danger" onclick="location.reload(true)" >Cancel</button>
                                                          </div>
                              </div>
                              </form>
                              
                                  <div class="modal fade" id="equipmentSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Equipment ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="equipmentSaveConfirm" id="equipmentSaveConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                              </div>
                   
       
                     </div>
                  </div>
               </div>
            </div>
            
            <div id="EditFormDivClassRoom" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View/Edit Facility</h3>
                     <div class="form-three widget-shadow">
                         
                           <form class="form-horizontal" id="updateClassRoomForm">
                 
               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditClassRoomName" id="editClassRoomName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditClassRoomNo" id="editClassRoomNo" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Description</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditClassRoomDescription" id="editClassRoomDescription" placeholder="">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditNoOfSeats" id="editNoOfSeats" placeholder="" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Room Location</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditClassRoomLocation" id="editClassRoomLocation" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditPersonResponsible" id="editPersonResponsible" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Room Reference: Layout</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditClassRoomReference1"  id="editClassRoomReference1"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Room Reference: List of Equipment</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditClassRoomReference2" id="editClassRoomReference2"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Update Status</label> 
                                 <div class="col-sm-6">
                                    <select name="EditClassRoomUpdateStatus" id="EditClassRoomUpdateStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Available</option>
                                       <option value="4">Not Available for Exams</option>
                                       <option value="5">Available for Exams</option>
                                       <option value="3">Out of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateClassRoom" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                              
                          
                           </form>  
                           
                             
           
       
                     </div>
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
										 <h5>Are you sure?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="updateConfirm" id="updateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>  
             <div id="EditFormDivTransport" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View/Edit Facility</h3>
                     <div class="form-three widget-shadow">
                         
                           <form class="form-horizontal" id="updateTransportForm">
                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportName" id="editTransportName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportNo" id="editTransportNo" placeholder="">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Vehicle Registration Number</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportRegistrationNumber" id="editTransportRegistrationNumber" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Vehicle Model</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportVehicleModel" id="editTransportVehicleModel" placeholder="">
                                 </div>
                              </div>
                                  
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group</label> 
                                 <div class="col-sm-6"> 
                                 	<input class="form-control" type="text" name="EditTransportItemGroup" id="editTransportItemGroup" placeholder="">	
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditNoOfSeats" id="editNoOfSeats" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Route Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportRouteName" id="editTransportRouteName" placeholder="">
                                 </div>
                              </div>
                                
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Vehicle Cost</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportVehicleCost" id="editTransportVehicleCost" placeholder="">
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">License Renewal Date</label> 
                                 <div class="col-sm-6"> 
 
                                    <input type="text" class="form-control form-control-datepicker" name="EditTransportLicenseRenewalDate" id="editTransportLicenseRenewalDate" placeholder="">

                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Insurance Renewal Date</label> 
                                 <div class="col-sm-6"> 
                                
                                    <input type="text" class="form-control form-control-datepicker" name="EditTransportInsuranceRenewalDate" id="editTransportInsuranceRenewalDate" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Transport Location</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportLocation" id="editTransportLocation" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportPersonResponsible" id="editTransportPersonResponsible" placeholder="">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference</label> 
                                  <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditTransportTallyReference" id="editTransportTallyReference" placeholder="">
                                 </div>
                              </div>
                           
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status</label> 
                                 <div class="col-sm-6">
                                    <select name="EditTransportStatus" id="EditTransportStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                              
                              
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateTransport" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                              
                          
                           </form>  
                           
                             
       
                     </div>
                  </div>
               </div>
            </div>
            
             <div id="EditFormDivLaboratory" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View/Edit Facility</h3>
                     <div class="form-three widget-shadow">
                         
                           <form class="form-horizontal" id="updateLaboratoryForm">
                 
               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditLaboratoryName" id="editlaboratoryName"  placeholder="">
                                 </div>
                              </div>
                                    
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditLaboratoryNo" id="editlaboratoryNo"  placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Description</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditLaboratoryDescription" id="editlaboratoryDescription" placeholder="">
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditNoofSeats" id="editnoofseats" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Location</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditLaboratoryLocation" id="editlaboratoryLocation" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditLaboratoryPersonResponsible" id="editlaboratoryPersonResponsible" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Reference: Layout</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditLaboratoryReference1" id="editlaboratoryReference1"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Lab Reference: List of Equipment</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditLaboratoryReference2" id="editlaboratoryReference2"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status</label> 
                                 <div class="col-sm-6">
                                    <select name="EditLaboratoryStatus" id="editlaboratoryStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Available</option>
                                       <option value="2">Not Available</option>
                                        <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                             
                           
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateLaboratory" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                              
                          
                           </form>  
                            
          
                     </div>
                  </div>
               </div>
            </div>
            
             <div id="EditFormDivHostel" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View/Edit Facility</h3>
                     <div class="form-three widget-shadow">
                         
                           <form class="form-horizontal" id="updateHostelForm">
                 
               
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Hostel Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelName" id="editHostelName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Hostel No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelNo" id="editHostelNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hostel Room No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelRoomNo" id="editHostelRoomNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hostel Room Description</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelRoomDescription" id="editHostelRoomDescription" placeholder="">
                                 </div>
                              </div>
                              
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No Of Seats</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditNoOfSeats" id="editNoOfSeats" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Occupied Till Date</label> 
                                 <div class="col-sm-6"> 
                                  
                                    <input type="text" class="form-control form-control-datepicker" name="EditHostelOccupiedTillDate" id="editHostelOccupiedTillDate" placeholder="">
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Charge Per Day</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelChargePerDay" id="editHostelChargePerDay" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Person Responsible</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditHostelFacilityPersonResponsible" id="editHostelFacilityPersonResponsible" placeholder="">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference</label> 
                                  <div class="col-sm-6"> 
                                    <input type="text" class="form-control"name="EditHostelTallyReference" id="editHostelTallyReference" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Reference: Room Layout</label> 
                                 <div class="col-sm-6">
                                          <input type="file"name="EditHostelReferenceLayout" id="editHostelReferenceLayout"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Reference: Tariff</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditHostelReferenceTraiff" id="editHostelReferenceTraiff"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status</label> 
                                 <div class="col-sm-6">
                                    <select name="EditHostelStatus" id="EditHostelStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateHostel" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                              
                          
                           </form>  
                           
       
                     </div>
                  </div>
               </div>
            </div>
            
             <div id="EditFormDivEquipment" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View/Edit Facility</h3>
                     <div class="form-three widget-shadow">
                         
                           <form class="form-horizontal" id="updateEquipmentForm">
                 
               	<div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Equipment (Model) Name</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentName" id="editEquipmentName" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment No</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentNo" id="editEquipmentNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Description </label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentDescription" id="editEquipmentDescription" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Person Responsible</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentPersonResponsible" id="editEquipmentPersonResponsible" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Equipment Location</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentLocation" id="editEquipmentLocation" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentItemGroup" id="editEquipmentItemGroup" placeholder="">
                                 </div>
                              </div>
                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentTallyReference" id="editEquipmentTallyReference" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Cost</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentCost" id="editEquipmentCost" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Quantity Available</label> 
                                 <div class="col-sm-6"> 
                                    <input type="text" class="form-control" name="EditEquipmentQuantityAvailable" id="editEquipmentQuantityAvailable" placeholder="">
                                 </div>
                              </div>
                              
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Maintenance Manual Reference</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditEquipmentMaintenanceReference" id="editEquipmentMaintenanceReference"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Operation Manual Reference</label> 
                                 <div class="col-sm-6">
                                          <input type="file" name="EditEquipmentOperationReference" id="editEquipmentOperationReference"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status</label> 
                                 <div class="col-sm-6">
                                    <select name="EditEquipmentStatus" id="EditEquipmentStatus" class="form-control1">
                                       <option value="" disabled selected>Select Status</option>
                                       
                                       <option value="2">Not Available</option>
                                       <option value="1">Available</option>
                                       <option value="3">Out Of Service</option>
                                    </select>
                                 </div>
                              </div>
                               <div class="row">
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateEquipment" style="float:right" class="btn btn-success" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger" type="button" onclick="location.reload(true)">Cancel</button>
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
       <script src="${pageContext.request.contextPath}/resources/themes/script/facilities.js"></script>
   
      
        <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script> 
       
 <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
           
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
     
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
   </body>
</html>