$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	 
        	 
        	 
        	
        	
        //add academic year
          $("#academicYearSave").click(function(event){
        	  
        	  $('#academicYearSaveForm').validate();
        	  if($("#academicYearSaveForm").valid())
        		  {
        		  $("#academicYearSaveConfirmation").modal('show');
        		  
        		  $("#academicYearSaveConfirm").click(function(){
           			 
            			$('#academicYearSaveForm').submit();
        		  });
        		  }
          	  
          		 return false;
          });
         
          
          /*Academic Year Close*/
          $("#academicyearclose").click(function(event){
          	  $("#academicyearcloseconfirmation").modal('show');
          	  $("#confirmAcademicYearClosing").click(function(){
          		  var academicYearId=$("#academicyearclose").val();
	          		 $.post(ctx+"/academic/academicyear/close",{academicYearId:academicYearId},function() {
	          			location.reload();
	          		   
	                  });
          		});
          });
          
         
        
          $(".select2_multiple").select2({
              maximumSelectionLength:null,
              placeholder: "click here",
              allowClear: true
          });
          
});
    

$(document).ready(function() {
	  
    
        
     	$("#nextButtonacademicyear").click(function(){
     		var inp1 = $("#academicYearName").val();
     		var inp2 =$("#academicYearStartEndDate").val();
     		var inp3 =$("#academicYearWorkingDays").val(); 
     		var inp4 =[];
     		inp4=$("#semesterSystems").val(); 
     	 if ((jQuery.trim(inp1).length && jQuery.trim(inp2).length && jQuery.trim(inp3).length && jQuery.trim(inp4).length) > 0){
     		current_fs = $('#firststep');
     		next_fs = $('#secondstep');
     		next_fs.show(); 
     		current_fs.hide();
     		
         for(i=0;i<inp4.length;i++){
      			 $("#semestersystemsubsetforacademicyear").append('<div class="test" id="semesterSystemSubset'+(i+1)+'">'
      					+'<div class="form-group">'
                        +'<label for="" id="semesterSystemLabel" class="col-sm-3 control-label">System Subset</label>' 
                        +'<div class="col-sm-6">' 
                        +'<select name="semesterSystemSubsets'+[i]+'" id="semesterSystemSubsets'+[i]+'" class="form-control1" required="required">'
                        +'<option value="" disabled selected>Select Current Subset</option>'
                    +'</select>' 
                        +'</div>'
                     +'</div>'); 
      			 var subsetDropdownId="#semesterSystemSubset"+(i+1);
      			 getSemesterSubset(subsetDropdownId,inp4[i]);
      		 }
     	
   
     		}
     		
     		else{
       		  
     	         
     		    $("#academicYearSaveForm").before(
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
     
     	
     
     	$('#academicYearBackButton').click(function(){
         	current_fs = $('#secondstep');
         	next_fs = $('#firststep');
         	next_fs.show(); 
         	current_fs.hide();
         	 $('#semestersystemsubsetforacademicyear .test').remove();
         }); 
     	
     	
     
     
     });
    
/*'<option value="'+semesterSystemSubset.semSystemSubsetId+'">'+semesterSystemSubset.semSystemSubsetTitle+'</option>'*/

function getSemesterSubset(subsetDropdownId,semesterSystemId){
	 $.get('semesterSystem/getSubsetBySemesterSystem',{semesterSystemId:semesterSystemId},function(response){
				 $.each(response, function(index,semesterSystemSubset) {
					 $(subsetDropdownId+" #semesterSystemLabel").text(semesterSystemSubset.semesterSystem.semSystemTitle);
					 $(subsetDropdownId+" select").append(
							 '<option value="'+semesterSystemSubset.semSystemSubsetId+'">'+semesterSystemSubset.semSystemSubsetTitle+'</option>');
			  	  });
	      });
}

 
