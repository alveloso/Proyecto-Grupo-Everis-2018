package daos;

import modelos.Usuario;

public interface UsuariosDAO {
	
	int identificarUsuario(String user,String pass);
	void registrarUsuario(Usuario usuario);
}
