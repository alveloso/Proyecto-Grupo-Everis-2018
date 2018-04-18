package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import modelo.Respuestaspreguntas;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.RespuestaspreguntasDAO;

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
	public void borrarRespuesta(int idpregunta) {
		conectar();
		try{
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.BORRAR_RESPUESTA);
			ps.setInt(1, idpregunta);
			ps.execute();
			ps.close();
			System.out.println("borrado con exito");
		} catch(SQLException e){
			System.out.println("SQL borrar pregunta esta mal");
			
		}
		desconectar();
	}



	}




	


