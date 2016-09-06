$(document).ready(function() {
			
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	  $("#getAllReceipts").click(function(event){
				 $('#studentReceiptCriteriaForm').validate({
					submitHandler: function(form) {
						var admissionNo=$("#admissionNo").val();
						$('.loader').show();
						    $.ajax(	
							    {
							        type: "GET",
							        url:ctx+"/receipt/byAdmissionNo",
							        data: {admissionNo:admissionNo},
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success:function (data) {
							        	 $('.loader').hide();
							        	  document.getElementById('receiptDetailDiv').style.display="block";
							        	var datatable = $('#studentReceipts').DataTable();
							        	 $(".form-horizontal").trigger('reset'); 
											      datatable.clear().draw();
											  $.each(data, function (i, item) {
												  if(item!=null){
													  var name;
											        	if(item.student.lastName!=null){
											        		name=item.student.firstName+' '+item.student.lastName;
											        	}else{
											        		name=item.student.firstName;
											        	}
											        	datatable.row.add([item.receiptId,item.student.admissionNo,name,item.student.studentClass.className,item.student.section.sectionName,'<a href="#"  id="delete"  type="button" data-href="#"  data-id='+item.receiptId+' data-toggle="modal" data-target="#confirm_delete_receipt">'
									                                      +'<span class="glyphicon glyphicon-trash"></span>' 
									                                       +'</a>']).draw( false );
												  }
												 });
							        },
							        error:function(){
							        	 $('.loader').hide();
							        	 $(".form-horizontal").trigger('reset'); 
							        	 document.getElementById('invoicedetailsdiv').style.display="none";
							        	 alert("Data  Not Found")
								 	    }
							      
							    });
						    
				       }
						  
				  });	
				 
				 
				
				  });	
	  
	  
	  $('#studentReceipts').on( 'click', 'tr td a#delete', function () {
			 var receiptid = $(this).attr('data-id');
			 $("#deleteReceipitId").val(receiptid);
			  $('#confirm_delete_receipt').on('show.bs.modal', function (e) {
					 $("#confirmDeleteReceipt").click(function(event) {
						 $("#deleteReceiptForm").submit();
					  });
			  });
		});

			
			
			});
			
	
	
		

	

   