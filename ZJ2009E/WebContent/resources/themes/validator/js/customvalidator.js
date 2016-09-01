/** currency Only**/
function isFloatNumber(item,evt) 
{
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode==46)
    {
    	
        var regex = new RegExp(/\./g)
        var count = $(item).val().match(regex).length;
        if (count > 1)
        { 
            return false;
        }
   }
 
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    } 
   
    
    
    return true;
  
}

//DECIMAL POINT
function decimalAmount(myfield, e, dec)
{
 var str = myfield.value;
 var decPos = str.split('.');
 
 var key;
 var keychar;
 
if (window.event)
 key = window.event.keyCode;
else if (e)
 key = e.which;
else
 return true;


if (key==46)
{
    var regex = new RegExp(/\./g)
    var count = $(myfield).val().match(regex).length;
    if (count > 1)
    { 
        return false;
    }
}
if (key > 31 && (key < 48 || key > 57)) {
    return false;
  } 
  
keychar = String.fromCharCode(key);
 
if ((key==null) || (key==0) || (key==8) || (key==9) || (key==13) || (key==27) ) // control keys
 return true;
else if(decPos.length > 1)
{
 decPos = decPos[1];
 if(decPos.length >= 2) return false;
}
else if ((("0123456789.").indexOf(keychar) > -1)) // numbers
 return true;
else if (dec && (keychar == ".")) // decimal point jump
{
 myfield.form.elements[dec].focus();
 return false;
}
else
 return false;
}

//Numbers Only
function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	    	
	 	
	 	
	        return false;
	    }
	    
	    return true;
	}



////password

/*function myFunction() {
    var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    if (pass1 != pass2) {
        //alert("Passwords Do not match");
        document.getElementById("pass1").style.borderColor = "#E34234";
        document.getElementById("pass2").style.borderColor = "#E34234";
    }
    else {
        alert("Passwords Match!!!");
    }
}*/


/*function checkPassword(str)
{
  var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
  return re.test(str);
}

function checkForm(form)
{
  if(form.username.value == "") {
    alert("Error: Username cannot be blank!");
    form.username.focus();
    return false;
  }
  re = /^\w+$/;
  if(!re.test(form.username.value)) {
    alert("Error: Username must contain only letters, numbers and underscores!");
    form.username.focus();
    return false;
  }
  if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
    if(!checkPassword(form.pwd1.value)) {
      alert("The password you have entered is not valid!");
      form.pwd1.focus();
      return false;
    }
  } else {
    alert("Error: Please check that you've entered and confirmed your password!");
    form.pwd1.focus();
    return false;
  }
  return true;
}

*/
	