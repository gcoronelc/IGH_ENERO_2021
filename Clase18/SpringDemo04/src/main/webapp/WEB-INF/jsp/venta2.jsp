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
	<form id="frmVenta">

		<div>
			<label>Precio:</label> 
			<input type="text" name="precio" />
		</div>
		
		<div>
			<label>Cantidad:</label> 
			<input type="text" name="cantidad" />
		</div>

		<div>
			<input type="button" id="btnProcesar" value="Procesar" />
		</div>

	</form>
	
	<h3>RESULTADO</h3>
	
	<p>Precio: <span id="repoPrecio"></span></p>
	<p>Cantidad: <span id="repoCantidad"></span></p>
	<p>Importe: <span id="repoImporte"></span></p>
	
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	
	<script type="text/javascript">

	$(function() {

		$("#btnProcesar").click(fnProcesar);

		  
	});

	function fnProcesar(){
		let data = $("#frmVenta").serialize();
		$.post("/venta/proceso3", data, function(venta){
			$("#repoPrecio").html(venta.precio);
			$("#repoCantidad").html(venta.cantidad);
			$("#repoImporte").html(venta.importe);
		});

	}

	</script>
	
</body>
</html>