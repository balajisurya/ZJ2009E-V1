 $(document).ready(function() {
        	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
        	 //deleting department
	 $('#table tbody').on( 'click', 'tr td a#delete', function () {
        		   var departmentid = $(this).attr('data-id');
        		   $('#confirm-delete').on('show.bs.modal', function (e) {
        			   $('#confirmDeleteDepartment').attr("href", "department/delete?departmentId="+departmentid);
        			});
        		   
        		});
        	 
        	//adding department
        	 $("#departmentSaveButton").click(function(event){
        		  
        	 $('#addDepartmentForm').validate({
  				   submitHandler: function(form) {
                   $('#departmentAddingConfirmation').modal('show');
  	        		$('#confirmAddDepartment').click(function(){
  	        			var data=$('#addDepartmentForm').serialize();
  	        				$.post("department/add",data,function(data) {
  	        					window.location.href="department";
  	                 });
  	               });
  			        return false;     
  			     }
  			  });	   
        		 
        	 });
        	
        	//edit
        	     			 
      			 
      				 $('#table tbody').on( 'click', 'tr td a#edit', function () {
      				
          		   var departmentid = $(this).attr('data-id');
          		  
  	        	   
          		   $.get(ctx+'/department/getDepartment', {
          			 departmentId : departmentid
        	        }, function(response) {
        	        	$('#updateDepartment').attr('data-id',response.departmentId);
        	        	$("[name=editDepartmentName]").val(response.departmentName);     
        	        	
        				$("[name=editHeadStaffId]").find('option[value='+response.departmentHead.staffId +']').attr('selected','selected');
        				
        	        });
          		 });
      			//update code
      		
      			$("#updateDepartment").click(function(event){
      				
      				$(this).validate();
      				
      				if($("#updateDepartmentDetails").valid())
      					{
      					
      					var departmentId = $(this).attr('data-id');
      	      			
              		  $('#saveConfirmation').modal('show');
              			$('#saveConfirm').click(function(){
              				var data=$('#updateDepartmentDetails').serialize();
              			  
        	        				$.post(ctx+"/department/update?departmentId="+departmentId,data,function(data) 
        	        						{
        	        					window.location.href=ctx+"/department";
        	                 });
        	               });
    					  
      					
      					}
      				
      			
      					  
      					
      					  
      					
      				
      				
      				
      				 
    			 });
      			 
      			 
      			
        	
         });
     
      
      
    