		/*	Daterange Pickers*/		
			$(function() {

				  $('.form-control-datepicker-range').daterangepicker({
				      autoUpdateInput: false,
				      locale: {
				          cancelLabel: 'Clear'
				      }
				  });

				  $('.form-control-datepicker-range').on('apply.daterangepicker', function(ev, picker) {
				      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
				  });

				  $('.form-control-datepicker-range').on('cancel.daterangepicker', function(ev, picker) {
				      $(this).val('');
				  });

				});
			
