 $(document).ready(function() {
	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 $('#getStaffProfile').click(function(event) 
		{
		  var staffId = $("#getStaffId").val();
	        $.get(ctx+'/staff/getStaff', {
	        	staffId : staffId
	        }, function(data) {
	        
	        		var t= $("#table");
	        	
	        			t.find('table').remove();      
	        	
	        			$('#staffImage').show();
	        	
	        			t.append('<table class="table table-bordered"><tbody><tr><th class="success"scope="row">Staff Id</th><td>'+data.staffId+'</td><th class="success"scope="row">Date of Birth</th><td>'+data.staffBirthDate+'</td></tr><tr><th class="info" scope="row">Staff Name</th><td><span>'+data.staffFirstName+' '+ data.staffLastName+'</span></td><th class="info" scope="row">Joining Date</th><td>'+data.joiningDate+'</td></tr><tr><th class="danger" scope="row">User Id</th><td>'+data.user.userId+'</td><th class="danger" scope="row">Total Experience</th><td>'+data.previousExperience+'</td></tr><tr ><th class="info" scope="row">Designation</th><td>'+data.staffCategory.staffCategoryName+'</td><th class="info" scope="row">Mobile No</th><td>'+data.staffContact+'</td></tr><tr > <th  class="warning" scope="row">Department</th><td>'+data.department.departmentName+'</td><th  class="warning" scope="row">Email Id</th><td>'+data.staffEmail+'</td></tr></tbody></table>' );
	        	
	        });
		 
	 	});
 });
