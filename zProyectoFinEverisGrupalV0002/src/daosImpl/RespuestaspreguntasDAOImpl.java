package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.RespuestaspreguntasDAO;
import modelos.Respuestaspreguntas;

public  class RespuestaspreguntasDAOImpl extends GenericDAO implements RespuestaspreguntasDAO {

	@Override
	public List<Respuestaspreguntas> obtenerRespuestaspreguntas() {
		conectar();
		List<Respuestaspreguntas> respuestaspreguntas = new ArrayList<Respuestaspreguntas>();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.SELECCION_RESPUESTASPREGUNTAS);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Respuestaspreguntas respuestapregunta = new Respuestaspreguntas();
				respuestapregunta.setDescripcion(resultado.getString("descripcion"));
				respuestaspreguntas.add(respuestapregunta);
			
			}//end while
		} catch (SQLException e) {
			System.out.println("SQL select respuestaspreguntas esta mal");
			System.out.println(e.getMessage());
		
		}//end catch
		desconectar();
		
		return respuestaspreguntas;
	}
	
	@Override
	public void registrarRespuesta(Respuestaspreguntas respuestaNueva, int idPreguntaAsociada) {
		conectar();
		
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.REGISTRAR_RESPUESTA_ADMIN);
			ps.setString(1, respuestaNueva.getDescripcion());
			ps.setInt(2, idPreguntaAsociada);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error SQL registrar respuesta administrador");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

}





	


