$(document).ready(function() 
		{
	
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$("#updateinstitution").click(function(event) {
		 var updateInstitutionId = $(this).attr('data-id');
				 $("#updateInstitutionId").val(updateInstitutionId);
			if($("#editinstitutionform").valid()){
				
				$("#institutionupdateconfirmation").modal('show');	
				 $("#institutionupdateconfirm").click(function(){
				
					 $("#editinstitutionform").submit();
			});		
				
			} 
			
	
	});
	
	
     $('#geographicallocation').change(function(event) {
   	    var countryid = $(this).children(':selected').attr('id');
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
	            		 $('#geographicallocationstate').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
	            	}); 
	        });
	       
	 });
	        
	        
	$('#geographicallocationstate').change(function(event) {
	    var stateid = $(this).children(':selected').attr('id'); 

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
	        		 $('#geographicallocationcity').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
	        	  
	        	 }); 
	    });
	   
	    });	
	
	
});

/*function showimage()
{
	var folder = "images/";


	        $(data).find("a").attr("href", function (i, val) {
	            if( val.match(/\.(jpe?g|png|gif)$/) ) { 
	                $("body").append( "<img src='"+ folder + val +"'>" );
	            } 
	        });
}
*/


