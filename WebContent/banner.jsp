<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Daemon Job Portal</h1>
<p>your path to great oppourtunity </p>
<%String name = (String)session.getAttribute("name"); %>
<div>hello <%=name %>|<a href="Home.jsp?logout=yes">logout</a>
<a href="profile.jsp">profile</a>


</div>
</body>
</html>