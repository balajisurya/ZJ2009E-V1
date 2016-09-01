           $(document).ready(function() {
        	 $("#getFeesDetails").click(function(event){
        			var id = $("#studentId").val();
        	       if(id){
        	    	   var valid=true;
        	    	   if(valid){
        	    		   loadReceiptDetails(id);   
        	    	   }
        	    	   else{
        	    		   $("#getFeesDetails").before(
        					        '<div class="alert alert-danger alert-dismissable">'+
        					            '<button type="button" class="close" ' + 
        					                    'data-dismiss="alert" aria-hidden="true">' + 
        					                '&times;' + 
        					            '</button>' + 
        					            'Please enter the input Or valid input to corresponding fields...' + 
        					            '</div>'+
        					         '</div>');
        					
        	    	   }
        	    	}
        	       else{
        	    	   $(".form-group").before(
   					        '<div class="alert alert-danger alert-dismissable">'+
   					            '<button type="button" class="close" ' + 
   					                    'data-dismiss="alert" aria-hidden="true">' + 
   					                '&times;' + 
   					            '</button>' + 
   					            'Please enter the input Or valid input to corresponding fields...' + 
   					            '</div>'+
   					         '</div>');
        	    	}
        	       window.setTimeout(function() {
       			    $(".alert").fadeTo(500, 0).slideUp(500, function(){
       			        $(this).remove(); 
       			    });
       			},2000);
       		
       		});
        	          
        	  
         });
           
     //****Numbers Only***//
      
      function isNumber(evt) {
    	    evt = (evt) ? evt : window.event;
    	    var charCode = (evt.which) ? evt.which : evt.keyCode;
    	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	        return false;
    	    }
    	    return true;
    	}
    	
        
    