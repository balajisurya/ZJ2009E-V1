$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	$("#getdetails").click(function(event){
		 $('#getDetailsForm').validate({
				 submitHandler: function(form) {
					var admissionNo= $("#admissionNo").val();
					document.getElementById('invoicedetailsdiv').style.display="block";
					  $.ajax(	
					    {
					        type: "GET",
					        url:ctx+'/invoice/studentInvoices' ,
					        data:{admissionNo:admissionNo},
					        contentType: "application/json; charset=utf-8",
					        dataType: "json",
					        cache: false,
					        success: function (data) {
					        	var datatable = $('#studentInvoicesTable').DataTable();
					        	 $(".form-horizontal").trigger('reset'); 
					        	  datatable.clear().draw();
									$.each(data, function (i, item) {
										var totalInvoiceAmount=0.0;
										var totalFineAmount=0.0;
										$.each(item.studentInvoiceDetails, function (j, studentInvoiceDetail) {
											totalInvoiceAmount+=studentInvoiceDetail.studentInvoiceElementTotalAmount;
										});
										$.each(item.studentInvoiceFineDetails, function (k, studentInvoiceFineDetail) {
											totalFineAmount+=studentInvoiceFineDetail.fineAmount;
										});
										
										datatable.row.add([item.invoiceNo,item.student.studentClass.className,totalInvoiceAmount,totalFineAmount,'<a href="#" id="feesitem"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="showFeesItemDiv('+item.studentInvoiceId+')" >'
				                                           +'<span class="glyphicon glyphicon-credit-card"></span>'
			                                                +'</a>']).draw( false );
								});
					      
					        }
					      
					    });
				 return false;   
			   }
				  
		  });	 
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
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('FormDiv').style.display="none";
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
			        	datatable.row('.even').remove().draw( false );  
			        	datatable.row('.odd').remove().draw( false );  
						if (!$.trim(data)){ 
							datatable.row('.even').remove().draw( false );  
							datatable.row('.odd').remove().draw( false );  
					 	}
						else
					 	{
							$.each(data, function (i, item) {
								i=i+1;
							   datatable.row.add([i,item.feesTemplateItem.templateItemName,item.studentInvoiceElementTotalAmount,'<input class="case" name="invoiceFeesItem" value='+item.studentInvoiceDetailId+' type="checkbox" />']).draw( false );
						   });
					}
					
			        }
			      
			    });
		
		$.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/invoice/studentInvoice/fineitems' ,
			        data:{studentInvoiceId:studentInvoiceId},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success: function (fineItems) {
			        	var datatable = $('#studentInvoiceFineItems').DataTable();
			        	 $(".form-horizontal").trigger('reset'); 
			        	datatable.row('.even').remove().draw( false );  
			        	datatable.row('.odd').remove().draw( false );  
			        	if (!$.trim(fineItems)){ 
							datatable.row('.even').remove().draw( false );  
							datatable.row('.odd').remove().draw( false );  
					 	}
						else
					 	{
							$.each(fineItems, function (j, fineItem) {
								j=j+1;
							   datatable.row.add([j,fineItem.fineName,fineItem.fineAmount,'<input class="case" name="invoiceFineItem" value='+fineItem.studentInvoiceFineDetaiId+' type="checkbox" />']).draw( false );
						   });
					}
					
			        }
			      
			    });
		
		
		/* $('#studentInvoiceFeesItems').change(function() {*/
			 	  $("#proceedForPayment").click(function(event){
			 		 var  feesitemidlists=[];
					  $.each($("[name=invoiceFeesItem]:checked"), function(){
						  feesitemidlists.push($(this).attr('value'));
					   });
					  
					  var fineItemList=[];
					  $.each($("[name=invoiceFineItem]:checked"), function(){
						  fineItemList.push($(this).attr('value'));
					   });
					  
						if(feesitemidlists.length>0 || fineItemList.length>0){
					    	var datatable = $('#finalPaymentDetailTable').DataTable();
				        	 $(".form-horizontal").trigger('reset'); 
				        	datatable.row('.even').remove().draw( false );  
				        	datatable.row('.odd').remove().draw( false );  
							/*if (!$.trim(feesItemJson) && $.trim(fineItemJson)){ 
								datatable.row('.even').remove().draw( false );  
								datatable.row('.odd').remove().draw( false );  
						 	}
							else
						 	{*/
								var serialNo=0;
								var amountToBePaid=0.0;
								if(feesitemidlists.length>0){
						    		$.ajax({
									        type: "GET",
									        url:ctx+'/invoice/studentInvoice/finalitemdetails' ,
									        data:{feesitemidlist:feesitemidlists},
									        contentType: "application/json; charset=utf-8",
									        dataType: "json",
									        async:false,
									        cache: false,
									        success: function (response) {
									        	$.each(response, function (i, feesitemRecord) {
									        		serialNo=serialNo+1;
									        		datatable.row.add([serialNo,feesitemRecord.feesTemplateItem.templateItemName,feesitemRecord.studentInvoiceElementTotalAmount]).draw( false );
									        		$("#hiddenPaidItems").append('<input type="hidden" value='+feesitemRecord.studentInvoiceDetailId+' name="paidItemId"/>');
											       amountToBePaid=amountToBePaid+feesitemRecord.studentInvoiceElementTotalAmount;
										      });
									        }
									    });
						    	}
						    	
								if(fineItemList.length>0){
						    		 $.ajax({
								        type: "GET",
								        url:ctx+'/invoice/studentInvoice/finalFineitemdetails' ,
								        data:{fineItemList:fineItemList},
								        contentType: "application/json; charset=utf-8",
								        dataType: "json",
								        async:false,
								        cache: false,
								        success: function (data) {
								        	$.each(data, function (i, fineitemRecord) {
								        		serialNo=serialNo+1;
								        		datatable.row.add([serialNo,fineitemRecord.fineName,fineitemRecord.fineAmount]).draw( false );
								        		$("#hiddenPaidFine").append('<input type="hidden" value='+fineitemRecord.studentInvoiceFineDetaiId+' name="paidFineId"/>');
										         amountToBePaid=amountToBePaid+fineitemRecord.fineAmount;
									      });
								        }
								    });
						    	}
								
				            /*}*/ //finish of  datatable else
					    			
					    	
					    	 $('#amount').val(amountToBePaid);
				    			$('#feesItemFormDiv').hide();
				    			$('#confirmedfeesItemFormDiv').show();
				    			$("#generateFCR").click(function(){
				    				if($("#paymentDetailsForm").valid()){
				    					$('#paymentDetailsForm').submit();
				    				}
				    				
				    			});
					    }else{
					    	alert("Please Select Atleast one");
					    }
			   
				  });
			/*}); */
		

	}
    
      
      
    