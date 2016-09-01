var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function(){
	
	
	//start special category wise student ratio
	var specialCategoryId=$("#specialCategory").val();
	specialCategoryWiseStudentComponentData(specialCategoryId);
	
	
	var classId=$("#classList").val();
	classWiseComponentData(classId);
	
	var categoryId=$("#Category").val();
	categoryWiseComponentData(categoryId);
	
	$("#specialCategory").change(function(){
		var specialCategoryId=$(this).val();
		specialCategoryWiseStudentComponentData(specialCategoryId);
	});
	
	
	$("#classList").change(function(){
		var classId=$(this).val();
		classWiseComponentData(classId);
	});
	
	
	$("#Category").change(function(){
		var categoryId=$(this).val();
		categoryWiseComponentData(categoryId);
	});
	//end special category wise student ratio
	
	 
	//start blood group wise student count
	bloodGroupWiseStudentCount();
	//end blood group wise student count
});

function categoryWiseComponentData(categoryId)
{
	if(categoryId!=null)
	{
		$.ajax({
			   url:ctx+'/dashboard/studentRatioFromCategory',
			   data:{categoryId:categoryId},
			   type:'GET',
			   success: function(response){
				   if(response.f1>0 | response.f2>0 | response.f3>0){
					   document.getElementById('cateoryImage').style.display="none";
					   document.getElementById('categoryChart').style.display="block";
					   document.getElementById('d1-legend2').style.display="block";
					   $('#doughnut2').remove(); // this is my <canvas> element
					   $('#categoryChart').append('<canvas id="doughnut2" style="width:400px; height: 250px;"></canvas>');
					   
						var doughnutData1 = [
												{
													value: response.f1,
													color:'#'+Math.random().toString(16).substr(-6),
													 label: "Male"
												},
												{
													value : response.f2,
													color : '#'+Math.random().toString(16).substr(-6),
													 label: "Female"
												},
												{
													value : response.f3,
													color : '#'+Math.random().toString(16).substr(-6),
													 label: "Others"
												}
												
											];
							
							var d1	=new Chart(document.getElementById("doughnut2").getContext("2d")).Doughnut(doughnutData1);
							document.getElementById('d1-legend2').innerHTML = d1.generateLegend();
							 
					}
				   else
					{
					   document.getElementById('cateoryImage').style.display="block";
					   document.getElementById('categoryChart').style.display="none";
					   document.getElementById('d1-legend2').style.display="none";
					}
				},
			   error: function(){
			     alert('ERROR OCCURED');
			   }
			 });
	}
	else
	{
		 document.getElementById('cateoryImage').style.display="block";
		   document.getElementById('categoryChart').style.display="none";
		   document.getElementById('categoryDiv').style.display="none";
		   document.getElementById('d1-legend2').style.display="none";
	}
}


function classWiseComponentData(classId)
{
	
	if(classId!=null)
	{
		$.ajax({
			   url:ctx+'/dashboard/studentRatioFromClass',
			   data:{classId:classId},
			   type:'GET',
			   success: function(response){
				   if(response.f1>0 | response.f2>0 | response.f3>0){
					   document.getElementById('classImage').style.display="none";
					   document.getElementById('classChart').style.display="block";
					   document.getElementById('b1-legend').style.display="block";
					 
					   $('#bar1').remove(); // this is my <canvas> element
					   $('#classChart').append('<canvas id="bar1" height="300" width="800" style="width: 400px; height: 370px;"></canvas>');
					var classwisestudent = {
								labels : [""],
								datasets : [
									
									{
										fillColor : '#'+Math.random().toString(16).substr(-6),
										label: "Male",
										data : [response.f1]
										
									},
									{
										fillColor : '#'+Math.random().toString(16).substr(-6),
										label: "Female",
										data : [response.f2]
										
									},
									{
										fillColor : '#'+Math.random().toString(16).substr(-6),
										label: "Others",
										data : [response.f3]
										
									}
								]  
								
							};
					
						var b=	new Chart(document.getElementById("bar1").getContext("2d")).Bar(classwisestudent);
						document.getElementById('b1-legend').innerHTML = b.generateLegend();
						
					
						
					}
				   else
					{
					   document.getElementById('classImage').style.display="block";
					   document.getElementById('classChart').style.display="none";
					   document.getElementById('b1-legend').style.display="none";
					}
				},
			   error: function(){
			     alert('ERROR OCCURED');
			   }
			 });
	}
	else
	{
		 document.getElementById('classImage').style.display="block";
		   document.getElementById('classChart').style.display="none";
		   document.getElementById('classDiv').style.display="none";
		   document.getElementById('b1-legend').style.display="none";
	}
}


