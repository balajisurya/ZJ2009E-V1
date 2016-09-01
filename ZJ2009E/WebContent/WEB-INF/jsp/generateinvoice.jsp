 <!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
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

      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
          
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery-ui-1.10.3.js"></script>
        
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
     
      <style>
      
      .loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('${pageContext.request.contextPath}/resources/themes/images/page-loader.gif') 50% 50% no-repeat rgba(255, 255, 255, 0.71);
}
      
      
      </style>
     
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 <div class="loader"  style="display: none"></div>
		<!-- main content start-->
		<div id="page-wrapper">
		  <h3 class="title1">Select to Create Invoices</h3>
		<div class="main-page">
		<div class="form-three widget-shadow">
		   <form class="form-horizontal" id="studentDetailsForm">
                                  <div class="form-group form-group-groupcriteria" style="display: block">
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="class" id="class" class="form-control1" required="required">
                                  <option value="" disabled selected>Select Class</option>
                                  
                                  <c:if test="${!empty classes}">
                                  		<option value="all">All</option>
                                       <c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group form-group-section" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="section" id="section" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Class</option>
                                   </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="criteria" id="criteria" class="form-control1" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                            	
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                              
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="specialCategoryId" id="specialCategoryId" class="form-control1" required="required">
                                  	<c:if test="${!empty specialCategories}">
                                  		 <option value="" disabled selected>Select Special Category</option>
                                      		 <c:forEach items="${specialCategories}" var="specialCategory">
                                      			 <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                            </c:forEach>
                                      </c:if>
                                    </select>
                                    
                                 </div>
                              </div>
                              </div>
                                <div class="form-group form-group-studentid" style="display:block">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
                                 </div>
                              </div>
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="submit"  id="getdetailsfromselectedcriteria" class="btn btn-success">Get Student List</button>
                                 <button style="float:right; margin-right: 20px " type="button" class="btn btn-danger" onclick="location.reload(true)">Back</button>
                                  
                                  </div>
                              </div>
            
               </form>
               </div>
               
                 <div id="invoicedetailsdiv" style="display:none;">
                 <br>
                
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                
                                 
     
                   		<h3 class="title1">Select Student(s) to Generate Invoice with Fees Structure and Due Date</h3>
                   		 
                    
                    
                    <form class="form-horizontal" id="applyfeestructureform">
                       <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="invoiceList">
                              <thead>
                                 <tr>
                                 <th> <input name="select_all" value="1" id="example-select-all" type="checkbox"/>
                                   </th>
                                    <th>Admission No</th>
                                  	<th>Student Name</th>
                                   	<th>Class</th>
                               		<th>Section</th>
                                 </tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                       <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                         <!--  <input id="selectedStudentIds" name="selectedStudentIds" type="hidden"> -->
             					 <div class="row">
                                 		<div class="col-sm-offset-3">
                                            <button style="float:right" type="button" id="createTermFees" class="btn btn-success">Next</button>
									   </div>
                              </div>
                        </form>  
                        
       </div>  
       
       
        <div id="termFeesSetup" style="display:none;">
                 <br>
        		<h3 class="title1">Select Fees Structure For All Terms</h3>
                   	 <form class="form-horizontal" id="applyTermFeesform" action="${pageContext.request.contextPath}/invoice/generate" method="post">
                       <div class="tables">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="feesTermsWithFeesStructure">
                              <thead>
                                 <tr>
                                    <th>Term Name</th>
                                  	<th>Fees Structure</th>
                                 </tr>
                               </thead>
                              	<tbody id="test">	
                              		<c:if test="${!empty academicFeesTerms}">
                                  	<c:forEach items="${academicFeesTerms}" var="academicFeesTerm">
                                  		<tr>
                                 			<td id="${academicFeesTerm.getAcademicYearFeesTermId()}">
                                                          ${academicFeesTerm.getFeesTermTitle()}
						                    </td>
                                  			<td>
                                  				 <select name="${academicFeesTerm.getFeesTermTitle()}" id="${academicFeesTerm.getAcademicYearFeesTermId()}" class="form-control1" required="required">
                                  				  <option value="" disabled selected>Select Fees Structure</option>
							                                  	<c:if test="${!empty feesTemplates}">
							                                  		
							                                      		<c:forEach items="${feesTemplates}" var="feesTemplate">
							                                      		 	<option value="${feesTemplate.getTemplateId()}">${feesTemplate.getTemplateName()}</option>
							                                      		 </c:forEach>
							                                          </c:if>
							                          </select>
                                					 
                                  			</td>
                                 		</tr>
                                     </c:forEach>
                              		 </c:if>
                              	</tbody>
                           </table>
                        </div>
                        </div>
	                       <div class="x_title">
	                     		<div class="clearfix">
	                     		</div>
	                	  </div>
                            <input id="selectedStudentIds" name="selectedStudentIds" type="hidden">
             					<div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="generateinvoice" class="btn btn-success">Generate Invoice</button>
								 </div>
                                </div>
                       </form>  
       			</div>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
</div>
         </div>
		</div>
		
	
		
	
	
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
<script src="${pageContext.request.contextPath}/resources/themes/script/generateinvoice.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
<script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>

</body>
</html>