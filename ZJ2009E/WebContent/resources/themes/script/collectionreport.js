$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

	 $('#fineTable').DataTable({
		 dom: 'Bfrtip',
         buttons: [
             'csv', 'excel', 'pdf', 'print'
         ]
	 });
		
});