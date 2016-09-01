 $(document).ready(function() {
	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 var stuId=null;
	 
	 $('#getStudentPerformance').click(function(event) {
		
		var data=$('#getDetails').serialize();
		 var status=null;
			stuId=$('#getStudentId').val();
			
				$.post(ctx+"/student/getStudentPerformanceList",data,function(data) {
					
					var t = $('#datatable').DataTable();
						t.row('.even').remove().draw(false );  
						t.row('.odd').remove().draw(false );  
					
					if (!$.trim(data))
					{ 
						t.row('.even').remove().draw(false);  
						t.row('.odd').remove().draw(false);  
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
								            value.studentPerformanceId ,
								            value.appraisalTerm ,
								            status ,
								            '<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.studentPerformanceId+' data-toggle="modal" onclick="showeditDiv();" ><span class="glyphicon glyphicon-edit"></span> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.studentPerformanceId+' data-target="#confirm-delete"><span class="glyphicon glyphicon-trash"></span></a>'
								        ] ).draw( false );
				 		});
					    
				   
				 	}
				 
				    
					   });
		});
	 
	   	 $("#addStudentAppraisal").click(function(event){
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
        	$('#appraisal').submit();		
			});
               });
	
	 
  	 $("#updateStudentAppraisal").click(function(event){
  		 $('#saveConfirmation').modal('show');
  		 var studentPerformanceId = $(this).attr('data-id');
			$('#saveConfirm').click(function(){
				var data=$('#editAppraisal').serialize();	
        	$.post(ctx+"/student/updateStudentPerformance?studentPerformanceId="+studentPerformanceId,data,function(data) {
					window.location.href=ctx+"/student/studentappraisal";       				
      });
			});
               });
 	 
	
	 
  	$(document).on('click',".edit",function (){   
  		var studentPerformanceId = $(this).attr('data-id');
  		
  	      $.get(ctx+'/student/editStudentPerformance', {
  	    	  studentPerformanceId : studentPerformanceId
  	      }, function(response) {   
  	      		$("[name=editStudentId]").val(stuId);
  				$("[name=editAppraisalTerm]").val(response.appraisalTerm);
  				$("[name=editRelationshipRating]").find('option[value='+response.relationshipRating+']').attr('selected','selected');
  				$("[name=editRelationshipComments]").val(response.relationshipComments);
  				$("[name=editAttitudeRating]").find('option[value='+response.attitudeRating+']').attr('selected','selected');
  				$("[name=editAttitudeComments]").val(response.attitudeComments);
  				$("[name=editAcademicRating]").find('option[value='+response.academicRating+']').attr('selected','selected');
  				$("[name=editAcademicComments]").val(response.academicComments);
  				$("[name=editInitiativeRating]").find('option[value='+response.initiativeRating+']').attr('selected','selected');
  				$("[name=editInitiativeComments]").val(response.initiativeComments);
  				$("[name=editCreativityRating]").find('option[value='+response.creativityRating+']').attr('selected','selected');
  				$("[name=editCreativityComments]").val(response.creativityComments);
  				$("[name=editPunctualityRating]").find('option[value='+response.punctualityRating+']').attr('selected','selected');
  				$("[name=editPunctualityComments]").val(response.punctualityComments);
  				$("[name=editSportsAndSocialRating]").find('option[value='+response.sportsAndSocialRating+']').attr('selected','selected');
  				$("[name=editSportsAndSocialComments]").val(response.sportsAndSocialComments);
  				$("[name=editRecommentation]").val(response.recommendations);
  				$("[name=editAppraisalStatus]").find('option[value='+response.appraisalStatus+']').attr('selected','selected');
  			    $('#updateStudentAppraisal').attr('data-id',response.studentPerformanceId);
  	      	
  	      });
  		 });
  
  	$(document).on('click',".delete",function (){   
  		var studentPerformanceId = $(this).attr('data-id');
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				 $.get(ctx+'/student/deleteStudentPerformance', {
		  	    	  studentPerformanceId : studentPerformanceId
		  	      }, function(response) {   
		  	    	window.location.href=ctx+"/student/studentappraisal";     
		  	      });
			});
    	  
  		 });
  
  	
         });


 
 