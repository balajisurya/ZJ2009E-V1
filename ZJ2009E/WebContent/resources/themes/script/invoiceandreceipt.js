 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {
	 $('.table-bordered').DataTable({
		 
		
		
    	 dom: 'Bfrtip',
         buttons: [
             'csv', 'excel', 'pdf', 'print'
         ]
	 });	
	
	
		
		$('#class').change(function(event) {
	  	    var classId = $("#class").val();
	  	    $.get(ctx+'/class/sectionsOfClass', {
	                classId : classId
	        }, function(response) {
	        	  var select = $('#section');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
	   	        	    	}
	            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
	            	  
	            	 }); 
	        });
	       
	 });
	$("#criteria").change(function() {
		var value = $(this).val();
		  if(value ==="specificstudent"){
			 $(".form-group-student-id").show();
		        $(".form-group-special-category").hide(); 
			 
		 }
		 else if(value==="specialcategory"){
			 $(".form-group-student-id").hide();
		        $(".form-group-special-category").show();  
			 
		 }
		 else
			 {
			 
			 
			 $(".form-group-student-id").hide();
		        $(".form-group-special-category").hide();  
			 
			 
			 }
			
			 


	});
			 $("#getdetailsfromselectedcriteria").click(function(event){

			
						if($("#getDetailsForm").valid())
								{
							
							var invoiceorfcrvalue = $("#invoiceandfcr").val();
							 var data=$("#getDetailsForm").serialize();
							 
							 
							 $('.loader').show();
							
							 if(invoiceorfcrvalue ==="invoice"){
								
								
								 
								   
								  
								   $.ajax(	
									    {
									        type: "GET",
									        url:ctx+"/invoice/invoiceAndReceipt/invoice" ,
									        data: data,
									        contentType: "application/json; charset=utf-8",
									        dataType: "json",
									        cache: false,
									        success: function (invoices) {
									        	  document.getElementById('invoicedetailsdiv').style.display="block";
												   document.getElementById('receiptdetailsdiv').style.display="none";
												  $('.loader').hide();
									        	var datatable = $('#invoicedatatable').DataTable();
									        	 $(".form-horizontal").trigger('reset'); 
													      datatable.clear().draw();
													  $.each(invoices, function (i,invoices) {
													      var url=ctx+"/invoice/print?invoiceId="+invoices.studentInvoiceId;
												        	var name;
												        	if(invoices.student.lastName!=null){
												        		name=invoices.student.firstName+' '+invoices.student.lastName;
												        	}else{
												        		name=invoices.student.firstName;
												        	}
												            datatable.row.add([invoices.academicYear.academicYearTitle,invoices.academicYearFeesTerm.feesTermTitle,invoices.student.admissionNo,name,invoices.invoiceAmount,'<a href='+url+' id="viewinvoice" target="__blank" class="invoice" type="button"data-href="#" data-id="" data-toggle="modal" >'
								                               +'<span class="glyphicon glyphicon-eye-open"></span></a>'
									                              + '<a href="" class="print" id="invoiceprint"  type="button" data-toggle="modal" data-id='+invoices.studentInvoiceId+' data-target="#invprint">'
									                                   +'<span class="glyphicon glyphicon-print"></span></a> '
									                              ]).draw( false );
												        });
									        	
									       
									        	
									        
									        }
									      
									    });
									  
									
										
								 
							 }
							
							 else
								 {
								
								
								$.ajax(	
										    {
										        type: "GET",
										        url:ctx+"/receipt/invoiceAndReceipt/receipt",
										        data: data,
										        contentType: "application/json; charset=utf-8",
										        dataType: "json",
										        cache: false,
										        success: function (receipts) {
										        	$('.loader').hide();
										        	 document.getElementById('receiptdetailsdiv').style.display="block";
													 document.getElementById('invoicedetailsdiv').style.display="none";
													

										        	var datatable = $('#receiptdatatable').DataTable();
										        	 $(".form-horizontal").trigger('reset'); 
														      datatable.clear().draw();
														  $.each(receipts, function (i,receipts) {
														
															  
															  
													        	var name;
													        	if(receipts.student.lastName!=null){
													        		name=receipts.student.firstName+' '+receipts.student.lastName;
													        	}else{
													        		name=receipts.student.firstName;
													        	}
													        	
													        	var url=ctx+"/receipt/print?receiptId="+receipts.receiptId;
													            datatable.row.add([receipts.receiptId,receipts.student.admissionNo,name,receipts.paymentReceivedDate,receipts.paymentMode.paymentModeTitle,receipts.paymentStatus.paymentStatusTitle,receipts.amount,'<a href='+url+' id="viewreceipt"  class="receipt" target="_blank" type="button"data-href="#" data-id="" data-toggle="modal">'
									                               +'<span class="glyphicon glyphicon-eye-open"></span></a>'
										                              + '<a href="" class="print" id="receiptprint" data-toggle="modal" type="button"  data-id='+receipts.receiptId+' data-target="#recprint">'
										                                   +'<span class="glyphicon glyphicon-print"></span></a> '
										                              ]).draw( false );
													        });
										       
										        
										        }
										      
										    });
								 
								 }
								
							
								}
								
						
									 


							
						   
						   
				  });	 
		
	 $('#invoicedatatable').on( 'click', 'tr td a#invoiceprint', function () {
        		 
        		 var invoiceId = $(this).attr('data-id');
        		
        		 
      		   $('#invprint').on('show.bs.modal', function (e) {
      			   $('#printinv').attr("href", ctx+"/invoice/print?invoiceId="+invoiceId);
      			});
      		  $("#printinv").printPage();
      		
      		   
      		 
      		   
      		}); 
$('#receiptdatatable').on( 'click', 'tr td a#receiptprint', function () {
        		 
        		 var receiptId = $(this).attr('data-id');
        		
        		 
      		   $('#recprint').on('show.bs.modal', function (e) {
      			   $('#printrec').attr("href", ctx+"/receipt/print?receiptId="+receiptId);
      			});
      		  $("#printrec").printPage();
      		
      		   
      		 
      		   
      		}); 
				 
				  
					 
				   
				
		});
		
	
function showinvoiceDiv(){
	
	if(document.getElementById('viewinvoicediv').style.display=="none"){
	document.getElementById('viewinvoicediv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";
	document.getElementById('viewreceipt').style.display="none";
	
	}

}
function showreceiptDiv(){
	
	if(document.getElementById('viewreceiptdiv').style.display=="none"){
	document.getElementById('viewreceiptdiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";
	
	document.getElementById('viewinvoice').style.display="none";
	}

}

    