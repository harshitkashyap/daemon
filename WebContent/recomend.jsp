<%@page import="lti.demon.bean.RequirementBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <% include file="banner.html" %> --%>

<% List<RequirementBean> recomend=(List) request.getAttribute("Recommend"); %>

<table border="2">

<tr><th colspan="7">Job recomendation for you</th></tr>
<% if(recomend.size()==0){ %>
	<tr><td colspan="7">Sorry no recomendation</td></tr>
	
<%}else for(RequirementBean bean:recomend) {%>
	<tr>
		<td><%= bean.getCompany() %></td>
		<td><%= bean.getType() %></td>
		<td><%= bean.getLocation() %></td>
		<td><%= bean.getSkill() %></td>
		<td><%= bean.getExperience() %></td>
		<td><%= bean.getSalary() %></td>
		<td><a href="Daemon.job?jobid=<%= bean.getId() %>">Apply</a></td>
		</tr>
		<%} %>
	

</table>

</body>
</html>