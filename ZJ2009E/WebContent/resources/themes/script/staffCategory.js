 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	//adding staff category
	 $("#addStaffCategory").click(function(event){
		 $('#addNewStaffCategory').validate({
			   submitHandler: function(form) {
		 $("#addStaffCategoryConfirmation").modal('show');
		  $("#addStaffCategoryConfirm").click(function(){
      			 var data=$("#addNewStaffCategory").serialize();
           		 $.post(ctx+"/staff/category/add",data,function(){
           			window.location.href=ctx+"/staff/category";
                 });
      		});
			   }
		 });
      });
	 
	//delete staff category
	 $('table tbody').on( 'click', 'tr td a#delete', function () {
		   var staffCategoryid = $(this).attr('data-id');
		   $("#staff-category-delete-modal").on('show.bs.modal', function (e) {
			   $("#deleteStaffCategory").attr("href",ctx+"/staff/category/delete?staffCategoryId="+staffCategoryid);
			});
		   
		});
	 
	 $('table tbody').on( 'click', 'tr td a#edit', function () {
		   var staffCategoryId = $(this).attr('data-id');
		   $.get(ctx+'/staff/category/edit', {
			   staffCategoryId : staffCategoryId
	    }, function(response) {
	    
	    	$("[name=editStaffCategoryName]").val(response.staffCategoryName);
		  	$("[name=editStaffCategoryVisible]").find('option[value='+response.staffCategoryVisible+']').attr('selected','selected');	
			$("[name=editStaffTypeId]").find('option[value='+response.staffType.staffTypeId+']').attr('selected','selected');
		/*	$("[name=editStaffRoleType]").find('option[value='+response.masterUserType.typeId+']').attr('selected','selected');*/
		    $('#updateStaffCategory').attr('data-id',response.staffCategoryId);
	        	
	    });
		   
		});
	 
	 
	 $("#updateStaffCategory").click(function(event){
		 $("#SaveConfirmation").modal('show');
		  var staffCategoryId = $(this).attr('data-id');
		  $("#SaveConfirm").click(function()
				  {
				 var data=$("#editStaffCategory").serialize();
           		 $.post(ctx+"/staff/category/update?staffCategoryId="+staffCategoryId,data,function(data){
           			window.location.href=ctx+"/staff/category";
           		
                 });
      		});    
      });
	 
 });