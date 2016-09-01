 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
      $("#addStaffLeaveRequisition").click(function(event){
    	  $("#addStaffLeaveRequisitionForm").validate();
    	  if( $("#addStaffLeaveRequisitionForm").valid()){
    		  $("#addStaffLeaveRequisitionConfirmation").modal('show');
      		$("#addStaffLeaveRequisitionConfirm").click(function(){
      			$('#addStaffLeaveRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $("#addStaffPurchaseRequisition").click(function(event){
    	  $("#addStaffPurchaseRequisitionForm").validate();
    	  if( $("#addStaffPurchaseRequisitionForm").valid()){
    		  $("#addStaffPurchaseRequisitionConfirmation").modal('show');
      		$("#addStaffPurchaseRequisitionConfirm").click(function(){
      			$('#addStaffPurchaseRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $("#addStaffTravelRequisition").click(function(event){
    	  $("#addStaffTravelRequisitionForm").validate();
    	  if( $("#addStaffTravelRequisitionForm").valid()){
    		  $("#addStaffTravelRequisitionConfirmation").modal('show');
      		$("#addStaffTravelRequisitionConfirm").click(function(){
      			$('#addStaffTravelRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $("#addStaffFacilityRequisition").click(function(event){
    	  $("#addStaffFacilityRequisitionForm").validate();
    	  if( $("#addStaffFacilityRequisitionForm").valid()){
    		  $("#addStaffFacilityRequisitionConfirmation").modal('show');
      		$("#addStaffFacilityRequisitionConfirm").click(function(){
      			$('#addStaffFacilityRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $('#leaveRequisitionsList').on( 'click', 'tr td a#leaveCancel', function () {
     
		   var staffLeaveRequisitionId = $(this).attr('data-id');
		   $("#leaveCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#leaveCancelConfirm").click(function(){
				   $.post(ctx+"/staff/requisition/staffLeaveRequest/cancel",{staffLeaveRequisitionId:staffLeaveRequisitionId},function(){
					   window.location.reload();
				   });
				});
			});
		   
		});
  });
  	
      
      
      
    