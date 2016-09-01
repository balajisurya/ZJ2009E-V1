         $(document).ready(function(){
        	 
        	 /*Semester System Close*/
             $("#semestersystemsub-systemclose").click(function(event){
             	  $("#semestersystemsub-systemcloseconfirmation").modal('show');
             		
             	 
             });
             
        	 /*Semeter System*/
             $("#semesterSystemSave").click(function(event){
           	  
           	  
           	  $('#semesterSystemSaveForm').validate();
           	  if($("#semesterSystemSaveForm").valid())
           		  {
           		  $("#semesterSystemSaveConfirmation").modal('show');
           		  
           		  $("#semesterSystemSaveConfirm").click(function(){
              			 
               			$('#semesterSystemSaveForm').submit();
           		  });
           		  }
             	  
             		 return false;
           	  
           	  
             	
             });
         
         	$("#NextButton").click(function(){
         		
         		var inp1 = $("#semestersystemtitle").val();
         		var inp2 =$("#ssperyear").val();
         		var inp3 =$("#status").val(); 
         		
         	 if ((jQuery.trim(inp1).length && jQuery.trim(inp2).length && jQuery.trim(inp3).length) > 0){
         		current_fs = $('#firststepforsemestersystem');
         		next_fs = $('#secondstepforsemestersystem');
         		next_fs.show(); 
         		current_fs.hide();
         		
         		var yearCount=$("#ssperyear").val();
         
          		 for(i=1;i<=yearCount;i++){
          			
          			 $("#semesterSystemSubset").append(
          					'<div id="ssid"class="form-group">'
                            +'<label for="" class="col-sm-3 control-label">System Subset '+i+'<span class="at-required-highlight">*</span></label>' 
                            +'<div class="col-sm-6">' 
                               +'<input type="text" name="subset'+[i]+'" class="form-control" id="subset'+i+'" placeholder="" required="required">'
                            +'</div>'
                         +'</div>'); 
          		 }
         	
       
         		}
         		
         		else{
           		  
         	         
         		    $("#semesterSystemSaveForm").before(
         		        '<div class="alert alert-danger alert-dismissable">'+
         		            '<button type="button" class="close" ' + 
         		                    'data-dismiss="alert" aria-hidden="true">' + 
         		                '&times;' + 
         		            '</button>' + 
         		            'Please enter the input Or valid input to corresponding fields...' + 
         		            '</div>'+
         		         '</div>');
         		} 
         	window.setTimeout(function() {
         	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
         	        $(this).remove(); 
         	    });
         	},2000);
         
         });
         
         	
         
         	$('#BackButton').click(function(){
             	current_fs = $('#secondstepforsemestersystem');
             	next_fs = $('#firststepforsemestersystem');
             	next_fs.show(); 
             	current_fs.hide();
             	 $('#semesterSystemSubset #ssid').remove();
             }); 
         	
         	
         
         
         });
        
    	 
    	   