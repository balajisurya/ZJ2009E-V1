$(document).ready(function() {
	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	   $('#example-select-all').on('click', function(){
		      // Check/uncheck all checkboxes in the table
		   var datatable = $('#studentList').DataTable();
		      var rows = datatable.rows({ 'search': 'applied' }).nodes();
		      $('input[type="checkbox"]', rows).prop('checked', this.checked);
		      
		      
		      
		      
		      
		   });
	   $('#studentList').on('change', 'input[type="checkbox"]', function(){
		      // If checkbox is not checked
		      if(!this.checked){
		         var el = $('#example-select-all').get(0);
		         // If "Select all" control is checked and has 'indeterminate' property
		         if(el && el.checked && ('indeterminate' in el)){
		            // Set visual state of "Select all" control 
		            // as 'indeterminate'
		            el.indeterminate = true;
		         }
		      }
		    
		   
		   });
	
	 $('#class').change(function(event) {
	  	    var classId = $("#class").val();
	  	    $.get(ctx+'/class/sectionsOfClass', {
	                classId : classId
	        }, function(response) {
	        	  var select = $('#section');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
	   	        	    	}
	            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
	            	  
	            	 }); 
	        });
	       
	 });
		
	 $('#joinedClass').change(function(event) {
	  	    var classId = $("#joinedClass").val();
	  	    $.get(ctx+'/class/sectionsOfClass', {
	                classId : classId
	        }, function(response) {
	        	  var select = $('#joinedSection');
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
	   	        	    	}
	            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
	            	  }); 
	        });
	       
	 });
	 
	 
	 $('#studentDataExcel').click(function(){
		 if($("#getDetails").valid())
		 {
			 var url=ctx+'/student/excelDownload';
			 $('#getDetails').attr('action',url).submit(); 
		 }
			
		 
	 });
	 
	 $('#studentBulkUpdateSave').click(function(){
		 if($("#studentBulkUpdateForm").valid())
		 {
			 $("#studentBulkUpdateForm").submit();
		 }
	 });
	 
	 $("#getDetailsFromSelectedCriteria").click(function(event){
		 if($("#getDetails").valid())
			 {
			 $('.loader').show();
			 	var data=$('#getDetails').serialize();
			 	$.ajax(	
			 	{
			        type: "GET",
			        url:ctx+"/student/editReterive" ,
			        data: data,
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success: function (data) {
			        	 $('.loader').hide();
			        	var datatable = $('#studentList').DataTable();
			        	$(".form-horizontal").trigger('reset');
			        	 
						
			        	datatable.clear().draw();
						
						
							$.each(data, function (i, value) {
								var name;
								if(value.lastName!=null){
									
									name=value.firstName +' '+value.lastName;
								}
								else{
									name=value.firstName;
								}
								 datatable.row.add(['<input type="checkbox" value='+value.studentId+' name="studentId" class="case" id='+value.studentId+'></input>',value.admissionNo,name,value.contact,value.parentContact,value.specialCategory.specialCategoryName,'<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.studentId+' data-toggle="modal" onclick="showeditDiv();" ><span class="glyphicon glyphicon-edit"></span> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.studentId+' data-toggle="modal" data-target="#confirm_delete_std"><span class="glyphicon glyphicon-trash"></span></a>']).draw( false );
								});
			         	
			        },
			 	 	error:function(){
			 	 		$('.loader').hide();
			        	$(".form-horizontal").trigger('reset'); 
			 	    }
		      
			 	});
			  }
		  });	   
      
		//edit		 
		 $('table tbody').on( 'click', 'tr td a#edit', function () {
			 var studentId = $(this).attr('data-id');
		  		
	  	      $.get(ctx+'/student/editStudentDetailsRetreive', {
	  	    	studentId : studentId
	  	      }, function(response) {  
	  	    	 $('#updateStudent').attr('data-id',response.studentId);
	  				$("[name=editAdmissionNo]").val(response.admissionNo);
	  				$("[name=editFirstName]").val(response.firstName);
	  				$("[name=editLastName]").val(response.lastName);
	  				$("[name=editRollNo]").val(response.rollNo);
	  				$("[name=editParentOrGuardianFirstName]").val(response.parentGuardianFirstName);
	  				$("[name=editParentOrGuardianLastName]").val(response.parentGuardianLastName);
	  				$("[name=editParentOrGuardianEmail]").val(response.parentGuardianEmail);
	  				 if(response.sex!=null)
	  				 {
	  					 $("[name=editStudentGender]").val(response.sex);
	  				 }
	  				 if(response.category!=null)
	  				 { 
							$("[name=editCategoryId]").val(response.category.categoryId);
					 }
	  				if(response.specialCategory!=null)
	  				 { 
	  					$("[name=editSpecialCategoryId]").val(response.specialCategory.specialCategoryId);
	  				 }
	  				if(response.birthDate!=null)
	  				{
	  					$("[name=editDateOfBirth]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.birthDate)));
	  				}
	  				else
	  				{
	  					$("[name=editDateOfBirth]").val('');
	  				}
	  			
	  				$("[name=editEMail]").val(response.email);
	  				$("[name=editContact]").val(response.contact);
	  				$("[name=editParentContact]").val(response.parentContact);
	  				$("[name=editFatherIncome]").val(response.fathersIncome);
	  				$("[name=editMotherIncome]").val(response.mothersIncome);
	  				$("[name=editAddressLine1]").val(response.addressLine1);
	  				$("[name=editAddressLine2]").val(response.addressLine2);
	  				if(response.countryId!=null)
	  				 { 
	  					$("[name=editCountryId]").val(response.countryId);
	  				 }
	  				if(response.stateId!=null)
	  				 { 
	  					$("[name=editStateId]").val(response.stateId);
	  					$("#geographicallocationstate").prop('disabled', 'disabled');
	  				 }
	  				else
	  				{
	  					$("#geographicallocationstate").prop('disabled', 'disabled');	
	  				}
	  				if(response.cityId!=null)
	  				 { 
	  					$("[name=editCityId]").val(response.cityId);
	  					$("#geographicallocationcity").prop('disabled', 'disabled');
	  				 }
	  				else
	  				{
	  					$("#geographicallocationcity").prop('disabled', 'disabled');
	  				}
	  				$("[name=editPostCode]").val(response.postcode);
	  				if(response.studentClass!=null)
	  				 { 
	  					$("[name=editJoinedClass]").val(response.studentClass.classId);
	  				 }
	  				if(response.section!=null)
	  				 { 
	  					$("[name=editJoinedSection]").val(response.section.sectionId);
	  				 }
	  				if(response.joinedAcademicYear!=null)
	  				 { 
	  					$("[name=editAcademicYearId]").val(response.joinedAcademicYear.academicYearId);
	  				 }
	  				if(response.studentStatus!=null){
	  					$("[name=editStudentStatus]").val(response.studentStatus.studentStatusId);
	  				}
	  				
	  				$("[name=editJoinedDate]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.joinedDate)));
	  				$("[name=editStudentAccessNo]").val(response.accessNo);
	  				$("[name=editPassportNo]").val(response.passportNumber);			
	  				if(response.bloodGroup!=null)
	  				 { 
	  					$("[name=editBloodGroupId]").val(+response.bloodGroup.bloodGroupId);
	  				 }
	  							
	  				 $("#studentImage").attr('src',".."+response.photoPath); 
	  	      });
			
	 });
		 
//delete	
		 $('table tbody').on( 'click', 'tr td a#delete', function () {	 
			 var studentid = $(this).attr('data-id');
			 $("#deleteStudentId").val(studentid);
			 $('#confirm_delete_std').on('show.bs.modal', function (e) {
				 $("#deleteStdConfirm").click(function(event) {
						$("#deleteStudentIdForm").submit();
				 		});
					});
				
		   		});
		 
	//update code

	$("#updateStudent").click(function(event){
		$("#updateStudentId").val( $(this).attr('data-id'));
		 $('#geographicallocationstate').attr('disabled', false);
		 $('#geographicallocationcity').attr('disabled', false);
			if($("#editStudentForm").valid())
			{
			 $('#updateConfirmation').modal('show');
    			$('#updateConfirm').click(function(){
    				$("#editStudentForm").submit();
    			});
			}	
	});  
	
	
	$('#deleteStudents').click(function() {
		
		if($("#deleteStudentForms").valid()){
			 var selectedstudentid = [];
			
			 var oTable = $('#studentList').dataTable();
			 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
			 rowcollection.each(function(index,elem){
			     selectedstudentid.push($(elem).val());
			 });
			
		 $("#selectedStudentIds").val(selectedstudentid);	  
			
				if((selectedstudentid.length)>0)
				 {
					 $('#bulkConfirmation').modal('show');
		    			$('#bulkConfirm').click(function(){
				$("#deleteStudentForms").submit();
		    			});
				 }
				 else{
					 alert(" You have to select atleast one student for delete ")
				 }
		
			   }  
		  });
	
	
            });
