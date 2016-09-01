$(document).ready(function() {
				//deleting course
	
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	 $('#courselist').on( 'click', 'tr td a#delete', function () {
        		   var courseid = $(this).attr('data-id');
        		   $("#confirm-delete").on('show.bs.modal', function (e) {
        			   $("#confirmcourseDelete").click(function() {
        				   $.ajax({
        					    url: ctx+'/course/delete',
        					    type: 'POST',
        					    data:{courseId:courseid},
        					    success: function(result) {
        					    	location.reload();
        					    }
        					});
        			   });
        			});
        		});
        	 
           	 
        	 $('#courselist').on( 'click', 'tr td a#edit', function () {
         		
        		 var courseid = $(this).attr('data-id');
      		
        		 $.get(ctx+'/course/get', {
      			
        			 courseId : courseid
   	       
        		 }, function(response) {
   	     
   	        	
        			 var selectedValues = new Array();
   	        	
   	        	
        			 $.each(response.courseCategories, function(key,value) 
        					 { 
						
        				 selectedValues[key]=value.courseCategoryId;
					
        					 });
   	        
   	        	
				
        			
        			 $("[name=editCourse_name]").val(response.courseName); 
        			 $("[name=EditDescription]").val(response.courseDescription); 
        			 $("[name=EditYears]").val(response.durationInYears); 
        			 $("[name=editSems]").val(response.durationInSemesters); 
        			 $("[name=editTotalSeats]").val(response.totalSeats); 
        			 $("[name=editCourseType]").find('option[value='+response.courseType.courseTypeId+']').attr('selected','selected');
        			 $("[name=editStatus]").find('option[value='+response.courseStatus+']').attr('selected','selected');
        			 $("[name=editSemestersystem]").find('option[value='+response.semesterSystem.semSystemId+']').attr('selected','selected');
        			 $("[name=editDepartment]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
        			 $('#updateCourse').attr('data-id',response.groupId);
        			 $("#editCoursecategory").val(selectedValues).trigger("change"); 
     
                
        			
   				
        		 });
        	
        	 });
        	//adding course
        	 $("#courseSave").click(function(event){
        	
        		 $('#newCourseForm').validate({
  				  submitHandler: function(form) {
        		  $("#courseSaveConfirmation").modal('show');
  	        		$("#courseSaveConfirm").click(function(){
  	        			 var data=$("#newCourseForm").serialize();
  	             		 $.post("course/add",data,function(data) {
  	             			window.location.href="course";
  	                      });
  	        		});
  			         return false;     
  			        }
  			 });	   
        		 
        	 });
        	
        	
        	
        	//Multiple Selection 
        	 $(".select2_single").select2({
                 placeholder: "Select a Option",
                 allowClear: true
             });
             $(".select2_group").select2({});
             $(".select2_multiple").select2({
                 maximumSelectionLength:null,
                 placeholder: "click here",
                 allowClear: true
             });
        	 
        	
         });

 /** Numbers Only**/
 function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	    	$("#newCourseForm").before(
     		        '<div class="alert alert-warning alert-dismissable">'+
     		            '<button type="button" class="close" ' + 
     		                    'data-dismiss="alert" aria-hidden="true">' + 
     		                '&times;' + 
     		            '</button>' + 
     		            'Numbers Only Allowed.' + 
     		            '</div>'+
     		         '</div>');
     	
     	window.setTimeout(function() {
     	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
     	        $(this).remove(); 
     	    });
     	},800);
	    	
	        return false;
	    }
	    return true;
	}
 
 function getSemesterSubset(){
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 var semesterSystemId= $("#semestersystem").val();
	 $.get(ctx+'/course/semesterSystemSubset/get',{semesterSystemId:semesterSystemId},function(response){
	  		$.each(response, function(index,semesterSystemSubset) {
	  			$("#semesterSubsetDropdown select").append(
	  					'<option value="'+semesterSystemSubset.semSystemSubsetId+'">'+semesterSystemSubset.semSystemSubsetTitle+'</option>');
     	  });
    });
 }
 function editSemesterSubset(){
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 var semesterSystemId= $("#editSemestersystem").val();
	 $.get(ctx+'/course/semesterSystemSubset/get',{semesterSystemId:semesterSystemId},function(response){
	  		$.each(response, function(index,semesterSystemSubset) {
	  			$("#editsemesterSubsetDropdown select").append(
	  					'<option value="'+semesterSystemSubset.semSystemSubsetId+'">'+semesterSystemSubset.semSystemSubsetTitle+'</option>');
     	  });
    });
 }
 
 
 /** MultiSelect**/
 function multiselect(){
		$(".select2_multiple").select2({
    		maximumSelectionLength: null,
    		placeholder: "Select modules for this semester",
    		allowClear: true
});
}
 