package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Preguntas;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.PreguntasDAO;

public class PreguntasDAOImpl extends GenericDAO implements PreguntasDAO {

	@Override
	public List<Preguntas> obtenerPreguntas() {
		conectar();
		List<Preguntas> preguntas = new ArrayList<Preguntas>();
		try {
			PreparedStatement ps = con
					.prepareStatement(ConstantesSQL.LISTAR_PREGUNTAS);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Preguntas pregunta = new Preguntas();
				pregunta.setIdpregunta(resultado.getInt("idpregunta"));
				pregunta.setDescripcion(resultado.getString("descripcion"));
				pregunta.setTipo(resultado.getInt("tipo"));
				preguntas.add(pregunta);

			}
		} catch (SQLException e) {
			System.out.println("Error en la SQL de listar preguntas");
			e.printStackTrace();
		}
		desconectar();
		return preguntas;
	}

	public void borrarPregunta(int idpregunta) {
		conectar();
		try{
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.BORRAR_PREGUNTA);
			ps.setInt(1, idpregunta);
			ps.execute();
			ps.close();
			System.out.println("borrado con exito");
		} catch(SQLException e){
			System.out.println("SQL borrar pregunta esta mal");
			
		}
		desconectar();
	}

	@Override
	public int buscarPreguntaPorId(int idpregunta) {
		conectar();
		int tipopregunta = -1;
		try {
			PreparedStatement ps = con
					.prepareStatement(ConstantesSQL.OBTENER_PREGUNTA_POR_ID);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				tipopregunta = resultado.getInt("tipo");
			}
		} catch (SQLException e) {
			System.out.println("Error en la SQL de obtener pregunta por id");
			System.out.println(e.getMessage());
		}
		desconectar();
		return tipopregunta;
	}

}
