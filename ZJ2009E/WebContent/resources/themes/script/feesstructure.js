$(document).ready(function() {
        	 
        	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
         
        	 $('#feestemplatelist').on( 'click', 'tr td a#edit', function () {
        		 
        		 var feestemplatestuctid = $(this).attr('data-id');
        		
        		 $.get(ctx+'/feestemplate/getFeesTemplate', {
        			 
        			feesTemplateStuctId : feestemplatestuctid
        			
        		 	}, function(response) {
      	        
        				var selectedValues=new Array();
      	        	
      	        		$.each(response.feesTemplateItems, function(key,value) 
      	        			{ 
      	        				selectedValues[key]=value.templateItemId;
      	        				
      	        			});
      	        		
      	        		$('#updateFeesStructure').attr('data-id',response.templateId);
      	        		$("[name=editStructure-name]").val(response.templateName); 
      	        		
      	        		$("#editTemplateItemList").val(selectedValues).trigger("change"); 
      	        		
      	        		/*$("[name=editTemplateItemList]").val(selectedValues);*/
      	        		});
       		});
        	 
        	 
        	//adding 
        	 $("#feesStructureSave").click(function(event){
        	 	$('#feestemplateform').validate({
        	 		ignore:null,
        	 		 errorPlacement: function ($error, $element) {
        	             var name = $element.attr("name");   	             
             	             $("#error" + name).append($error);
        	         }
        	 		
        	          
        	 	});
        		if($('#feestemplateform').valid()){
        	 			$("#feesStructureSaveConfirmation").modal('show');
        	 			$("#feesStructureConfirmSave").click(function(){
        		 			$('#feestemplateform').submit();
        		 			
        		 		});
        	 		}
        			return false;
  			 });
        	 
        	//deleting 
        	 $('#feestemplatelist').on( 'click', 'tr td a#delete', function () {   
        		   var feestemplatestuctid = $(this).attr('data-id');
        		   $('#deleteFeesStructureConfirmation').on('show.bs.modal', function (e) {
        				 $("#confirmFeesTemplateDelete").click(function(event) {
        					 $("#deleteFeesStructureId").val(feestemplatestuctid);
        					 $("#deleteFeesStructureForm").submit();
        				});
        				});
        		 	});
          	 
        	 $("#updateFeesStructure").click(function(event){
        		 var feesTemplateStuctId = $(this).attr('data-id');
        		 $("#updateFeesStructureId").val(feesTemplateStuctId);
        		 if($('#updateFeesStructureDetails').valid()){
       		  $('#saveConfirmation').modal('show');
       			$('#saveConfirm').click(function(){
       				$('#updateFeesStructureDetails').submit();
       			     });
        		 }
 			 });
             });
         
         /** date Picker**/
         $(document).ready(function () {
             $(".select2_single").select2({
                 placeholder: "Select a group",
                 allowClear: true
             });
             $(".select2_group").select2({});
             $(".select2_multiple").select2({
                 maximumSelectionLength: null,
                 placeholder: "Select Options",
                 allowClear: true
             });
         });
