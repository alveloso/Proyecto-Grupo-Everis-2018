package daos;

import java.util.List;

import modelos.Respuestaspreguntas;

public interface RespuestaspreguntasDAO {


	
	List <Respuestaspreguntas> obtenerRespuestaspreguntas();


	void registrarRespuesta(Respuestaspreguntas respuestaNueva, int idPreguntaAsociada);
	

	
}
