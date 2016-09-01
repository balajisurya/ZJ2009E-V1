 $(document).ready(function(){
	 
	 
	 
	 
	 //add academic year schedule day
	 
     $("#addacademicyearscheduleday").click(function(event){
    	 
    	 $('#academic_year_calendar_form').validate();
    	 if($("#academic_year_calendar_form").valid())
    		 {
    		 
    		 $('#confirm-save-academicyear-schedule-day').modal('show');
    		 
    		 }
    	 return false;
   	});
   
  
    
	 
        	

              		$("#addmore").on('click',function(){
              			 $('#day_type').modal('show');
              		});
              			
              	
              		
             
        });
        