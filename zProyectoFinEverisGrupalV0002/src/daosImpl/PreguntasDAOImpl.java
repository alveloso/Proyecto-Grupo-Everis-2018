package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.PreguntasDAO;
import modelos.Preguntas;

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
			System.out.println("Error en la SQL");
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
	public int registrarPregunta(Preguntas nuevaPregunta) {
		conectar();
		
		int idGenerado = -1;
		
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.REGISTRAR_PREGUNTA_ADMIN, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nuevaPregunta.getDescripcion());
			ps.setInt(2, nuevaPregunta.getTipo());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				idGenerado = rs.getInt(1);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error SQL registrar pregunta administrador");
			System.out.println(e.getMessage());
		}
		desconectar();
		
		return idGenerado;
	}

}
