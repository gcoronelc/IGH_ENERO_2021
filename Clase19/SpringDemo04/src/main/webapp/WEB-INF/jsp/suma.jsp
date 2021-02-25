<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>SUMA</h1>
	
	<h3>Datos</h3>
	<form method="post" action="/mate/suma">

		<div>
			<label>Número 1:</label> 
			<input type="text" name="n1" />
		</div>
		
		<div>
			<label>Número 2:</label> 
			<input type="text" name="n2" />
		</div>

		<div>
			<input type="submit" value="Procesar" />
		</div>

	</form>
	
	<h3>Resultado</h3>
	
	<p>Número 1: ${n1}</p>
	<p>Número 2: ${n2}</p>
	<p>Suma: ${suma}</p>
		
</body>
</html>