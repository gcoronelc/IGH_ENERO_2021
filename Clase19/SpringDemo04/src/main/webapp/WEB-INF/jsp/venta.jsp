<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>VENTA</h1>
	
	<h3>Datos</h3>
	<form method="post" action="/venta/proceso">

		<div>
			<label>Precio:</label> 
			<input type="text" name="precio" />
		</div>
		
		<div>
			<label>Cantidad:</label> 
			<input type="text" name="cantidad" />
		</div>

		<div>
			<input type="submit" value="Procesar" />
		</div>

	</form>
	
	<h3>RESULTADO</h3>
	
	<p>Precio: ${venta.precio}</p>
	<p>Cantidad: ${venta.cantidad}</p>
	<p>Importe: ${venta.importe}</p>
</body>
</html>