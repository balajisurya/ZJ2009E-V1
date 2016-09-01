$(document).ready(function() {
        	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
		
	
	 $("#invoiceId").change(function(event) {
		  var invoiceid = $("#invoiceId").val();
	 	        $.get(ctx+'/student/getFeesDetails', {
	 	                invoiceId : invoiceid
	 	        }, function(response) 
	 	        {
	 	        	
	 	        	var amount=null;
					$.each(response.studentInvoiceDetails, function(key,value) 
					{ 
						
					 amount+=value.studentInvoiceElementAmount;
					});
					
	 	        	$("[name=studentId]").val(response.student.studentId);
					$("[name=instituteId]").val(response.student.institution.institutionId);
					$("[name=amount1]").val(amount);
					
					
				
	 	        });
	 	       
	 	 });
       
	 
	 
	 $("#saveRecord").click(function(event){
		 
		 $("#feesDetails").validate();
		 if($("#feesDetails").valid())
			 {
			  $('#SaveConfirmation').modal('show');	
		   	  $('#SaveConfirm').click(function(){
		   	  $("#feesDetails").submit();
		   		   	 });
			 }
		 return false;
   	
   	  	 });
	 
	 
	  $('#FeesCollectionRecordList td a#edit').click(function() {
		  var feesCollectionRecordId = $(this).attr('data-id');
		  if(document.getElementById('EditFormDiv').style.display=="none")
			{
			document.getElementById('EditFormDiv').style.display="block";
			document.getElementById('ListDiv').style.display="none";
			
     	        $.get(ctx+'/student/editFeesDetails', {
     	        	feesCollectionRecordId : feesCollectionRecordId
     	        }, function(response) {     
     	        	$("[name=editInvoiceId]").val(response.invoice.studentInvoiceId);
					$("[name=editStudentId]").val(response.student.studentId);
					$("[name=editInstituteId]").val(response.institution.institutionId);
					$("[name=editAmount]").val(response.amount);
					$("[name=editPaymentMode]").find('option[value='+response.paymentMode+']').attr('selected','selected');
					$("[name=editPayableAt]").val(response.payableAt);
					
					var paymode=response.paymentMode;
					if(paymode=="Cash")
					{
						
						  $(".form-group-cheque-dd").hide();
					      $(".form-group-cheque-dd-eft").hide();
					      $(".form-group-eft").hide();
					      $(".form-group-eft-cash").show();
					      
						$("[name=editDateOFEFTOrCash]").val($.datepicker.formatDate('mm/dd/yy', new Date(response.bankEFTDate)));
						
						$("[name=editTallyGLAccount]").val(response.tallyGLAccount);
						$("[name=editRemarks]").val(response.remarks);
						$('#updateRecord').attr('data-id',response.feesCollectionRecordId);
						
						
						
					}
					else if(paymode=="Cheque"||paymode=="DD")
					{
						$(".form-group-cheque-dd").show();
				    	 $(".form-group-cheque-dd-eft").show();
					     $(".form-group-eft").hide();
					     $(".form-group-eft-cash").hide();
						
						$("[name=editDdOrChequeNo]").val(response.ddorchequenumber);
						$("[name=editDdOrChequeDate]").val($.datepicker.formatDate('mm/dd/yy', new Date(response.ddorchequeDate)));
						$("[name=editOutStationCheque]").find('option[value='+response.outstationCheque+']').attr('selected','selected');
						$("[name=editBankName]").val(response.bankName);
						$("[name=editBankAddressLine1]").val(response.bankAddressLine1);
						$("[name=editBankAddressLine2]").val(response.bankAddressLine2);
						$("[name=editBankCountryId]").find('option[value='+response.bankCountryId+']').attr('selected','selected');
						$("[name=editBankStateId]").find('option[value='+response.bankStateId+']').attr('selected','selected');
						$("[name=editBankCityId]").find('option[value='+response.bankCityId+']').attr('selected','selected');
						$("[name=editBankPostCode]").val(response.bankPostcode);
						$("[name=editBankStatementStatus]").val(response.bankStatementStatus);
						
						$("[name=editTallyGLAccount]").val(response.tallyGLAccount);
						$("[name=editRemarks]").val(response.remarks);
						$('#updateRecord').attr('data-id',response.feesCollectionRecordId);
						
						
						 
					}
					else if(paymode=="BankEFT")
					{
						 $(".form-group-cheque-dd").hide();
					     $(".form-group-eft").show();
					     $(".form-group-cheque-dd-eft").show();
					     $(".form-group-eft-cash").show();
						
						$("[name=editBankName]").val(response.bankName);
						$("[name=editBankAddressLine1]").val(response.bankAddressLine1);
						$("[name=editBankAddressLine2]").val(response.bankAddressLine2);
						$("[name=editBankCountryId]").find('option[value='+response.bankCountryId+']').attr('selected','selected');
						$("[name=editBankStateId]").find('option[value='+response.bankStateId+']').attr('selected','selected');
						$("[name=editBankCityId]").find('option[value='+response.bankCityId+']').attr('selected','selected');
						$("[name=editBankPostCode]").val(response.bankPostcode);
						$("[name=editBankTransactionCode]").val(response.bankEFTTransactionCode);
						$("[name=editBankIFSCCode]").val(response.bankIFSCode);
						$("[name=editDateOFEFTOrCash]").val($.datepicker.formatDate('mm/dd/yy', new Date(response.bankEFTDate)));
						
						$("[name=editTallyGLAccount]").val(response.tallyGLAccount);
						$("[name=editRemarks]").val(response.remarks);
						$('#updateRecord').attr('data-id',response.feesCollectionRecordId);
						
						
					}
					
				/*	$("[name=editDdOrChequeNo]").val(response.ddorchequenumber);
					$("[name=editDdOrChequeDate]").val($.datepicker.formatDate('mm/dd/yy', new Date(response.ddorchequeDate)));
					$("[name=editPayableAt]").val(response.payableAt);
					$("[name=editOutStationCheque]").find('option[value='+response.outstationCheque+']').attr('selected','selected');
					$("[name=editBankName]").val(response.bankName);
					$("[name=editBankAddressLine1]").val(response.bankAddressLine1);
					$("[name=editBankAddressLine2]").val(response.bankAddressLine2);
					$("[name=editBankCountryId]").find('option[value='+response.bankCountryId+']').attr('selected','selected');
					$("[name=editBankStateId]").find('option[value='+response.bankStateId+']').attr('selected','selected');
					$("[name=editBankCityId]").find('option[value='+response.bankCityId+']').attr('selected','selected');
					$("[name=editBankPostCode]").val(response.bankPostcode);
					$("[name=editBankTransactionCode]").val(response.bankEFTTransactionCode);
					$("[name=editBankIFSCCode]").val(response.bankIFSCode);
					
					$("[name=editBankStatementStatus]").val(response.bankStatementStatus);
					$("[name=editTallyGLAccount]").val(response.tallyGLAccount);
					$("[name=editRemarks]").val(response.remarks);
				
				    $('#updateRecord').attr('data-id',response.feesCollectionRecordId);*/
				    
					
     	        	
     	        });
			}
     	 });
	 
	  
	  $("#updateRecord").click(function(event){
	   	  $('#SaveConfirmation').modal('show');	
	   	 var feesCollectionRecordId = $(this).attr('data-id');
	   	  $('#SaveConfirm').click(function(){
	   var data=$("#updatefeesDetails").serialize();	
	   $.post(ctx+"/student/updateStudentFeesDetails?feesCollectionRecordId="+feesCollectionRecordId,data,function(data) {
			window.location.href=ctx+"/collection/dataentry";    
	   });
	   		   				  				
	   	  });
	   	  	 });
	  
	
	  
	  $('#FeesCollectionRecordList td a#delete').click(function() {
		  var feesCollectionRecordId = $(this).attr('data-id');
		  $('#SaveConfirmation').modal('show');	
	 	  $('#SaveConfirm').click(function(){
	 		 var data=$(this).attr('data-id');
		 $.post(ctx+"/student/deleteStudentFeesDetails?feesCollectionRecordId="+feesCollectionRecordId,data,function(data) {
				window.location.href=ctx+"/collection/dataentry";    
		   });
		});
	  
		    });
	  
	    $('#bankgeographicallocation').change(function(event) {
      	  
	        var countryid = $("#bankgeographicallocation").val();
	        $.get(ctx+'/geographicallocation/state', {
	                countryId : countryid
	        }, function(response) {
	        	  var select = $('#bankgeographicallocationstate');
	        	   select.find('option').remove();
	        	   var select1=$('#bankgeographicallocationcity');
	        	   		select1.find('option').remove();
	            	 var obj = jQuery.parseJSON(response);
	            	
	            	 $.each(obj, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	   	        	    	}
	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	            	  
	            	 }); 
	        });
	       
	 });
	        
	        
	$('#bankgeographicallocationstate').change(function(event) {
	    var stateid = $("#bankgeographicallocationstate").val();

	    $.get(ctx+'/geographicallocation/city', {
	            stateId : stateid
	    }, function(response) {
	    	
	    	  var select = $('#bankgeographicallocationcity');
	        	 select.find('option').remove();
	        	 var obj = jQuery.parseJSON(response);
	        	
	        	 $.each(obj, function(key,value) {
	        		 if(key==0){
	        	    		select.append('<option value="" disabled selected>Select City</option>');
	        	    	}
	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	        	  
	        	 }); 
	    });
	   
	    });
	 $("#paymentMode").change(function() {
		 
		    var val = $(this).val();
		    if(val ==="Cash") {
		      
		        $(".form-group-cheque-dd").hide();
		        $(".form-group-cheque-dd-eft").hide();
		        $(".form-group-eft").hide();
		        $(".form-group-eft-cash").show();
		       
		          }
		    else if(val ==="Cheque"||val === "DD") {
		    	 $(".form-group-cheque-dd").show();
		    	 $(".form-group-cheque-dd-eft").show();
			        $(".form-group-eft").hide();
			        $(".form-group-eft-cash").hide();
		       }
		   
		    
		    else if(val ==="BankEFT") {
		    	 $(".form-group-cheque-dd").hide();
			        $(".form-group-eft").show();
			        $(".form-group-cheque-dd-eft").show();
			        $(".form-group-eft-cash").show();
		     }
		    
		  });
		  

	 $("#editPaymentMode").change(function() {
		 
		    var val = $(this).val();
		    if(val ==="Cash") {
		      
		        $(".form-group-cheque-dd").hide();
		        $(".form-group-cheque-dd-eft").hide();
		        $(".form-group-eft").hide();
		        $(".form-group-eft-cash").show();
		       
		          }
		    else if(val ==="Cheque"||val === "DD") {
		    	 $(".form-group-cheque-dd").show();
		    	 $(".form-group-cheque-dd-eft").show();
			        $(".form-group-eft").hide();
			        $(".form-group-eft-cash").hide();
		       }
		   
		    
		    else if(val ==="BankEFT") {
		    	 $(".form-group-cheque-dd").hide();
			        $(".form-group-eft").show();
			        $(".form-group-cheque-dd-eft").show();
			        $(".form-group-eft-cash").show();
		     }
		    
		  });
	 
	 
});
    
      
      
    