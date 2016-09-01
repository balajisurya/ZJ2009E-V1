var resizefunc = [];
        var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        function checkPasswordMatch() {
             var password = $("#adminPassword").val();
             var confirmPassword = $("#adminConfirmPassword").val();

             if (password != confirmPassword){
             	$(".error1").show();
                 $(".error1").html("Passwords do not match!");
             }
             	
             else
             	$(".error1").hide();
         }
          $(document).ready(function(){
        	     $("#confirm").keyup(checkPasswordMatch);
        	      $('#geographicallocation').change(function(event) {
        	     	    var countryid = $(this).children(':selected').attr('id');
        	     	    $.get(ctx+'/geographicallocation/state', {
        		                countryId : countryid
        		        }, function(response) {
        		        	  var select = $('#geographicallocationstate');
        		        	   select.find('option').remove();
        		        	   var select1=$('#geographicallocationcity');
        		        	   		select1.find('option').remove();
        		            	 var obj = jQuery.parseJSON(response);
        		            	
        		            	 $.each(obj, function(key,value) {
        		            		 if(key==0){
        		   	        	    		select.append('<option value="" disabled selected>Select State</option>');
        		   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
        		   	        	    	}
        		            		 $('#geographicallocationstate').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
        		            	}); 
        		        });
        		       
        		 });
        		        
        		        
        		$('#geographicallocationstate').change(function(event) {
        		    var stateid = $(this).children(':selected').attr('id'); 

        		    $.get(ctx+'/geographicallocation/city', {
        		            stateId : stateid
        		    }, function(response) {
        		    	
        		    	  var select = $('#geographicallocationcity');
        		        	 select.find('option').remove();
        		        	 var obj = jQuery.parseJSON(response);
        		        	
        		        	 $.each(obj, function(key,value) {
        		        		 if(key==0){
        		        	    		select.append('<option value="" disabled selected>Select City</option>');
        		        	    	}
        		        		 $('#geographicallocationcity').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
        		        	  
        		        	 }); 
        		    });
        		   
        		    });
          })

         $(document).ready(function() {
                 $("#institutionProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder2");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                    	  $('#institutionProfilePic').val(''); 
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                	   $('#institutionProfilePic').val(''); 
                     alert("Please select only images");
                   }
                 });
               });