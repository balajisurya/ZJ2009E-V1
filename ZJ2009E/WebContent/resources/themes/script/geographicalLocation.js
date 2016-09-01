 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	
	 
          $('#geographicallocation').change(function(event) {
        	  $('#geographicallocationstate').attr('disabled', false);
     		  $('#geographicallocationcity').attr('disabled', false);
        	        var countryid = $("#geographicallocation").val();
        	        $.get(ctx+'/geographicallocation/state', {
        	                countryId : countryid
        	        }, function(response) {
        	        	  var select = $('#geographicallocationstate');
        	        	   select.find('option').remove();
        	        	   var select1=$('#geographicallocationcity');
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
        	        
        	        
        	$('#geographicallocationstate').change(function(event) {
        		
        	    var stateid = $("#geographicallocationstate").val();

        	    $.get(ctx+'/geographicallocation/city', {
        	            stateId : stateid
        	    }, function(response) {
        	    	
        	    	  var select = $('#geographicallocationcity');
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
        	 
        	 
        	    
    });
 
 