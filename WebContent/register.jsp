<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href=”bootstrap/bootstrap.css” rel=”stylesheet” type=”text/css” />
<link href="bootstrap/signin.css" rel="stylesheet">
</head>
<body>

<jsp:include page="banner.jsp"/>

    <div class="container" id="focus">

      <form class="form-signin" action="User.zs"style="background:white;">
        <h2 class="form-signin-heading">Input Details</h2>
        
        <label  class="sr-only">Name</label><br>
        <input class="form-control" placeholder="Name" required autofocus name="name"><br>
        
         <label  class="sr-only">Email</label><br>
        <input type="email"  class="form-control" placeholder="Email" required autofocus name="email"><br>
        
        <br><label  class="sr-only">Password</label><br>
        <input type="password"  class="form-control" placeholder="password" required name="password">
        
         <br><label  class="sr-only">Gender</label><br>
         
          <div class="checkbox">
          <label>
           	
           	 male :<input type="radio" name="gender" value="male" checked >female:
			<input type="radio" name="gender" value="female">
	
          </label>
        </div>
        
        
		<label  class="sr-only">Age</label><br>
        <input  class="form-control" placeholder="age" required autofocus name="age"><br>
        
        <label  class="sr-only">City</label><br>
        <input  class="form-control" placeholder="city" required autofocus name="city"><br>
        
        <label  class="sr-only">Phone</label><br>
        <input  class="form-control" placeholder="contact number" required autofocus name="phone"><br>
        
        
       	<br><br>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="next">Next</button>
      </form>

    </div> <!-- /container -->


   
  </body>


<%-- <form action="User.zs">

<%@ include file="banner.html"%>

	<table class="table table-dark" border="2">
	
	<tr><th colspan="2" >registeration</th></tr>
	<tr><td><input name="name"></td>
	</tr>
	
	<tr><td colspan="2" >email</td></tr>
	<tr><td><input name="email"></td>
	</tr>
	
	<tr><td colspan="2" >password</td></tr>
	<tr><td><input name="password" type="password"></td>
	</tr>
	
		<tr><td colspan="2" >gender</td></tr>
	<tr><td>male :<input type="radio" name="gender" value="male" checked>female:
	<input type="radio" name="gender" value="female"></td>
	</tr>
	
	<tr><td>age</td>
		<td><select name="age">
		<% for(int a=1;a<=50;a++) { %>
		<option value="<%=a %>"><%=a %></option>
		<%} %>
		</select></td>
	</tr>
	
	<tr>
	<tr><td colspan="2" >city</td></tr>
	<tr><td><input name="city"></td>
	</tr>
	
	<tr><td colspan="2" >phone</td></tr>
	<tr><td><input name="phone"></td>
	</tr>	
	<tr>
	<th colspan="2"><input type="submit" value="next"></th>
	</tr>
	
	
	
	
	</table>

</form> --%>

</body>
</html>