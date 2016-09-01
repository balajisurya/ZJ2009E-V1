$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$('#joinedClass').change(function(event) {
  	    var classId = $("#joinedClass").val();
  	    $.get(ctx+'/class/sectionsOfClass', {
                classId : classId
        }, function(response) {
        	  var select = $('#joinedsection');
        	   select.find('option').remove();
        	   $.each(response, function(key,value) {
            		 if(key==0){
   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
   	        	    	}
            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
            	  }); 
        });
       
 });
	
	
	$("#studentSave").click(function(event) {
		$(this).validate();
		if($("#studentRegistrationform").valid())
			{
				$("#studentSaveConfirmation").modal('show');
				$("#studentSaveConfirm").click(function(event) {
					$("#studentRegistrationform").submit();
				});
				return false;
			}
	});
	

	/*$("#confirmExcelUpload")click(function(event) {
		alert("hai");
		if($("#studentExcelUploadForm").valid())
			{
			   $("#studentExcelUploadForm").submit();
			   return false;
			}
	});*/
});