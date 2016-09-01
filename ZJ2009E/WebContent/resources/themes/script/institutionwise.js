$(document).ready(function() {
    $('#institutionWise').DataTable( {
    	"searching":false,
    	 dom: 'Bfrtip',
         buttons: [
             'csv', 'excel', 'pdf', 'print'
         ]
        
    } );
} );