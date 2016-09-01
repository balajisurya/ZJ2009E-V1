$(document).ready(function() {
		var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
			 $("#admissionSave").click(function(event){
				
				 $('#newadmissionForm').validate({
	  				 submitHandler: function(form) {
				  $("#admissionSaveConfirmation").modal('show');
				  	$("#admissionSaveConfirm").click(function(){
		     			 var data=$("#newadmissionForm").serialize();
		     			 $.post("newAdmission/save",data,function(data) {
		          			window.location.href="applyforadmission";
		                   });
		     		});
			        return false;     
	  			      }
	  			  });	   
			});
			
			 
			//edit
        	 $('#applicationList td a#edit').click(function(){
        		 var admissionid = $(this).attr('data-id');
        			if(document.getElementById('editFormDiv').style.display=="none"){
        				document.getElementById('editFormDiv').style.display="block";
        				document.getElementById('ListDiv').style.display="none";
        				
        				$.get(ctx+'/admissions/candidate/newAdmission/edit', {
        					admissionId:admissionid
        						}, function(response) {
        							$("[name=editcandidateFirstName]").val(response.candidateFirstName);
        							$("[name=editcandidateLastName]").val(response.candidateLastName);
        							$("[name=editcandidateGender]").find('option[value='+response.candidateGender+']').attr('selected','selected');
        							$("[name=editdateOfBirth]").val(new Date(response.dateOfBirth).toString('MM/dd/yy'));
        							$("[name=editreligionId]").find('option[value='+response.religion.religionId+']').attr('selected','selected');
        							$("[name=editcategoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
        							$("[name=editspecialCategoryId]").find('option[value='+response.specialCategory.specialCategoryId+']').attr('selected','selected');
        							$("[name=editpassportNo]").val(response.passportNo);
        							$("[name=editpassportissuedCountryId]").find('option[value='+response.passportIssuedCountry+']').attr('selected','selected');
        							$("[name=editIsStudiedBefore]").find('option[value='+response.studiedHereBefore+']').attr('selected','selected');
        							$("[name=editpreviousStudentId]").val(response.previousStudentIdOfThisInstitute);
        							$("[name=editsponserId]").find('option[value='+response.sponser.sponserId+']').attr('selected','selected');
        							$("[name=editisDisability]").find('option[value='+response.disability+']').attr('selected','selected');
        							$("[name=editfatherFirstName]").val(response.fatherFirstName);
        							$("[name=editfatherLastName]").val(response.fatherLastName);
        							$("[name=editfatherOccupation]").val(response.fatherOccupation);
        							$("[name=editmotherFirstNamee]").val(response.motherFirstName);
        							$("[name=editmotherLastName]").val(response.motherLastName);
        							$("[name=editmotherOccupation]").val(response.motherOccupation);
        							$("[name=editfatherIncome]").val(response.fatherIncome);
        							$("[name=editmotherIncome]").val(response.motherIncome);
        							$("[name=editguardianFirstName]").val(response.guardianFirstName);
        							$("[name=editguardianLastName]").val(response.guardianLastName);
        							$("[name=editreference1FirstName]").val(response.referenceOneFirstName);
        							$("[name=editreference1LastName]").val(response.referenceOneLastName);
        							$("[name=editreference1Email]").val(response.referenceOneEmail);
        							$("[name=editreference1Mobile]").val(response.referenceOneMobile);
        							$("[name=editreference1AddressLine1]").val(response.referenceOneAddressLineOne);
        							$("[name=editreference1AddressLine2]").val(response.referenceOneAddressLineTwo);
        							$("[name=editreference1CountryId]").find('option[value='+response.referenceOneCountry+']').attr('selected','selected');
        							$("[name=editreference1Pincode]").val(response.referenceOnePincode);
        							$("[name=editreference2FirstName]").val(response.referenceTwoFirstName);
        							$("[name=editreference2LastName]").val(response.referenceTwoLastName);
        							$("[name=editreference2Email]").val(response.referenceTwoEmail);
        							$("[name=editreference2Mobile]").val(response.referenceTwoMobile);
        							$("[name=editreference2AddressLine1]").val(response.referenceTwoAddressLineOne);
        							$("[name=editreference2AddressLine2]").val(response.referenceTwoAddressLineTwo);
        							$("[name=editreference2CountryId]").find('option[value='+response.referenceTwoCountry+']').attr('selected','selected');
        							$("[name=editreference2Pincode]").val(response.referenceTwoPincode);
        							$("[name=edithearedUsid]").find('option[value='+response.hearedUs.hearedUsId+']').attr('selected','selected');
        							$("[name=editcandidateAddressLine1]").val(response.candidateAddressLineOne);
        							$("[name=editcandidateAddressLine2]").val(response.candidateAddressLineTwo);
        							$("[name=editmobileNumber]").val(response.referenceTwoPincode);
        							$("[name=editcandidateEmail]").val(response.referenceTwoPincode);
        							$("[name=editcandidateCountryid]").find('option[value='+response.candidateCountry+']').attr('selected','selected');
        							$("[name=editcandidateStateid]").find('option[value='+response.candidateState+']').attr('selected','selected');
        							$("[name=editcandidateCityid]").find('option[value='+response.candidateCity+']').attr('selected','selected');
        							$("[name=editcandidatePostCode]").val(response.candidatePostcode);
        							$("[name=editcourseTypeId]").find('option[value='+response.courseType.courseTypeId+']').attr('selected','selected');
        							$("[name=editcourseCategoryId]").find('option[value='+response.courseCategory.courseCategoryId+']').attr('selected','selected');
        							$("[name=editdepartmentId]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
        							$("[name=editcourseId]").find('option[value='+response.course.courseId+']').attr('selected','selected');
        						});
        				
        			}
        			
              });
	
			 
			 

	
			$('#educationLevel').change(function(event) {
				$('#educationLevelSubject').empty();
		  	   var educationLevelid = $("#educationLevel").val();
		  	   $.get('/EducationManagementSystem/admissions/educationLevelSubject/list', {
		      	educationLevelId : educationLevelid
		        }, function(jsonresponse) {
		        	if(jsonresponse){
		        		 $.each(jsonresponse, function(key,value) {
		               	      var id=key+1
		        	    	 $('#educationLevelSubject').append('<div name=subject'+id+'>'
		        	    			 +'<label for="" class="col-sm-3 control-label">'+value.educationLevelSubjectTitle+'</label>'
		        	             	 +'<div class="col-sm-2">' 
		        	             		 +'<input type="text" class="form-control" id="" placeholder="">'
		        	             	 +'</div>'
		        	             	 +'</div>');
		          		 });
		            }});
		  	   });
			
			
			$("#newadmissionForm").bind("change", function() {
			  
			        // Exist text in your input
			        $("#admissionSave").show();
			 
			});
			
});
//** Numbers Only**/

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
   	$("#templateitemform").before(
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

/** currency Only**/
function isFloatNumber(item,evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode==46)
    {
        var regex = new RegExp(/\./g)
        var count = $(item).val().match(regex).length;
        if (count > 1)
        {
            return false;
        }
    }
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

///email validation

$(document).ready(function(){
	$('.form-control-email').keyup(function() {
	    $('span.error-keyup-7').remove();
	    var inputVal = $(this).val();
	    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	    if(!emailReg.test(inputVal)) {
	        $(this).after('<span class="error error-keyup-7">Invalid Email Format</span>');
	    }
	});
	    });






