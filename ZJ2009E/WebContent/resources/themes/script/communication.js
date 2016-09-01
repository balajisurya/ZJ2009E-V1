 $(document).ready(function() {
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	
 	 $("#saveCommunicationMessage").click(function(event){
 		$("#communication").validate();
 		if($("#communication").valid())
 			{
 			
 			$('#communication').submit();
 			}
				
				 return false;
 			
 		});
 	 
 	 $("#close").click(function(event){	
  		$('#close').submit();
 		 });
 	 
 	 
	     });


 
 
    