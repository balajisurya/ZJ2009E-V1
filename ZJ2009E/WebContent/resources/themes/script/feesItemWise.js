$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$("#getReport").click(function(event) {
		$('#feesItemReportForm').validate({
			 submitHandler: function(form) {
				var ledgerId=$("#ledgerAccount").val();
				 $.ajax(	
						    {
						        type: "GET",
						        url:ctx+'/report/byFeesItem/ledger' ,
						        data:{ledgerId:ledgerId},
						        contentType: "application/json; charset=utf-8",
						        dataType: "json",
						        cache: false,
						        success: function (data) {
						        	var datatable = $('#feesItemReportTable').DataTable();
						        	 $(".form-horizontal").trigger('reset');
						        	 datatable.clear().draw();
						        		$.each(data, function (i, item) {
										datatable.row.add([item.f1.templateItemName,item.f2,item.f3,item.f4]).draw( false );
									});
						        $("#feesItemReportTableDiv").show();
						        }
						      
						    });
					      return false;
			 }
		});
	});
});