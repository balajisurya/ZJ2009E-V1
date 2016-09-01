 $(document).ready(function() {
        	 
        	
        	 
        	//adding department
        	 $("#labplansave").click(function(event){
        		  $('#confirm-save').modal('show');
        		// $('#addDepartmentForm').validate({
  				 //  submitHandler: function(form) {
                 //   $('#departmentAddingConfirmation').modal('show');
  	        	/*	$('#confirmAddDepartment').click(function(){
  	        			var data=$('#addDepartmentForm').serialize();
  	        				$.post("department/add",data,function(data) {
  	        					window.location.href="department";
  	                 });
  	               });*/
  			           
  			     //   }
  			   // });	   
        		 

        	 });
        	 
         	//adding department
         	 $("#labplanschedulesave").click(function(event){
         		  $('#confirm-save').modal('show');
         		// $('#addDepartmentForm').validate({
   				 //  submitHandler: function(form) {
                  //   $('#departmentAddingConfirmation').modal('show');
   	        	/*	$('#confirmAddDepartment').click(function(){
   	        			var data=$('#addDepartmentForm').serialize();
   	        				$.post("department/add",data,function(data) {
   	        					window.location.href="department";
   	                 });
   	               });*/
   			           
   			     //   }
   			   // });	   
         		 
 return false;
         	 });
 });
	
       