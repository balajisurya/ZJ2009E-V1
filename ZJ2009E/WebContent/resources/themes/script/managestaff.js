$(document).ready(function() {
        	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 //geographical locations
     $('#geographicallocation').change(function(event) {
   	       var countryid = $("#geographicallocation").val();
   	        $.get(ctx+'/geographicallocation/state', {
   	                countryId : countryid
   	        }, function(response) {
   	        	  var select = $('#geographicallocationstate');
   	        	   		select.find('option').remove();
   	        	   var select1=$('#geographicallocationcity');
   	        	   		select1.find('option').remove();
   	            	 var obj = jQuery.parseJSON(response);
   	            	  $.each(obj, function(key,value) {
   	            		if(key==0){
	        	    		select.append('<option value="" disabled selected>Select State</option>');
	        	    		select1.append('<option value="" disabled selected>No State Selected</option>');
	        	    	}
   	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
   	            	 }); 
   	        });
   	  });
     
   	        
   	        
   	$('#geographicallocationstate').change(function(event) {
   	    var stateid = $("#geographicallocationstate").val();
   	    $.get(ctx+'/geographicallocation/city', {
   	            stateId : stateid
   	    }, function(response) {
   	    	  var select = $('#geographicallocationcity');
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
	
	  //staff categories based on staff type
   	$('#staffTypeId').change(function(event) {
	       var staffTypeid = $("#staffTypeId").val();
	        $.get(ctx+'/staff/staffcategory', {
	        	staffTypeId : staffTypeid
	        }, function(response) {
	        	
	        	   var select = $('#staffCategoryId');
	        	   select.find('option').remove();
	        	    $.each(response, function(key,value) {
	        	    	if(key==0){
	        	    		select.append('<option value="" disabled selected>Select Category</option>');
	        	    	}
	            		 $('<option>').val(value.staffCategoryId).text(value.staffCategoryName).appendTo(select);
	            	 }); 
	        });
	  });
	$('#editStaffTypeId').change(function(event) {
	       var staffTypeid = $("#editStaffTypeId").val();
	        $.get(ctx+'/staff/staffcategory', {
	        	staffTypeId : staffTypeid
	        }, function(response) {
	        	   var select = $('#editStaffCategoryId');
	        	   select.find('option').remove();
	        	    $.each(response, function(key,value) {
	        	    	if(key==0){
	        	    		select.append('<option value="" disabled selected>Select Category</option>');
	        	    	}
	            		 $('<option>').val(value.staffCategoryId).text(value.staffCategoryName).appendTo(select);
	            	 }); 
	        });
	  });
   	
        	//adding new staff
			    $("#saveStaff").click(function(event){
			    	
			    	$('#newStaff').validate();
		        	  if($("#newStaff").valid())
		        		  {
		        		  $("#saveStaffConfirmation").modal('show');
		        		  
		        		  $("#saveStaffConfirm").click(function(){
		           			 
		            			$('#newStaff').submit();
		        		  });
		        		  }
		          	  
		          		 return false;
			    	
					 
					        
					 
				 });
        	 //delete
			    $('table tbody').on( 'click', 'tr td a#delete', function () {
        	
        		   var staffid = $(this).attr('data-id');
        		   $('#confirm-delete').on('show.bs.modal', function (e) {
        			   $('#deletestaff').attr("href", ctx+"/staff/delete?staffId="+staffid);
        			});
        		   
        		});
        	 
			    $('#stafflist').on( 'click', 'tr td a#edit', function () {
      		   var staffId = $(this).attr('data-id');
      		  $.get(ctx+'/staff/getStaff', {
      			staffId : staffId
  	        }, function(response) {
  	        	$('#updateStaff').attr('data-id',response.staffId);
  	        	$("[name=editAccessId]").val(response.accessId);
				$("[name=editStaffCode]").val(response.staffCode);
				$("[name=editStaffFirstName]").val(response.staffFirstName);
				$("[name=ediStaffLastName]").val(response.staffLastName);
				$("[name=editStaffParentOrGuardianFirstName]").val(response.parentOrGuardianFirstName);
				$("[name=editStaffParentOrGuardianLastName]").val(response.parentOrGuardianLastName);
				$("[name=editStaffGender]").find('option[value='+response.staffSex+']').attr('selected','selected');
			    $("[name=editStaffDOB]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.staffBirthDate)));
				$("[name=editStaffBloodGroupId]").find('option[value='+response.bloodGroup.bloodGroupId+']').attr('selected','selected');
				$("[name=editStaffEmail]").val(response.staffEmail);
				$("[name=editStaffContact]").val(response.staffContact);
				$("[name=editCategoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
				$("[name=editStaffSpouseName]").val(response.spouseName);
				$("[name=editStaffAddressLine1]").val(response.staffAddressLineOne);
			    $("[name=editStaffAddressLine2]").val(response.staffAddressLineTwo);
				$("[name=editStaffCountryId]").find('option[value='+response.countryId+']').attr('selected','selected');
				$("[name=editStaffStateId]").find('option[value='+response.stateId+']').attr('selected','selected');
				$("[name=editStaffCityId]").find('option[value='+response.cityId+']').attr('selected','selected');
				$("[name=editStaffPostCode]").val(response.postCode);
				$("[name=editStaffBankName]").val(response.bankName);
				$("[name=editStaffBankAccountNo]").val(response.bankAccountNo);
			    $("[name=editStaffBankIFSC]").val(response.bankIFSC);
				$("[name=editStaffBankAddress]").val(response.bankAddress);
				$("[name=editStaffTallyAccountNo]").val(response.tallyAccountNo);
				$("[name=editStaffPassportNo]").val(response.passportNo);
				$("[name=editStaffPANNo]").val(response.panNO);
				$("[name=editStaffPFAccountNo]").val(response.pfNo);
			    $("[name=editStaffTypeId]").find('option[value='+response.staffType.staffTypeId+']').attr('selected','selected');
				$("[name=editStaffCategoryId]").find('option[value='+response.staffCategory.staffCategoryId+']').attr('selected','selected');
				 if(response.approver.staff.staffId!=null){
					 $("[name=editApproverId]").find('option[value='+response.approver.staff.staffId+']').attr('selected','selected');
				 }
				 else{
					 $("[name=editApproverId]").find('option[value='+response.staffId+']').attr('selected','selected');
				 }
				/*$("[name=editInstituteId]").find('option[value='+response.institution.institutionId+']').attr('selected','selected');*/
				$("[name=editStaffJoinedDate]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.joiningDate)));
				$("[name=editPreviousExp]").val(response.previousExperience);
				$("[name=editHealthInsuranceNo]").val(response.healthInsuranceNo);
				$("[name=editStaffStatus]").find('option[value='+response.status+']').attr('selected','selected');
				$("[name=editDepartmentId]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
				
				
			   
  	        	
  	        });
      		   
      		});
        	 
        	 
        	 
        	    $('#staffgeographicallocation').change(function(event) {
        	      	  
        	        var countryid = $("#staffgeographicallocation").val();
        	        $.get(ctx+'/geographicallocation/state', {
        	                countryId : countryid
        	        }, function(response) {
        	        	  var select = $('#staffgeographicallocationstate');
        	        	   select.find('option').remove();
        	        	   var select1=$('#staffgeographicallocationcity');
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
        	        
        	        
        	$('#staffgeographicallocationstate').change(function(event) {
        	    var stateid = $("#staffgeographicallocationstate").val();

        	    $.get(ctx+'/geographicallocation/city', {
        	            stateId : stateid
        	    }, function(response) {
        	    	
        	    	  var select = $('#staffgeographicallocationcity');
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
        	
        	
        	
      	  $("#updateStaff").click(function(event){
        	  $('#SaveConfirmation').modal('show');	
    	   	 var staffId = $(this).attr('data-id');
    	   	  $('#SaveConfirm').click(function(){
    	   var data=$("#updateStaffDetails").serialize();	
    	   $.post(ctx+"/staff/updateStaffDetails?staffId="+staffId,data,function(data) {
    			window.location.href=ctx+"/staff/manage";    
    	   });
    	   		   				  				
    	   	  });
    	   	  	 });
        	
         });
    
  
    
  
      
