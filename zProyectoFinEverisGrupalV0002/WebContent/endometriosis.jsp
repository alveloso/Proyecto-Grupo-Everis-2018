<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Endometriosis</title>
	</head>
	<body>
	
	<c:if test="${sessionScope.idUser != null}">
		Bienvenido: ${sessionScope.idUser} <br/>
		<a href="ServletsListadoPreguntas">Preguntas</a>&nbsp;
		<a href="ServletListadoRespuestaspreguntas">Respuestas preguntas</a>&nbsp;
		
		<!--Para ir al formulario -->
		<a href="ServletCreaFormulario">IR AL FORMULARIO</a>
	</c:if>
	
	<c:if test="${sessionScope.idUserAdmin != null}">
		Bienvenido ADMINISTRADOR: ${sessionScope.idUser} <br/>
		<!-- Registrar editar borrar nuevas preguntas redirecciones -->
		<a href="ServletCargaDeDatosPreviaParaBusquedaPregunta">Borrar Preguntas</a>&nbsp;
	</c:if>
	
		<!-- Queda pendiente mostrar por aquí mensaje de formulario realizado-->
		<!-- Variable setAttribute mensajeFormSubido en servletRecogidaDatos-->
	</body>
</html>
