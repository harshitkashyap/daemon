<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="banner.jsp"/>
<form action="User.zs">
<table border="2">


	
	
	<tr><th colspan="2" >registeration</th></tr>
	<tr><td>email<td><input name="email"></td>
	</tr>
	
	<tr><td colspan="2" >preferred role</td></tr>
	<tr><td><input name="role"></td>
	</tr>
	
	<tr><td colspan="2" >current location</td></tr>
	<tr><td><input name="location"></td>
	</tr>
	
	<tr><td colspan="2" >skill</td></tr>
	<tr><td><input name="skill"></td>
	</tr>
	
	
	
	<tr><td>experience</td>
		<td><select name="experience">
		<% for(int ex=1;ex<=15;ex++) { %>
		<option value="<%=ex %>"><%=ex %></option>
		<%} %>
		</select></td>
	</tr>
	
	<tr><td colspan="2" >expected salary</td></tr>
	<tr><td><input name="salary"></td>
	</tr>
	
	<tr>
	<input type="submit" value="finish">
	
	</tr>
	


</table>

</form>
</body>

</html>