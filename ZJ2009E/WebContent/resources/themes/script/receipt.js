$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	var datatable;
	$("#getdetails").click(function(event){
		 $('#getDetailsForm').validate({
				 submitHandler: function(form) {
					var admissionNo= $("#admissionNo").val();
					  $.ajax(	
					    {
					        type: "GET",
					        url:ctx+'/invoice/studentInvoices',
					        data:{admissionNo:admissionNo},
					        contentType: "application/json; charset=utf-8",
					        dataType: "json",
					        cache: false,
					        success: function (data) {
					        	if(data.length>0){
					        		datatable= $('#studentReceiptListTable').DataTable();
						        	 $(".form-horizontal").trigger('reset'); 
						        	  datatable.clear().draw();
										$.each(data, function (i, item) {
											if(i==0){
												
												var studentClassName=item.student.studentClass.className;
												var studentSection=item.student.section.sectionName;
												var studentName=null;
												if(item.student.lastName!=null){
													studentName=item.student.firstName+' '+item.student.lastName;
												}
												else{
													studentName=item.student.firstName;
													
													
												}
												
												$("#displayStudentName").text(studentName);
												$("#displayClassName").text(studentClassName);
												$("#displaySectionName").text(studentSection);
												
												
											}
											var totalInvoiceAmount=0.0;
											$.each(item.studentInvoiceDetails, function (j, studentInvoiceDetail) {
												totalInvoiceAmount+=studentInvoiceDetail.studentInvoiceElementTotalAmount;
											});
											
											datatable.row.add(['<input type="checkbox" unchecked name="studentInvoice" value='+item.studentInvoiceId+' class="case"></input>',item.academicYear.academicYearTitle,item.academicYearFeesTerm.feesTermTitle,totalInvoiceAmount,'<a href="#" id="feesitem"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="showFeesItemDiv('+item.studentInvoiceId+')" >'
					                                           +'<span class="glyphicon glyphicon-list-alt"></span>'
				                                                +'</a>']).draw( false );
									});
										document.getElementById('invoicedetailsdiv').style.display="block";
										document.getElementById('FormDiv').style.display="none";
					        	}
					        	
					        	else{
					        		alert("No Receipts Found");
					        	}
					        
					      
					        }
					      
					    });
				 return false;   
			   }
				  
		  });	 
	});
	
	
	 $("#proceedForPayment").click(function(event){
		 var  invoiceForPayment=[];
			var rowcollection =  datatable.$(".case:checked", {"page": "all"});
			rowcollection.each(function(index,elem){
				invoiceForPayment.push($(elem).val());
			 });
			
			if(invoiceForPayment.length>0){
				 $.post(ctx+'/invoice/invoiceValidation',{invoiceForPayment:invoiceForPayment},function(response){
					 if(response==false){
						 alert('Please Pay Lower Term Fees First');
					 }
					 else if(response==true){
						 if(invoiceForPayment.length>0){
							 var datatable = $('#finalPaymentDetailTable').DataTable();
					           $(".form-horizontal").trigger('reset'); 
					        	
									var serialNo=0;
									var amountToBePaid=0.0;
									if(invoiceForPayment.length>0){
										$.get(ctx+'/invoice/studentInvoice/finalStudentInvoices',{invoiceForPayment:invoiceForPayment},function(response){
											$.each(response, function (i, finalStudentInvoices) {
								        		serialNo=serialNo+1;
								        		datatable.row.add([serialNo,finalStudentInvoices.academicYear.academicYearTitle,finalStudentInvoices.academicYearFeesTerm.feesTermTitle,finalStudentInvoices.invoiceAmount]).draw( false );
								        		$("#hiddenPaidInvoices").append('<input type="hidden" value='+finalStudentInvoices.studentInvoiceId+' name="paidInvoiceId"/>');
										       amountToBePaid=amountToBePaid+finalStudentInvoices.invoiceAmount;
									      });
											 $('#amount').val(amountToBePaid);
										});
							    	 }
							    	
								
						    	
					    			$('#invoicedetailsdiv').hide();
					    			$('#confirmedInvoiceFormDiv').show();
					    			$("#generateFCR").click(function(){
					    				if($("#paymentDetailsForm").valid()){
					    					$('#paymentDetailsForm').submit();
					    				}
					    				
					    			});
						    
							 
						 }else{
							 alert('Select atleast one term to proceed');
						 }
						 
						 
						 /*$.post(ctx+'/invoice/invoiceValidation',{invoiceForPayment:invoiceForPayment},function(response){
							 
						 }); */
					 }
		  		 })
			}
			else{
				alert('Select atleast one term to proceed');
			}
	 });
	 
	 
	 
	
	
	 $("#savepaymentdetails").click(function(event){
		 
		if($("#feesDetails").valid())
			{
			
			alert("valid");
			}
			 
		//submit to data then load the print page using printpage method
		 //
			
		
    	 });
	 
	
	        
	
	 $("#paymentMode").change(function() {
		 
		    var val = $(this).val();
		    if(val ==="1") {
		       $(".form-group-dd").hide();
		        $(".form-group-cheque").hide();
		        $(".form-group-dd-input").prop('required',false);
		        $(".form-group-cheque-input").prop('required',false);
		       }
		    else if(val ==="2") {
		    	    $(".form-group-dd").hide();
		    	    $(".form-group-dd-input").prop('required',false);
			        $(".form-group-cheque").show();
			        $(".form-group-cheque-input").prop('required',true);
		       }
		   
		    
		    else if(val ==="3") {
		    	 //$(".form-group-cheque-dd").show();
		    	 $(".form-group-dd-input").prop('required',true);
		    	 $(".form-group-dd").show();
			     $(".form-group-cheque").hide();
			     $(".form-group-cheque-input").prop('required',false);
		     }
		    
		  });

});

function showFeesItemDiv(invoiceId){
	
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	if(document.getElementById('feesItemFormDiv').style.display=="none"){
	document.getElementById('feesItemFormDiv').style.display="block";
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";

	}
	
	
	var studentInvoiceId=invoiceId;
		$.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/invoice/studentInvoice/itemdetails' ,
			        data:{studentInvoiceId:studentInvoiceId},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success: function (data) {
			        	
			          	var datatable = $('#studentInvoiceFeesItems').DataTable();
			        	 $(".form-horizontal").trigger('reset'); 
			        	 datatable.clear().draw();
						
							$.each(data, function (i, item) {
								i=i+1;
							   datatable.row.add([i,item.feesTemplateItem.templateItemName,item.studentInvoiceElementTotalAmount]).draw( false );
						   });
					
					
			        }
			      
			    });
}
function showStudentFeesDiv(){
	
	
	if(document.getElementById('feesItemFormDiv').style.display=="block"){
	document.getElementById('feesItemFormDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="block";
	

	}
}  
      
    