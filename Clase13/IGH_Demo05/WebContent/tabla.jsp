
<%@page import="pe.igh.app.dto.TablaItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	List<TablaItem> lista = (List<TablaItem>) request.getAttribute("lista");

%>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>TABLA DE MULTIPLICAR</h1>
	
		<h2>DATOS</h2>
		
	<form method="post" action="TablaMultiplicar">
		<label>Número: </label>
		<input type="text" name="num">
		<input type="submit" />
	</form>
	
	<h2>RESULTADO</h2>
	
	<table>
		<% for( TablaItem item: lista) { %>
		<tr>
			<td><%= item.getNum1() %></td>
			<td><%= item.getOperador() %></td>			
			<td><%= item.getNum2() %></td>
			<td><%= item.getRpta() %></td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>