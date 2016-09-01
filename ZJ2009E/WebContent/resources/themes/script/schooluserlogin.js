
$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	$("#signIn").keyup(function() {
		$(this).validate();
	})
	
	
	
	
	
	 
	$("#login").click(function(event){
		if($("#signIn").valid())
  		  {
  		  	$('#signIn').submit();
  		
  		  }
    		 return false;
    });
	$("#forgotpasswordformvalid").click(function(event){
		
		
		
		
	if($("#forgotpasswordform").valid())
  		  {
  		  	$('#forgotpasswordform').submit();
  		
  		  }
    		 
    });

	
	
	/*$("#email").change(function(){
		var email=$(this).val();
		$.ajax({
		    url: ctx+'/schooluser/emailCheck',
		    type: 'GET',
		    data:{username:email},
		    success: function(response) {
		    	if(response.status=='failed'){
		    		$('#email').val("");
		    		$('#message').empty();
		    		$('#message').append('<div id="login-alert" class="alert alert-danger" >'
				           	+'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
				  			 +'<strong>'+response.message+'</strong>"'
				   		 +'</div>');
		    	}
		    	
		    	window.setTimeout(function() {
		     	    $(".alert").fadeTo(500, 0).slideUp(800, function(){
		     	        $(this).remove(); 
		     	    });
		     	},800);
		   }
		});
	});
	*/
	
	
});
function showForgotForm(){
	if(document.getElementById('FormDiv').style.display=="none"){
	document.getElementById('FormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	}
else{
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}



	

	
	
	

