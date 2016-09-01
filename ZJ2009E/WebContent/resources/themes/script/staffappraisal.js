 $(document).ready(function() {
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 var staId=null;
	 $('#getStaffPerformance').click(function(event) {
		 
  		 var data=$('#getDetails').serialize();
			var status=null;
			staId=$('#getStaffId').val();
				$.post(ctx+"/staff/getStaffPerformanceList",data,function(data) {
				
					
					
					var t = $('#datatable').DataTable();
					
					t.row('.even').remove().draw( false );  
					t.row('.odd').remove().draw( false );  
					
					if (!$.trim(data)){ 
					 	
						t.row('.even').remove().draw( false );  
						t.row('.odd').remove().draw( false );  
				 		
				 	}
					else
				 	{
					    $.each(data, function(key,value) 
				 			{
				 			 if(value.appraisalStatus==1)
							 {
								status="Completed";
							 }
							 else 
							 {
								status="In-Process";
							 }
				 			 t.row.add( [
								            value.staffPerformanceId ,
								            value.appraisalTerm ,
								            status ,
								            '<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.staffPerformanceId+' data-toggle="modal" onclick="showeditDiv();" ><span class="glyphicon glyphicon-edit"></span> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.staffPerformanceId+' data-target="#confirm-delete"><span class="glyphicon glyphicon-trash"></span></a>'
								        ] ).draw( false );
				 			});
					    
				   
				 	}
			
			});
		});
	 
	   	 $("#addStaffAppraisal").click(function(event){
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
        	$('#addAppraisal').submit();		
			});
               });
	
	 
  	 $("#updateStaffAppraisal").click(function(event){
  		 $('#saveConfirmation').modal('show');
  		 var staffPerformanceId = $(this).attr('data-id');
			$('#saveConfirm').click(function(){
				var data=$('#editAppraisal').serialize();	
        	$.post(ctx+"/staff/updateStaffPerformance?staffPerformanceId="+staffPerformanceId,data,function(data) {
					window.location.href=ctx+"/staff/staffappraisal";       				
      });
			});
               });
 	 
	
	 
  	$(document).on('click',".edit",function (){   
  		var staffPerformanceId = $(this).attr('data-id');
  		
  	      $.get(ctx+'/staff/editStaffPerformance', {
  	    	  staffPerformanceId : staffPerformanceId
  	      }, function(response) {   
  	    	 
  	      		$("[name=editStaffId]").val(staId);
  				$("[name=editAppraisalTerm]").val(response.appraisalTerm);
  				$("[name=editRelationshipRating]").find('option[value='+response.relationshipRating+']').attr('selected','selected');
  				$("[name=editRelationshipComments]").val(response.relationshipComments);
  				$("[name=editTeachingRating]").find('option[value='+response.teachingRating+']').attr('selected','selected');
  				$("[name=editTeachingComments]").val(response.teachingComments);
  				$("[name=editResearchAndHigherQualificationRating]").find('option[value='+response.researchAndHigherQualificationRating+']').attr('selected','selected');
  				$("[name=editResearchAndHigherQualificationComments]").val(response.researchAndHigherQualificationComments);
  				$("[name=editInitiativeAndOrganizationRating]").find('option[value='+response.initiativeAndOrganizationRating+']').attr('selected','selected');
  				$("[name=editInitiativeAndOrganizationComments]").val(response.initiativeAndOrganizationComments);
  				$("[name=editInnovationRating]").find('option[value='+response.innovationRating+']').attr('selected','selected');
  				$("[name=editInnovationComments]").val(response.innovationComments);
  				$("[name=editPunctualityRating]").find('option[value='+response.punctualityRating+']').attr('selected','selected');
  				$("[name=editPunctualityComments]").val(response.punctualityComments);
  				$("[name=editGoalAlignmentRating]").find('option[value='+response.goalAlignmentRating+']').attr('selected','selected');
  				$("[name=editGoalAlignmentcomments]").val(response.goalAlignmentComments);
  				$("[name=editRecommendations]").val(response.recommendations);
  				$("[name=editAppraisalStatus]").find('option[value='+response.appraisalStatus+']').attr('selected','selected');
  			    $('#updateStaffAppraisal').attr('data-id',response.staffPerformanceId);
  	      	
  	      });
  		 });
  
  	$(document).on('click',".delete",function (){   
  		var staffPerformanceId = $(this).attr('data-id');
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				 $.get(ctx+'/staff/deleteStaffPerformance', {
		  	    	  staffPerformanceId : staffPerformanceId
		  	      }, function(response) {   
		  	    	window.location.href=ctx+"/staff/staffappraisal";     
		  	      });
			});
    	  
  		 });
  
  	
         });


 
 