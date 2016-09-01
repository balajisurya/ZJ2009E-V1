var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$("#specialCategorySave").click(function(event) {
	$(this).validate();
	if($("#specialCategoryform").valid())
		{
			$("#specialCategorySaveConfirmation").modal('show');
			$("#specialCategorySaveConfirm").click(function(event) {
				$("#specialCategoryform").submit();
			});
			return false;
		}
});

$('#specialCategorylist').on( 'click', 'tr td a#delete', function () {
	 var specialCategoryid = $(this).attr('data-id');
	 $('#deleteSpecialCategoryConfirmation').on('show.bs.modal', function (e) {
		 $("#confirmDeleteSpecialCategory").click(function(event) {
			 $("#deleteSpecialCategoryId").val(specialCategoryid);
			 $("#deleteSpecialCategoryForm").submit();
		});
		});
	   
});

$('#specialCategorylist').on( 'click', 'tr td a#edit', function () {
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
	 $("#updateSpecialCategoryId").val(specialCategoryId);
	 if($("#updateSpecialCategoryForm").valid())
		{
			$("#specialCategoryUpdateConfirmation").modal('show');
			$("#specialCategoryUpdateConfirm").click(function(event) {
				$('#updateSpecialCategoryForm').submit();
				
			});
		}
		
  });
