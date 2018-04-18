package servletsAdmin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.PreguntasDAO;
import daosImpl.PreguntasDAOImpl;

@WebServlet("/ServletBorrarPreguntas")
public class ServletBorrarPreguntas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idpregunta = request.getParameter("idpregunta");
		System.out.println("borrar id pregunta: " + idpregunta);
	
		System.out.println("borrar preguntas por idpregunta: " + idpregunta);
		PreguntasDAO preguntasDAO = new PreguntasDAOImpl();
	
		
		preguntasDAO.borrarPregunta(Integer.parseInt(idpregunta));
		request.getRequestDispatcher("ServletsListadoPreguntas").forward(request, response);
	}

}


