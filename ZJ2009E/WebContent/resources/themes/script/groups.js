 $(document).ready(function() {
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
 	
        	//deleting group
	
       
	 $('#grouplist').on( 'click', 'tr td a#delete', function () {
        		   var groupid = $(this).attr('data-id');
        		   $('#confirm-delete').on('show.bs.modal', function (e) {
        			   $('#confirmDeleteGroup').attr("href", "group/delete?groupId="+groupid);
        			});
        		   
        		});
        	 
          	 
        	 $('#grouplist').on( 'click', 'tr td a#edit', function () {
      		  
        		 var groupid = $(this).attr('data-id');
      		
        		 $.get(ctx+'/group/getGroup', {
      			
        			 groupId : groupid
   	       
        		 }, function(response) {
   	     
   	        	
        			 var selectedValues = new Array();
   	        	
   	        	
        			 $.each(response.groupMapping, function(key,value) 
        					 { 
						
        				 selectedValues[key]=value.courseSemId;
					
        					 });
   	        
   	        	
				
        			 $('#updateGroup').attr('data-id',response.groupId);
        			 $("[name=editGroup-name]").val(response.groupName); 
        			 $("#editCourseSem").val(selectedValues).trigger("change"); 
        			 /*$("[name=editCourseSemList]").val(selectedValues);*/
   				
   	        });
     		   
      		   
      		});
        	 
        	 
        	 
        	 $("#updateGroup").click(function(event){
        		 var groupId = $(this).attr('data-id');
       		  $('#saveConfirmation').modal('show');
       			$('#saveConfirm').click(function(){
       				var data=$('#updateGroupDetails').serialize();
       			  
 	        				$.post(ctx+"/group/update?groupId="+groupId,data,function(data) 
 	        						{
 	        					window.location.href=ctx+"/group";
 	                 });
 	               });
 			 })
        	//adding group
        	 $("#groupSaveButton").click(function(event){
        		 
        	 	 $('#addGroupForm').validate();
        	 	 if($('#addGroupForm').valid()){
        	 	 	 $("#groupAddingConfirmation").modal('show');
	                 $('#confirmAddGroup').click(function(){
	                	$('#addGroupForm').submit();
	  	        	});
        	 	 }
        	 	 return false;
             });
        	
        	
         });
         
         $(document).ready(function () {
        	 $(".select2_single").select2({
                 placeholder: "Select a Option",
                 allowClear: true
             });
             $(".select2_group").select2({});
             $(".select2_multiple").select2({
                 maximumSelectionLength:null,
                 placeholder: "click here",
                 allowClear: true,
                 
                 
                 
             });
             
         });
    