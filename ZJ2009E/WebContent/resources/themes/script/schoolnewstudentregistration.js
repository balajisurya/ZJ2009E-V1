 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	   $("#newstudentValid").click(function(event){
    	  
    	  $(this).validate();
    	  if( $('#newStudentDetails').valid()){
    		  
    		  $('#confirm-save').modal('show');	
        	  $('#confirmSave').click(function(){
        	
        		  $("#newStudentDetails").submit();
        		
             	 }); 
    		  
    	  }
    	  return false;
    	  	 });
      

	 
 
           /*  $('#countryId').change(function(event) {
           	  
     	        var countryid = $("#countryId").val();
     	        $.get(ctx+'/geographicallocation/state', {
     	                countryId : countryid
     	        }, function(response) {
     	        	  var select = $('#stateId');
     	        	   select.find('option').remove();
     	        	   var select1=$('#cityId');
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
     	       
     	 });*/
     	        
     	        
     	/*$('#stateId').change(function(event) {
     	    var stateid = $("#stateId").val();

     	    $.get(ctx+'/geographicallocation/city', {
     	            stateId : stateid
     	    }, function(response) {
     	    	
     	    	  var select = $('#cityId');
     	        	 select.find('option').remove();
     	        	 var obj = jQuery.parseJSON(response);
     	        	
     	        	 $.each(obj, function(key,value) {
     	        		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select City</option>');
	   	        	    	}
     	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
     	        	  
     	        	 }); 
     	    });
     	   
     	    });*/
     	 

	   
        	 
         });
