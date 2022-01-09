package managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import beans.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOImp;

public class UsuarioMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImp();
	private Usuario usuario;
	private boolean exibirForm = false;

	public ListDataModel getUsuarios() {
		return new ListDataModel(usuarioDAO.procurarTodosUsuario());
	}

	public String adicionarUsuario() {
		this.limparUsuario();
		this.exibirForm();
		return null;
	}

	public String alterarUsuario() {
		this.exibirForm();
		return null;
	}

	public String salvarUsuario() {
		if (usuario.getId() == 0) {
			usuarioDAO.insereUsuario(usuario);
		} else {
			usuarioDAO.alteraUsuario(usuario);
		}
		this.mostrarMensagem(usuario.getNome() + " foi salvo!");
		this.ocultarForm();
		return null;
	}

	public String excluirUsuario() {
		usuarioDAO.excluiUsuario(usuario);
		this.mostrarMensagem(usuario.getNome() + " foi excluido!");
		return null;
	}
	
	public String cancelarCadastroUsuario() {
		this.ocultarForm();
		return null;
	}

	private void limparUsuario() {
		usuario = new Usuario();
	}

	private void exibirForm() {
		exibirForm = true;
	}

	private void ocultarForm() {
		exibirForm = false;
	}

	private void mostrarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(mensagem));
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isExibirForm() {
		return exibirForm;
	}

}
