<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Secccion para editar la pregunta</h1>
	<form action="ServletGuardarCambios" method="post">
		<label>Pregunta a editar</label><br/>
		<input type="text" name="guardarPregunta" value="${preguntaAeditar.descripcion}">
		<input type="hidden" name="idPreguntaEditada" value="${preguntaAeditar.idpregunta}">
		
		<c:if test="${respuestaAeditar != null}">
			<label>Respuesta a editar</label><br/>
			<label>Recuerde separar las posibles respuestas con -</label><br/>
			<input type="text" name="guardarRespuesta" value="${respuestaAeditar.descripcion}">
		</c:if>
		
		<input type="submit" value="Guardar cambios">
	</form>

</body>
</html>