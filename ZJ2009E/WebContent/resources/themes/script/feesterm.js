$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

	$("#feesTermSave").click(function(event) {
		$(this).validate();
		if($("#feesTermform").valid())
			{
				$("#feesTermSaveConfirmation").modal('show');
				$("#feesTermSaveConfirm").click(function(event) {
					$("#feesTermform").submit();
				});
				return false;
			}
	});

	$('#feestermList').on( 'click', 'tr td a#delete', function () {
		 var feesTermid = $(this).attr('data-id');
		 $('#confirm-delete').on('show.bs.modal', function (e) {
			 $("#confirmDeleteFeesTerm").click(function(event) {
				 $("#feesTermid").val(feesTermid);
				 $("#deleteFeesTermForm").submit();
			});
			});
		   
	});

	$('#feestermList').on( 'click', 'tr td a#edit', function () {
		var feesTermid = $(this).attr('data-id');
		
		$.ajax({
			   url:ctx+'/feestemplate/feesterm/editReterive',
			   data:{feesTermid:feesTermid},
			   type:'GET',
			   success: function(response){
				   $("[name=editFeesTermName]").val(response.feesTermName);
				   $("[name=editFeesTermOrder]").val(response.termOrder);
				   $("#updateFeesTerm").attr('data-id',response.feesTermId);
				   
			   },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/feestemplate/feesterm";
			   }
			 });
	});

	$("#updateFeesTerm").click(function(event){
		var feesTermId = $(this).attr('data-id');
		$(this).validate();
		 $("#updateFeesTermId").val(feesTermId);
		 if($("#updateFeesTermForm").valid())
			{
				$("#updateConfirmation").modal('show');
				$("#updateConfirm").click(function(event) {
					$('#updateFeesTermForm').submit();
				});
			
			}
	  });



});