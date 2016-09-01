         $(document).ready(function() {
        	 
        	 
        	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	
        	$("#getinvoices").click(function(event){
               var id = $("#studentId").val();
               if(id){
            	   $("#invoice-content").load('allInvoices.jsp', {"studentId":id} );
            	}
               else{
            	   $('#invde').modal('show');
               }
                  
            });
        	
        	
        	 $('#getInvoiceDetails').click(function(event) {
        		 
       		  var studentId = $("#studentId").val();
            	        $.get(ctx+'/student/editInvoice', {
            	        	studentId : studentId
            	        }, function(data) {
            	        	var t = $('#datatable').DataTable();
    						t.row('.even').remove().draw(false );  
    						t.row('.odd').remove().draw(false );  
    					/*
    					if (!$.trim(data))
    					{ 
    						t.row('.even').remove().draw(false);  
    						t.row('.odd').remove().draw(false);  
    					}
    					else
    				 	{*/
    						var amount=null;
    						$.each(data.studentInvoiceDetails, function(key,value) 
    						{ 
    							
    						 amount+=value.studentInvoiceElementAmount;
    						});
    						
    						var name= data.student.firstName +" "+data.student.lastName ;
    						
    						 t.row.add( [
								            name,
								            data.student.department.departmentName,
								            data.student.course.courseName,
								            data.semester ,
								            amount
								              ] ).draw( false );
    						
    				 	/*}*/
    				 
            	        	
            	        });
       			
        	 });
        	
        

    	
    	
     });
      
         
    
   
      //**Numbers Only***///
      
      function isNumber(evt) {
  	    evt = (evt) ? evt : window.event;
  	    var charCode = (evt.which) ? evt.which : evt.keyCode;
  	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
  	        return false;
  	    }
  	    return true;
  	}
  	
      
      
      
    