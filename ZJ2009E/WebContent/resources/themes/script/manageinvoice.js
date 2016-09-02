$(document).ready(function() {
			
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $('#example-select-all').on('click', function(){
		      // Check/uncheck all checkboxes in the table
		   var datatable = $('#invoiceList').DataTable();
		      var rows = datatable.rows({ 'search': 'applied' }).nodes();
		      $('input[type="checkbox"]', rows).prop('checked', this.checked);
		   });
	 
	 
	   
	 $('#invoiceList').on('change', 'input[type="checkbox"]', function(){
		      // If checkbox is not checked
		      if(!this.checked){
		         var el = $('#example-select-all').get(0);
		         // If "Select all" control is checked and has 'indeterminate' property
		         if(el && el.checked && ('indeterminate' in el)){
		            // Set visual state of "Select all" control 
		            // as 'indeterminate'
		            el.indeterminate = true;
		         }
		      }
		    
		   
		   });
	
	   
				$('#class').change(function(event) {
			  	    var classId = $("#class").val();
			  	  $(".form-group-section").hide();
			  	 $(".form-group-studentid").hide();
			  
			  	    if(classId!=="all"){
			  	    	 $(".form-group-section").show();
			  	    	  $.get(ctx+'/class/sectionsOfClass', {
				                classId : classId
				        }, function(response) {
				        	  var select = $('#section');
				        	   select.find('option').remove();
				        	   $.each(response, function(key,value) {
				            		 if(key==0){
				   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
				   	        	    	}
				            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
				            	  
				            	 }); 
				        });
			  	    	
			  	    }
			  	  
			       
			 });
				$("#admissionNo").click(function() {
					        $(".form-group-groupcriteria").hide();  
					    	
				});
			$("#criteria").change(function() {
				var value = $(this).val();
			
				 if(value==="specialcategory"){
					 
				        $(".form-group-special-category").show();  
					 
				 }
				 else
					 {
					 
					 
					
				        $(".form-group-special-category").hide();  
					 
					 
					 }
					
					 
		
		
			});
			 $("#getdetailsfromselectedcriteria").click(function(event){
				 $('#studentDetailsForm').validate({
					submitHandler: function(form) {
						$(".form-group-groupcriteria").show();
						 $(".form-group-studentid").show();
						  $(".form-group-section").hide();
						 $('.loader').show();
						    var data=$("#studentDetailsForm").serialize();
						    $.ajax(	
							    {
							        type: "GET",
							        url:ctx+"/invoice/students" ,
							        data: data,
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success:function (data) {
							        	 $('.loader').hide();
							        	  document.getElementById('invoicedetailsdiv').style.display="block";
							        	var datatable = $('#invoiceList').DataTable();
							        	 $(".form-horizontal").trigger('reset'); 
											      datatable.clear().draw();
											  $.each(data, function (i, item) {
												  if(item!=null){
													  var name;
											        	if(item.lastName!=null){
											        		name=item.firstName+' '+item.lastName;
											        	}else{
											        		name=item.firstName;
											        	}
											        	datatable.row.add(['<input type="checkbox" value='+item.studentId+' name="studentId" class="case" id='+item.studentId+'></input>',item.admissionNo,name,item.studentClass.className,item.section.sectionName]).draw( false );
												  }
												 });
							      
							        
									 	
							        
							        },
							        error:function(){
							        	 $('.loader').hide();
							        	$(".form-horizontal").trigger('reset'); 
							        	document.getElementById('invoicedetailsdiv').style.display="none";
							        	 alert("Data  Not Found")
								 	    }
							      
							    });
								
			       
			    		
				        return false;   
				        
				        
				        
				        
					   }
						  
				  });	
				 
				 
				
				  });	 	  

			 $('#deletegenerateinvoice').click(function() {
					
					
				 var selectedstudentids = [];
				
				 var oTable = $('#invoiceList').dataTable();
				 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
				 rowcollection.each(function(index,elem){
					 selectedstudentids.push($(elem).val());
				 });
				 
				 $("#selectedStudentIds").val(selectedstudentids);
				 if((selectedstudentids.length)>0)
				 {
					if($("#generateinvoiceform").valid()){
						$("generateinvoiceform").submit();
					}
					 
				 }
				 else{
					 
					 alert(" You have to select atleast one student")
					 
					 
				 }
			 });
			
			});
			
			
			
			
			
			
			
			
	
		
		function select_all() {
		
			$('input[class=case]:checkbox').each(function(){ 
				
				if($('input[class=check_all]:checkbox:checked').length == 0)
				{ 
					$(this).prop("checked", false); 
					
				} else 
				{ 
					$(this).prop("checked", true); 
				} 
				
				
				
			});
		}
	

   