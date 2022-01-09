package persistencia;

import java.util.List;

import beans.Usuario;

public interface UsuarioDAO {

	boolean insereUsuario(Usuario usuario);

	boolean alteraUsuario(Usuario usuario);

	boolean excluiUsuario(Usuario usuario);

	Usuario procurarUsuario(Usuario usuario);

	List<Usuario> procurarTodosUsuario();

}
