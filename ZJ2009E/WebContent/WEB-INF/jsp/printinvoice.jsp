<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
  <head>
  <title>Invoice</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" media="all" />
        <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    
	
  </head>
 <body>

	 <c:if test="${!empty studentInvoice}">
	     <header class="clearfix">
				  <div id="logo">
				  <img src="${pageContext.request.contextPath}${logo}"></img>
			      </div>
      			   <h2 ><label style="margin-left:-120px">${studentInvoice.getInstitution().getInstitutionName()}</label></h2>
				   <h3 ><label style="margin-left:-120px">(Affiliated to the Central Board Of Secondary Education)</label></h3>
				   <h4 ><label style="margin-left:-120px">${studentInvoice.getInstitution().getInstitutionAddressline1().toLowerCase()}, <c:if test="${!empty studentInvoice.getInstitution().getInstitutionAddressline2()}">${studentInvoice.getInstitution().getInstitutionAddressline2().concat(",").toLowerCase()}</c:if>${studentInvoice.getInstitution().getInstitutionCity()} - ${studentInvoice.getInstitution().getInstitutionPostcode()}</label></h4>
			       <div id="company">
			         <div style="margin-top: -30px;margin-bottom: 4px;"> <span style="margin-left:-7px">INVOICE NO&nbsp&nbsp:</span>${studentInvoice.getInvoiceNo()}<br></div>
					 <div style="margin-bottom: 0px;"><span style="margin-right:15px">DATE&nbsp&nbsp:</span>${studentInvoice.getCreatedDate()}</div>
					
			       </div>
	  				<br>	  
	  				<h1></h1>
				     <div id="project">
				        <div style="margin-bottom: 4px;"><span>NAME<label style="margin-left:80px;">:</label>  </span><label style="margin-left:0px;">${studentInvoice.getStudent().getFirstName()} ${studentInvoice.getStudent().getLastName()}</label></div>
				        <div style="margin-bottom: 4px;"><span>ADMISSION.NO <label style="margin-left:35px;">:</label></span><label style="margin-left:0px;">${studentInvoice.getStudent().getAdmissionNo()}</label></div>
				        <div ><span>SPECIAL CATEGORY&nbsp&nbsp <label style="margin-left:5px;">:</label></span><label style="margin-left:0px;">${studentInvoice.getStudent().getSpecialCategory().getSpecialCategoryName()}</label></div>
				    
				    </div>
				    <div id="company1">
			         <div style="margin-bottom: 4px;"><span>ACADEMIC YEAR&nbsp&nbsp:</span>&nbsp&nbsp${studentInvoice.getAcademicYear().getAcademicYearTitle()}</div>
					 <div><span>TERM&nbsp&nbsp:</span>&nbsp&nbsp${studentInvoice.getAcademicYearFeesTerm().getFeesTermTitle()}</div>
			       </div>
				    
           </header>
     		<main>
  
     		  <table>
        		<thead style="border-top:2px solid red;border-bottom:2px solid red;border-left:2px solid red;border-right:2px solid red; background:yellow">
			          <tr>
			            <th class="service">SERIAL NO</th>
			            <th class="deschead" style="width:500px">FEE DESCRIPTION</th>
			             <th>AMOUNT IN RUPEES</th>
			          </tr>
         		</thead>
        		<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
        		   <c:set var="grandTotal"  scope="page" value="0.0"/>
        		   <c:set var="serialNumber" scope="page"  value="1"/>
        			 <c:if test="${!empty studentInvoice.getStudentInvoiceDetails()}">
                     		<c:forEach items="${studentInvoice.getStudentInvoiceDetails()}" var="studentInvoiceDetail">
                     			<tr>
						            <td class="service">${serialNumber}</td>
						            <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
						            <td class="desc">${studentInvoiceDetail.getFeesTemplateItem().getTemplateItemName()}</td>
						            <td class="total">${studentInvoiceDetail.getStudentInvoiceElementTotalAmount()}</td>
						            <c:set var="grandTotal"  value="${grandTotal+studentInvoiceDetail.getStudentInvoiceElementTotalAmount()}"/>
						        </tr>
                            </c:forEach>
                      </c:if>
                      <tr>
			            <td colspan="2" class="grand total">GRAND TOTAL</td>
			            <td class="grand total">${grandTotal}</td>
			           </tr>
					    <tr>
						<td  colspan="2" style="text-align:left;height:50px">Amount In Words:&nbsp&nbsp<label>${numberConverter.convert(grandTotal).toUpperCase()} RUPEES ONLY</label></td>
			            <td  style=" text-align:center;height:80px">Cashier Signature</td>
			           </tr>
        			</tbody>
				</table>
     		</c:if>
        <br>
		<br>
		
      
    </main>
    
  </body>
</html>