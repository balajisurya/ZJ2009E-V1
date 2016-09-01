 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 $( "#admissionId").change(function() {
		  var admissionId = $("#admissionId").val();
 	        $.get(ctx+'/admissions/getAdmission', {
 	        	admissionId : admissionId
 	        }, function(response) {
 	
 	        	
 	        	$("[name=firstName]").val(response.candidateFirstName);
 	        	$("[name=lastName]").val(response.candidateLastName);
 	        	$("[name=parentOrGuardianFirstName]").val(response.fatherFirstName);
 	        	$("[name=parentOrGuardianLastName]").val(response.fatherLastName);
 	        	$("[name=dateOfBirth]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.dateOfBirth)));
 	        	$("[name=eMail]").val(response.candidateEmail);
 	        	$("[name=contact]").val(response.candidateContactNo);
 	        	$("[name=fatherIncome]").val(response.fatherIncome);
 	        	$("[name=motherIncome]").val(response.motherIncome);
 	        	$("[name=addressLine1]").val(response.candidateAddressLineOne);
 	        	$("[name=addressLine2]").val(response.candidateAddressLineTwo);
 	        	$("[name=postCode]").val(response.candidatePostcode);
 	        	$("[name=passportNo]").val(response.passportNo);
 	        	/*$("[name=bankName]").val(response.);
 	        	$("[name=bankAccountNo]").val(response.);
 	        	$("[name=bankIFSCCode]").val(response.);	
 	        	$("[name=bankAddress]").val(response.);
 	        	$("[name=tallyAccountNo]").val(response.);    	
 	        	$("[name=batch]").val(response.);
 	        	$("[name=joinedDate]").val(response.);
 	        	$("[name=achievement]").val(response.);
 	        	$("[name=allergy]").val(response.);
 	        	$("[name=medicineAllergy]").val(response.);*/
 	        	$("[name=studentGender]").find('option[value='+response.candidateGender+']').attr('selected','selected');
 	        	$("[name=categoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
 	        	$("[name=specialCategoryId]").find('option[value='+response.specialCategory.specialCategoryId+']').attr('selected','selected');
 	        	$("[name=countryId]").find('option[value='+response.candidateCountry+']').attr('selected','selected'); 	
 	        	$("[name=stateId]").find('option[value='+response.candidateState+']').attr('selected','selected');
 	        	$("[name=cityId]").find('option[value='+response.candidateCity+']').attr('selected','selected');
 	        	$("[name=courseTypeId]").find('option[value='+response.courseType.courseTypeId+']').attr('selected','selected');
 	        	$("[name=courseCategoryId]").find('option[value='+response.courseCategory.courseCategoryId+']').attr('selected','selected');
 	        	$("[name=departmentId]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
 	        	$("[name=courseId]").find('option[value='+response.course.courseId+']').attr('selected','selected');
 	        	/*$("[name=feesTemplateListId]").find('option[value='+response.+']').attr('selected','selected');
 	        	$("[name=bloodGroupListId]").find('option[value='+response.+']').attr('selected','selected');
 	        	$("[name=atRiskCategory]").find('option[value='+response.+']').attr('selected','selected');
 	        	$("[name=scholarShip]").find('option[value='+response.+']').attr('selected','selected');
 	        	$("[name=ategoryId]").find('option[value='+response.+']').attr('selected','selected');
 	        	$("[name=studentStatus]").find('option[value='+response.+']').attr('selected','selected');*/
 	        	
 	        	
 	        	
 	        });
		});
	 
	  $('#studentList td a#edit').click(function() {
		  
		  var studentId = $(this).attr('data-id');
		  if(document.getElementById('EditFormDiv').style.display=="none")
			{
			document.getElementById('EditFormDiv').style.display="block";
			document.getElementById('ListDiv').style.display="none";
			
     	        $.get(ctx+'/student/editAdmission', {
     	        	studentId : studentId
     	        }, function(response) {
     	        	
     	        	$("[name=editFirstName]").val(response.firstName);
     	        	$("[name=editLastName]").val(response.lastName);
     	        	$("[name=editParentOrGuardianFirstName]").val(response.parentGuardianFirstName);
     	        	$("[name=editParentOrGuardianLastName]").val(response.parentGuardianLastName);
     	        	$("[name=editDateOfBirth]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.birthDate)));
     	        	$("[name=editParentOrGuardianEmail]").val(response.parentGuardianEmail);
     	        	$("[name=editEMail]").val(response.email);
     	        	$("[name=editContact]").val(response.contact);
     	        	$("[name=editFatherIncome]").val(response.fathersIncome);
     	        	$("[name=editMotherIncome]").val(response.mothersIncome);
     	        	$("[name=editAddressLine1]").val(response.addressLine1);
     	        	$("[name=editAddressLine2]").val(response.addressLine2);
     	        	$("[name=editPostCode]").val(response.postcode);
     	        	$("[name=editPassportNo]").val(response.passportNumber);
     	        	$("[name=editBankName]").val(response.bankName);
     	        	$("[name=editBankAccountNo]").val(response.bankAccountNo);
     	        	$("[name=editBankIFSCCode]").val(response.bankIfsc);	
     	        	$("[name=editBankAddress]").val(response.bankAddress);
     	        	$("[name=editTallyAccountNo]").val(response.tallyAccountNo);    	
     	        	$("[name=editBatch]").val(response.batch);
     	        	$("[name=editCurrentSemester]").val(response.currentSemester);
     	        	$("[name=editJoinedSemester]").val(response.joinedSemester);
     	        	$("[name=editJoinedDate]").val(response.joinedDate);
     	        	$("[name=editAchievement]").val(response.achievement);
     	        	$("[name=editAllergy]").val(response.allergy);
     	        	$("[name=editStudentAccessNo]").val(response.accessNo);
     	        	$("[name=editMedicineAllergy]").val(response.medicineAllergy);
     	        	$("[name=editMyStrength]").val(response.myStrengths);
     	        	$("[name=editStudentGender]").find('option[value='+response.sex+']').attr('selected','selected');
     	        	$("[name=editCategoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
     	        	$("[name=editSpecialCategoryId]").find('option[value='+response.specialCategory.specialCategoryId+']').attr('selected','selected');
     	        	$("[name=editCountryId]").find('option[value='+response.countryId+']').attr('selected','selected'); 	
     	        	$("[name=editStateId]").find('option[value='+response.stateId+']').attr('selected','selected');
     	        	$("[name=editCityId]").find('option[value='+response.cityId+']').attr('selected','selected');
     	        	$("[name=editScholarShip]").find('option[value='+response.scholarship+']').attr('selected','selected');
     	        	$("[name=editCourseTypeId]").find('option[value='+response.courseType.courseTypeId+']').attr('selected','selected');
     	        	$("[name=editCourseCategoryId]").find('option[value='+response.courseCategory.courseCategoryId+']').attr('selected','selected');
     	        	$("[name=editDepartmentId]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
     	        	$("[name=editCourseId]").find('option[value='+response.courses.courseId+']').attr('selected','selected');
     	        	$("[name=editApproverId]").find('option[value='+response.approver.userId+']').attr('selected','selected');
     	        	$("[name=editStudentStatus]").find('option[value='+response.studentStatus.studentStatusId+']').attr('selected','selected');
     	        	$("[name=editBloodGroupListId]").find('option[value='+response.bloodGroup.bloodGroupId+']').attr('selected','selected');
     	        	$("[name=editAtRiskCategory]").find('option[value='+response.atRiskCategory+']').attr('selected','selected');
     	        	
     	        	
     	        	/*$("[name=editFeesTemplateListId]").find('option[value='+response.+']').attr('selected','selected');*/
     	        });
			}
     	 });
	 
	 
      $("#studentValid").click(function(event){
    	  
    	  $('#saveStudentDetails').validate();
    	  if( $('#saveStudentDetails').valid()){
    		  
    		  $('#confirm-save').modal('show');	
        	  $('#confirmSave').click(function(){
        	
        		  $("#saveStudentDetails").submit();
        		
             	 }); 
    		  
    	  }
    	  return false;
    	  	 });
      

	  
	  $('#studentList td a#delete').click(function() {
		  
		  var studentId = $(this).attr('data-id');
		  $('#confirm-save').modal('show');	
	 	  $('#confirmSave').click(function(){
	 		 var data=$(this).attr('data-id');
		 $.post(ctx+"/student/deleteAdmission?studentId="+studentId,data,function(data) {
				window.location.href=ctx+"/admissions/newadmission";    
		   });
	 	  });
	  
		    });
      
 
             $('#countryId').change(function(event) {
           	  
     	        var countryid = $("#countryId").val();
     	        $.get(ctx+'/geographicallocation/state', {
     	                countryId : countryid
     	        }, function(response) {
     	        	  var select = $('#stateId');
     	        	   select.find('option').remove();
     	        	   var select1=$('#cityId');
   	        	   		select1.find('option').remove();
     	            	 var obj = jQuery.parseJSON(response);
     	            	
     	            	 $.each(obj, function(key,value) {
     	            		 if(key==0){
     	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
     	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
     	   	        	    	}
     	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
     	            	  
     	            	 }); 
     	        });
     	       
     	 });
     	        
     	        
     	$('#stateId').change(function(event) {
     	    var stateid = $("#stateId").val();

     	    $.get(ctx+'/geographicallocation/city', {
     	            stateId : stateid
     	    }, function(response) {
     	    	
     	    	  var select = $('#cityId');
     	        	 select.find('option').remove();
     	        	 var obj = jQuery.parseJSON(response);
     	        	
     	        	 $.each(obj, function(key,value) {
     	        		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select City</option>');
	   	        	    	}
     	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
     	        	  
     	        	 }); 
     	    });
     	   
     	    });
     	 

	    $('#editgeographicallocation').change(function(event) {
      	  
	        var countryid = $("#editgeographicallocation").val();
	        $.get(ctx+'/geographicallocation/state', {
	                countryId : countryid
	        }, function(response) {
	        	  var select = $('#editgeographicallocationstate');
	        	   select.find('option').remove();
	        	   var select1=$('#editgeographicallocationcity');
	        	   		select1.find('option').remove();
	            	 var obj = jQuery.parseJSON(response);
	            	
	            	 $.each(obj, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	   	        	    	}
	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	            	  
	            	 }); 
	        });
	       
	 });
	        
	        
	$('#editgeographicallocationstate').change(function(event) {
	    var stateid = $("#editgeographicallocationstate").val();

	    $.get(ctx+'/geographicallocation/city', {
	            stateId : stateid
	    }, function(response) {
	    	
	    	  var select = $('#editgeographicallocationcity');
	        	 select.find('option').remove();
	        	 var obj = jQuery.parseJSON(response);
	        	
	        	 $.each(obj, function(key,value) {
	        		 if(key==0){
	        	    		select.append('<option value="" disabled selected>Select City</option>');
	        	    	}
	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	        	  
	        	 }); 
	    });
	   
	    });
        	 
         });
