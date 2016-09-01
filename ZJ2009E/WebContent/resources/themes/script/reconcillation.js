$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $('table').DataTable( {
	    	"searching":true,
	    	 dom: 'Bfrtip',
	         buttons: [
	             'csv', 'excel', 'pdf', 'print'
	         ]
	        
	    } );
	//paymentStatus Of PaymentMode
	 $("#paymentModeId").change(function() {
		var paymentModeId=$(this).val();
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#paymentStatusId');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/receipt/reconcillation";
			   }
			 });
     });
	 
	 $("#getReceiptsRecords").click(function(event) {
		$('#reconcillationCriteriaForm').validate({
			 submitHandler: function(form) {
				var paymentModeId= $("#paymentModeId").val();
				var paymentStatusId= $("#paymentStatusId").val();
				 $.ajax(	
				    {
				        type: "GET",
				        url:ctx+'/receipt/byPaymentModeAndStatus' ,
				        data:{paymentModeId:paymentModeId,paymentStatusId:paymentStatusId},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        cache: false,
				        success: function (response) {
				        	$("#receiptdetailsdiv").hide();
				        	$("#chequeReconPendingTable").hide();
			        		$("#ddReconPendingTable").hide();
			        		$("#paymentGatewayReconPendingTable").hide();
			        		$("#cashReconPendingTable").hide();
				        	if(response.length!=0){
				        		 $(".form-horizontal").trigger('reset'); 
				        		var datatable1 = $('#cashReconPending').DataTable();
				        		var datatable2 = $('#cashReconCleared').DataTable();
				        		var datatable3 = $('#chequeReconPending').DataTable();
				        		var datatable4 = $('#chequeReconCleared').DataTable();
				        		var datatable5 = $('#chequeReconBounced').DataTable();
				        		var datatable6 = $('#ddReconPending').DataTable();
				        		var datatable7 = $('#ddReconCleared').DataTable();
				        		var datatable8 = $('#ddReconBounced').DataTable();
				        		datatable1.clear().draw();
				        		datatable2.clear().draw();
				        		datatable3.clear().draw();
				        		datatable4.clear().draw();
				        		datatable5.clear().draw();
				        		datatable6.clear().draw();
				        		datatable7.clear().draw();
				        		datatable8.clear().draw();
				        		$.each(response, function (i, data) {
				        			
				        			
				        			if(data.paymentMode.paymentModeId==1){
				        				
					        			$("#receiptdetailsdiv").show();
					        			if(data.paymentStatus.paymentStatusId==1){
					        				$("#cashReconPendingTable").show();
						        				var datatable = $('#cashReconPending').DataTable();
									        
									        	 
																var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
																}
															  datatable.row.add([data.transactionNo,name,data.student.admissionNo,data.amount,data.paymentReceivedDate,'<a href="#"  id="cashReconReceiptId" class="cash-recon-update" type="button" data-href="#"  data-id="'+data.receiptId+'" data-toggle="modal">'
												                                   +'<span class="glyphicon glyphicon-pencil"></span>' 
														                             +'</a>']).draw( false );
														    
					        			}
					        			if(data.paymentStatus.paymentStatusId==2){
					        				$("#cashReconClearedTable").show();
						        				var datatable = $('#cashReconCleared').DataTable();
									        	 
											        	
											        	
											        	 
																var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
																}
															  datatable.row.add([data.transactionNo,name,data.student.admissionNo,data.amount,data.paymentClearedDate]).draw( false );
														   
					        			}
						        	}
						        	else if(data.paymentMode.paymentModeId==2){
						        		$("#receiptdetailsdiv").show();
						        		if(data.paymentStatus.paymentStatusId==1){
						        			
						        			$("#chequeReconPendingTable").show();
						        			var datatable = $('#chequeReconPending').DataTable();
								        	 
														
															var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
															}
														  datatable.row.add([name,data.student.admissionNo,data.amount,data.chequeNumber,data.paymentReceivedDate,data.chequeBankName,data.chequeBranchName,'<a href="#" id="chequeReconReceiptId" class="cheque-recon-update" type="button" data-href="#" data-id='+data.receiptId+' data-toggle="modal" >'
				                                           +'<span class="glyphicon glyphicon-pencil"></span>'
			                                                +'</a>']).draw( false );
													   
					        			}
						        		if(data.paymentStatus.paymentStatusId==2){
					        				$("#chequeReconClearedTable").show();
						        				var datatable = $('#chequeReconCleared').DataTable();
									        	
															
																var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
																}
															  datatable.row.add([name,data.student.admissionNo,data.amount,data.chequeNumber,data.paymentClearedDate,data.chequeBankName,data.chequeBranchName]).draw( false );
														   
					        			}
						        		if(data.paymentStatus.paymentStatusId==3){
					        				$("#chequeReconBouncedTable").show();
						        				var datatable = $('#chequeReconBounced').DataTable();
									        	 
															
															
																var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
																}
															  datatable.row.add([name,data.student.admissionNo,data.amount,data.chequeNumber,data.chequeBankName,data.chequeBranchName]).draw( false );
														    
					        			}
						        	}
						        	else if(data.paymentMode.paymentModeId==3){
						        		$("#receiptdetailsdiv").show();
						        		if(data.paymentStatus.paymentStatusId==1){
						        			$("#ddReconPendingTable").show();
						        			var datatable = $('#ddReconPending').DataTable();
								        	 
														
														
															var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
															}
														  datatable.row.add([name,data.student.admissionNo,data.amount,data.ddNumber,data.paymentReceivedDate,data.ddBankName,data.ddBranchName,'<a href="#" id="ddReconReceiptId"  class="dd-recon-update" type="button" data-href="#" data-id='+data.receiptId+' data-toggle="modal" >'
									                                           +'<span class="glyphicon glyphicon-pencil"></span>'
								                                                +'</a>']).draw( false );
													   
					        			}
						        		if(data.paymentStatus.paymentStatusId==2){
						        			$("#ddReconClearedTable").show();
						        			var datatable = $('#ddReconCleared').DataTable();
								        	 
										        	
														
															var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
															}
														  datatable.row.add([data.receiptId,name,data.student.admissionNo,data.amount,data.ddNumber,data.paymentClearedDate,data.ddBankName,data.ddBranchName]).draw( false );
													    
					        			}
						        		if(data.paymentStatus.paymentStatusId==3){
						        			$("#ddReconBouncedTable").show();
						        			var datatable = $('#ddReconBounced').DataTable();
								        	
														
															var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
															}
														  datatable.row.add([data.receiptId,name,data.student.admissionNo,data.amount,data.ddNumber,data.ddBankName,data.ddBranchName]).draw( false );
													    
					        			}
						        	}
						        	else{
						        		alert("Invalid Mode");
						        	}
					        	});
				        	}
				        	else{
				        		alert("No Receipts Found With Following Status And Payment Mode")
				        	}
				        }
				      
				    });
			 return false;   
		   }
			  
	  });
	});
	 
	 
	 $('#cashReconPending').on('click', '.cash-recon-update', function(){
		 var receiptId=$(this).attr('data-id');
		 $("#updateCashRecon").attr('data-id',receiptId);
		 var paymentModeId=1;
		 $("input[id=cashReconReceiptId]").val(receiptId);
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   async:false,
			   success: function(response){
				   var select = $('#cashReconPaymentStatusId');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/home";
			   }
			 });
		 
		  $("#cash_recon_update_status").modal('show');
			 $("#updateCashRecon").click(function(){
				 if( $("#updateCashReconForm").valid())
					{
					 $("#updateCashReconForm").submit();
					}
			 });
		 
		});
	 
	
	 
	 $('#chequeReconPending').on('click', '.cheque-recon-update', function(){
		 var receiptId=$(this).attr('data-id');
		 $("#updateChequeRecon").attr('data-id',receiptId);
		 var paymentModeId=2;
		 $("input[id=chequeReconReceiptId]").val(receiptId);
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#chequeReconPaymentStatusId');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/home";
			   }
			 });
		 
		  $("#cheque_recon_update_status").modal('show');
			 $("#updateChequeRecon").click(function(){
				 if( $("#updateChequeReconForm").valid())
					{
					  $("#updateChequeReconForm").submit();
					}
			 });
		 
		});
	 
	 
	 
	 $('#ddReconPending').on('click', '.dd-recon-update', function(){
		 var receiptId=$(this).attr('data-id');
		 $("#updateDdRecon").attr('data-id',receiptId);
		 var paymentModeId=3;
		 $("input[id=ddReconReceiptId]").val(receiptId);
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#ddReconPaymentStatusId');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/home";
			   }
			 });
		 
		  $("#dd_recon_update_status").modal('show');
			 $("#updateDdRecon").click(function(){
				 if( $("#updateDdReconForm").valid())
					{
					 $("#updateDdReconForm").submit();
					}
			 });
		 
		});
	 
});
	 

	 