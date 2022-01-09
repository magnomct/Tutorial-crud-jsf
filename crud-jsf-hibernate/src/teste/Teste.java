package teste;

import java.util.List;

import beans.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOImp;

public class Teste {
	
	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImp();
		Usuario usuario = new Usuario();
		
		usuario.setNome("Jabes Felipe");
		usuario.setEmail("jabesfelipe@gmail.com");
		usuario.setSenha("senha");
		
		if(usuarioDAO.insereUsuario(usuario)) {
			System.out.println("Usuario Cadastrado!");
		} else {
			System.out.println("Cadastro Falhou!");
		}
		
		List<Usuario> usuarios = usuarioDAO.procurarTodosUsuario();
		for(Usuario u : usuarios) {
			System.out.println("Nome: " + u.getNome() + "\nEmail: " + u.getEmail());
		}
	}
}
