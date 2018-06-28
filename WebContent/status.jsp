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

<% String status = request.getParameter("job");
	if(status.equals("success")) {%>
	
	<font size="5" color="blue"> Job submitted successfully</font>
<%}else { %>
	
	<font size="5" color="red"> Job application already exist</font>
<%} %>


</body>
</html>