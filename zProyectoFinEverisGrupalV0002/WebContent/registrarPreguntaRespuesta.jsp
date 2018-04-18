<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar pregunta y respuesta</title>
		<link rel="stylesheet" href="css/registroPreguntaStyle.css">
	</head>
<body>
	<h1>Registrar pregunta y respuesta para el formulario</h1>
	
	<div class="formularioRegistroPregunta">
			<form action="ServletRegistroAdminPregunta" method="post">
				
				<label>Introduzca la pregunta:</label>
				<input type="text" name="registroPregunta" placeholder="Pregunta">
				<br/><br/>
			
				<label>Se�ale el tipo de respuesta:</label>
				<input type="radio" name="tipoRespuesta" value="Texto">Texto &nbsp;&nbsp;&nbsp;
				<input type="radio" name="tipoRespuesta" value="Radio">Radio &nbsp;&nbsp;&nbsp;
				<input type="radio" name="tipoRespuesta" value="Check">Check &nbsp;&nbsp;&nbsp;
				<br/><br/>
				
				<label>Introduzca la respuesta (Si es respuesta m�ltiple introduzca las respuestas separadas por guiones):</label><br/>
				<label>Ejemplo: respuesta1-respuesta2-respuesta3</label><br/>
				<input type="text" name="resgistroRespuesta" placeholder="Respuesta">
				<br>
				<input type="submit" value="Registrar pregunta">
				
			</form>
		</div>
</body>
</html>