function specialCategoryWiseStudentComponentData(specialCategoryId){
	
	if(specialCategoryId!=null){
		$.ajax({
			   url:ctx+'/dashboard/studentRatioFromSpecialCategory',
			   data:{specialCategory:specialCategoryId},
			   type:'GET',
			   success: function(response){
				   if(response.f1>0 | response.f2>0| response.f3>0){
					   document.getElementById('specialCateoryImage').style.display="none";
					   document.getElementById('specialCategoryChart').style.display="block";
					   document.getElementById('d1-legend').style.display="block";
					   $('#doughnut1').remove(); // this is my <canvas> element
					   $('#specialCategoryChart').append('	<canvas id="doughnut1" style="width:400px; height: 250px;"></canvas>');
						var doughnutData1 = [
												{
													value: response.f1,
													color:'#'+Math.random().toString(16).substr(-6),
													 label: "Male"
												},
												{
													value : response.f2,
													color : '#'+Math.random().toString(16).substr(-6),
													 label: "Female"
												},
												{
													value : response.f3,
													color : '#'+Math.random().toString(16).substr(-6),
													 label: "Others"
												}
											];
							
							var d1	=new Chart(document.getElementById("doughnut1").getContext("2d")).Doughnut(doughnutData1);
							document.getElementById('d1-legend').innerHTML = d1.generateLegend();
							
							
					}
				   else
					{
					
					   document.getElementById('specialCateoryImage').style.display="block";
					   document.getElementById('specialCategoryChart').style.display="none";
					   document.getElementById('d1-legend').style.display="none";
					}
				},
			   error: function(){
			     alert('ERROR OCCURED');
			   }
			 });
	}else
	{
		  document.getElementById('specialCateoryImage').style.display="block";
		   document.getElementById('specialCategoryChart').style.display="none";
		   document.getElementById('d1-legend').style.display="none";
		   document.getElementById('specialCategoryDiv').style.display="none";
	}
	
}



function bloodGroupWiseStudentCount(){
	 

	
	$.ajax({
		   url:ctx+'/dashboard/bloodGroupWiseStudentCount',
		   type:'GET',
		   success: function(response){
			 
				   var tmp=new Array();
			 var count=0;
			   $('#pie').remove(); // this is my <canvas> element
			   $('#bloodGroupChart').append('<canvas id="pie" height="320" width="400" style="width: 400px; height: 250px;"></canvas>');
              	$.each(response, function(key,data)
                              {   
              		if(data.f2==0)
              			{
              			count++;
              			}
                     tmp.push({
              			value: data.f2,
            			color:'#'+Math.random().toString(16).substr(-6),
            			label: data.f1});
                  
                      });
          
      
			if(count!=9){
				  document.getElementById('bloodGroupImage').style.display="none";
				   document.getElementById('bloodGroupChart').style.display="block";
				   document.getElementById('p-legend').style.display="block";
			   var p=	new Chart(document.getElementById("pie").getContext("2d")).Pie(tmp);
			    document.getElementById('p-legend').innerHTML = p.generateLegend();
				  }
			   else
			   {
				   document.getElementById('bloodGroupImage').style.display="block";
				   document.getElementById('bloodGroupChart').style.display="none";
				   document.getElementById('p-legend').style.display="none";
			   }
			},
		   error: function(){
		     alert('ERROR OCCURED');
		   }
		 });
}