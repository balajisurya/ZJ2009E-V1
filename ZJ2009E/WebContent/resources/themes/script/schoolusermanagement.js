
$(document).ready(function() {
	 
	 
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$('#saveuser').click(function() {
		
		
		if($("#newuserform").valid()){
			
			
			$("#userSaveConfirmation").modal('show');
			$("#userSaveConfirm").click(function(event) {
				$("#newuserform").submit();
			});
			return false;
			
			
			
		}
		
		
		
		 
		});
	 		
	 		
	 		
	$("#newuserform").keyup(function() {
		 $(this).validate(
					{
						  rules: {
							  userpassword: "required",
							  pass_word_confirm: {
							      equalTo: "#password"
							    }
							  }
					}
					
			
			);
	})
	
		$("#updateForm").keyup(function() {
		 $(this).validate(
					{
						  rules: {
							  editPassword: "required",
							  editPasswordConfirm: {
							      equalTo: "#editPassword"
							    }
							  }
					}
					
			
			);
	})
	
        	 
	$('#userslist').on( 'click', 'tr td a#delete', function () {
		 var userId = $(this).attr('data-id');
		 $('#confirm_delete_user').on('show.bs.modal', function (e) {
			 $("#confirmDeleteUser").click(function(event) {
				 $("#deleteUserId").val(userId);
				 $("#deleteUserForm").submit();  
			});
			});
		   
	});
	
	$('#userslist').on( 'click', 'tr td a#edit', function () {
		var userId = $(this).attr('data-id');
		
		$.ajax({
			   url:ctx+'/schooluser/editRetreive',
			   data:{userId:userId},
			   type:'GET',
			   success: function(response){
				   $("[name=editUserName]").val(response.name);
				   $("[name=editUserEmail]").val(response.email);
				   $("[name=editPassword]").val(response.password);
				   $("[name=editPasswordConfirm]").val(response.password);
				   $("[name=editUserStatus]").val(response.status);
				   $("#updateUser").attr('data-id',response.userId);
				   
			   }
			 });
	});
	
	$("#updateUser").click(function(event){
		 var updateUserId = $(this).attr('data-id');
		 $("#updateUserId").val(updateUserId);
		
		 if( $("#updateForm").valid())
			{
		 $('#update_User_Confirmation').modal('show');
		 $('#updateUserConfirm').click(function(){
			
			 $("#updateForm").submit();
		  });
			}
	});
	
        	
         });
