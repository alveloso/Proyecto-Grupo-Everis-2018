package daos;

import java.util.List;

import modelos.Preguntas;

public interface PreguntasDAO {

	List<Preguntas> obtenerPreguntas();
	
	void borrarPregunta(int idpregunta);
	
	int registrarPregunta(Preguntas nuevaPregunta);

}
