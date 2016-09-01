$(document).ready(function() {

				
        		 $('#admissionConfiglist').on( 'click', 'tr td a#delete', function () {
        		   var admissionConfigId = $(this).attr('data-id');
        		   $("#confirm-delete").on('show.bs.modal', function (e) {
        			   $("#confirmcAdmissionConfigDelete").attr("href", "admissionconfig/delete?admissionConfigId="+admissionConfigId);
        			});
        		   
        		});
        	 
        	//adding admission config
        	 $("#admissionConfigSave").click(function(event){
        		 
        		 $('#newadmissionConfigForm').validate();
        		 if($('#newadmissionConfigForm').valid())
        			 {
        			 
        			 $("#admissionConfigSaveConfirmation").modal('show');
         			$("#admissionConfigSaveConfirm").click(function(){
         			    $("#newadmissionConfigForm").submit();
        			
  	        	});
        			 }
        		 return false;
  			});
        	
});
