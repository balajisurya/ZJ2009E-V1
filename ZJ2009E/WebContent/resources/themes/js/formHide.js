function showDiv(){
	  $(".form-horizontal").trigger('reset'); 
		if(document.getElementById('ListDiv').style.display=="block"){
	  
		document.getElementById('FormDiv').style.display="block";
		document.getElementById('ListDiv').style.display="none";
	}
	else{
		document.getElementById('FormDiv').style.display="none";
		document.getElementById('ListDiv').style.display="block";
		
		 
	    // let the browser natively reset defaults
	
	}	
}
function cancelDiv(){
	 $(".form-horizontal").trigger('reset'); 
	if(document.getElementById('EditFormDiv').style.display="block"){
		document.getElementById('EditFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}


function showeditDiv(){
	if(document.getElementById('EditFormDiv').style.display=="none")
	{
	document.getElementById('EditFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('EditFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showopenDiv(){
	if(document.getElementById('OpenFormDiv').style.display=="none"){
	document.getElementById('OpenFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

function cmDiv(){
	if(document.getElementById('candmDiv').style.display=="none"){
	document.getElementById('candmDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('candmDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function labsDiv(){
	if(document.getElementById('labsDiv').style.display=="none"){
	document.getElementById('labsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('labsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}
function lessonsDiv(){
	if(document.getElementById('lessonsDiv').style.display=="none"){
	document.getElementById('lessonsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('lessonsDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function assignmentsDiv(){
	if(document.getElementById('assignmentDiv').style.display=="none"){
	document.getElementById('assignmentDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('assignmentDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function outstandingDiv(){
	if(document.getElementById('outstandingDiv').style.display=="none"){
	document.getElementById('outstandingDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('outstandingDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function notificationsDiv(){
	if(document.getElementById('notificationsDiv').style.display=="none"){
	document.getElementById('notificationsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('notificationsDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function showsetupDiv(){
	if(document.getElementById('SetupDiv').style.display=="none"){
	document.getElementById('SetupDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('SetupDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showsemestersystemDiv(){
	if(document.getElementById('semestersystemDiv').style.display=="none"){
	document.getElementById('semestersystemDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('semestersystemDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

function showSignUpForm(){
	if(document.getElementById('FormDiv').style.display=="none"){
	document.getElementById('FormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	}
else{
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

/////class and section script

function showClassAndSectionDiv(){
	if(document.getElementById('classAndSectionDiv').style.display=="none"){
	document.getElementById('classAndSectionDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('classAndSectionDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showeditsectionDiv(){
	if(document.getElementById('EditSectionFormDiv').style.display=="none")
	{
	document.getElementById('EditSectionFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	
	document.getElementById('classAndSectionDiv').style.display="none";
	
	
}

}
function showeditclassandsectionDiv(){
	if(document.getElementById('EditClassFormDiv').style.display=="none")
	{
	document.getElementById('EditClassFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	
	document.getElementById('classAndSectionDiv').style.display="none";

	
}

}
///FCR





function showpaymentDiv(){
	if(document.getElementById('PaymentFormDiv').style.display=="none"){
	document.getElementById('PaymentFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('feesItemFormDiv').style.display="none";
	document.getElementById('FormDiv').style.display="none";
	
	}

}


