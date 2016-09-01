

$(document).ready(function() {
        	 
	$('#list').click(function() {
		 $(".form-horizontal").trigger('reset'); 
    location.reload();

});
        	//adding new staff
        	 $("#studentattendance").click(function(event){
        		 $('#confirm-save').modal('show');
        		// $('#managestaffform').validate({
  				//   submitHandler: function(form) {
                //    $('#testcourse').modal('show');
  	        	//	 $('#addnew').click(function(){
  	             		 
  	             	//	 var data=$('#managestaffform').serialize()+"&action=save";
  	             	//	 $.post("StaffServlet",data,function(data) {
  	             		//	 window.location.href="managestaff.jsp";
  	                   //   });
  	             	//});
  			            return false;     
  			      //  }
  			   // });	   
        		 
        	 });
        	
        	      
         });
    
   
      
