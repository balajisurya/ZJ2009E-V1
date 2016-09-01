$(document).ready(function() {
        	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
        	 //deleting course

	 $('#modulelist').on( 'click', 'tr td a#delete', function () {
        		   var moduleid = $(this).attr('data-id');
        		   $('#confirm-delete').on('show.bs.modal', function (e) {
        			   $('#confirmDeleteModule').attr("href", "module/delete?moduleId="+moduleid);
        			});
        		   
        		});
        	 
        	 
        	 $('#modulelist').on( 'click', 'tr td a#edit', function () {
      		   var moduleid = $(this).attr('data-id');
      		
      		   $.get(ctx+'/course/module/get', {
      			 moduleId : moduleid
    	        }, function(response) {
    	        	
    	        	var has=null;
    	        	
    	        	if(response.hasExam==true)
    	        	{has=1;}
    	        	else
    	        	{has=0;}
    	        	
    	        	$("[name=editModule-name]").val(response.moduleName);
    	        	$("[name=editModule-credit]").val(response.moduleCredit);
    	        	$("[name=editTotalHours]").val(response.totalHours);
    	        	$('#updateValid').attr('data-id',response.moduleId);
    				$("[name=editHasExam]").find('option[value='+ has+']').attr('selected','selected');	   	
    			/*	$("[name=editModuleType]").find('option[value='+ response.moduleType +']').attr('selected','selected');*/
    				$("[name=editModuleType]").val(response.moduleType);
    	        });
      		 });
        	//adding course
        	 $("#modulevalid").click(function(event){
        
        		 
         $('#newModuleForm').validate({
  			submitHandler: function(form) {
  				$('#confirm-save').modal('show');
  	        		$('#confirmModuleSave').click(function(){
  	             		 var data=$('#newModuleForm').serialize();
  	             		
  	        					$.post("module/add",data,function(data){
  	        						window.location.href="module";
  	        					});
  	             	});
  	        		
  			       return false;     
  			       }
  		 });	   
        		 
        	 });
        	 
        	 
        	 $("#updateValid").click(function(event){
        		 var moduleId = $(this).attr('data-id');
        		 $('#confirm-save').modal('show');
	        		$('#confirmModuleSave').click(function(){
       				var data=$('#ediModuleForm').serialize();
       			  	$.post("module/update?moduleId="+moduleId,data,function(data) 
 	        						{
 	        					window.location.href="module";
 	                 });
 	               });
 			 });
        	 
        	 
        	 
        	
         });
    
    
      
      
     
      
      
  