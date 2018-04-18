<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="modelos.Preguntas" %>
<%@page import="modelos.Respuestaspreguntas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Rellene el formulario</title>
		<link rel="stylesheet" href="css/formulario.css">
	</head>
	
	<body>

		<div class='explicacion'>Por favor, conteste a las preguntas que se muestran a continuación y envíe el formulario.</div>
	
		<form action="ServletRecogidaDatos" method="post">
			<%
			if(request.getAttribute("preguntas") instanceof List){
				
				//Recojo las preguntas y respuestas del servlet
				List<?>listaPreguntas=(List<?>)request.getAttribute("preguntas");
				List<?>listaRespuestas=(List<?>)request.getAttribute("respuestas");
				
				//Bucle para ir publicando las preguntas
				for(int i=0;i<listaPreguntas.size();i++) {
					out.println("<div class='campoFormulario'>");
					//Voy sacando pregunta y su respectiva respuesta
					Preguntas pregunta = (Preguntas)listaPreguntas.get(i);
					Respuestaspreguntas respuesta = (Respuestaspreguntas)listaRespuestas.get(i);
					
				    out.println(pregunta.getDescripcion() + "<br/>");
				    
				    //Si la pregunta es de texto...
				    if(pregunta.getTipo()== 1){
				    	
				    	out.println("<input class='texto' type='text' name='" + pregunta.getTipo() + "_" + pregunta.getIdpregunta() + "'><br/>");
				    	out.println("</div>");
				    	
				    }else if(pregunta.getTipo() == 2){//Si la pregunta es de tipo radio...
				    	
				    	//Guardo en un array las posibles respuestas
				    	String[] respuestasRadio = respuesta.getDescripcion().split("-");
				    	
				    	//Imprimo cada respuesta
				    	for(int j=0;j<respuestasRadio.length;j++){
				    		out.println("<input class='radio' type='radio' name='" + pregunta.getTipo() + "_" + pregunta.getIdpregunta() + "' value='" + respuestasRadio[j] + "'> " + respuestasRadio[j] + "&nbsp;&nbsp;&nbsp;");
				    	}
				    	out.println("</div>");
				    	
				    }else if(pregunta.getTipo() == 3){//Si la pregunta es de tipo check lo mismo que las de tipo radio
				    	
				    	String[] respuestasCheck = respuesta.getDescripcion().split("-");
				    
				    	for(int j=0;j<respuestasCheck.length;j++){
				    		out.println("<input class='check' type='checkbox' name='" + pregunta.getTipo() + "_" + pregunta.getIdpregunta() + "_" + (j+1) + "' value='" + respuestasCheck[j] + "'> " + respuestasCheck[j] + "&nbsp;&nbsp;&nbsp;");
				    	}
				    	out.println("</div>");
				    }
				}
			}
			%>
			
			<input class='submit' type="submit" value="Enviar formulario">
	
		</form>
	</body>
</html>