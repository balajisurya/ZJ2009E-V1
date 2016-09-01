
         $(document).ready(function() {
        	 
        	 
        	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	//deleting 
        	 $('#templateitemlist').on( 'click', 'tr td a#delete', function () {
        		 var templateitemid = $(this).attr('data-id');
        		 $('#confirm-delete').on('show.bs.modal', function (e) {
        			 $("#confirmDeleteTemplateItem").click(function(event) {
        				 $("#deleteTemplateItemId").val(templateitemid);
        				 $("#deleteTemplateItemForm").submit();
        			});
        			});
        		   
        	});
        	//adding 
        	 $("#templateitemSave").click(function(event){
        		$('#templateitemform').validate();
        		if($('#templateitemform').valid()){
        	 			$("#templateitemSaveConfirmation").modal('show');
        	 			$("#templateitemSaveConfirm").click(function(){
        	 				$('#templateitemform').submit();
        		 		});
        	 		}
  			  });	   

         	
        	 $('#templateitemlist').on( 'click', 'tr td a#edit', function () {
        	        
        
        	
        		   var templateitemid = $(this).attr('data-id');
        		   $.get(ctx+'/feestemplate/item/get', {
        			   templateItemId : templateitemid
          	        }, function(response) {
          	        
          	        	$("[name=editFeesItemName]").val(response.templateItemName);    
          	        	$("[name=editFeesItemPrice]").val(response.templateItemPrice);
          	        	$("[name=editLedgerAccountId]").val(response.ledgerAccount.ledgerAccountId).trigger("change");
          	        	$('#updateFeesTemplateItem').attr('data-id',response.templateItemId);
          				
          	        });
        		   
        		});
        	 
        		$("#updateFeesTemplateItem").click(function(event){
     				 var templateItemId = $(this).attr('data-id');
     				 $("#updateTemplateItemId").val(templateItemId);
     				if($('#updateTemplateItemForm').valid()){
     					$('#saveConfirmation').modal('show');
     					$('#saveConfirm').click(function(){
         				$('#updateTemplateItemForm').submit();
         			  });
     				} 
     				});
        	
        	 });
        	
        	
        	
      		
      
     
     
     
     
     
    
     
     