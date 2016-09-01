 $(document).ready(function() {
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	   $('#facilityCategoryId').change(function(event) {
		   
       	   var facilitycategoryid = $("#facilityCategoryId").val();
       	        $.get(ctx+'/facilities/facilityType', {
       	        	facilityCategoryId : facilitycategoryid
       	        }, function(response) {
       	         var select = $('#facilityTypeId');
       	        	   select.find('option').remove();          	            	
       	            	 $.each(response, function(key,value) {
       	            		if(key==0){
    	        	    		select.append('<option value="" disabled selected>Select Facility Type</option>');
    	        	    		 $("#transport").hide();
    	         		        $("#equipment").hide();
    	         		        $("#laboratory").hide();
    	         		        $("#classroom").hide();
    	         		        $("#hostel").hide();
    	        	    	}
       	            		 $('<option>').val(value.facilitytypeId).text(value.facilityTypeName).appendTo(select);
       	            	  
       	            	 }); 
       	        });
       	       
       	 });
	   
		 
	   $('#viewfacilityCategoryId').change(function(event) {
		   
       	   var facilitycategoryid = $("#viewfacilityCategoryId").val();
       	        $.get(ctx+'/facilities/facilityType', {
       	        	facilityCategoryId : facilitycategoryid
       	        }, function(response) {
       	         var select = $('#viewfacilityTypeId');
       	        	   select.find('option').remove();          	            	
       	            	 $.each(response, function(key,value) {
       	            		if(key==0){
    	        	    		select.append('<option value="" disabled selected>Select Facility Type</option>');
    	        	    		 $("#transport").hide();
    	         		        $("#equipment").hide();
    	         		        $("#laboratory").hide();
    	         		        $("#classroom").hide();
    	         		        $("#hostel").hide();
    	        	    	}
       	            		 $('<option>').val(value.facilitytypeId).text(value.facilityTypeName).appendTo(select);
       	            	  
       	            	 }); 
       	        });
       	       
       	 });

	   $('#facilityClassRoomlist td a#edit').click(function() {
			  var classRoomId = $(this).attr('data-id');
			  if(document.getElementById('EditFormDivClassRoom').style.display=="none")
				{
				document.getElementById('EditFormDivClassRoom').style.display="block";
				document.getElementById('ListDiv').style.display="none";
				
	     	        $.get(ctx+'/facilities/editClassRoom', {
	     	        	ClassRoomId : classRoomId
	     	        }, function(response) {     
	     	        	$("[name=EditClassRoomName]").val(response.facilityName);
						$("[name=EditClassRoomNo]").val(response.facilityNo);
						$("[name=EditClassRoomUpdateStatus]").find('option[value='+response.facilityStatus+']').attr('selected','selected');
						$("[name=EditClassRoomDescription]").val(response.facilityDescription);
						$("[name=EditNoOfSeats]").val(response.noOfSeats);
						$("[name=EditClassRoomLocation]").val(response.facilityLocation);
						$("[name=EditPersonResponsible]").val(response.facilityPersonResponsible);
					    $('#updateClassRoom').attr('data-id',response.facilityClassRoomId);
	     	        	
	     	        });
				}
	     	 });
	   
	   $('#facilityTransportList td a#edit').click(function() {
			  var transportId = $(this).attr('data-id');
			  if(document.getElementById('EditFormDivTransport').style.display=="none")
				{
				document.getElementById('EditFormDivTransport').style.display="block";
				document.getElementById('ListDiv').style.display="none";
				
	     	        $.get(ctx+'/facilities/editTransport', {
	     	        	TransportId : transportId
	     	        	
	     	        }, function(response) {   
	     	        	
	     	        	$("[name=EditTransportName]").val(response.facilityName);
						$("[name=EditTransportNo]").val(response.facilityNo);
						$("[name=EditTransportStatus]").find('option[value='+response.facilityStatus+']').attr('selected','selected');
						$("[name=EditTransportLicenseRenewalDate]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.licenseRenewalDate)));
						$("[name=EditTransportInsuranceRenewalDate]").val($.datepicker.formatDate("mm/dd/yy",new Date(response.insuranceRenewalDate)));
						$("[name=EditTransportRegistrationNumber]").val(response.facilityTransportRegistrationNumber);
						$("[name=EditTransportVehicleModel]").val(response.facilityTransportVehicleModelDescription);
						$("[name=EditTransportItemGroup]").val(response.itemGroup);
						$("[name=EditNoOfSeats]").val(response.noofSeats);
						$("[name=EditTransportRouteName]").val(response.routeName);
						$("[name=EditTransportVehicleCost]").val(response.totalCost);
						$("[name=EditTransportLocation]").val(response.facilityLocation);
						$("[name=EditTransportPersonResponsible]").val(response.facilityTransportPersonResponsible);
						$("[name=EditTransportTallyReference]").val(response.tallyReference);					
					    $('#updateTransport').attr('data-id',response.facilityTransportId);
	     	        	
	     	        });
				}
	     	 });
	   
	   $('#facilityLaboratorylist td a#edit').click(function() {
			  var laboratoryId = $(this).attr('data-id');
			  if(document.getElementById('EditFormDivLaboratory').style.display=="none")
				{
				document.getElementById('EditFormDivLaboratory').style.display="block";
				document.getElementById('ListDiv').style.display="none";
				
	     	        $.get(ctx+'/facilities/editLaboratory', {
	     	        	laboratoryId : laboratoryId
	     	        }, function(response) {     
	     	        	

	     	        	$("[name=EditLaboratoryName]").val(response.facilityName);
						$("[name=EditLaboratoryNo]").val(response.facilityNo);
						$("[name=EditLaboratoryStatus]").find('option[value='+response.facilityStatus+']').attr('selected','selected');
						$("[name=EditLaboratoryDescription]").val(response.facilityDescription);
						$("[name=EditNoofSeats]").val(response.noOfSeats);
						$("[name=EditLaboratoryLocation]").val(response.facilityLocation);
						$("[name=EditLaboratoryPersonResponsible]").val(response.facilityPersonResponsible);
					    $('#updateLaboratory').attr('data-id',response.facilityLaboratoryId);
	     	        });
				}
	     	 });
	   $('#facilityEquipmentList td a#edit').click(function() {
			  var equipmentId = $(this).attr('data-id');
			  if(document.getElementById('EditFormDivEquipment').style.display=="none")
				{
				document.getElementById('EditFormDivEquipment').style.display="block";
				document.getElementById('ListDiv').style.display="none";
				
	     	        $.get(ctx+'/facilities/editEquipment', {
	     	        	equipmentId : equipmentId
	     	        }, function(response) {     	

	     	        	$("[name=EditEquipmentName]").val(response.facilityEquipmentName);
						$("[name=EditEquipmentNo]").val(response.facilityEquipmentNo);
						$("[name=EditEquipmentStatus]").find('option[value='+response.facilityStatus+']').attr('selected','selected');
						$("[name=EditEquipmentDescription]").val(response.facilityEquipmentDescription);
						$("[name=EditEquipmentLocation]").val(response.facilityLocation);
						$("[name=EditEquipmentPersonResponsible]").val(response.facilityEquipmentPersonResponsible);
						$("[name=EditEquipmentItemGroup]").val(response.itemGroup);
						$("[name=EditEquipmentTallyReference]").val(response.tallyReference);
						$("[name=EditEquipmentCost]").val(response.totalCost);
						$("[name=EditEquipmentQuantityAvailable]").val(response.totalQuantityAvailable);
					    $('#updateEquipment').attr('data-id',response.facilityEquipmentId);
	     	        });
				}
	     	 });
	   
	   
	   $('#facilityHostelList td a#edit').click(function() { 
			  var hostelId = $(this).attr('data-id');
			  if(document.getElementById('EditFormDivHostel').style.display=="none")
				{
				document.getElementById('EditFormDivHostel').style.display="block";
				document.getElementById('ListDiv').style.display="none";
				
	     	        $.get(ctx+'/facilities/editHostel', {
	     	        	hostelId : hostelId
	     	        }, function(response) {     
	     	        	
	     	       	$("[name=EditHostelName]").val(response.facilityHostelName);
					$("[name=EditHostelNo]").val(response.facilityHostelNo);
					$("[name=EditHostelStatus]").find('option[value='+response.facilityHostelRoomStatus+']').attr('selected','selected');
					$("[name=EditHostelOccupiedTillDate]").val($.datepicker.formatDate("mm/dd/yy", new Date(response.occupiedTillDate)));
					$("[name=EditHostelRoomNo]").val(response.facilityHostelRoomNumber);
					$("[name=EditHostelRoomDescription]").val(response.facilityHostelRoomDescription);
					$("[name=EditNoOfSeats]").val(response.noofSeats);
					$("[name=EditHostelChargePerDay]").val(response.chargePerDay);
					$("[name=EditHostelTallyReference]").val(response.tallyReference);
					$("[name=EditHostelFacilityPersonResponsible]").val(response.facilityHostelPersonResponsible);	
				    $('#updateHostel').attr('data-id',response.facilityHostelId);
	     	        	
	     	        });
				}
	     	 });
	   
	  
	   
	   
  	 $("#classRoomSave").click(function(event){
  		$('#newclassRoomForm').validate({
			   submitHandler: function(form) {
  		  $('#classRoomSaveConfirmation').modal('show');
  			$('#classRoomSaveConfirm').click(function(){
        			var data=$("#newclassRoomForm,#facilityCategoryAndType").serialize();
        				$.post(ctx+"/facilities/addClassRoom",data,function(data) {
        				
        					window.location.href=ctx+"/facilities";
                 });
        				
               });
  			return false;     
			   }
  		 });
		 });
	 
 	 $("#laboratorySave").click(function(event){
 		$('#newlaboratoryForm').validate({
			   submitHandler: function(form) {
 		  $('#laboratorySaveconfirmation').modal('show');
 			$('#laboratorySaveConfirm').click(function(){
       			var data=$("#newlaboratoryForm,#facilityCategoryAndType").serialize();
       				$.post(ctx+"/facilities/addLaboratory",data,function(data) {
       					window.location.href=ctx+"/facilities";
                });
              });
 			return false;
			   }
		 });
 	});

 	 $("#equipmentSave").click(function(event){
 		$('#newequipmentForm').validate({
			   submitHandler: function(form) {
 		  $('#equipmentSaveConfirmation').modal('show');
 			$('#equipmentSaveConfirm').click(function(){
       			var data=$("#newequipmentForm,#facilityCategoryAndType").serialize();
       				$.post(ctx+"/facilities/addEquipment",data,function(data) {
       					window.location.href=ctx+"/facilities";
                });
              });
 			return false;
			   }
 		 });
		 });

 	 $("#hostelSave").click(function(event){
 		$('#newhostelForm').validate({
			   submitHandler: function(form) {
 		  $('#hostelSaveConfirmation').modal('show');
 			$('#hostelSaveConfirm').click(function(){
       			var data=$("#newhostelForm,#facilityCategoryAndType").serialize();
       				$.post(ctx+"/facilities/addHostel",data,function(data) {
       					window.location.href=ctx+"/facilities";
                });
              });
 			return false;

			   }
		 });
 	});

 	 $("#transportSave").click(function(event){
 		$('#newtransportForm').validate({
			   submitHandler: function(form) {
 		  $('#transportSaveConfirmation').modal('show');
 			$('#transportSaveConfirm').click(function(){
       			var data=$("#newtransportForm,#facilityCategoryAndType").serialize();
       				$.post(ctx+"/facilities/addTransport",data,function(data) {
       					window.location.href=ctx+"/facilities";
                });
              });
 			return false;
			   }
		 });
 	});
	     
 	 
		
 	 
	 $("#updateClassRoom").click(function(event){
		  $('#updateConfirmation').modal('show');
		   var classRoomId = $('#updateClassRoom').attr('data-id');
		  $('#updateConfirm').click(function(){
       			var data=$('#updateClassRoomForm').serialize();
       				$.post(ctx+"/facilities/updateClassRoom?classRoomId="+classRoomId,data,function(data) {
       					window.location.href=ctx+"/facilities";       				
              });
		 });
	 });
     
	 $("#updateLaboratory").click(function(event){
		  $('#updateConfirmation').modal('show');
		   var laboratoryId = $('#updateLaboratory').attr('data-id');
		  $('#updateConfirm').click(function(){
      			var data=$('#updateLaboratoryForm').serialize();
      				$.post(ctx+"/facilities/updateLaboratory?laboratoryId="+laboratoryId,data,function(data) {
      					window.location.href=ctx+"/facilities";       				
             });
		 });
	 });
	 $("#updateEquipment").click(function(event){
		  $('#updateConfirmation').modal('show');
		   var equipmentId = $('#updateEquipment').attr('data-id');
		  $('#updateConfirm').click(function(){
     			var data=$('#updateEquipmentForm').serialize();
     				$.post(ctx+"/facilities/updateEquipment?equipmentId="+equipmentId,data,function(data) {
     					window.location.href=ctx+"/facilities";       				
            });
		 });
	 });
	 
	 $("#updateHostel").click(function(event){
		  $('#updateConfirmation').modal('show');
		   var hostelId = $('#updateHostel').attr('data-id');
		  $('#updateConfirm').click(function(){
      			var data=$('#updateHostelForm').serialize();
      				$.post(ctx+"/facilities/updateHostel?hostelId="+hostelId,data,function(data) {
      					window.location.href=ctx+"/facilities";       				
             });
		 });
	 });
	
	 $("#updateTransport").click(function(event){
		  $('#updateConfirmation').modal('show');
		   var transportId = $('#updateTransport').attr('data-id');
		  $('#updateConfirm').click(function(){
      			var data=$('#updateTransportForm').serialize();
      				$.post(ctx+"/facilities/updateTransport?transportId="+transportId,data,function(data) {
      					window.location.href=ctx+"/facilities";       				
             });
		 });
	 });
	 
	 $('#facilityClassRoomlist td a#delete').click(function() {
		   var classRoomId = $(this).attr('data-id');
		   $("#confirm-delete").on('show.bs.modal', function (e) {
			   $("#confirmDelete").attr("href", "facilities/deleteClassRoom?classRoomId="+classRoomId);
			});
		   
		});
	 $('#facilityTransportList td a#delete').click(function() {
		   var transportId = $(this).attr('data-id');
		   $("#confirm-delete").on('show.bs.modal', function (e) {
			   $("#confirmDelete").attr("href", "facilities/deleteTransport?transportId="+transportId);
			});
		   
		});
	 $('#facilityLaboratorylist td a#delete').click(function() {
		   var laboratoryId = $(this).attr('data-id');
		   $("#confirm-delete").on('show.bs.modal', function (e) {
			   $("#confirmDelete").attr("href", "facilities/deleteLaboratory?laboratoryId="+laboratoryId);
			});
		   
		});
	 $('#facilityHostelList td a#delete').click(function() {
		   var hostelId = $(this).attr('data-id');
		   $("#confirm-delete").on('show.bs.modal', function (e) {
			   $("#confirmDelete").attr("href", "facilities/deleteHostel?hostelId="+hostelId);
			});
		   
		});
	 $('#facilityEquipmentList td a#delete').click(function() {
		   var equipmentId = $(this).attr('data-id');
		   $("#confirm-delete").on('show.bs.modal', function (e) {
			   $("#confirmDelete").attr("href", "facilities/deleteEquipment?equipmentId="+equipmentId);
			});
		   
		});
	 
	 
	 
	 
	 $("#facilityTypeId").change(function() {
		    var val = $(this).val();
		    if(val ==="3") {
		        $("#classroom").show();
		        $("#equipment").hide();
		        $("#laboratory").hide();
		        $("#transport").hide();
		        $("#hostel").hide();
		          }
		    else if(val ==="4") {
		        $("#laboratory").show();
		        $("#equipment").hide();
		        $("#transport").hide();
		        $("#classroom").hide();
		        $("#hostel").hide();
		       }
		   
		    else if(val === "1") {
		        $("#hostel").show();
		        $("#equipment").hide();
		        $("#laboratory").hide();
		        $("#classroom").hide();
		        $("#transport").hide();
		      }
		    else if(val ==="2") {
		        $("#transport").show();
		        $("#equipment").hide();
		        $("#laboratory").hide();
		        $("#classroom").hide();
		        $("#hostel").hide();
		     }
		    else if(val ==="5" || val ==="6" || val ==="7" || val ==="8") {
		        $("#transport").hide();
		        $("#equipment").show();
		        $("#laboratory").hide();
		        $("#classroom").hide();
		        $("#hostel").hide();
		    }
		    
		  });
		  
		  $("#viewfacilityTypeId").change(function() {
		    var val = $(this).val();
		    if(val ==="3") {
		    	$("#viewClassRoom").show();
		        $("#viewEquipment").hide();
		        $("#viewLaboratory").hide();
		        $("#viewTransport").hide();
		        $("#viewHostel").hide();
		     }
		    else if(val ==="4") {
		        $("#viewLaboratory").show();
		        $("#viewEquipment").hide();
		        $("#viewTransport").hide();
		        $("#viewClassRoom").hide();
		        $("#viewHostel").hide();
		    }
		   
		    else if(val === "1") {
		        $("#viewHostel").show();
		        $("#viewEquipment").hide();
		        $("#viewLaboratory").hide();
		        $("#viewClassRoom").hide();
		        $("#viewTransport").hide();
		     }
		    else if(val ==="2") {
		        $("#viewTransport").show();
		        $("#viewEquipment").hide();
		        $("#viewLaboratory").hide();
		        $("#viewClassRoom").hide();
		        $("#viewHostel").hide();
		     }
		    else if(val ==="5" || val ==="6" || val ==="7" || val ==="8") {
		        $("#viewTransport").hide();
		        $("#viewEquipment").show();
		        $("#viewLaboratory").hide();
		        $("#viewClassRoom").hide();
		        $("#viewHostel").hide();
		    }
		  
		    
		  });
		  
	
         });


 
 
    