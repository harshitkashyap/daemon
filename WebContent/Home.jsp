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
<%-- <body>

<%@ include file="banner.html" %>
 <div class="container-fluid">
 <div class="row">
 <div class="col-md-4 col-sm-4 col-xs-12">
<form class="form-signin">
  <div class="form-group">
    <label >Email address</label>
    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
</div>
 --%>

<!-- <form action="User.zs">

	<table>
	<tr><th colspan="2">lOGIN sCREEN</th></tr>
		
	<tr><td colspan="2" >email</td></tr>
	<tr><td><input name="email"></td>
	</tr>
	
	<tr><td colspan="2" >password</td></tr>
	<tr><td><input name="password" type="password"></td>
	</tr>
	
	
	<tr><th colspan="2"><input type="submit" value="login"></th></tr>
	
	<tr><td colspan="2"><a href="register.jsp">join us</a>
	</td></tr>
	
	
	
	
</table>

</form> -->


<body background="iamge1.jpg">

<%  if(request.getParameter("logout")!=null){
	session.invalidate();
		}
	%>


    <div class="container" id="focus">

      <form class="form-signin" action="User.zs" style="background:white;">
        <h2 class="form-signin-heading">LOG IN</h2>
        <label for="inputEmail" class="sr-only">Email address</label><br>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus name="email"><br>
        <label for="inputPassword" class="sr-only">Password</label><br>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
        <div class="checkbox">
          <label>
           	<a href="register.jsp">join us</a>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      
      
<% if(request.getParameter("invalid")!=null) {%>
  <h2 class="form-signin-heading">Invalid Usr Id/ Password</h2>
  <%} %>

    </div> <!-- /container -->


  
  </body>




</html>