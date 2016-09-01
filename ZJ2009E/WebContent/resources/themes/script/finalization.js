$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	
	 $('#shortcandidateForm').validate({
		   submitHandler: function(form) {
			  
				    $.ajax(	
				    {
				        type: "GET",
				        url: ctx+'/admissions/finalization/applyAdmssionRule',
				        data: $("#shortcandidateForm").serialize(),
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        cache: false,
				        success: function (data) {
				        	var datatable = $('#datatable').DataTable();
				        	 $(".form-horizontal").trigger('reset'); 
				        	datatable.row('.even').remove().draw( false );  
				        	datatable.row('.odd').remove().draw( false );  
							
							if (!$.trim(data)){ 
							 	
								datatable.row('.even').remove().draw( false );  
								datatable.row('.odd').remove().draw( false );  
						 		
						 	}
							else
						 	{
								
				        $.each(data, function (i, item) {
				            
				        	datatable.row.add(  [item.admissionCode,item.candidateFirstName+"/"+item.candidateLastName,item.dateOfBirth,item.candidateGender,item.admissionRank,'<input type="checkbox" name="admissionId" class="case" id='+item.admissionId+'></input>'] ).draw( false );
				        });
				        
						 	}
				        
				        }
				      
				    });
					
       
    		
	        return false;     
	     }
	  });	   
 
	 $('#list').click(function() {
		 var selectedAdmissionCandidates = [];
		  $.each($(".case:checked"), function(){            
			  selectedAdmissionCandidates.push($(this).attr('id'));
	         });
		  
		  $.post("finalization/intimateSelectCandidate?selectedAdmissionCandidates="+selectedAdmissionCandidates,function(){
			  location.reload();
		  });
		   
			 
		   
		});
	 
	 
	 /*$('#list').click(function() {
         var generatelist = [];

         $.each($(".case:checked"), function(){            

        	 generatelist.push($(this).attr('id'));

         });

         alert(generatelist);
	 
	 });*/
});
function select_all() {
	$('input[class=case]:checkbox').each(function(){ 
		if($('input[class=check_all]:checkbox:checked').length == 0){ 
			$(this).prop("checked", false); 
		} else {
			$(this).prop("checked", true); 
		} 
	});
}
