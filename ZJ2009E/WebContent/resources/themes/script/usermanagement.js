 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 		$("#roleTypeSave").click(function(event){
	 			
	 			$("#newrRoleTypeForm").validate({
	 				
	 				
	 				 submitHandler: function(form) {
	 					 $("#roleTypeSaveConfirmation").modal('show');
	 	        		$("#roleTypeSaveConfirm").click(function(){
	 	        			 var data=$("#newrRoleTypeForm").serialize();
	 	        			 $.post(ctx+"/user/roleType/add",data,function(data) {
	 	             			window.location.href=ctx+"/user";
	 	                      });
	 	        		});
	 	        		return false;
	 				 }
	 				 
	 				 
	 			});
	       		 
	 			         
	 		});
	 		
	 		
	 	/*	$("#userSave").click(function(event){
	       		  $("#userSaveConfirmation").modal('show');
	       		    $("#userSaveConfirm").click(function(){
	 	        			 var data=$("#newUserForm").serialize();
	 	        			 $.post(ctx+"/user/add",data);
	 	        		});
	 			         
	 		});*/
	 		//deleting user type
	 		 $('#userTypelist').on( 'click', 'tr td a#delete', function () {
       
       		  var usertypeid = $(this).attr('data-id');
       		   $("#roletypedeleteConfirmation").on('show.bs.modal', function (e) {
       			 $("#roletypedeleteConfirm").attr("href",ctx+"/user/roleType/delete?userTypeId="+usertypeid);
       			   
       			});
       		   
       		});
       	 
       	 $('#userlist td a#delete').click(function() {
      		   var userid = $(this).attr('data-id');
      		   $("#userdeleteConfirmation").on('show.bs.modal', function (e) {
    			 $("#userdeleteConfirm").attr("href",ctx+"/user/delete?userId="+userid);
    		   });
    		   
    	 });
        	
        	
        	 $('#userlist td a#edit').click(function() {
         		var userid = $(this).attr('data-id');
         		
         		//retrive to display
         	   $('#confirm-edit').on('show.bs.modal', function (e) {
       			 $.get('UserManagementServlet',{action:"reterive",userId:userid},function(response){
       				  $("#editusername").val(response.USER_NAME);
      		    	  $("#edituseremail").val(response.USER_EMAIL);
      		    	$("#edituserpassword").val(response.USER_PASSWORD);
      		    	
      		    	
      		    	
       			 });	
         	  });
         	//update code
     			
    			 $("#updateuser").click(function(event){
    				 var data=$('#UserUpdateModal').serialize()+"&action=update"+"&userId="+userid;
	             		 $.post("UserManagementServlet",data,function(data) {
	             			 window.location.href="usermanagement.jsp";
	                      });
    			   });
      		      });
        	 
        	 
        	 
        	
         });
