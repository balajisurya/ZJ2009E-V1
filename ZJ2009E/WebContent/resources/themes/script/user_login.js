
$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	
	$("#signIn").keyup(function() {
		$(this).validate();
	})
	
	$("#signup").keyup(function() {
		 $(this).validate(
					{
						  rules: {
							  pass_word: "required",
							  pass_word_confirm: {
							      equalTo: "#password"
							    }
							  }
					}
					
			
			);
	})
	
	
	
	 
	$("#login").click(function(event){
		if($("#signIn").valid())
  		  {
  		  	$('#signIn').submit();
  		
  		  }
    		 return false;
    });
	

	//email avaiablity check
	$("#email").change(function(){
		var email=$(this).val();
		$.ajax({
		    url: ctx+'/user/availablity',
		    type: 'GET',
		    data:{username:email},
		    success: function(response) {
		    	if(response.status=='failed'){
		    		$('#message').empty();
		    		$('#message').append('<div id="login-alert" class="alert alert-danger" >'
				           	+'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
				  			 +'<strong>'+response.message+'</strong>"'
				   		 +'</div>');
		    	}
		    	window.setTimeout(function() {
		     	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
		     	        $(this).remove(); 
		     	    });
		     	},800);
		   }
		});
	});
	

	
	$("#signupvalid").click(function(event){
	  	  if($("#signup").valid())
	  		  {
	  		    $('#loadingmessage').show();
	      			$('#signup').submit();
	  		
	  		  }
	    	  return false;
		
	});
	
});



	

	
	
	

