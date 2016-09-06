$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	 $('#academicYear').change(function(event) {
		    var academicYearId= $("#academicYear").val();
	  	    $.get(ctx+'/academicYear/academicFeesTermsByacademicYear', {
	  	    	academicYearId : academicYearId
	        }, function(response) {
	        	  var select = $('#feesTermId');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Terms</option>');
	   	        	    	}
	            		 $('<option>').val(value.academicYearFeesTermId).text(value.feesTermTitle).appendTo(select);
	            	  
	            	 }); 
	        });
	       
	 });
	 
	 
	 $('#studentListTable').DataTable({
    	 dom: 'Bfrtip',
         buttons: [
             'csv', 'excel', 'pdf', 'print'
         ]
	 });	
	
	 $("#getStudentList").click(function(){
		 if($("#getStudentDetailsForm").valid()){
			 $('.loader').show();
			 var academicYear=$("#academicYear").val();
			 var feesTermId=$("#feesTermId").val();
			 
			 $.get(ctx+'/report/termFeesReport/students', {
		  	    	academicYear : academicYear,feesTermId:feesTermId
		        }, function(response) {
		        	 $('.loader').hide();
		        	  document.getElementById('studentList').style.display="block";
		        	var datatable = $('#studentListTable').DataTable();
		        	 $(".form-horizontal").trigger('reset'); 
						      datatable.clear().draw();
						  $.each(response, function (i, item) {
							  if(item!=null){
								  var name;
						        	if(item.lastName!=null){
						        		name=item.firstName+' '+item.lastName;
						        	}else{
						        		name=item.firstName;
						        	}
						        datatable.row.add([item.admissionNo,name,item.studentClass.className,item.section.sectionName,item.specialCategory.specialCategoryName]).draw( false );
							  }
							 });
		        });
			
		 }
	 });
});