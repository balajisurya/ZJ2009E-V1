



$(document).ready(function() {
        	 
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	//adding new staff
        	 $("#staffattendance").click(function(event){
        		 $('#confirm-save').modal('show');
        		
        		 $('#save-attendance').click(function() {
        			 
        			  /* var date=$("#staffAttendanceDate").val();*/
        			   var attendancelists= [];
        			   

        			    var table = $("table tbody");

        			    table.find('tr').each(function () {
        			        var $tds = $(this).find('td');
        			        attendancelists +="-"+[$tds.eq(0).attr('id'),$tds.eq(3).find("option:selected").attr('value'),$tds.eq(4).find('input').val()];
        			            });
                               var date= $("#staffAttendanceDate").val();
        		            $.post(ctx+"/staff/attendance/save?attendanceLists="+attendancelists+"&staffAttendanceDate="+date,function(){
        					  location.reload();
        				     });
        				
        			 

        			}); 
        		
        		 
        		 
        		 
        		 
        		 
        	 });
        	
        	 return false; 
         });
    
   
      
