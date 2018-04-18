package daosImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelos.TextRespuesta;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.RespuestasTextoDAO;

public class RespuestasTextoDAOImpl extends GenericDAO implements RespuestasTextoDAO{

	@Override
	public void registrarRespuestas(List<TextRespuesta> textRespuestas) {
		conectar();
		
		try {
			
			//Preparo consulta para ir metiendo las respuestas
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.REGISTRAR_RESPUESTA_TEXTO);
			
			//Bucle para ir metiendo todas las respuestas de texto recogidas
			for(int i=0;i<textRespuestas.size();i++){
				//Variable para sacar una respuesta de la lista de respuestas
				TextRespuesta textRespuesta = new TextRespuesta();
				
				//Saco de la lista 1 elemento
				textRespuesta = textRespuestas.get(i);
				
				//Relleno la consulta con los valores del elemento sacado
				ps.setString(1, textRespuesta.getRespuesta());
				ps.setInt(2, textRespuesta.getIdPregunta());
				
				//Ejecuto consulta
				ps.execute();
				
			}
			System.out.println("Todas las respuestas de texto han sido insertadas");
			//Cierro el prepared para la consulta
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar respuesta de texto");
			System.out.println(e.getMessage());
		}
		//Desconecto
		desconectar();
	}

}
