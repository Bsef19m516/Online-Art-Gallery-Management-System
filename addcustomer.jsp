<html>

  <script>
    function validateForm() {

if (document.signup.name.value == "") {
    //alert("Name Field Empty!!")
    document.getElementById("i1").innerHTML =
            "*Name field is empty";
    document.signup.name.focus();
    return false;
}

if (!/^[a-z A-Z]+$/.test(document.signup.name.value)) {
    alert("Name must contain only alphabets")
    document.signup.name.focus()
    return false;
}



if (document.signup.password.value == "") {
   //alert("Password field is empty");
     document.getElementById("i2").innerHTML="*Password is empty"; 
    document.signup.password.focus();
    return false;

}
if (document.signup.confirm_password.value == "") {
    alert("Confirm Password field is empty");
    document.signup.confirm_password.focus();
    return false;
}
if (document.signup.password.value != document.signup.confirm_password.value) {
    alert("Password and Confirm password does not match");
    document.signup.confirm_password.focus();
    return false;
}

}


}

</script>
<body><center> 
<h2> Online art gallery  </h2> 
<h3> Signup and became our customer</h3> 


<form name ="signup" action="addcustomer" onSubmit = "return validateForm()" > 

<TABLE BORDER="1" > 

<TR> 
  <TD> <h4 > Name </h4> </TD> 
 <TD> <input type="text" name="name" /> </TD> 
</TR> 

<TR>
  <TD> <h4> Address </h4> </TD> 
  <TD> <input type="text" name="address" /> </TD> 
</TR> 

<TR> 
  <TD> <h4>Phone Number</h4> </TD> 
  <TD> <input type="text" name="phoneNum" /> </TD> 
</TR> 

<TR> 
  <TD> <h4 > Password </h4> </TD> 
 <TD> <input type="password" name="password" /> </TD> 
</TR> 
<TR> 
  <TD> <h4 > Confirm_Password </h4> </TD> 
 <TD> <input type="password" name="confirm_password" /> </TD> 
</TR> 


<TR> 
  <TD COLSPAN="2" ALIGN="CENTER"><input type="submit" value="signup" name="action" />
			<input type="reset" value="clear" /></TD> 
</TR> 


</TABLE></form> 


</center></body></html>