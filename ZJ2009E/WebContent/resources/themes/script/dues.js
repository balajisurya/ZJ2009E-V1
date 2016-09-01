var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {
        	 
	$("#getdetails").click(function(event){
		$('#getDetailsForm').validate({
				submitHandler: function(form) {
					var date=$('#startandenddate').val();
					/*var dt=new Date();
					var formattedDate=dt.getMonth()+1+"/"+dt.getDate()+"/"dt.getFullYear();
					alert(formattedDate);*/
				   document.getElementById('invoicedetailsdiv').style.display="block";
					  $.ajax(	
					    {
					        type: "GET",
					        url:ctx+"/invoice/dues/pending" ,
					        data:{startAndEndDate:date},
					        success: function (data) {
					        	var datatable = $('#penaltyInvoicesTable').DataTable();
					        	 $(".form-horizontal").trigger('reset'); 
					        	 datatable.clear().draw();
								
								
								
									
					        $.each(data, function (i, item) {
					        	var pendingFees=0.0;
					        	$.each(item.studentInvoiceDetails,function(j,item1){
					        		if(item1.studentInvoiceElementPaymentStatus==1){
					        			pendingFees=pendingFees+item1.studentInvoiceElementTotalAmount;
					        		}
					        	});
					        	
					        	var penaltyAmount=0.0;
					        	var pendingPenaltyAmount=0.0;
					        	$.each(item.studentInvoiceFineDetails,function(k,item2){
					        		penaltyAmount=penaltyAmount+item2.fineAmount;
					        		if(item2.fineStatus==1){
					        			pendingPenaltyAmount=pendingPenaltyAmount+item2.fineAmount;
					        		}
					        	});
					        	
					        	var studentName;
					        	if(item.student.lastName!=null){
					        		studentName=item.student.firstName+" "+item.student.lastName;
					        	}
					        	else{
					        		studentName=item.student.firstName;
					        	}
					        	var classSection=item.student.studentClass.className+'/'+item.student.section.sectionName;
					        	
					           datatable.row.add(['<input type="checkbox" name="studentInvoice" value='+item.studentInvoiceId+' class="case"></input>',item.dueDate,item.invoiceNo,studentName,classSection,item.invoiceAmount,penaltyAmount,pendingFees+pendingPenaltyAmount]).draw( false );
					        });
					        
							 	
					        
					        }
					      
					    });
						
	       
	    		
		        return false;   
			   }
				  
		  });	 
		 
		
		
   	 
   		 
   	 });
	$('#generateduesinvoice').click(function() {
		
	
		if($("#penaltyfeeform").valid()){
			
			 var selectedstudentid = [];
				
			 var oTable = $('#penaltyInvoicesTable').dataTable();
			 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
			 rowcollection.each(function(index,elem){
			     selectedstudentid.push($(elem).val());
			 });
			 $("#selectedStudentIds").val(selectedstudentid);	
			 
			
			 
			  if((selectedstudentid.length)>0)
				  {
				  	$('#penaltyfeeform').submit();
				  }
			  
			  else
			  {
				  
				 alert("You have to select atleast one student from invoice details table")
				  
				  
			  }
			 
			 
				 
				
			
		}
		 
		});

	
	
	$("#category").change(function() {
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
	 
	 
	
	 
	 
	
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#penaltyInvoicesTable').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	      
	      
	      
	      
	      
	   });
  $('#penaltyInvoicesTable').on('change', 'input[type="checkbox"]', function(){
	      // If checkbox is not checked
	      if(!this.checked){
	         var el = $('#example-select-all').get(0);
	         // If "Select all" control is checked and has 'indeterminate' property
	         if(el && el.checked && ('indeterminate' in el)){
	            // Set visual state of "Select all" control 
	            // as 'indeterminate'
	            el.indeterminate = true;
	         }
	      }
	    
	   
	   });
 
	  
	
	
	  
	 
	  
	   
	        
	
	 
		  

	
	 
	 
});

    