
$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$("#addsection").click(function(event) {
	
	$("#addSectionPopup").modal('show');	
	 $("#createnewsection").click(function(){
		 $("#classandsectionsettingform").valid();
		
});
});
$('#sectionList').on( 'click', 'tr td a#edit', function () {
	var sectionid = $(this).attr('data-id');
	
	$.ajax({
		   url:ctx+'/class/section/editReterive',
		   data:{sectionId:sectionid},
		   type:'GET',
		   success: function(response){
			   $("#updateSection").attr('data-id',response.sectionId);
			   $("[name=editSectionName]").val(response.sectionName);
			 
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/class";
		   }
		 });
});


$('#sectionList').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#confirm_delete_class_section').on('show.bs.modal', function (e) {
		 $("#deleteSectionConfirm").click(function(event) {
			 $("#deleteSectionId").val(sectionid);
			 $("#deleteSectionForm").submit();
		});
		});
});

$("#updateSection").click(function(event){
	 var sectionId = $(this).attr('data-id');
	 $("#updateSectionId").val(sectionId);
	
	 if( $("#updateSectionForm").valid())
		{
	 $('#update_Section_Confirmation').modal('show');
	 $('#updateSectionConfirm').click(function(){
		
		 $("#updateSectionForm").submit();
	  });
		}
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

//class logic

$("#classandsectionsavebutton").click(function(event) {
	$('#createclassform').validate({
 		ignore:null,
 		 errorPlacement: function ($error, $element) {
             var name = $element.attr("name");   	             
 	             $("#error" + name).append($error);
         }
 		
          
 	});
	if($("#createclassform").valid())
		{
			$("#classAndSectionAddingConfirmation").modal('show');
			$("#confirmAddClass").click(function(event) {
				$("#createclassform").submit();
			});
			return false;
		}
});

$('#classList').on( 'click', 'tr td a#delete', function () {
	 var classid = $(this).attr('data-id');
	 $('#confirm_delete_class').on('show.bs.modal', function (e) {
		 $("#confirmDeleteClass").click(function(event) {
			 $("#deleteClassId").val(classid);
			 $("#deleteClassForm").submit();  
		});
		});
	   
});


$('#classList').on( 'click', 'tr td a#edit', function () {
	 var classid = $(this).attr('data-id');
	
			   $.ajax({
				   url:ctx+'/class/editRetreive',
				   data:{classId:classid},
				   type:'GET',
				   success: function(response)
				   {
					   var selectedValues = new Array();
		   	        	
		   	        	
	        			 $.each(response.sections, function(key,value) 
	        					 { 
							
	        				 selectedValues[key]=value.sectionId;
						
	        					 });
	        		$("#updateClassAndSection").attr('data-id',response.classId);
					   $("[name=editClassName]").val(response.className);
					   $("#editSections").val(selectedValues).trigger("change"); 
					  
				   }
				 });
	   
});


$("#updateClassAndSection").click(function(event){
	 var classId = $(this).attr('data-id');
	 $("#updateClassId").val(classId);
	 if($("#updateClassAndSectionForm").valid())
		{
	 
	 $('#update_Class_Section_Confirmation').modal('show');
	 $('#saveConfirm').click(function(){
		 $("#updateClassAndSectionForm").submit();
		
    });
		}
});
/*$('#specialCategorylist').on( 'click', 'tr td a#edit', function () {
	var specialCategoryid = $(this).attr('data-id');
	
	$.ajax({
		   url:ctx+'/specialCategory/editReterive',
		   data:{specialCategoryId:specialCategoryid},
		   type:'GET',
		   success: function(response){
			   $("[name=editSpecialCategoryName]").val(response.specialCategoryName);
			   $("#updateSpecialCategory").attr('data-id',response.specialCategoryId);
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/class";
		   }
		 });
});

$("#updateSpecialCategory").click(function(event){
	var specialCategoryId = $(this).attr('data-id');
	$(this).validate();
	if($("#updateSpecialCategoryForm").valid())
		{
			$("#specialCategoryUpdateConfirmation").modal('show');
			$("#specialCategoryUpdateConfirm").click(function(event) {
				var data=$('#updateSpecialCategoryForm').serialize()+'&specialCategoryId='+specialCategoryId;
				 $.ajax({
					   url:ctx+'/specialCategory/editUpdate',
					   data:data,
					   type:'POST',
					   success: function(){
						   window.location.href=ctx+"/specialCategory";
					   },
					   error: function(){
					     alert('Special Category Was Not Updated');
					     window.location.href=ctx+"/specialCategory";
					   }
					 });
			});
			return false;
		}
		
  });*/

});
