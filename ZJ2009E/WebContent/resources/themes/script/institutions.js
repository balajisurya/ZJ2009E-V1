 $(document).ready(function() {
        	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	 
        	
        	 $("#institutionSave").click(function(event){
           		 $('#newInstitutionForm').validate({
     				  submitHandler: function(form) {
        		 
        		 
        		  $('#institutionSaveConfirmation').modal('show');
        			$('#institutionsSaveConfirm').click(function(){
  	        			var data=$('#newInstitutionForm').serialize();
  	        				$.post(ctx+"/institution/add",data,function(data) 
  	        						{
  	        					window.location.href=ctx+"/institution";
  	                 });
  	               });
        			 return false;     
    			        }
    			 });	   
        			
        			
        			
  			 });
        	 
        	 
        	 $("#updateInstitution").click(function(event){
        		 var institutionId = $(this).attr('data-id');
       		  $('#saveConfirmation').modal('show');
       			$('#saveConfirm').click(function(){
       				var data=$('#updateInstitutionDetails').serialize();
       			  
 	        				$.post(ctx+"/institution/update?institutionId="+institutionId,data,function(data) 
 	        						{
 	        					window.location.href=ctx+"/institution";
 	                 });
 	               });
 			 });
        	 
        
        	 $('#institutionlist').on( 'click', 'tr td a#delete', function () {
      		   var institutionid = $(this).attr('data-id');
      		   $("#confirm-delete").on('show.bs.modal', function (e) {
      			   $("#confirmiInstitutionDelete").attr("href", ctx+"/institution/delete?institutionId="+institutionid);
      			});
      		 
      		 });
        	 
          	 $('#institutionlist').on( 'click', 'tr td a#edit', function () {
        		   var institutionid = $(this).attr('data-id');
        		  
        		   $.get(ctx+'/institution/getInstitute', {
        			   institutionId : institutionid
      	        }, function(response) {
      	     	 
      	        	$("[name=editInstitutionName]").val(response.institutionName);
      	        	$("[name=editInstitutionDescription]").val(response.institutionDescription);
      	        	$("[name=editInstitutionEmail]").val(response.institutionEmail);
      	        	$("[name=editInstitutionContact]").val(response.institutionContact);
      	        	$("[name=editInstitutionAddressLine1]").val(response.institutionAddressline1);
      	        	$("[name=editInstitutionAddressLine2]").val(response.institutionAddressline2);
      	        	$("[name=editInstitutionAdminName]").val(response.institutionAdminName);
      	        	$("[name=editInstitutionAccountName]").val(response.institutionAccountName);
      	        	$("[name=editInstitutionAccountNo]").val(response.institutionAccountNumber);
      	        	$("[name=editInstitutionPostCode]").val(response.institutionPostcode);
      	        
      				$("[name=editCurrencyCode]").find('option[value='+response.currencyCode+']').attr('selected','selected');
      				$("[name=editInstituteCountryId]").find('option[value='+response.institutionCountryId+']').attr('selected','selected');
      				$("[name=editInstituteStateId]").find('option[value='+response.institutionStateId+']').attr('selected','selected');
      				$("[name=editInstituteCityId]").find('option[value='+response.institutionCityId+']').attr('selected','selected');
      				$("[name=editInstituteStatus]").find('option[value='+response.institutionStatus+']').attr('selected','selected');
      			   
      				$('#updateInstitution').attr('data-id',response.institutionId);
      	        });
        		 });
        	 
        	 
        	 
        
				
             $('#instituteCountryId').change(function(event) {
           	   var countryid = $("#instituteCountryId").val();
           	        $.get(ctx+'/geographicallocation/state', {
           	                countryId : countryid
           	        }, function(response) {
           	        	  var select = $('#instituteStateId');
           	        	   select.find('option').remove();
           	        	var select1=$('#instituteCityId');
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
           	        
           	        
           	$('#instituteStateId').change(function(event) {
           	    var stateid = $("#instituteStateId").val();

           	    $.get(ctx+'/geographicallocation/city', {
           	            stateId : stateid
           	    }, function(response) {
           	    	
           	    	  var select = $('#instituteCityId');
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
           	
           	
            $('#editInstituteCountryId').change(function(event) {
            	   var countryid = $("#editInstituteCountryId").val();
            	        $.get(ctx+'/geographicallocation/state', {
            	                countryId : countryid
            	        }, function(response) {
            	       
            	        	  var select = $('#editInstituteStateId');
            	        	   select.find('option').remove();
            	        	var select1=$('#editInstituteCityId');
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
            	        
            	        
            	$('#editInstituteStateId').change(function(event) {
            	    var stateid = $("#editInstituteStateId").val();

            	    $.get(ctx+'/geographicallocation/city', {
            	            stateId : stateid
            	    }, function(response) {
            	    	
            	    	  var select = $('#editInstituteCityId');
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
     
    
      
      
    