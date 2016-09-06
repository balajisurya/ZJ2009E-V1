<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
  <head>
  <title>Receipt</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" media="all" />
	
  </head>
 <body>

	 <c:if test="${!empty studentReceipt}">
	     <header class="clearfix">
				  <div id="logo">
			         <img src="${pageContext.request.contextPath}${logo}"></img>
			      </div>
      			   <h2 ><label style="margin-left:-120px">${studentReceipt.getInstitution().getInstitutionName()}</label></h2>
				   <h3 ><label style="margin-left:-120px">(Affiliated to the Central Board Of Secondary Education)</label></h3>
				   <h4 ><label style="margin-left:-120px">${studentReceipt.getInstitution().getInstitutionAddressline1().toLowerCase()}, <c:if test="${!empty studentReceipt.getInstitution().getInstitutionAddressline2()}">${studentReceipt.getInstitution().getInstitutionAddressline2().concat(",").toLowerCase()}</c:if>${studentReceipt.getInstitution().getInstitutionCity()} - ${studentReceipt.getInstitution().getInstitutionPostcode()}</label></h4>
			       <div id="company">
			         <div style="margin-top: -30px;margin-bottom: 4px;"> <span style="margin-left:-7px">RECEIPT NO&nbsp&nbsp:</span>${studentReceipt.getReceiptId()}<br></div>
					 <div style="margin-bottom: 0px;"><span style="margin-right:10px">DATE&nbsp&nbsp:</span>${studentReceipt.getCreatedDate()}</div>
					
			       </div>
	  				<br>	  
	  				<h1></h1>
				     <div id="project">
				        <div style="margin-bottom: 4px;"><span>NAME<label style="margin-left:80px;">:</label>  </span><label style="margin-left:0px;">${studentReceipt.getStudent().getFirstName()} ${studentReceipt.getStudent().getLastName()}</label></div>
				        <div style="margin-bottom: 4px;"><span>ADMISSION.NO <label style="margin-left:35px;">:</label></span><label style="margin-left:0px;">${studentReceipt.getStudent().getAdmissionNo()}</label></div>
				        
				        <div ><span>SPECIAL CATEGORY&nbsp&nbsp<label style="margin-left:7px;">:</label></span><label style="margin-left:0px;">${studentReceipt.getStudent().getSpecialCategory().getSpecialCategoryName()}</label></div>
				        </div>
				        <div id="company1">
			         <div style="margin-bottom: 4px;" ><span>CLASS & SECTION&nbsp&nbsp <label>:</label></span><label>&nbsp&nbsp${""}CLASS I & A </label></div>
					 <div style="margin-bottom: 4px;"><span>ACADEMIC YEAR&nbsp&nbsp:</span>&nbsp&nbsp${""}fsdfsdf</div>
					 <div ><span>TERM&nbsp&nbsp:</span>${""}fdfsfsfsfss</div>
			       </div>
			        
			        
           </header>
     		<main>
     		 <c:if test="${!empty studentReceipt.getPaymentMode()}">
	     		 <table>
				        <thead style="border-top:2px solid red;border-bottom:2px solid red;border-left:2px solid red;border-right:2px solid red; background:yellow">
				          <tr>
				            <th class="service">Payment Mode</th>
				            <th class="deschead" style="width:300px">DD/Cheque No</th>
							<th class="deschead" >Bank Name</th>
							<th class="deschead" >Bank Branch</th>
				          </tr>
				        </thead>
						<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==1}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">-</td>
								<td class="service">-</td>
					            <td class="service">-</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==2}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">${studentReceipt.getChequeNumber()}</td>
								<td class="service">${studentReceipt.getChequeBankName()}</td>
					            <td class="service">${studentReceipt.getChequeBranchName()}</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==3}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">${studentReceipt.getDdNumber()}</td>
								<td class="service">${studentReceipt.getDdBankName()}</td>
					            <td class="service">${studentReceipt.getDdBranchName()}</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==4}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">-</td>
								<td class="service">-</td>
					            <td class="service">-</td>
					          </tr>
							</c:if>
				         </tbody>
	     			 </table>
     		 </c:if>
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
        			 <c:if test="${!empty studentReceipt.getReceiptDetails()}">
                     		<c:forEach items="${studentReceipt.getReceiptDetails()}" var="receiptDetail">
                     			<tr>
						            <td class="service">${serialNumber}</td>
						            <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
						            <td class="desc">${receiptDetail.getStudentInvoiceDetail().getFeesTemplateItem().getTemplateItemName()}</td>
						            <td class="total">${receiptDetail.getStudentInvoiceDetail().getStudentInvoiceElementTotalAmount()}</td>
						            <c:set var="grandTotal"  value="${grandTotal+receiptDetail.getStudentInvoiceDetail().getStudentInvoiceElementTotalAmount()}"/>
						        </tr>
                            </c:forEach>
                      </c:if>
                       <c:if test="${!empty studentReceipt.getReceiptFines()}">
                     		<c:forEach items="${studentReceipt.getReceiptFines()}" var="receiptFine">
                     			<tr>
						            <td class="service">${serialNumber}</td>
						            <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
						            <td class="desc">${receiptFine.getFineTitle()}</td>
						            <td class="total">${receiptFine.getFineAmount()}</td>
						            <c:set var="grandTotal"  value="${grandTotal+receiptFine.getFineAmount()}"/>
			          			</tr>
                            </c:forEach>
                      </c:if>
			          <!-- <tr>
			            <td colspan="2">SUBTOTAL</td>
			            <td class="total">300.00</td>
			          </tr> -->
			         
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
		
      <div id="notices">
        <div>NOTE:</div>
        <div class="notice">Receipt  is subject to realization of the payment made.</div>
        
      </div>
    </main>
    
  </body>
</html>