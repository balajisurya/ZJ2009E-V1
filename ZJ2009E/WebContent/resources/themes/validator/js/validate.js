 $(document).ready(function(){
	 $(".form-horizontal").keyup(function() {
			$(this).validate();
		})
	    /*$(".form-horizontal").blur(function(){
	    	
	    	 $(this).validate();
	    });*/
	});