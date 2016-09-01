$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$("#getdetails").click(function(event){
		if($('#getFeesDetailsForm').valid){
			var date=$('#startandenddate').val();
			     $.ajax(	
				    {
				        type: "GET",
				        url:ctx+"/report/collections/fees" ,
				        data:{startAndEndDate:date},
				        success: function (data) {
				        	var datatable = $('#fessCollectionTable').DataTable();
				        	 $(".form-horizontal").trigger('reset'); 
				        	 datatable.clear().draw();
				        	 var datatable1=$('#fineCollectionTable').DataTable();
				        	 $(".form-horizontal").trigger('reset'); 
				        	 datatable1.clear().draw();
							
							
					   		
								
				        $.each(data, function (i, item) {
				        	if(item.paymentStatus!=null){
				        		if(item.paymentStatus.paymentStatusId!=3){
					        		datatable.row.add([item.receiptId,item.amount,item.paymentReceivedDate]).draw( false );
					        		if(item.receiptFines!=null){
					        			$.each(item.receiptFines, function (j, item1) {
					        				datatable1.row.add([item.receiptId,item1.studentInvoiceFineDetail.fineAmount,item.paymentReceivedDate]).draw( false );
					        			});
					        		}
					        	}
				        	}
				        });
				        
				        document.getElementById('fessCollectionTableDiv').style.display="block";
				        document.getElementById('fineCollectionTableDiv').style.display="block";
				       
						 	
				        
				        }
				      
				    });
	
		}
		
									
	   });
		
});