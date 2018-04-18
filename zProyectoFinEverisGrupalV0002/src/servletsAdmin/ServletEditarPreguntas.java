package servlets;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Preguntas;
import modelo.Respuestaspreguntas;
import daos.PreguntasDAO;
import daosImpl.PreguntasDAOImpl;
import daosImpl.RespuestaspreguntasDAOImpl;

@WebServlet("/ServletEditarPreguntas")
public class ServletEditarPreguntas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recojo el id de la pregunta escogida en el desplegable
		String idpregunta = request.getParameter("idpregunta");
		System.out.println("Ha escogido la pregunta: " + idpregunta);
	
		//Creo el objeto para utilizar las implementaciones
		PreguntasDAO preguntasDAO = new PreguntasDAOImpl();
		
		//Obtengo la pregunta a editar y su tipo
		Preguntas preguntaAeditar = preguntasDAO.obtenerPreguntaPorId(Integer.parseInt(idpregunta));
		int tipoAeditar = preguntaAeditar.getTipo();
		
		//Si el tipo es 2  o 3 es necesario traer la respuesta
		if(tipoAeditar != 1){
			RespuestaspreguntasDAOImpl respuestaspreguntasDAOImpl = new RespuestaspreguntasDAOImpl();
			
			Respuestaspreguntas respuestaAeditar = respuestaspreguntasDAOImpl.obtenerRespuestaPorId(Integer.parseInt(idpregunta));
			request.setAttribute("respuestaAeditar", respuestaAeditar);
		}
	
		//Dejo la pregunta a editar en una variable
		request.setAttribute("preguntaAeditar", preguntaAeditar);
		//Voy al jsp donde saldr� la informaci�n
		request.getRequestDispatcher("guardarCambiosPregunta.jsp").forward(request, response);
	}

}